package com.altran.general.emf.ecoredoc.generator

import com.altran.general.emf.ecoredoc.generator.config.EPackageConfig
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigBuilder
import com.altran.general.emf.ecoredoc.generator.impl.EClassGeneratorPart
import com.altran.general.emf.ecoredoc.generator.impl.EDataTypeGeneratorPart
import com.altran.general.emf.ecoredoc.generator.impl.EEnumGeneratorPart
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension
import com.google.common.collect.Multimap
import com.google.common.collect.TreeMultimap
import java.util.Collection
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage

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

		val parts = #[
			new EDataTypeGeneratorPart(getConfig(), getEPackages()),
			new EEnumGeneratorPart(getConfig(), getEPackages()),
			new EClassGeneratorPart(getConfig(), getEPackages())
		]
		
		for (ePackage : getEPackages().keySet) {
			
			val config = getConfig().findConfig(ePackage) as EPackageConfig
			
			if (config.shouldRender) {
				writeEPackageIntro(ePackage)
				
				parts.sortBy[
					switch(it) {
						EDataTypeGeneratorPart: config.EDataTypesPosition
						EEnumGeneratorPart: config.EEnumsPosition
						EClassGeneratorPart: config.EClassesPosition
					} as Integer
				].forEach [
					output.append(it.write(ePackage))
				]
			}
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
	
	protected def getEPackages() {
		if (this.ePackages.isEmpty) {
			collectEPackages()
		}
		
		return this.ePackages
	}

	protected def void collectEPackages() {
		for (eclassifier : input) {
			this.ePackages.put(eclassifier.eContainer as EPackage, eclassifier)
		}
	}
	
	protected def void assureConfigExists() {
		if (this.config === null) {
			this.config = new EcoreDocConfigBuilder(getEPackages().keySet).build()
		}
	}
}
