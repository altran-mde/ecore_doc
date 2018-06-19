package com.altran.general.emf.ecoredoc.generator.config;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAttribute;

public class EAttributeConfigPair extends AEcoreDocConfigPair<EAttribute, EAttributeConfig>
implements IEStructuralFeatureConfigPair<EAttribute, EAttributeConfig> {

	public EAttributeConfigPair(final EAttribute element, final EAttributeConfig config) {
		super(element, config);
	}
	
	public EAttributeConfigPair(final Entry<EAttribute, EAttributeConfig> entry) {
		super(entry);
	}

}
