package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import java.util.ArrayList

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

//	protected def writeEAttributes(EClass eClass) {
//		if(!eClass.EAllAttributes.isEmpty){
//			writeEAttributesHeader()
//			
//			//Gather all inherited attributes and their classes.
//			//Since a class can have common superclasses with it's superclasses we need a set so that we do not use duplicate methods.
//			val Set<EAttribute> inheritedEAttributes = new HashSet<EAttribute>
//			for(superclass : eClass.EAllSuperTypes){
//				// FIXME: superclass can never be of any other type - DONE
//				// FIXME: Why bother sorting? We're not relying on the order of inheritedEAttributes - DONE
//				// FIXME: In deep inheritance hierarchies, this leads to lots of duplicated entries in inheritedEAttributes. Explain why, fix it. - DONE
//				for(eAttribute : superclass.EAllAttributes){
//					inheritedEAttributes.add(eAttribute)
//				}
//				
//			}
//			
//			//Iterate through non inherited attributes.
//			for(eAttribute : eClass.EAllAttributes.sortBy[it.name]){
//				if(!inheritedEAttributes.contains(eAttribute)){
//				
//					//writeEAttributeRow(eAttribute, eClass)
//					writeRow(eAttribute, eClass)
//				}
//			}
//			
//			//Iterate through inherited attributes.
//			for(eAttribute : inheritedEAttributes.sortBy[it.name]){
//				//writeEAttributeRow(eAttribute, eClass)
//				writeRow(eAttribute, eClass)
//			}
//			// FIXME: Yet another useless richstring. Find all of them, fix! - DONE
//			output.append(tableFooter())	
//		}
//	}
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

	// protected def dispatch CharSequence doThisLine(EAttribute)
//	def protected writeEAttributeRow(EAttribute eAttribute, EClass eClass){
//		
//		//FIXME: rewrite as an understandable expression, also at other places - DONE
//		val eAttributeClass = eAttribute.eContainer as EClass
//		val isInherited = !(eClass == eAttributeClass) 
//		val lowerBound = eAttribute.lowerBound
//		val upperBound = eAttribute.upperBound
//		val eAttributeName = eAttribute.name
//		val inheritedFeatureSegments = collectInheritedFeatureSegments(eAttribute, eClass)
//		
//		output.append(
//		'''
//		|«eAttributeName»[[«inheritedFeatureSegments.join("-")»]]«IF isInherited» +«ENDIF»
//		«IF isInherited»«concatInheritedEStructuralElementType(eAttribute)»«ENDIF»
//		|«concatLinkTo(eAttribute.EType)»
//		|«concatBounds(lowerBound, upperBound)»
//		|
//		|«getDocumentation(eAttribute)»
//		
//		''')
//	}
//	
	def protected concatInheritedEStructuralElementType(ENamedElement eNamedElement) {
		'''(<<«concatAnchor(eNamedElement)», {inherited}«concatReferenceName(eNamedElement.eContainer as EClass)»>>)'''
	}

	def protected concatBounds(int lowerBound, int upperBound) {
		'''«lowerBound»«IF lowerBound != upperBound»..«upperBound»«ENDIF»'''
	}

//	def protected writeEReferences(EClass eClass) {
//		// FIXME: What's wrong here? You fixed it at other places - DONE
//		if(!eClass.EReferences.isEmpty){
//			writeEReferencesHeader()
//			//Gather all inherited attributes and their classes.
//			// FIXME: Same issues as for attributes - DONE
//			val Set<EReference> inheritedEReferences = new HashSet<EReference>
//			for(superclass : eClass.EAllSuperTypes){
//				
//				for(eReference : superclass.EReferences){
//					inheritedEReferences.add(eReference)
//				}
//			}	
//			
//			//Iterate through non inherited references.
//			for(eReference : eClass.EReferences.sortBy[it.name]){
//				if(!inheritedEReferences.contains(eReference)){
//					//writeEReferenceRow(eReference, eClass)
//					writeRow(eReference, eClass)
//				}
//			}
//			
//			//Iterate through inherited references.
//			for(eReference : inheritedEReferences.sortBy[it.name]){
//				//writeEReferenceRow(eReference, eClass)
//				writeRow(eReference, eClass)
//			}
//			// FIXME: !!!!! -DONE
//			output.append(tableFooter())	
//		}
//	}
//	
//	def protected writeEReferenceRow(EReference eReference, EClass eClass){
//		val eReferenceClass = eReference.eContainer as EClass
//		val inherited = !(eClass == eReferenceClass) 
//		val lowerBound = eReference.lowerBound
//		val upperBound = eReference.upperBound
//		val eReferenceName = eReference.name
//		val inheritedFeatureSegments = collectInheritedFeatureSegments(eReference, eClass)
//		
//		output.append(
//		'''
//		|«eReferenceName»[[«inheritedFeatureSegments.join("-")»]]«IF inherited» +«ENDIF»
//		«IF inherited»«concatInheritedEStructuralElementType(eReference)»«ENDIF»
//		|«concatLinkTo(eReference.EType)»
//		|«concatBounds(lowerBound, upperBound)»
//		|«IF eReference.EOpposite !== null»«concatOpposite(eReference)»«ENDIF»
//		|«getDocumentation(eReference)»
//		
//		''')
//	}
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
