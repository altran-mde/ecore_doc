package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature

class EClassGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> ePackages) {
		super(ePackages)
	}

	override write(EPackage ePackage) {
		val eClasses = collectEClasses(ePackage)

		writeEClasses(eClasses)

		return output
	}

	protected def List<EClass> collectEClasses(EPackage ePackages) {
		this.getEPackages.get(ePackages).filter(EClass).sortBy[it.name]
	}

	protected def writeEClasses(List<EClass> eClasses) {
		if (!eClasses.isEmpty) {
			writeEClassesHeader()

			for (eClass : eClasses) {
				writeEClass(eClass)
			}
		}
	}

	protected def writeEClassesHeader() {
		output.append('''=== Types

			''')
	}

	def protected writeEClass(EClass eClass) {
		writeEClassHeader(eClass)
		writeSuperTypes(eClass)

		if (!eClass.EAllAttributes.isEmpty) {
			writeEAttributesHeader()
			writeEStructuralFeatures(eClass.EAllAttributes, eClass, false)
		}

		if (!eClass.EAllReferences.isEmpty) {
			writeEReferencesHeader()
			writeEStructuralFeatures(eClass.EAllReferences, eClass, true)
		}

	}

	def protected writeSuperTypes(EClass eClass) {
		if (!eClass.EAllSuperTypes.isEmpty) {
			output.append(
			'''
				
				.Supertypes
				«FOR supertype : eClass.EAllSuperTypes.sortBy[it.name]»
					* «concatLinkTo(supertype)»
				«ENDFOR»
				
			''')
		} else {
			output.append(newline)
		}
	}

	protected def writeEAttributesHeader() {
		output.append(
		'''
			.Attributes
			«tableHeader»
			|===
			|Name
			|Type
			|Multiplicity{nbsp}/ Order
			|Default Value
			|Description
			
		''')
	}

	protected def tableHeader() {
		'''[cols="<15m,<15,<15m,<15m,<40a",options="header"]'''
	}

	protected def writeEStructuralFeatures(List<? extends EStructuralFeature> eStructuralFeatures, EClass eClass,
		boolean isEReference) {

		// Gather all inherited eStructuralFeatures and their classes.
		val Set<EStructuralFeature> inheritedStructuralFeatures = newLinkedHashSet()

		for (superclass : eClass.EAllSuperTypes) {
			if (isEReference) {
				inheritedStructuralFeatures.addAll(superclass.EAllReferences)
			} else {
				inheritedStructuralFeatures.addAll(superclass.EAllAttributes)
			}
		}

		// Iterate through non inherited eStructuralFeatures.
		for (eStructuralFeature : eStructuralFeatures.sortBy[it.name]) {
			if (!inheritedStructuralFeatures.contains(eStructuralFeature)) {

				writeRow(eStructuralFeature, eClass)
			}
		}

		// Iterate through inherited eStructuralFeatures.
		for (eStructuralFeature : inheritedStructuralFeatures.sortBy[it.name]) {

			writeRow(eStructuralFeature, eClass)
		}
		output.append(tableFooter())
	}

	def protected writeRow(EStructuralFeature eStructuralFeature, EClass eClass) {

		val eStructuralFeatureClass = eStructuralFeature.eContainer as EClass
		val isInherited = (eClass != eStructuralFeatureClass)
		val lowerBound = eStructuralFeature.lowerBound
		val upperBound = eStructuralFeature.upperBound
		val eStructuralFeatureName = eStructuralFeature.name
		val inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClass)
		val isEReference = (eStructuralFeature instanceof EReference)
		var EReference eReference
//		var EAttribute eAttribute
		if (isEReference) {
			eReference = (eStructuralFeature as EReference)
		} else {
//			eAttribute = (eStructuralFeature as EAttribute)
		}

		output.append(
		'''
		|«eStructuralFeatureName»[[«inheritedFeatureSegments.join("-")»]]«IF isInherited» +«ENDIF»
		«IF isInherited»«concatInheritedEStructuralElementType(eStructuralFeature)»«ENDIF»
		|«concatLinkTo(eStructuralFeature.EType)»
		|«concatBounds(lowerBound, upperBound)»
		|«IF isEReference»«IF eReference.EOpposite !== null»«concatOpposite(eReference)»«ENDIF»«ENDIF»
		|«getDocumentation(eStructuralFeature)»
		
		''')
	}

	def protected concatInheritedEStructuralElementType(ENamedElement eNamedElement) {
		'''(<<«concatAnchor(eNamedElement)», {inherited}«concatReferenceName(eNamedElement.eContainer as EClass)»>>)'''
	}

	def protected concatBounds(int lowerBound, int upperBound) {
		'''«lowerBound»«IF lowerBound != upperBound»..«upperBound»«ENDIF»'''
	}

	def protected concatOpposite(EReference eReference) {
		val eOppositeName = eReference.EOpposite.name
		// I'm pretty sure this will not produce the right outcome
		'''<<«concatAnchor(eReference.EReferenceType)»-«eOppositeName», «eOppositeName»>>'''
	}

	def protected writeEReferencesHeader() {
		output.append(
			'''
				.References
				[cols="<15m,<15,<15m,<15m,<40a",options="header"]
				|===
				|Name
				|Type
				|Multiplicity{nbsp}/ Order
				|Opposite
				|Description
				
			'''
		)
	}

	def protected CharSequence writeEClassHeader(EClass eClass) {

		val eClassName = eClass.name
		output.append(
		'''
			[[«concatAnchor(eClass)»]]
			==== «IF eClass.isAbstract && !eClass.isInterface»Abstract «ENDIF»«IF eClass.isInterface»Interface«ELSE»Class«ENDIF» «eClassName»
			
			«getDocumentation(eClass)»
		''')
	}
}
