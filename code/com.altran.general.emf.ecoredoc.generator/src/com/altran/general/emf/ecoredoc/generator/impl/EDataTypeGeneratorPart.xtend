package com.altran.general.emf.ecoredoc.generator.impl

import com.google.common.collect.Multimap
import java.util.List
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorPartConfig
import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline

class EDataTypeGeneratorPart extends AEcoreDocGeneratorPart {

	new(IEcoreDocGeneratorPartConfig config, Multimap<EPackage, EClassifier> ePackages) {
		super(config, ePackages)
	}

	override StringBuilder write(EPackage ePackage) {
		clearOutput()

		val eDataTypes = collectEDataTypes(ePackage)

		writeEDataTypes(eDataTypes)

		return output
	}

	protected def List<EDataType> collectEDataTypes(EPackage ePackage) {
		this.getEPackages.get(ePackage).filter(EDataType).filter[!(it instanceof EEnum)].sortBy[it.name ?: ""]
	}

	protected def void writeEDataTypes(List<EDataType> eDataTypes) {
		if (!eDataTypes.isEmpty) {
			writeEDataTypesHeader()

			for (eDataType : eDataTypes) {
				writeEDataTypeHeader(eDataType)
				writeProperties(eDataType)
				writeUseCases(eDataType)
			}
		}
	}

	protected def void writeEDataTypesHeader() {
		output.append(
		'''
			«newline»
			=== Data Types
		''')
	}

	protected def CharSequence writeEDataTypeHeader(EDataType eDataType) {
		output.append(
		'''
			«newline»
			[[«concatAnchor(eDataType)»]]
			==== «eDataType.name»
			«newline»
			«getDocumentation(eDataType)»
			«newline»
		''')
	}
}
