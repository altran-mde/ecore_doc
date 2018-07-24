package com.altran.general.emf.ecoredoc.generator.configbuilder;

import org.eclipse.emf.ecore.ETypedElement;

import com.altran.general.emf.ecoredoc.generator.config.IETypedElementConfig;

public interface IETypedElementConfigPair<E extends ETypedElement, C extends IETypedElementConfig>
extends IEcoreDocConfigPair<E, C> {
	@Override
	E getElement();
	
	@Override
	C getConfig();
}
