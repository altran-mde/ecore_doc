package com.altran.general.emf.ecoredoc.generator.configbuilder;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.EEnumLiteral;

import com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig;

public class EEnumLiteralConfigPair extends AEcoreDocConfigPair<EEnumLiteral, EEnumLiteralConfig> {

	public EEnumLiteralConfigPair(final EEnumLiteral element, final EEnumLiteralConfig config) {
		super(element, config);
	}
	
	public EEnumLiteralConfigPair(final Entry<EEnumLiteral, EEnumLiteralConfig> entry) {
		super(entry);
	}

}
