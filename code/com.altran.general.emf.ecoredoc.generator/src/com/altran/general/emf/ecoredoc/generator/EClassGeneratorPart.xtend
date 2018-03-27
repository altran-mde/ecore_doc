package com.altran.general.emf.ecoredoc.generator

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

	// FIXME: containments and references are on the same level as supertypes, subconcepts and attributes.
	protected def writeEReferences(EClass eClass) {
		if (!eClass.EAllReferences.isEmpty) {
			writeEContainments(eClass)
			writeECrossReferences(eClass)
		}
	}

	protected def writeEContainments(EClass eClass) {
		if (eClass.EAllReferences.exists[isContainment]) {
			writeEContainmentHeader()
			for (eReference : eClass.EAllReferences) {
				// FIXME: Use filter in loop (in all cases)
				if (eReference.isContainment) {
					writeRow(eReference, eClass)
				}
			}
			output.append(tableFooter())
		}
	}

	protected def writeECrossReferences(EClass eClass) {
		// FIXME: Don't use eCrossReferences, it provokes loading the targets of all references.
		if (!eClass.eCrossReferences.isEmpty) {
			writeEReferencesHeader()
			// FIXME: Why are you using a completely different implementation as for Containments?
			var List<EReference> crossReferences = newArrayList()
			for (eReference : eClass.EReferences) {
				if (!eReference.isContainment) {
					crossReferences.add(eReference)
				}
			}
			writeEStructuralFeatures(crossReferences, eClass, true)
		}
	}

	protected def writeEAttributes(EClass eClass) {
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
		// FIXME: Commonly known as subtypes
		var Set<EClass> eClassesThatInheritCurrent = newLinkedHashSet()

		for (eClass : collectAllEClasses.reject[eClass == currentEClass]) {
			if (eClass.EAllSuperTypes.contains(currentEClass)) {
				eClassesThatInheritCurrent.add(eClass)
			}
		}

		if (!eClassesThatInheritCurrent.isEmpty) {
			if (currentEClass.isInterface) {
				writeKnownImplementations
			} else {
				writeSubConceptsHeader()
			}

			for (eClass : eClassesThatInheritCurrent) {
				writeSubConcept(eClass)
			}
			
			output.append(newline)
		}
	}

	protected def writeSubConcept(EClass eClass) {
		output.append(
			'''
			* «concatLinkTo(eClass)»
		''')
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
				«newline»
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

	protected def writeRow(EStructuralFeature eStructuralFeature, EClass eClass) {

		val eStructuralFeatureClass = eStructuralFeature.eContainer as EClass
		val isInherited = (eClass != eStructuralFeatureClass)
		val eStructuralFeatureName = eStructuralFeature.name
		val inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClass)

		output.append(
		'''
			|«eStructuralFeatureName»[[«inheritedFeatureSegments.join(anchorSeparator)»]]«IF isInherited» +«ENDIF»
			«IF isInherited»«concatInheritedEStructuralElementType(eStructuralFeature)»«ENDIF»
			|«concatLinkTo(eStructuralFeature.EType)»
			|«concatBounds(eStructuralFeature)»
			|«dispatchEStructuralFeature(eStructuralFeature)»
			|«getDocumentation(eStructuralFeature)»
			«newline»
		''')
	}

	//FIXME: Use semantic name
	protected def dispatch dispatchEStructuralFeature(EAttribute eAttribute) {
		val defaultValue = eAttribute.defaultValue
		// FIXME: use eIsSet()
		if (defaultValue != 0 && defaultValue !== null) {
			'''<<«concatAnchor(eAttribute.EAttributeType)»«anchorSeparator»«defaultValue», «defaultValue»>>'''
		}
	}

	protected def dispatch dispatchEStructuralFeature(EReference eReference) {
		if (eReference.EOpposite !== null) {
			concatOpposite(eReference)
		}
	}

	protected def concatInheritedEStructuralElementType(ENamedElement eNamedElement) {
		'''(<<«concatAnchor(eNamedElement)», {inherited}«concatReferenceName(eNamedElement.eContainer as EClass)»>>)'''
	}

	protected def concatBounds(EStructuralFeature eStructuralFeature) {
		val lowerBound = eStructuralFeature.lowerBound
		val upperBound = eStructuralFeature.upperBound
		val ordered = eStructuralFeature.ordered
		'''«lowerBound»«IF lowerBound != upperBound»..«writeUpperBound(upperBound, ordered)»«ENDIF»'''
	}

	// FIXME: Why does a method called "upperBound" do something about "ordered"?
	// FIXME: is "write" the correct prefix? Check everywhere!
	protected def writeUpperBound(int upperBound, boolean ordered) {
		if (upperBound == -1) {
			'''*{nbsp}/ «IF ordered»ordered«ELSE»unordered«ENDIF»'''
		} else {
			//FIXME: AAAAAAAAAAAAAAAAAAAAAAARRRRRRRRRRRRRRRGGGGGGGGGGGGGGGHHHHHHHHHHHHH!!!!!!!!!!!!!!!!!!!
			'''«upperBound»'''
		}
	}

	protected def concatOpposite(EReference eReference) {
		val eOppositeName = eReference.EOpposite.name
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
