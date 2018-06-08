package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.ecoredoc.generator.config.IEDataTypeConfig
import com.google.common.collect.Multimap
import java.util.Map.Entry
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage

import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline

abstract class AEcoreDocGeneratorEDataTypePart extends AEcoreDocGeneratorPart {

	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages) {
		super(config, ePackages)
	}
	
	protected def void writeProperties(Entry<? extends EDataType, ? extends IEDataTypeConfig> entry) {
		val eDataType = entry.key
		
		output.append(
			#[
				defineDefaultValue(eDataType),
				defineInstanceClassName(eDataType),
				defineSerializable(eDataType)
			]
			.filterNull
			.join(EcoreDocExtension.ECLASSIFIER_PROPERTY_SEPARATOR)
		)
		output.append(newline)
	}
	
	protected def defineSerializable(EDataType eDataType) {
		val defaultValue = '''true'''
		val value = eDataType.serializable

		concatProperty("Serializable", defaultValue, value.toString)
	}
	
}