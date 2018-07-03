package com.altran.general.emf.ecoredoc.generator.config;

import org.eclipse.emf.ecore.EDataType;

public interface IEDataTypeConfigPair<E extends EDataType, C extends IEDataTypeConfig>
		extends IEClassifierConfigPair<E, C>, IEcoreDocConfigPair<E, C> {
	@Override
	E getElement();

	@Override
	C getConfig();
}
