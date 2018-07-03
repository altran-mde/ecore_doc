package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EStructuralFeature;

public interface IEStructuralFeatureConfigPair<E extends EStructuralFeature, C extends IEStructuralFeatureConfig>
extends IEcoreDocConfigPair<E, C> {
	@Override
	E getElement();

	@Override
	C getConfig();
}
