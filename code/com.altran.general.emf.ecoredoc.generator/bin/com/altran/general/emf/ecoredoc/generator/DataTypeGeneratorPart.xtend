package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage

class DataTypeGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> packages) {
		super(packages)
	}

	override write(EPackage pack) {
		val dataTypes = collectDataTypes(pack)

		writeDataTypes(dataTypes)

		return output
	}

	// FIXME: sort
	// FIXME: same name as similar methods
	protected def Collection<EDataType> collectDataTypes(EPackage pack) {
		this.packages.get(pack).filter(EDataType).filter[!(it instanceof EEnum)].toSet
	}

	/*
	 * Writes the dataTypes of the EPackage and where they are used in.
	 */
	// FIXME: parameter should be List (is sorted)
	protected def void writeDataTypes(Collection<EDataType> dataTypes) {

		if (!dataTypes.isEmpty) {
			writeDataTypesHeader()
			val pack = getPackage(dataTypes.get(0))
			for (dataType : dataTypes) {
				writeDataType(pack.name, dataType.name)
				writeUseCases(dataType)
			}
		}
	}

	protected def writeDataTypesHeader() {
		output.append('''
			=== Data Types
			
			TODO: Create template for EDataType
			
		''')
	}

	// FIXME: Use same signature for similar methods in all GeneratorParts
	protected def writeDataType(String packageName, String dataTypeName) {
		output.append('''
			[[«packageName»-«dataTypeName»]]
			==== «dataTypeName»
			
		''')
	}

}
