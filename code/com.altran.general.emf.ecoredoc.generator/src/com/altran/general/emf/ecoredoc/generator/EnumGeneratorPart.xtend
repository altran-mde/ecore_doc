package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil

// FIXME: Decide for one naming:
// EEnum vs. Enumerations vs. Enum
class EnumGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> packages) {
		super(packages)
	}

	override write(EPackage pack) {
		val eenums = collectEEnums(pack)

		writeEnumerations(eenums)

		return output
	}

	// FIXME: sort
	// FIXME: same name as similar methods
	protected def Collection<EEnum> collectEEnums(EPackage pack) {
		this.packages.get(pack).filter(EEnum).toSet
	}

	// FIXME: parameter should be List (is sorted)
	protected def void writeEnumerations(Collection<EEnum> eenums) {
		if (!eenums.isEmpty) {
			writeEnumerationsHeader()
			val pack = getPackage(eenums.get(0))
			for (eenum : eenums) {
				writeEnumHeader(eenum)
				writeEnumLiterals(eenum, pack)
				writeUseCases(eenum)
			}
		}
	}

	protected def writeEnumerationsHeader() {
		output.append('''=== Enumerations

			''')
	}

	protected def writeEnumHeader(EEnum eenum) {

		writeEClassifierHeader(eenum)
		output.append(
		'''
			«getDocumentation(eenum)»
			
			.Literals
			[cols="<20m,>10m,<70a",options="header"]
			|===
			|Symbol
			|Value
			|Description
			
		''')
	}

	// FIXME: Use same signature for similar methods
	protected def writeEnumLiterals(EEnum eenum, EPackage pack) {
		for (literal : eenum.ELiterals) {
			writeLiteral(literal)
		}
		// FIXME: Call this symmetrically in the same method that creates the table header
		writeBlockClosure()
	}

	protected def writeLiteral(EEnumLiteral literal) {
		val eenum = literal.eContainer as EEnum
		val pack = eenum.eContainer as EPackage
		output.append(
			'''
			|«literal.name»[[«pack.name»-«eenum.name»-«literal.name»]]
			|«literal.value»
			|«EcoreUtil.getDocumentation(literal)»
			
		''')
	}

	// FIXME: Either move to superclass and reuse it or rename
	protected def writeEClassifierHeader(EClassifier eclassifier) {
		val pack = getPackage(eclassifier)
		output.append(
		'''
			[[«pack.name»-«eclassifier.name»]]
			==== «eclassifier.name»
			
		''')
	}

}
