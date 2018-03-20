package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import com.google.common.collect.TreeMultimap
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage

// FIXME: Decide for all places: Either include the leading "E" in names or omit it, do not mix -->
// EcoreDocGenerator.packages vs. EcoreDocGenerator.epackages
// EcoreDocGenerator.generate(): pack vs. epackage
// DataTypeGeneratorPart.writeDataType() vs. ClassGeneratorPart.writeEClass()
// DataTypeGeneratorPart.writeDataTypes parameter dataTypes vs. AEcoreDocGeneratorPart.getPackage parameter eclassifier
class EcoreDocGenerator {

	val Collection<? extends EClassifier> input

	val output = new StringBuilder

	val Multimap<EPackage, EClassifier> packages = TreeMultimap.create(
		[o1, o2|o1.name.compareTo(o2.name)],
		[o1, o2|o1.name.compareTo(o2.name)]
	);

	new(Collection<? extends EClassifier> input) {
		this.input = input
	}

	def CharSequence generate() {
		writeIntro()

		collectPackages()

		val dataTypeGeneratorPart = new DataTypeGeneratorPart(packages)
		val enumGeneratorPart = new EnumGeneratorPart(packages)
		val classGeneratorPart = new ClassGeneratorPart(packages)

		for (pack : packages.keySet) {

			writePackageIntro(pack.name)

			output.append(dataTypeGeneratorPart.write(pack))
			output.append(enumGeneratorPart.write(pack))
			output.append(classGeneratorPart.write(pack))

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

	protected def writePackageIntro(String packageName) {
		output.append('''
			[[«packageName»]]
			== Contents of «packageName»
			
		''')
	}

	protected def void collectPackages() {
		for (eclassifier : input) {
			packages.put(eclassifier.eContainer as EPackage, eclassifier)
		}
	}

	// TODO: Unused?
	protected def dispatch CharSequence writeEClassifierType(EClass clazz) {
		'''Class'''
	}

	// TODO: Unused?
	protected def dispatch CharSequence writeEClassifierType(EEnum eenum) {
		'''Enum'''
	}

	// TODO: Unused?
	protected def dispatch CharSequence writeEClassifierType(EDataType dataType) {
	}
}
