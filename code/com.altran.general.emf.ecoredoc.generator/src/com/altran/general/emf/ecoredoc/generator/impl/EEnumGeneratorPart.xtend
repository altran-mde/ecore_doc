package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig
import com.google.common.collect.Multimap
import java.util.List
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage

import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline

class EEnumGeneratorPart extends AEcoreDocGeneratorPart {

	new(IEcoreDocGeneratorPartConfig config, Multimap<EPackage, EClassifier> ePackages) {
		super(config, ePackages)
	}

	override StringBuilder write(EPackage ePackage) {
		clearOutput()

		val eEnums = collectEEnums(ePackage)

		writeEEnums(eEnums)

		return output
	}

	protected def List<EEnum> collectEEnums(EPackage ePackage) {
		this.getEPackages.get(ePackage).filter(EEnum).sortBy[it.name ?: ""]
	}

	protected def void writeEEnums(List<EEnum> eEnums) {
		if (!eEnums.isEmpty) {
			writeEEnumsHeader()

			for (eEnum : eEnums) {
				writeEEnumHeader(eEnum)
				writeProperties(eEnum)
				writeEEnumLiterals(eEnum)
				writeUseCases(eEnum)
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

	protected def void writeEEnumLiterals(EEnum eEnum) {
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

	def protected CharSequence writeEEnumHeader(EEnum eEnum) {
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
