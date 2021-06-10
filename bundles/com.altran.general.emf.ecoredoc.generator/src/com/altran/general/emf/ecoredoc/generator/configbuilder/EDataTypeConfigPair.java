package com.altran.general.emf.ecoredoc.generator.configbuilder;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EDataType;

import com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig;

public class EDataTypeConfigPair extends AEcoreDocConfigPair<EDataType, EDataTypeConfig>
		implements IEDataTypeConfigPair<EDataType, EDataTypeConfig> {
	
	public EDataTypeConfigPair(final EDataType element, final EDataTypeConfig config) {
		super(element, config);
	}

	public EDataTypeConfigPair(final Entry<EDataType, EDataTypeConfig> entry) {
		super(entry);
	}
	
}
