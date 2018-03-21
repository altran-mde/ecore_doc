package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import com.google.common.collect.TreeMultimap
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.util.EcoreUtil

// FIXME: Decide for all places: Either include the leading "E" in names or omit it, do not mix -->
// EcoreDocGenerator.packages vs. EcoreDocGenerator.epackages
// EcoreDocGenerator.generate(): pack vs. epackage
// DataTypeGeneratorPart.writeDataType() vs. ClassGeneratorPart.writeEClass()
// DataTypeGeneratorPart.writeDataTypes parameter dataTypes vs. AEcoreDocGeneratorPart.getPackage parameter eclassifier
class EcoreDocGenerator {

	val Collection<? extends EClassifier> input

	val output = new StringBuilder

	val Multimap<EPackage, EClassifier> ePackages = TreeMultimap.create(
		[o1, o2|o1.name.compareTo(o2.name)],
		[o1, o2|o1.name.compareTo(o2.name)]
	);

	new(Collection<? extends EClassifier> input) {
		this.input = input
	}

	def CharSequence generate() {
		writeIntro()

		collectEPackages()

		val eDataTypeGeneratorPart = new EDataTypeGeneratorPart(ePackages)
		val eEnumGeneratorPart = new EEnumGeneratorPart(ePackages)
		val eClassGeneratorPart = new EClassGeneratorPart(ePackages)

		for (ePackage : ePackages.keySet) {

			writeEPackageIntro(ePackage.name)

			output.append(eDataTypeGeneratorPart.write(ePackage))
			output.append(eEnumGeneratorPart.write(ePackage))
			output.append(eClassGeneratorPart.write(ePackage))

		}

		return output.toString
	}

	protected def writeIntro() {
		output.append('''
			// White Up-Pointing Triangle
			:wupt: &#9651;
			
			:inherited: {wupt}{nbsp}
			
			:table-caption!:
			
			= Ecore Documentation
			:toc:
			:toclevels: 4
			
		''')
	}

	protected def writeEPackageIntro(String ePackageName) {
		output.append('''
			[[«ePackageName»]]
			== Contents of «ePackageName»
			
		''')
	}

	protected def void collectEPackages() {
		for (eclassifier : input) {
			ePackages.put(eclassifier.eContainer as EPackage, eclassifier)
		}
	}
}
