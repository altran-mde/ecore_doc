package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil

abstract class AEcoreDocGeneratorPart {

	val Multimap<EPackage, EClassifier> packages

	val output = new StringBuilder

	new(Multimap<EPackage, EClassifier> packages) {
		this.packages = packages
	}

	def abstract StringBuilder write(EPackage pack)

	protected def getPackages() {
		this.packages
	}

	protected def getOutput() {
		this.output
	}

	protected def EPackage getPackage(EClassifier eclassifier) {
		eclassifier.eContainer as EPackage
	}

	// FIXME: Introduce method to create the anchor name (<EPackage.name>-<EClass.name>-<EAttribute.name>) of EClassifiers and use it at any place we output the anchor name
	// FIXME: Introduce method to create the reference name (<EPackage.name>.<EClass.name>.<EAttribute.name>) of EClassifiers and use it at any place we output the reference name
	/*
	 * Writes in which classes the given EClassifier is used. 
	 * Goes through every class and then every attribute and it compare the dataType.name with the attribute type name.
	 */
	protected def void writeUseCases(EClassifier target) {
		var anyMatch = false

		val eclasses = collectAllEClasses.reject[it == target]

		val useCaseStrings = newArrayList()
		for (eclass : eclasses) {
			for (feature : eclass.EAllStructuralFeatures) {
				if (feature.EType == target) {
					anyMatch = true
					val packageName = (eclass.eContainer as EPackage).name
					useCaseStrings.add(
					'''
						* <<«packageName»-«eclass.name»-«feature.name», «packageName».«eclass.name».«feature.name»>>
					''')
				}

			}
		}

		if (anyMatch) {
			output.append('''
				.Used at
			''')
			for (useCaseString : useCaseStrings.sort) {
				output.append(useCaseString)
			}
			output.append(newline)
		}
	}

	// FIXME: This is the footer of a table in AsciiDoc. Use appropriate method name.
	// FIXME: Use at all places that end a table, symmetrically to the start of the table
	protected def writeBlockClosure() {
		output.append('''|===

		''')
	}

	// FIXME: Use the for every element that may have a documentation
	protected def getDocumentation(EClassifier eclassifier) {
		EcoreUtil.getDocumentation(eclassifier)
	}

	protected def String newline() {
		System.getProperty("line.separator")
	}

	protected def Collection<EClass> collectAllEClasses() {
		packages.values.filter(EClass).toSet
	}
}
