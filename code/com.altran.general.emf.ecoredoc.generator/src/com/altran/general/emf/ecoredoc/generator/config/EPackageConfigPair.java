package com.altran.general.emf.ecoredoc.generator.config;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EPackage;

public class EPackageConfigPair extends AEcoreDocConfigPair<EPackage, EPackageConfig> {
	
	public EPackageConfigPair(final EPackage element, final EPackageConfig config) {
		super(element, config);
	}
	
	public EPackageConfigPair(final Entry<EPackage, EPackageConfig> entry) {
		super(entry);
	}
	
}
