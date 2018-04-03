package com.altran.general.emf.ecoredoc.generator

import com.altran.general.emf.ecoredoc.generator.impl.EClassGeneratorPart
import com.altran.general.emf.ecoredoc.generator.impl.EDataTypeGeneratorPart
import com.altran.general.emf.ecoredoc.generator.impl.EEnumGeneratorPart
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension
import com.google.common.collect.Multimap
import com.google.common.collect.TreeMultimap
import java.util.Collection
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage

class EcoreDocGenerator {

	extension EcoreDocExtension = new EcoreDocExtension

	val Collection<? extends EClassifier> input

	val StringBuilder output = new StringBuilder

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

		val EDataTypeGeneratorPart eDataTypeGeneratorPart = new EDataTypeGeneratorPart(ePackages)
		val EEnumGeneratorPart eEnumGeneratorPart = new EEnumGeneratorPart(ePackages)
		val EClassGeneratorPart eClassGeneratorPart = new EClassGeneratorPart(ePackages)

		for (ePackage : ePackages.keySet) {
			writeEPackageIntro(ePackage)

			output.append(eDataTypeGeneratorPart.write(ePackage))
			output.append(eEnumGeneratorPart.write(ePackage))
			output.append(eClassGeneratorPart.write(ePackage))
		}

		return output.toString
	}

	protected def void writeIntro() {
		output.append(
		'''
			// White Up-Pointing Triangle
			:wupt: &#9651;
			«newline»
			:inherited: {wupt}{nbsp}
			«newline»
			:table-caption!:
			«newline»
			= Ecore Documentation
			:toc:
			:toclevels: 4
		''')
	}

	protected def void writeEPackageIntro(EPackage ePackage) {
		val String ePackageName = ePackage.name

		output.append(
		'''
			«newline»
			«newline»
			[[«ePackageName»]]
			== Contents of «ePackageName»
			«newline»
			«getDocumentation(ePackage)»
		''')
	}

	protected def void collectEPackages() {
		for (eclassifier : input) {
			ePackages.put(eclassifier.eContainer as EPackage, eclassifier)
		}
	}
}
