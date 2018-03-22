package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import java.util.List

class EDataTypeGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> ePackages) {
		super(ePackages)
	}

	override write(EPackage ePackage) {
		val eDataTypes = collectEDataTypes(ePackage)

		writeEDataTypes(eDataTypes)

		return output
	}

	// FIXME: sort - DONE
	// FIXME: same name as similar methods
	protected def List<EDataType> collectEDataTypes(EPackage ePackage) {
		this.getEPackages.get(ePackage).filter(EDataType).filter[!(it instanceof EEnum)].sortBy[it.name]
	}

	/*
	 * Writes the dataTypes of the EPackage and where they are used in.
	 */
	// FIXME: parameter should be List (is sorted) - DONE
	protected def void writeEDataTypes(List<EDataType> eDataTypes) {

		if (!eDataTypes.isEmpty) {
			writeEDataTypesHeader()
			for (eDataType : eDataTypes) {
				output.append('''«writeEClassifierHeader(eDataType)»''')
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
}
