package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EClassifier;

public interface IEClassifierConfigPair<E extends EClassifier, C extends IEClassifierConfig>
extends IEcoreDocConfigPair<E, C> {
	@Override
	E getElement();
	
	@Override
	C getConfig();
}
