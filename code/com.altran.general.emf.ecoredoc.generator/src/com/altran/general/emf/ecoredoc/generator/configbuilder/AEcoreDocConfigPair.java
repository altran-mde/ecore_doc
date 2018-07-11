package com.altran.general.emf.ecoredoc.generator.configbuilder;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.ENamedElement;

import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;

public abstract class AEcoreDocConfigPair<E extends ENamedElement, C extends IENamedElementConfig>
implements IEcoreDocConfigPair<E, C> {
	private final E element;
	private final C config;
	
	public AEcoreDocConfigPair(final E element, final C config) {
		this.element = element;
		this.config = config;
	}

	public AEcoreDocConfigPair(final Entry<E, C> entry) {
		this(entry.getKey(), entry.getValue());
	}

	@Override
	public E getElement() {
		return this.element;
	}

	@Override
	public C getConfig() {
		return this.config;
	}
}
