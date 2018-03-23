package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.List
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage

class EDataTypeGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> ePackages) {
		super(ePackages)
	}

	override write(EPackage ePackage) {
		val eDataTypes = collectEDataTypes(ePackage)

		writeEDataTypes(eDataTypes)

		return output
	}

	// FIXME: same name as similar methods - Vasileios : i dont understand.
	protected def List<EDataType> collectEDataTypes(EPackage ePackage) {
		this.getEPackages.get(ePackage).filter(EDataType).filter[!(it instanceof EEnum)].sortBy[it.name]
	}

	/*
	 * Writes the dataTypes of the EPackage and where they are used in.
	 */
	protected def void writeEDataTypes(List<EDataType> eDataTypes) {
		if (!eDataTypes.isEmpty) {
			writeEDataTypesHeader()

			for (eDataType : eDataTypes) {
				//FIXME: Why wrap in richtstring? - DONE
				writeEDataTypeHeader(eDataType)
				writeUseCases(eDataType)
			}
		}
	}

	protected def writeEDataTypesHeader() {
		output.append('''
			=== Data Types
			
			TODO: Create template for EDataType
			
		''')
	}
	// FIXME: Why is this method public?- DONE
	// TODO: does this need to be a dispatch method? - DONE
	def protected CharSequence writeEDataTypeHeader(EDataType eDataType) {
		output.append(
		'''
		[[«writeDataTypes(eDataType)»]]
		==== «eDataType.name»
		
		''')
	}
}
