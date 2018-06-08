package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.ecoredoc.generator.config.EEnumConfig
import com.altran.general.ecoredoc.generator.config.EEnumLiteralConfig
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

	protected def void writeEEnumLiterals(Entry<EEnum, EEnumConfig> eEnumEntry) {
		val eEnum = eEnumEntry.key

		val eLiterals = eEnum.ELiterals
		
		val eLiteralsMap = eLiterals
			.toInvertedMap[getConfig().findConfig(it) as EEnumLiteralConfig]
			.filter[eLiteral, config|
				config.shouldRender
			]
			
		if (!eLiteralsMap.isEmpty) {
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
			
			for (entry : eLiteralsMap.entrySet) {
				writeELiteral(entry)
			}
			
			output.append(tableFooter())
		}
		
	}

	protected def void writeELiteral(Entry<EEnumLiteral, EEnumLiteralConfig> entry) {
		val eLiteral = entry.key
		
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
