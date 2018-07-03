package com.altran.general.emf.ecoredoc.generator.config;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EReference;

public class EReferenceConfigPair extends AEcoreDocConfigPair<EReference, AEReferenceConfig>
implements IEStructuralFeatureConfigPair<EReference, AEReferenceConfig> {

	public EReferenceConfigPair(final EReference element, final AEReferenceConfig config) {
		super(element, config);
	}
	
	public EReferenceConfigPair(final Entry<EReference, AEReferenceConfig> entry) {
		super(entry);
	}

}
