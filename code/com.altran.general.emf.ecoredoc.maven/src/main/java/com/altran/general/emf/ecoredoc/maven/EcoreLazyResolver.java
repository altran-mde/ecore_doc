package com.altran.general.emf.ecoredoc.maven;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BiFunction;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.google.common.collect.ImmutableMap;

/**
 * Defers resolving references to EPackage contents.
 *
 * <p>
 * During the maven configuration buildup, we don't know yet about the EPackages
 * (and contents) we're operating on. However, we want to reference them as
 * {@linkplain com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig#getTarget()
 * target} of our config models. Therefore, we create only EMF proxies at this
 * point, and resolve them once we know about our target EPackages.
 * </p>
 *
 * <p>
 * We use our own proxy resolution mechanism as we don't know anything about the
 * path of the target EPackages, and the standard proxy resolution relies
 * heavily on this information.
 * </p>
 */
public class EcoreLazyResolver {
	private static final String LAZY_ECORE_RESOLVER_SCHEME = "lazyEcoreResolve";
	
	// @formatter:off
	private final Map<Class<?>, BiFunction<EObject, String, EObject>> resolvers = ImmutableMap
			.<Class<?>, BiFunction<EObject, String, EObject>> builder()
			.put(EAttribute.class,   (c, s) -> resolveEAttribute(c, s))
			.put(EReference.class,   (c, s) -> resolveEReference(c, s))
			.put(EEnumLiteral.class, (c, s) -> resolveEEnumLiteral(c, s))
			.put(EClass.class,       (c, s) -> resolveEClassifier(EClass.class, s))
			.put(EEnum.class,        (c, s) -> resolveEClassifier(EEnum.class, s))
			.put(EDataType.class,    (c, s) -> resolveEClassifier(EDataType.class, s))
			.put(EPackage.class,     (c, s) -> resolveEPackage(s))
			.build();
	// @formatter:on
	
	private final EcoreLookupHelper lookupHelper;
	
	public EcoreLazyResolver(final EcoreLookupHelper lookupHelper) {
		this.lookupHelper = lookupHelper;
	}
	
	/**
	 * Encodes a lazy reference, if applicable.
	 *
	 * @param bean
	 *            Object to encode. Will not be touched if lazy resolving is not
	 *            applicable.
	 * @param target
	 *            {@link ENamedElement#getName() name} of the target element.
	 * @return {@code true} if {@code bean} was turned into a proxy,
	 *         {@code false} otherwise.
	 */
	public boolean encodeLazyReference(final Object bean, final String target) {
		if (StringUtils.isNotBlank(target)) {
			if (findResolver(bean.getClass()).isPresent()) {
				((InternalEObject) bean).eSetProxyURI(URI.createGenericURI(LAZY_ECORE_RESOLVER_SCHEME, target, null));
				
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Resolves lazy Ecore references in all contents of {@code input}.
	 *
	 * @param input
	 *            Root element possibly containing lazy Ecore references.
	 * @return {@code input}.
	 */
	public <T extends EObject> T resolveAll(final T input) {
		final TreeIterator<EObject> eAllContents = input.eAllContents();
		
		while (eAllContents.hasNext()) {
			final EObject content = eAllContents.next();
			for (final EReference ref : content.eClass().getEAllReferences()) {
				final Collection<EObject> refTargets = collectRefTargets(content, ref);
				
				for (final EObject refTarget : refTargets) {
					final String opaquePart = extractValidProxyValue(refTarget);
					final Optional<BiFunction<EObject, String, EObject>> resolverOpt = findResolver(
							refTarget.getClass());
					if (resolverOpt.isPresent()) {
						final EObject realOne = resolverOpt.get().apply(content, opaquePart);
						if (realOne != null) {
							EcoreUtil.replace(content, ref, refTarget, realOne);
						}
					}
				}
			}
		}
		
		return input;
	}
	
	protected String extractValidProxyValue(final EObject refTarget) {
		final URI proxyUri = ((InternalEObject) refTarget).eProxyURI();
		if (proxyUri != null && LAZY_ECORE_RESOLVER_SCHEME.equalsIgnoreCase(proxyUri.scheme())) {
			final String opaquePart = proxyUri.opaquePart();
			assert opaquePart != null;
			
			return opaquePart;
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected Collection<EObject> collectRefTargets(final EObject content, final EReference ref) {
		Collection<EObject> refTargets;
		if (ref.isMany()) {
			refTargets = (Collection<EObject>) content.eGet(ref);
		} else {
			refTargets = Collections.singleton((EObject) content.eGet(ref));
		}
		return refTargets;
	}
	
	protected Optional<BiFunction<EObject, String, EObject>> findResolver(final Class<?> type) {
		return this.resolvers.keySet().stream()
				.filter(c -> c.isAssignableFrom(type))
				.map(k -> this.resolvers.get(k))
				.findAny();
	}
	
	protected EPackage resolveEPackage(final String opaquePart) {
		return this.lookupHelper.getEPackages()
				.filter(p -> opaquePart.equals(p.getName()))
				.findAny()
				.orElseThrow(() -> new NoSuchElementException("Cannot find EPackage " + opaquePart));
	}
	
	protected EEnumLiteral resolveEEnumLiteral(final EObject content, final String opaquePart) {
		final EEnum eEnum = findAncestor(EEnum.class, content);
		return eEnum.getEEnumLiteral(opaquePart);
	}
	
	protected EReference resolveEReference(final EObject content, final String opaquePart) {
		final EClass eClass = findAncestor(EClass.class, content);
		return eClass.getEAllReferences().stream()
				.filter(a -> opaquePart.equals(a.getName()))
				.findAny()
				.orElseThrow(() -> new NoSuchElementException(
						"Cannot find EReference " + opaquePart + " in EClass " + eClass));
	}
	
	protected EAttribute resolveEAttribute(final EObject content, final String opaquePart) {
		final EClass eClass = findAncestor(EClass.class, content);
		return eClass.getEAllAttributes().stream()
				.filter(a -> opaquePart.equals(a.getName()))
				.findAny()
				.orElseThrow(() -> new NoSuchElementException(
						"Cannot find EAttribute " + opaquePart + " in EClass " + eClass));
	}
	
	protected <T extends EClassifier> T resolveEClassifier(final Class<T> type, final String opaquePart) {
		final T result = this.lookupHelper.findEClassifier(type, opaquePart);
		if (result == null) {
			throw new NoSuchElementException("Cannot find " + type.getSimpleName() + " " + opaquePart);
		}
		return result;
	}
	
	/**
	 * Walks up the config tree to find the appropriate content to create
	 * sub-elements.
	 *
	 * <p>
	 * Example: To create an EAttribute, we need to find the containing EClass.
	 * </p>
	 *
	 * <p>
	 * We assume the config tree is resolved from root to leaf, so once we
	 * arrive at the EAttribute, the containing EClass is already resolved.
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	protected <T extends EClassifier> T findAncestor(final Class<T> type, final EObject context) {
		if (context instanceof IENamedElementConfig) {
			final ENamedElement target = ((IENamedElementConfig) context).getTarget();
			if (target != null) {
				final Class<? extends ENamedElement> targetClass = target.getClass();
				if (type.isAssignableFrom(targetClass)) {
					return (T) target;
				}
			}
		}
		
		if (context.eContainer() != null) {
			return findAncestor(type, context.eContainer());
		}
		
		return null;
	}
}
