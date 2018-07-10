package com.altran.general.emf.ecoredoc.generator.configbuilder;

import org.eclipse.emf.ecore.EDataType;

import com.altran.general.emf.ecoredoc.generator.config.IEDataTypeConfig;

public interface IEDataTypeConfigPair<E extends EDataType, C extends IEDataTypeConfig>
		extends IEClassifierConfigPair<E, C>, IEcoreDocConfigPair<E, C> {
	@Override
	E getElement();

	@Override
	C getConfig();
}
