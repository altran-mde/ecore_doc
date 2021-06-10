package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEDataTypeConfigPair
import com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension
import com.google.common.collect.Multimap
import com.google.inject.Injector
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

abstract class AEcoreDocGeneratorEDataTypePart extends AEcoreDocGeneratorPart {

	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages, Injector xcoreInjector) {
		super(config, ePackages, xcoreInjector)
	}
	
	protected def void writeProperties(IEDataTypeConfigPair<?,?> pair) {
		output.append(
			#[
				defineDefaultValue(pair),
				defineInstanceClassName(pair),
				defineSerializable(pair)
			]
			.filterNull
			.join(EcoreDocExtension.ECLASSIFIER_PROPERTY_SEPARATOR)
		)
		output.append(newline)
	}
	
	protected def defineSerializable(IEDataTypeConfigPair<?,?> pair) {
		val eDataType = pair.element
		
		val defaultValue = '''true'''
		val value = if (eDataType.eIsSet(EcorePackage.eINSTANCE.EDataType_Serializable)) eDataType.serializable.toString else null

		concatProperty("Serializable", defaultValue, value, pair)
	}
	
}