package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.List
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage

class EEnumGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> ePackages) {
		super(ePackages)
	}

	override write(EPackage ePackage) {
		clearOutput()

		val eEnums = collectEEnums(ePackage)

		writeEEnums(eEnums)

		return output
	}

	protected def List<EEnum> collectEEnums(EPackage ePackage) {
		this.getEPackages.get(ePackage).filter(EEnum).sortBy[it.name]
	}

	protected def void writeEEnums(List<EEnum> eEnums) {
		if (!eEnums.isEmpty) {
			writeEEnumsHeader()

			for (eEnum : eEnums) {
				writeEEnumHeader(eEnum)
				writeEEnumLiterals(eEnum)
				writeUseCases(eEnum)
			}
		}
	}

	protected def writeEEnumsHeader() {
		output.append(
		'''
			=== Enumerations
			«newline»
		''')
	}

	protected def writeEEnumLiterals(EEnum eEnum) {
		output.append(
			'''
				«newline»
				.Literals
				[cols="<20m,>10m,<70a",options="header"]
				|===
				|Symbol
				|Value
				|Description
				«newline»
			'''
		)
		
		for (eLiteral : eEnum.ELiterals) {
			writeELiteral(eLiteral)
		}
		
		output.append(tableFooter())
	}

	protected def writeELiteral(EEnumLiteral eLiteral) {
		output.append(
		'''
			|«eLiteral.name»[[«concatAnchor(eLiteral)»]]
			|«eLiteral.value»
			|«getDocumentation(eLiteral)»
			«newline»
		''')
	}

	def protected CharSequence writeEEnumHeader(EEnum eEnum) {
		output.append(
		'''
			[[«concatAnchor(eEnum)»]]
			==== «eEnum.name»
			«newline»
			«getDocumentation(eEnum)»
		''')
	}

}
