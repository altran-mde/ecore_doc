package com.altran.general.emf.ecoredoc.generator.config;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;

public class EClassConfigPair extends AEcoreDocConfigPair<EClass, EClassConfig>
implements IEClassifierConfigPair<EClass, EClassConfig> {

	public EClassConfigPair(final EClass element, final EClassConfig config) {
		super(element, config);
	}
	
	public EClassConfigPair(final Entry<EClass, EClassConfig> entry) {
		super(entry);
	}

}
