package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.ENamedElement;

public interface IEcoreDocConfigPair<E extends ENamedElement, C extends IENamedElementConfig> {
	E getElement();
	
	C getConfig();
}
