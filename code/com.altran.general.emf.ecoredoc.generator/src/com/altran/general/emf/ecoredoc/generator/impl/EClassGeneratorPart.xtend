package com.altran.general.emf.ecoredoc.generator.impl

import com.google.common.collect.Multimap
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature

class EClassGeneratorPart extends AEcoreDocGeneratorPart {
	extension EStructuralFeaturePropertyHelper = new EStructuralFeaturePropertyHelper
	
	new(Multimap<EPackage, EClassifier> ePackages) {
		super(ePackages)
	}

	override write(EPackage ePackage) {
		clearOutput()

		val eClasses = collectEClasses(ePackage)

		writeEClasses(eClasses)

		return output
	}

	protected def List<EClass> collectEClasses(EPackage ePackages) {
		getEPackages.get(ePackages).filter(EClass).sortBy[it.name]
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
		output.append(
		'''
			«newline»
			=== Types
		''')
	}

	protected def writeEClass(EClass eClass) {
		writeEClassHeader(eClass)
		
		writeSuperTypes(eClass)
		
		writeSubTypes(eClass)
		
		writeEAttributes(eClass)
		
		writeEContainments(eClass)
		
		writeECrossReferences(eClass)

		writeUseCases(eClass)
	}

	protected def writeEContainments(EClass eClass) {
		val containmentExists = eClass.EAllReferences.exists[isContainment]
		
		if (containmentExists) {
			writeEContainmentHeader()
			
			var List<EReference> eContainments = collectEContainments(eClass)
			var Set<? extends EStructuralFeature> inheritedEContainments = collectInheritedEContainments(eClass)
			
			writeEStructuralFeatures(eContainments, eClass, inheritedEContainments)
		}
	}
	
	protected def writeECrossReferences(EClass eClass) {
		val eCrossReferenceExists = eClass.EAllReferences.exists[!isContainment]
		
		if (eCrossReferenceExists) {
			writeEReferencesHeader()
			
			var List<EReference> crossReferences = collectECrossReferences(eClass)
			var Set<? extends EStructuralFeature> inheritedECrossReferences = collectInheritedECrossReferences(eClass)
			
			writeEStructuralFeatures(crossReferences, eClass, inheritedECrossReferences)
		}
	}

	protected def writeEAttributes(EClass eClass) {
		val eAttributeExists = !eClass.EAllAttributes.isEmpty
		
		if (eAttributeExists) {
			writeEAttributesHeader()
			
			var Set<EStructuralFeature> inheritedEAttributes = collectInheritedEAttributes(eClass)
			
			writeEStructuralFeatures(eClass.EAttributes, eClass, inheritedEAttributes)
		}
	}

