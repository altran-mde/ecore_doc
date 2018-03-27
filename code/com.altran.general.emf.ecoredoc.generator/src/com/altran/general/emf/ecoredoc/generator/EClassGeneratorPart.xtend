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
import org.eclipse.emf.ecore.EAttribute

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
		output.append('''
		=== Types
		«newline»
		''')
	}

	protected def writeEClass(EClass eClass) {
		writeEClassHeader(eClass)
		writeSuperTypes(eClass)
		writeSubConcepts(eClass)
		writeEAttributes(eClass)
		writeEReferences(eClass)
	
		concatUseCases(eClass)
	}
	protected def writeEReferences(EClass eClass){
		if (!eClass.EAllReferences.isEmpty) {
			writeEConainments(eClass)
			writeECrossReferences(eClass)
		}
	}
	protected def writeEConainments(EClass eClass){
		if(eClass.EAllReferences.exists[isContainment]){
			writeEContainmentHeader()
			for(eReference : eClass.EAllReferences){
				if(eReference.isContainment){
					writeRow(eReference, eClass)
				}
			}
		}
	}
	
	protected def writeECrossReferences(EClass eClass){
		if(!eClass.eCrossReferences.isEmpty){
			writeEReferencesHeader()
			writeEStructuralFeatures(eClass.EAllReferences, eClass, true)
		}
	}
	protected def writeEAttributes(EClass eClass){
		if (!eClass.EAllAttributes.isEmpty) {
			writeEAttributesHeader()
			writeEStructuralFeatures(eClass.EAllAttributes, eClass, false)
		}
	}
	
	
	protected def writeEContainmentHeader() {
		output.append(
		'''
		.Containments
		[cols="<15m,<15,<15m,<15m,<40a",options="header"]
		|===
		|Name
		|Type
		|Multiplicity{nbsp}/ Order
		|Opposite
		|Description
		«newline»
		''')
	}
	
	protected def writeSubConcepts(EClass currentEClass) {
		var Set<EClass> eClassesThatInheritCurrent = newLinkedHashSet() 
		for (eClass : collectAllEClasses.reject[eClass == currentEClass]){
			if(eClass.EAllSuperTypes.contains(currentEClass)){
				eClassesThatInheritCurrent.add(eClass)
			}
		}
		var subConceptExists = !eClassesThatInheritCurrent.isEmpty
		if(subConceptExists){
			writeSubConceptsHeader()
		}
		for(eClass : eClassesThatInheritCurrent){
			writeSubConcept(eClass)
		}
		if(subConceptExists){
			output.append(newline)
		}
	}
	
	protected def writeSubConcept(EClass eClass){
		output.append(
			'''
			* «concatLinkTo(eClass)»
			'''
		)
	}

	protected def writeSuperTypes(EClass eClass) {
		if (!eClass.EAllSuperTypes.isEmpty) {
			output.append(
			'''
				«newline»
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
			«newline»
		''')
	}

	protected def tableHeader() {
		'''[cols="<15m,<15,<15m,<15m,<40a",options="header"]'''
	}

	protected def writeEStructuralFeatures(List<? extends EStructuralFeature> eStructuralFeatures, EClass eClass, boolean isEReference) {

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

	protected def writeRow(EStructuralFeature eStructuralFeature, EClass eClass) {

		val eStructuralFeatureClass = eStructuralFeature.eContainer as EClass
		val isInherited = (eClass != eStructuralFeatureClass)
		val lowerBound = eStructuralFeature.lowerBound
		val upperBound = eStructuralFeature.upperBound
		val eStructuralFeatureName = eStructuralFeature.name
		val inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClass)

		output.append(
		'''
		|«eStructuralFeatureName»[[«inheritedFeatureSegments.join(anchorSeparator)»]]«IF isInherited» +«ENDIF»
		«IF isInherited»«concatInheritedEStructuralElementType(eStructuralFeature)»«ENDIF»
		|«concatLinkTo(eStructuralFeature.EType)»
		|«concatBounds(lowerBound, upperBound)»
		|«dispatchEStructuralFeature(eStructuralFeature)»
		|«getDocumentation(eStructuralFeature)»
		«newline»
		''')
	}
	
	protected def dispatch dispatchEStructuralFeature(EAttribute eAttribute){
		if(eAttribute.defaultValue != 0 && eAttribute.defaultValue !== null){
			val eAttributeDefaultvalue = eAttribute.defaultValue
			'''<<«concatAnchor(eAttribute.EAttributeType)»«anchorSeparator»«eAttributeDefaultvalue», «eAttributeDefaultvalue»>>'''
		}
	}
	
	protected def dispatch dispatchEStructuralFeature(EReference eReference){
		if(eReference.EOpposite !== null){
			concatOpposite(eReference)
		} 
	}

	protected def concatInheritedEStructuralElementType(ENamedElement eNamedElement) {
		'''(<<«concatAnchor(eNamedElement)», {inherited}«concatReferenceName(eNamedElement.eContainer as EClass)»>>)'''
	}

	protected def concatBounds(int lowerBound, int upperBound) {
		'''«lowerBound»«IF lowerBound != upperBound»..«writeUpperBound(upperBound)»«ENDIF»'''
	}
	protected def writeUpperBound(int upperBound){
		if(upperBound == -1){
			'''*{nbsp}/ unordered'''
		}else{
			'''«upperBound»'''
		}
	}

	protected def concatOpposite(EReference eReference) {
		val eOppositeName = eReference.EOpposite.name
		// I'm pretty sure this will not produce the right outcome
		'''<<«concatAnchor(eReference.EReferenceType)»«anchorSeparator»«eOppositeName», «eOppositeName»>>'''
	}

	protected def writeEReferencesHeader() {
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
				«newline»
			'''
		)
	}

	protected def CharSequence writeEClassHeader(EClass eClass) {

		val eClassName = eClass.name
		output.append(
		'''
			[[«concatAnchor(eClass)»]]
			==== «IF eClass.isAbstract && !eClass.isInterface»Abstract «ENDIF»«IF eClass.isInterface»Interface«ELSE»Class«ENDIF» «eClassName»
			«newline»
			«getDocumentation(eClass)»
		''')
	}
}
