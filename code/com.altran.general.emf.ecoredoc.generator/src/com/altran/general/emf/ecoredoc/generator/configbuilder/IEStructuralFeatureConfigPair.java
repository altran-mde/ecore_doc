package com.altran.general.emf.ecoredoc.generator.configbuilder;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig;

public interface IEStructuralFeatureConfigPair<E extends EStructuralFeature, C extends IEStructuralFeatureConfig>
extends IEcoreDocConfigPair<E, C> {
	@Override
	E getElement();

	@Override
	C getConfig();
}
