package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.List
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil

// FIXME: Decide for one naming:
// EEnum vs. Enumerations vs. Enum
class EEnumGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> ePackages) {
		super(ePackages)
	}

	override write(EPackage ePackage) {
		val eEnums = collectEEnums(ePackage)

		writeEEnumerations(eEnums)

		return output
	}

	// FIXME: same name as similar methods
	protected def List<EEnum> collectEEnums(EPackage ePackage) {
		this.getEPackages.get(ePackage).filter(EEnum).sortBy[it.name]
	}

	protected def void writeEEnumerations(List<EEnum> eEnums) {
		if (!eEnums.isEmpty) {
			writeEEnumerationsHeader()

			val ePackage = getEPackage(eEnums.get(0))
			for (eEnum : eEnums) {
				//FIXME: Why wrap in richstring?
				output.append('''«writeEClassifierHeader(eEnum)»''')
				output.append('''«getDocumentation(eEnum)»''')
				writeEEnumLiterals(eEnum, ePackage)
				writeUseCases(eEnum)
			}
		}
	}

	protected def writeEEnumerationsHeader() {
		output.append('''=== Enumerations

			''')
	}

	// FIXME: Use same signature for similar methods
	protected def writeEEnumLiterals(EEnum eEnum, EPackage ePackage) {
		output.append(
		'''
		
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
		// FIXME: Why wrap in richstring?
		output.append(
		'''
		«writeFooter()»
		'''
		)
		
	}

	protected def writeELiteral(EEnumLiteral eLiteral) {
		// FIXME: Warning! --> act!
		val eEnum = eLiteral.eContainer as EEnum
		output.append(
		'''
		|«eLiteral.name»[[«writeAnchor(eLiteral)»]]
		|«eLiteral.value»
		|«EcoreUtil.getDocumentation(eLiteral)»
		
		''')
	}

}
