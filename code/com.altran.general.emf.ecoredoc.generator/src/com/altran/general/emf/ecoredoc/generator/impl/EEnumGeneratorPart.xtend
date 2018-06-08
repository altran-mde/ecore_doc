package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.ecoredoc.generator.config.EEnumConfig
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.google.common.collect.Multimap
import java.util.Map
import java.util.Map.Entry
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage

import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline

class EEnumGeneratorPart extends AEcoreDocGeneratorEDataTypePart {

	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages) {
		super(config, ePackages)
	}

	override StringBuilder write(EPackage ePackage) {
		clearOutput()

		val eEnums = getEPackages().get(ePackage).collectEEnums()

		val eEnumMap = eEnums
			.toInvertedMap[getConfig().findConfig(it) as EEnumConfig]
			.filter[eEnum, config|
				config.shouldRender
			]
			
		writeEEnums(eEnumMap)

		return output
	}

	protected def void writeEEnums(Map<EEnum, EEnumConfig> eEnumMap) {
		if (!eEnumMap.isEmpty) {
			writeEEnumsHeader()

			for (entry : eEnumMap.entrySet) {
				writeEEnumHeader(entry)
				writeProperties(entry)
				writeEEnumLiterals(entry)
				writeUseCases(entry)
			}
		}
	}

	protected def void writeEEnumsHeader() {
		output.append(
		'''
			«newline»
			=== Enumerations
		''')
	}

	protected def void writeEEnumLiterals(Entry<EEnum, EEnumConfig> entry) {
		val eEnum = entry.key

		output.append(
			'''
				«newline»
				.Literals
				[cols="<20m,>10m,<70a",options="header"]
				|===
				|Symbol
				|Value
				|Description
			'''
		)
		
		for (eLiteral : eEnum.ELiterals) {
			writeELiteral(eLiteral)
		}
		
		output.append(tableFooter())
	}

	protected def void writeELiteral(EEnumLiteral eLiteral) {
		output.append(
		'''
			«newline»
			|«eLiteral.name»[[«concatAnchor(eLiteral)»]]
			|«eLiteral.value»
			|«getDocumentation(eLiteral)»
		''')
	}

	def protected void writeEEnumHeader(Entry<EEnum, EEnumConfig> entry) {
		val eEnum = entry.key

		output.append(
		'''
			«newline»
			[[«concatAnchor(eEnum)»]]
			==== «eEnum.name»
			«newline»
			«getDocumentation(eEnum)»
			«newline»
		''')
	}

}
