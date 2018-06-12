package com.altran.general.emf.ecoredoc.util;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EcoreMerger<T extends EObject> {
	private final T base;

	public EcoreMerger(final T base) {
		this.base = base;
	}

	public <O extends T> T merge(final O overwrite) {
		mergeRecursive(this.base, overwrite);

		return this.base;
	}

	protected void mergeRecursive(final EObject localBase, final EObject overwrite) {
		if (localBase == null || overwrite == null) {
			return;
		}

		for (final EStructuralFeature feature : localBase.eClass().getEAllStructuralFeatures()) {
			if (feature.isChangeable() && overwrite.eIsSet(feature)) {
				if (feature instanceof EAttribute) {
					mergeAttribute(localBase, overwrite, (EAttribute) feature);
				} else if (feature instanceof EReference) {
					mergeReference(localBase, overwrite, (EReference) feature);
				}
			}
		}

	}

	@SuppressWarnings("unchecked")
	protected void mergeAttribute(final EObject localBase, final EObject overwrite, final EAttribute attribute) {
		final Object localRaw = localBase.eGet(attribute);
		final Object overwriteRaw = overwrite.eGet(attribute);

		if (attribute.isMany()) {
			final Collection<Object> localValue = (Collection<Object>) localRaw;

			for (final Object overwriteValue : (Collection<Object>) overwriteRaw) {
				if (!localValue.contains(overwriteValue)) {
					localValue.add(overwriteValue);
				}
			}
		} else {
			localBase.eSet(attribute, overwriteRaw);
		}
	}

	@SuppressWarnings("unchecked")
	protected void mergeReference(final EObject localBase, final EObject overwrite, final EReference feature) {
		if (feature.isContainment()) {
			final Object localRaw = localBase.eGet(feature);
			final Object overwriteRaw = overwrite.eGet(feature);

			if (feature.isMany()) {
				final Collection<EObject> localValue = (Collection<EObject>) localRaw;

				for (final EObject overwriteValue : (Collection<EObject>) overwriteRaw) {
					final Optional<EObject> localEntry = findFirst(localValue,
							l -> EcoreUtil.equals(l, overwriteValue));
					if (localEntry.isPresent()) {
						// TODO: I think we don't need this, as
						// EcoreUtil.equals() will only be true if there's
						// nothing to merge
						mergeRecursive(localEntry.get(), overwriteValue);
					} else {
						final String overwriteId = EcoreUtil.getID(overwriteValue);
						if (overwriteId != null) {
							final Optional<EObject> localIdEntry = findFirst(localValue,
									l -> overwriteId.equals(EcoreUtil.getID(l)));
							if (localIdEntry.isPresent() && isAssignableFrom(localIdEntry.get(), overwriteValue)) {
								mergeRecursive(localIdEntry.get(), overwriteValue);
							} else {
								localValue.add(overwriteValue);
							}
						}
					}
				}
			} else if (localRaw instanceof EObject && overwriteRaw instanceof EObject) {
				mergeRecursive((EObject) localRaw, (EObject) overwriteRaw);
			}
		}

	}

	protected boolean isAssignableFrom(final EObject superType, final EObject candidate) {
		if (superType == null || candidate == null) {
			return false;
		}
		return superType.eClass() == EcorePackage.Literals.EOBJECT
				|| superType.eClass().isSuperTypeOf(candidate.eClass());
	}

	protected Optional<EObject> findFirst(final Collection<EObject> collection,
			final Predicate<? super EObject> condition) {
		return collection.stream().filter(condition).findFirst();
	}
}
