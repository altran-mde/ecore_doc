package com.altran.general.emf.ecoredoc.generator.configbuilder;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EEnum;

import com.altran.general.emf.ecoredoc.generator.config.EEnumConfig;

public class EEnumConfigPair extends AEcoreDocConfigPair<EEnum, EEnumConfig>
		implements IEDataTypeConfigPair<EEnum, EEnumConfig> {
	
	public EEnumConfigPair(final EEnum element, final EEnumConfig config) {
		super(element, config);
	}

	public EEnumConfigPair(final Entry<EEnum, EEnumConfig> entry) {
		super(entry);
	}
	
}