	protected def writeEContainmentHeader() {
		output.append(
		'''
			«newline»
			.Containments
			«tableHeader»
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def writeSubTypes(EClass currentEClass) {
		var Set<EClass> subTypes = newLinkedHashSet()
		
		for (eClass : collectAllEClasses.reject[eClass == currentEClass]) {
			if (eClass.EAllSuperTypes.contains(currentEClass)) {
				subTypes.add(eClass)
			}
		}

		if (!subTypes.isEmpty) {
			writeSubTypesHeader()
			
			for (eClass : subTypes) {
				writeType(eClass)
			}
		}
	}
	
	protected def writeSuperTypes(EClass eClass) {
		val superTypesExist = !eClass.EAllSuperTypes.isEmpty
		
		if (superTypesExist) {
			writeSuperTypesHeader()
			
			for (supertype : eClass.EAllSuperTypes.sortBy[it.name]) {
				writeType(supertype)
			}
		}
	}

	protected def writeType(EClass eClass) {
		output.append(
		'''
			* «concatLinkTo(eClass)»
		''')
	}
	
	protected def writeSubTypesHeader() {
		output.append(
		'''
			«newline»
			.Sub-types
		''')
	}
	
	protected def writeSuperTypesHeader() {
		output.append(
		'''
			«newline»
			.Super-types
		''')
	}

	protected def writeEAttributesHeader() {
		output.append(
		'''
			«newline»
			.Attributes
			«tableHeader»
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def tableHeader() {
		'''[cols="<20m,<20,<20m,<40a",options="header"]'''	
	}
	
	protected def List<EReference> collectEContainments(EClass eClass) {
		eClass.EReferences.filter[isContainment].toList
	}
	
	protected def Set<? extends EStructuralFeature> collectInheritedEContainments(EClass eClass) {
		eClass.EAllReferences.filter[isContainment].reject[eClass.EReferences.contains(it)].toSet
	}
	
	protected def List<EReference> collectECrossReferences(EClass eClass) {
		eClass.EReferences.filter[!isContainment].toList
	}
	
	protected def Set<? extends EStructuralFeature> collectInheritedECrossReferences(EClass eClass) {
		eClass.EAllReferences.filter[!isContainment]
							 .reject[eClass.EReferences.contains(it)]
							 .toSet
	}
	
	protected def Set<EStructuralFeature> collectInheritedEAttributes(EClass eClass) {
		val Set<EStructuralFeature> inheritedEAttributes = newLinkedHashSet()
		
		for (superclass : eClass.EAllSuperTypes) {
			inheritedEAttributes.addAll(superclass.EAllAttributes)
		}
		
		return inheritedEAttributes
	}
	
	protected def writeEStructuralFeatures(List<? extends EStructuralFeature> eStructuralFeatures, EClass eClass,
		Set<? extends EStructuralFeature> inheritedStructuralFeatures) {
			
		// Iterate through non inherited eStructuralFeatures.
		for (eStructuralFeature : eStructuralFeatures.sortBy[it.name]) {
			writeRow(eStructuralFeature, eClass)
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
		val eStructuralFeatureName = eStructuralFeature.name
		val inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClass)

		output.append(
		'''
			«newline»
			|«eStructuralFeatureName»[[«inheritedFeatureSegments.join(EcoreDocExtension.ANCHOR_SEPARATOR)»]]«IF isInherited» +«ENDIF»
			«IF isInherited»«concatInheritedElement(eStructuralFeature)»«ENDIF»
			|«concatFeatureType(eStructuralFeature)»
			|«concatFeatureProperties(eStructuralFeature)»
			|«getDocumentation(eStructuralFeature)»
		''')
	}
	
	protected def dispatch concatFeatureProperties(EReference eReference) {
		#[
			concatBounds(eReference),
			defineOrdered(eReference)
		]
		.filter[it !== null]
		.join(newline)
	}
	
	protected def dispatch concatFeatureProperties(EAttribute eAttribute) {
		#[
			concatBounds(eAttribute),
			defineOrdered(eAttribute),
			concatDefaultValue(eAttribute),
			defineId(eAttribute)
		]
		.filter[it !== null]
		.join(newline)
	}
	
	protected def dispatch concatFeatureType(EReference eReference) {
		'''
			«concatLinkTo(eReference.EType)»
			«getOpposite(eReference)»
		'''
	}
	
	protected def dispatch concatFeatureType(EAttribute eAttribute) {
		'''
			«concatLinkTo(eAttribute.EType)»
		'''
	}

	protected def getOpposite(EReference eReference) {
		if (eReference.EOpposite !== null) {
			val eOppositeName = eReference.EOpposite.name
			
			'''
				«newline»
				_opposite_ <<«concatAnchor(eReference.EReferenceType)»«EcoreDocExtension.ANCHOR_SEPARATOR»«eOppositeName», «eOppositeName»>>
			'''
		}
	}

	protected def concatInheritedElement(ENamedElement eNamedElement) {
		'''(<<«concatAnchor(eNamedElement)», {inherited}«concatReferenceName(eNamedElement.eContainer as EClass)»>>)'''
	}

	protected def writeEReferencesHeader() {
		output.append(
		'''
			«newline»
			.References
			«tableHeader»
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def CharSequence writeEClassHeader(EClass eClass) {
		val eClassName = eClass.name
		
		output.append(
		'''
			«newline»
			[[«concatAnchor(eClass)»]]
			==== «IF eClass.isAbstract && !eClass.isInterface»Abstract «ENDIF»«IF eClass.isInterface»Interface«ELSE»Class«ENDIF» «eClassName»
			«newline»
			«getDocumentation(eClass)»
		''')
	}
}
