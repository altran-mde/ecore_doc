package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.ENamedElement

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
	 
	protected def CharSequence writeAnchor(ENamedElement eNamedElement){
		writeType(eNamedElement, '-')
	}
	
	protected def CharSequence writeReferenceName(ENamedElement eNamedElement){
		writeType(eNamedElement, '.')
	}
	
	//Character S is serparator chosen to improve readability.
	protected def dispatch CharSequence writeType(EClass eClass, Character S) {
		val eClassName = eClass.name
		val ePackageName = getEPackage(eClass).name
		
		'''«ePackageName»«S»«eClassName»'''
	}
	
	protected def dispatch CharSequence writeType(EReference eReferece, Character S){
		val eClass = eReferece.EReferenceType
		val ePackageName = getEPackage(eClass).name
		val eClassName = eClass.name
		val eReferenceName = eReferece.name
		
		'''«ePackageName»«S»«eClassName»«S»«eReferenceName»'''
	}
	
	protected def dispatch CharSequence writeType(EAttribute eAttribute, Character S){
		val eClass = eAttribute.EAttributeType
		val ePackageName = getEPackage(eClass).name
		val eClassName = eClass.name
		val eAttributeName = eAttribute.name
		
		'''«ePackageName»«S»«eClassName»«S»«eAttributeName»'''
	}

	protected def dispatch CharSequence writeType(EDataType eDataType, Character S) {
		switch(eDataType) {
			case EcorePackage.eINSTANCE.EInt:
				'''EInt'''
			
			case EcorePackage.eINSTANCE.EString:
				'''EString'''
				
			case EcorePackage.eINSTANCE.EDouble:
				'''EDouble'''
				
			case EcorePackage.eINSTANCE.EChar:
				'''EChar'''
			
			case EcorePackage.eINSTANCE.EFloat:
				'''EFloat'''
				
			case EcorePackage.eINSTANCE.ELong:
				'''ELong'''
				
			case EcorePackage.eINSTANCE.EShort:
				'''EShort'''
				
			case EcorePackage.eINSTANCE.EBoolean:
				'''EBoolean'''
				
			case EcorePackage.eINSTANCE.EByte:
				'''EByte'''
				
			case EcorePackage.eINSTANCE.EDate:
				'''EDate'''
					
			default:
				'''«getEPackage(eDataType).name»«S»«(eDataType.eContainer as ENamedElement).name»«S»«eDataType.name»'''
		}
	}
	
	protected def dispatch CharSequence writeType(EEnumLiteral eEnumLiteral, Character S) {
		val eEnum = eEnumLiteral.eContainer as EEnum
		val ePackageName = getEPackage(eEnum).name
		val eClassName = eEnum.eClass.name
		'''«ePackageName»«S»«eEnum.name»«S»«eEnumLiteral.name»'''
	}
	
	
	protected def CharSequence writeAnchorAndReference(ENamedElement eNamedElement){
		'''«writeAnchor(eNamedElement)», «writeReferenceName(eNamedElement)»'''
	}
	protected def void writeUseCases(EClassifier target) {
		var anyMatch = false

		val eClasses = collectAllEClasses.reject[it == target]

		val useCaseStrings = newArrayList()
		for (eClass : eClasses) {
			for (feature : eClass.EAllStructuralFeatures.sortBy[it.name]) {
				if (feature.EType == target) {
					anyMatch = true
					useCaseStrings.add(
					'''
					* <<«writeAnchorAndReference(feature)»>>
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
		'''
		[[«writeAnchor(eDataType)»]]
		==== «eDataType.name»
		
		'''
	}
	def  dispatch CharSequence writeEClassifierHeader(EClass eClass) {
		val eClassName = eClass.name
		'''
		[[«writeAnchor(eClass)»]]
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
