package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.emf.ecoredoc.generator.config.EEnumConfig
import com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.EEnumConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.EEnumLiteralConfigPair
import com.google.common.collect.Multimap
import com.google.inject.Injector
import java.util.Map
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

class EEnumGeneratorPart extends AEcoreDocGeneratorEDataTypePart {

	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages, Injector xcoreInjector) {
		super(config, ePackages, xcoreInjector)
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
				val pair = new EEnumConfigPair(entry)
				writeEEnumHeader(pair)
				writeProperties(pair)
				writeEEnumLiterals(pair)
				writeUseCases(pair)
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

	protected def void writeEEnumLiterals(EEnumConfigPair pair) {
		val eEnum = pair.element

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
				writeELiteral(new EEnumLiteralConfigPair(entry))
			}
			
			output.append(tableFooter())
		}
		
	}

	protected def void writeELiteral(EEnumLiteralConfigPair pair) {
		val eLiteral = pair.element
		
		output.append(
		'''
			«newline»
			|«eLiteral.name»[[«concatAnchor(eLiteral)»]]
			|«eLiteral.value»
			|«getDocumentation(eLiteral)»
		''')
	}

	def protected void writeEEnumHeader(EEnumConfigPair pair) {
		val eEnum = pair.element

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
