package com.altran.general.emf.ecoredoc.generator.impl

import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature

abstract class AEcoreDocGeneratorPart {

	protected extension EcoreDocExtension = new EcoreDocExtension

	val Multimap<EPackage, EClassifier> ePackages

	var StringBuilder output

	new(Multimap<EPackage, EClassifier> ePackages) {
		this.ePackages = ePackages
	}

	protected def abstract StringBuilder write(EPackage ePackage)

	protected def void clearOutput() {
		this.output = new StringBuilder()
	}

	protected def  Multimap<EPackage, EClassifier> getEPackages() {
		this.ePackages
	}

	protected def StringBuilder getOutput() {
		if (this.output === null) {
			throw new IllegalStateException("Tried to write to output before clearing it")
		}

		this.output
	}

	protected def CharSequence concatReferenceName(ENamedElement eNamedElement) {
		collectTypeSegments(eNamedElement).join(EcoreDocExtension.REFERENCE_SEPARATOR)
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

	protected def CharSequence concatUsedLink(EStructuralFeature eStructuralFeature, EClass eClassThatInherits) {
		val inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClassThatInherits)

		'''<<«inheritedFeatureSegments.join(EcoreDocExtension.ANCHOR_SEPARATOR)», «inheritedFeatureSegments.join(EcoreDocExtension.REFERENCE_SEPARATOR)»>>'''
	}

	protected def String[] collectInheritedFeatureSegments(EStructuralFeature eStructuralFeature,
		EClass eClassThatInherits) {
		val ePackageName = getEPackage(eClassThatInherits).name
		val eClassName = eClassThatInherits.name
		val eStructuralFeatureName = eStructuralFeature.name

		#[ePackageName, eClassName, eStructuralFeatureName]
	}

	protected def void writeUseCases(EClassifier target) {
		var anyMatch = false
		val eClasses = collectAllEClasses()
		val useCaseStrings = newArrayList()

		for (eClass : eClasses.sortBy[it.name]) {
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
			output.append(
			'''
				«newline»
				.Used at
			''')

			for (useCaseString : useCaseStrings.sort) {
				output.append(useCaseString)
			}
		}
	}

	protected def CharSequence tableFooter() {
		'''
			|===
		'''
	}

	protected def Collection<EClass> collectAllEClasses() {
		ePackages.values.filter(EClass).toSet
	}
}
