package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EDataType

abstract class AEcoreDocGeneratorPart {

	val Multimap<EPackage, EClassifier> ePackages

	val output = new StringBuilder

	new(Multimap<EPackage, EClassifier> ePackages) {
		this.ePackages = ePackages
	}

	def abstract StringBuilder write(EPackage ePackage)

	protected def getEPackages() {
		this.ePackages
	}

	protected def getOutput() {
		this.output
	}

	protected def EPackage getEPackage(EClassifier eClassifier) {
		eClassifier.eContainer as EPackage
	}

	// FIXME: Introduce method to create the anchor name (<EPackage.name>-<EClass.name>-<EAttribute.name>) of EClassifiers and use it at any place we output the anchor name -DONE
	// FIXME: Introduce method to create the reference name (<EPackage.name>.<EClass.name>.<EAttribute.name>) of EClassifiers and use it at any place we output the reference name -DONE
	/*
	 * Writes in which classes the given EClassifier is used. 
	 * Goes through every class and then every attribute and it compare the dataType.name with the attribute type name.
	 */
	protected def CharSequence writeAnchor(String...toAnchor){
		var anchor = ''''''
		var counter = 0;
		for(name : toAnchor){
			anchor = anchor+'''«IF counter!=0»-«ENDIF»'''+name
			counter++
		}
		return anchor
	}
	protected def CharSequence writeReference(String...toReference){
		var reference = ''''''
		var counter = 0;
		for(name : toReference){
			reference = reference+'''«IF counter!=0».«ENDIF»'''+name
			counter++
		}
		return reference
	}
	protected def CharSequence writeAnchorAndReference(String...names){
		'''«writeAnchor(names)», «writeReference(names)»'''
	}
	protected def void writeUseCases(EClassifier target) {
		var anyMatch = false

		val eClasses = collectAllEClasses.reject[it == target]

		val useCaseStrings = newArrayList()
		for (eClass : eClasses) {
			for (feature : eClass.EAllStructuralFeatures) {
				if (feature.EType == target) {
					anyMatch = true
					val ePackageName = (eClass.eContainer as EPackage).name
					useCaseStrings.add(
					'''
						* <<«writeAnchorAndReference(ePackageName, eClass.name, feature.name)»>>
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
	// FIXME: Either move to superclass and reuse it or rename - DONE
	def  dispatch CharSequence writeEClassifierHeader(EDataType eDataType) {
		val ePackageName = getEPackage(eDataType).name
		val eDataTypeName = eDataType.name
		'''
		[[«writeAnchor(ePackageName, eDataTypeName)»]]
		==== «eDataType.name»
		
		'''
	}
	def  dispatch CharSequence writeEClassifierHeader(EClass eClass) {
		val ePackageName = getEPackage(eClass).name
		val eClassName = eClass.name
		'''
		[[«writeAnchor(ePackageName, eClassName)»]]
		==== «IF eClass.isAbstract && !eClass.isInterface»Abstract «ENDIF»«IF eClass.isInterface»Interface«ELSE»Class«ENDIF» «eClassName»
		
		'''
	}

	// FIXME: This is the footer of a table in AsciiDoc. Use appropriate method name. - DONE
	// FIXME: Use at all places that end a table, symmetrically to the start of the table - DONE
	def CharSequence writeFooter() {
		'''
		|===
		
		'''
	}
	// FIXME: Use the for every element that may have a documentation - DONE
	def CharSequence getDocumentation(EModelElement modelElement) {
		'''
		«EcoreUtil.getDocumentation(modelElement)
		»
		'''
	}

	protected def String newline() {
		System.getProperty("line.separator")
	}

	protected def Collection<EClass> collectAllEClasses() {
		ePackages.values.filter(EClass).toSet
	}
}
