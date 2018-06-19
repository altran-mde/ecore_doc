package com.altran.general.emf.ecoredoc.generator.config;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EDataType;

public class EDataTypeConfigPair extends AEcoreDocConfigPair<EDataType, EDataTypeConfig>
		implements IEDataTypeConfigPair<EDataType, EDataTypeConfig> {
	
	public EDataTypeConfigPair(final EDataType element, final EDataTypeConfig config) {
		super(element, config);
	}

	public EDataTypeConfigPair(final Entry<EDataType, EDataTypeConfig> entry) {
		super(entry);
	}
	
}
