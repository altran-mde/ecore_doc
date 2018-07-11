package com.altran.general.emf.ecoredoc.generator.configbuilder;

import org.eclipse.emf.ecore.ENamedElement;

import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;

public interface IEcoreDocConfigPair<E extends ENamedElement, C extends IENamedElementConfig> {
	E getElement();
	
	C getConfig();
}
