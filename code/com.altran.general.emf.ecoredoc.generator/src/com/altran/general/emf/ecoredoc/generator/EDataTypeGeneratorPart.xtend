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
		clearOutput()
		
		val eDataTypes = collectEDataTypes(ePackage)

		writeEDataTypes(eDataTypes)

		return output
	}

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
				writeEDataTypeHeader(eDataType)
				concatUseCases(eDataType)
			}
		}
	}

	protected def writeEDataTypesHeader() {
		output.append('''
			=== Data Types
			
			TODO: Create template for EDataType
			
		''')
	}
	
	protected def CharSequence writeEDataTypeHeader(EDataType eDataType) {
		output.append(
		'''
		[[«concatAnchor(eDataType)»]]
		==== «eDataType.name»
		
		''')
	}
}
