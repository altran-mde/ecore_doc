package com.altran.general.emf.ecoredoc.generator.configbuilder;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EOperation;

import com.altran.general.emf.ecoredoc.generator.config.EOperationConfig;

public class EOperationConfigPair extends AEcoreDocConfigPair<EOperation, EOperationConfig>
		implements IETypedElementConfigPair<EOperation, EOperationConfig> {

	public EOperationConfigPair(final EOperation element, final EOperationConfig config) {
		super(element, config);
	}
	
	public EOperationConfigPair(final Entry<EOperation, EOperationConfig> entry) {
		super(entry);
	}

}
