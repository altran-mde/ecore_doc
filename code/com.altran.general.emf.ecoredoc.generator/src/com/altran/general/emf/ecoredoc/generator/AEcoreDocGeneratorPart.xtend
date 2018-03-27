package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.util.EcoreUtil

abstract class AEcoreDocGeneratorPart {

	val Multimap<EPackage, EClassifier> ePackages
	
	val anchorSeparator = '-'
	
	protected def getAnchorSeparator() {
		this.anchorSeparator
	}
	
	val referenceSeparator = '.'
	
	protected def getReferenceSeparator() {
		this.referenceSeparator
	}
	
	val output = new StringBuilder()

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
	
	protected def dispatch CharSequence concatAnchor(ENamedElement eNamedElement) {
		collectTypeSegments(eNamedElement).join(anchorSeparator)
	}
	
	// Special handling for default EDataTypes: Don't create anchor
	protected def dispatch CharSequence concatAnchor(EDataType eDataType) {
		if (!isDefaultEDataType(eDataType)) {
			collectTypeSegments(eDataType).join(anchorSeparator)
		} else {
			""
		}
	}
	
	protected def CharSequence concatReferenceName(ENamedElement eNamedElement) {
		collectTypeSegments(eNamedElement).join(referenceSeparator)
	}
	
	protected def dispatch CharSequence concatLinkTo(ENamedElement eNamedElement) {
		'''<<«concatAnchor(eNamedElement)», «concatReferenceName(eNamedElement)»>>'''
	}

	// Special handling for default EDataTypes: Don't create anchor
	protected def dispatch CharSequence concatLinkTo(EDataType eDataType) {
		if (!isDefaultEDataType(eDataType)) {
			'''<<«concatAnchor(eDataType)», «concatReferenceName(eDataType)»>>'''
		} else {
			eDataType.name
		}
	}
	
	protected def CharSequence concatUsedLink(EStructuralFeature eStructuralFeature, EClass eClassThatInherits){
		val inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClassThatInherits)
		'''<<«inheritedFeatureSegments.join(anchorSeparator)», «inheritedFeatureSegments.join(referenceSeparator)»>>'''
	}
	
	protected def String[] collectInheritedFeatureSegments(EStructuralFeature eStructuralFeature, EClass eClassThatInherits){
		
		val ePackageName = getEPackage(eClassThatInherits).name
		val eClassName = eClassThatInherits.name
		val eStructuralFeatureName = eStructuralFeature.name
		
		#[ePackageName, eClassName, eStructuralFeatureName]
	}
	
	protected def dispatch String[] collectTypeSegments(EClass eClass) {
		val eClassName = eClass.name
		val ePackageName = getEPackage(eClass).name
		
		#[ePackageName, eClassName]
		
	}
	
	protected def dispatch String[] collectTypeSegments(EStructuralFeature eStructuralFeature) {
		val eClass = eStructuralFeature.eContainer as EClass
		val ePackageName = getEPackage(eClass).name
		val eClassName = eClass.name
		val eStructuralFeatureName = eStructuralFeature.name
		
		#[ePackageName, eClassName, eStructuralFeatureName]
	}
	
	protected def dispatch String[] collectTypeSegments(EEnumLiteral eEnumLiteral) {
		val eEnum = eEnumLiteral.eContainer as EEnum
		val ePackageName = getEPackage(eEnum).name
		
		#[ePackageName, eEnum.name, eEnumLiteral.name]
	}

	protected def dispatch String[] collectTypeSegments(EDataType eDataType) {
		val eDataTypeName = eDataType.name
		if (!isDefaultEDataType(eDataType)) {
			val eDataTypePackageName = (eDataType.eContainer as EPackage).name
			#[eDataTypePackageName, eDataTypeName]
		} else {
			#[eDataTypeName]
		}
	}
	
	protected def void concatUseCases(EClassifier target) {
		var anyMatch = false

		val eClasses = collectAllEClasses.reject[it == target]

		val useCaseStrings = newArrayList()
		for (eClass : eClasses) {
			for (feature : eClass.EAllStructuralFeatures.sortBy[it.name]) {
				if (feature.EType == target) {
					anyMatch = true
					useCaseStrings.add(
					'''
						* «concatUsedLink(feature, eClass)»
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
	def protected writeSubConceptsHeader(){
		output.append('''.Sub-concepts
		''')
	
	}
	def protected CharSequence tableFooter() {
		'''
		|===
		«newline»
		'''
	}
	
	def protected CharSequence getDocumentation(EModelElement modelElement) {
		EcoreUtil.getDocumentation(modelElement)
	}

	protected def boolean isDefaultEDataType(EDataType eDataType) {
		EcorePackage.eINSTANCE.nsURI == getEPackage(eDataType).nsURI
	}

	protected def String newline() {
		System.getProperty("line.separator")
	}

	protected def Collection<EClass> collectAllEClasses() {
		ePackages.values.filter(EClass).toSet
	}
}
