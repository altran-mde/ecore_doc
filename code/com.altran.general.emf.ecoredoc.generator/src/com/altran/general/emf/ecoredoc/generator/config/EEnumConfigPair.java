package com.altran.general.emf.ecoredoc.generator.config;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EEnum;

public class EEnumConfigPair extends AEcoreDocConfigPair<EEnum, EEnumConfig>
		implements IEDataTypeConfigPair<EEnum, EEnumConfig> {
	
	public EEnumConfigPair(final EEnum element, final EEnumConfig config) {
		super(element, config);
	}

	public EEnumConfigPair(final Entry<EEnum, EEnumConfig> entry) {
		super(entry);
	}
	
}
