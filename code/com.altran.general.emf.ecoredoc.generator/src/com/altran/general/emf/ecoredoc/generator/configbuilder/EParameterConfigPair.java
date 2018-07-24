package com.altran.general.emf.ecoredoc.generator.configbuilder;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EParameter;

import com.altran.general.emf.ecoredoc.generator.config.EParameterConfig;

public class EParameterConfigPair extends AEcoreDocConfigPair<EParameter, EParameterConfig>
		implements IETypedElementConfigPair<EParameter, EParameterConfig> {
	
	public EParameterConfigPair(final EParameter element, final EParameterConfig config) {
		super(element, config);
	}

	public EParameterConfigPair(final Entry<EParameter, EParameterConfig> entry) {
		super(entry);
	}
	
}
