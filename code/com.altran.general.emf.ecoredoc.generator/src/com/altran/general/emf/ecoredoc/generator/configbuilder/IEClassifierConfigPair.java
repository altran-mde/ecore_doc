package com.altran.general.emf.ecoredoc.generator.configbuilder;

import org.eclipse.emf.ecore.EClassifier;

import com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig;

public interface IEClassifierConfigPair<E extends EClassifier, C extends IEClassifierConfig>
extends IEcoreDocConfigPair<E, C> {
	@Override
	E getElement();
	
	@Override
	C getConfig();
}
