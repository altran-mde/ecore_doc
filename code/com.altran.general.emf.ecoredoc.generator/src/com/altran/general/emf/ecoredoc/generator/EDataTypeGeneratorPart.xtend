package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
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

	// FIXME: sort
	// FIXME: same name as similar methods
	protected def Collection<EDataType> collectEDataTypes(EPackage ePackage) {
		this.getEPackages.get(ePackage).filter(EDataType).filter[!(it instanceof EEnum)].toSet
	}

	/*
	 * Writes the dataTypes of the EPackage and where they are used in.
	 */
	// FIXME: parameter should be List (is sorted)
	protected def void writeEDataTypes(Collection<EDataType> eDataTypes) {

		if (!eDataTypes.isEmpty) {
			writeEDataTypesHeader()
			val ePackage = getEPackage(eDataTypes.get(0))
			for (eDataType : eDataTypes) {
				writeEDataType(ePackage.name, eDataType.name)
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

	// FIXME: Use same signature for similar methods in all GeneratorParts
	protected def writeEDataType(String ePackageName, String eDataTypeName) {
		output.append('''
			[[«ePackageName»-«eDataTypeName»]]
			==== «eDataTypeName»
			
		''')
	}

}
