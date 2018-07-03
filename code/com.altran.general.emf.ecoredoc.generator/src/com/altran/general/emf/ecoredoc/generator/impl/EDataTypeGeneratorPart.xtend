package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig
import com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfigPair
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.google.common.collect.Multimap
import java.util.Map
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage

import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline

class EDataTypeGeneratorPart extends AEcoreDocGeneratorEDataTypePart {

	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages) {
		super(config, ePackages)
	}

	override StringBuilder write(EPackage ePackage) {
		clearOutput()

		val eDataTypes = getEPackages().get(ePackage).collectEDataTypes()

		val eDataTypeMap = eDataTypes
			.toInvertedMap[getConfig().findConfig(it) as EDataTypeConfig]
			.filter[eDataType, config|
				config.shouldRender
			]
		
		writeEDataTypes(eDataTypeMap)

		return output
	}

	protected def void writeEDataTypes(Map<EDataType, EDataTypeConfig> eDataTypeMap) {
		if (!eDataTypeMap.isEmpty) {
			writeEDataTypesHeader()

			for (entry : eDataTypeMap.entrySet) {
				val pair = new EDataTypeConfigPair(entry)
				writeEDataTypeHeader(pair)
				writeProperties(pair)
				writeUseCases(pair)
			}
		}
	}

	protected def void writeEDataTypesHeader() {
		output.append(
		'''
			«newline»
			=== Data Types
		''')
	}

	protected def void writeEDataTypeHeader(EDataTypeConfigPair pair) {
		val eDataType = pair.element
		
		output.append(
		'''
			«newline»
			[[«concatAnchor(eDataType)»]]
			==== «eDataType.name»
			«newline»
			«getDocumentation(eDataType)»
			«newline»
		''')
	}
}
