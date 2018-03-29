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
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.ecoredoc.generator.config.ConfigFactory

import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline

class EcoreDocGenerator {

	extension EcoreDocExtension = new EcoreDocExtension

	val Collection<? extends EClassifier> input

	val output = new StringBuilder

	val Multimap<EPackage, EClassifier> ePackages = TreeMultimap.create(
		[o1, o2|o1.name.compareTo(o2.name)],
		[o1, o2|o1.name.compareTo(o2.name)]
	);
	
	var EcoreDocGeneratorConfig config

	new(Collection<? extends EClassifier> input) {
		this.input = input
	}

	def CharSequence generate() {
		writeIntro()

		collectEPackages()

		val eDataTypeGeneratorPart = new EDataTypeGeneratorPart(getConfig().EDataType, ePackages)
		val eEnumGeneratorPart = new EEnumGeneratorPart(getConfig().EEnum, ePackages)
		val eClassGeneratorPart = new EClassGeneratorPart(getConfig().EClass, ePackages)

		for (ePackage : ePackages.keySet) {

			writeEPackageIntro(ePackage)

			output.append(eDataTypeGeneratorPart.write(ePackage))
			output.append(eEnumGeneratorPart.write(ePackage))
			output.append(eClassGeneratorPart.write(ePackage))
		}

		return output.toString
	}
	
	def getConfig() {
		assureConfigExists()
		
		return this.config
	}

	protected def writeIntro() {
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

	protected def writeEPackageIntro(EPackage ePackage) {
		val ePackageName = ePackage.name
		output.append(
		'''
			«newline»
			«newline»
			[[«ePackageName»]]
			== Contents of «ePackageName»
			«newline»
			«getDocumentation(ePackage)»
			«newline»
			«concatEPackageProperties(ePackage)»
		''')
	}

	protected def concatEPackageProperties(EPackage ePackage) {
		'''
			Ns Prefix:: «ePackage.nsPrefix»
			Ns URI:: «ePackage.nsURI»
		'''
	}

	protected def void collectEPackages() {
		for (eclassifier : input) {
			ePackages.put(eclassifier.eContainer as EPackage, eclassifier)
		}
	}
	
	protected def void assureConfigExists() {
		if (this.config === null) {
			this.config = ConfigFactory.eINSTANCE.createEcoreDocGeneratorConfig
		}
	}
}
