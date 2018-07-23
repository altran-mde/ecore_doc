package com.altran.general.emf.ecoredoc.generator

import com.altran.general.emf.ecoredoc.generator.config.EPackageConfig
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.EcoreDocConfigBuilder
import com.altran.general.emf.ecoredoc.generator.impl.EClassGeneratorPart
import com.altran.general.emf.ecoredoc.generator.impl.EDataTypeGeneratorPart
import com.altran.general.emf.ecoredoc.generator.impl.EEnumGeneratorPart
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension
import com.google.common.collect.Multimap
import com.google.common.collect.TreeMultimap
import com.google.inject.Injector
import java.util.Collection
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage

import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline

/**
 * Creates JavaDoc-like documents for Ecore metamodels in AsciiDoctor format.
 *
 * @see <a href=
 *      "http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html">JavaDoc
 *      Homepage</a>
 * @see <a href="https://wiki.eclipse.org/Ecore">Ecore Wiki entry</a>
 * @see <a href="https://asciidoctor.org/">AsciiDoctor Homepage</a>
 *
 */
/*
 * Naming conventions:
 *  - Ecore names are written in full, i.e. including the leading "E".
 *  - "writeX()" returns void and writes directly to the output.
 *  - "defineX()" produces the output text for a property, or null if no output is required.
 */
class EcoreDocGenerator {

	extension EcoreDocExtension ecoreDocExtension = new EcoreDocExtension

	val Collection<? extends EClassifier> input

	val output = new StringBuilder
	
	var Injector xcoreInjector

	val Multimap<EPackage, EClassifier> ePackages = TreeMultimap.create(
		[o1, o2|o1.name.compareTo(o2.name)],
		[o1, o2|o1.name.compareTo(o2.name)]
	);
	
	var EcoreDocGeneratorConfig config

	new(Collection<? extends EClassifier> input) {
		this.input = input
	}

	/**
	 * Generates the AsciiDoctor contents.
	 */
	def CharSequence generate() {
		writeIntro()

		val parts = #[
			new EDataTypeGeneratorPart(getConfig(), getEPackages(), getXcoreInjector()),
			new EEnumGeneratorPart(getConfig(), getEPackages(), getXcoreInjector()),
			new EClassGeneratorPart(getConfig(), getEPackages(), getXcoreInjector())
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
	
	/**
	 * Returns a fully populated configuration.
	 */
	def getConfig() {
		ensureConfigExists()
		
		return this.config
	}
	
	def getXcoreInjector() {
		this.xcoreInjector
	}
	
	def setXcoreInjector(Injector xcoreInjector) {
		this.xcoreInjector = xcoreInjector
	}

	protected def void writeIntro() {
		output.append(
		'''
			// White Up-Pointing Triangle
			:wupt: &#9651;

			:inherited: {wupt}{nbsp}

			// Black Up-Pointing Triangle
			:bupt: &#9650;

			:override: {bupt}{nbsp}

			:table-caption!:

			:source-highlighter: pygments
			
			= «getConfig().documentTitle»
			:toc:
			:toclevels: 4
		''')
	}

	protected def void writeEPackageIntro(EPackage ePackage) {
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
	
	protected def void ensureConfigExists() {
		if (this.config === null) {
			this.config = new EcoreDocConfigBuilder(getEPackages().keySet).build()
		}
	}
}
