package com.altran.general.emf.ecoredoc.maven;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

/**
 * Finds {@link EPackage}s and {@link EClassifier}s in a set of EPackages.
 *
 */
public class EcoreLookupHelper {
	private final Collection<EPackage> ePackages;
	
	/**
	 * Creates an EcoreLookupHelper that searches through the EPackage registry.
	 *
	 * @see #collectDefaults()
	 */
	public static EcoreLookupHelper createDefault() {
		return new EcoreLookupHelper(collectDefaults());
	}
	
	/**
	 * Collects all EPackages from {@link EPackage.Registry}.
	 */
	public static Collection<EPackage> collectDefaults() {
		return EPackage.Registry.INSTANCE.keySet().stream()
				.filter(Objects::nonNull)
				.map(nsUri -> EPackage.Registry.INSTANCE.getEPackage(nsUri))
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
	}
	
	public EcoreLookupHelper(final Collection<EPackage> ePackages) {
		this.ePackages = ePackages;
	}
	
	public EcoreLookupHelper addPackages(final Collection<EPackage> ePackages) {
		this.ePackages.addAll(ePackages.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toSet()));
		
		return this;
	}
	
	public <T extends EClassifier> T findEClassifier(final Class<T> type, final String name) {
		return findEClassifiers(name)
				.filter(type::isInstance)
				.map(type::cast)
				.findAny()
				.orElse(null);
	}
	
	public Stream<EClassifier> findEClassifiers(final String name) {
		return getEPackages()
				.map(ePackage -> ePackage.getEClassifier(name))
				.filter(Objects::nonNull);
	}
	
	public Stream<EPackage> getEPackages() {
		return this.ePackages.stream();
	}
	
}
