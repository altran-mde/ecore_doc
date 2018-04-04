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

	override StringBuilder write(EPackage ePackage) {
		clearOutput()

		val List<EClass> eClasses = collectEClasses(ePackage)

		writeEClasses(eClasses)

		return output
	}

	protected def List<EClass> collectEClasses(EPackage ePackages) {
		getEPackages.get(ePackages).filter(EClass).sortBy[it.name]
	}

	protected def void writeEClasses(List<EClass> eClasses) {
		if (!eClasses.isEmpty) {
			writeEClassesHeader()

			for (eClass : eClasses) {
				writeEClass(eClass)
			}
		}
	}

	protected def void writeEClassesHeader() {
		output.append(
		'''
			�newline�
			=== Types
		''')
	}

	protected def void writeEClass(EClass eClass) {
		writeEClassHeader(eClass)

		writeSuperTypes(eClass)

		writeSubTypes(eClass)

		writeEAttributes(eClass)

		writeEContainments(eClass)

		writeECrossReferences(eClass)

		writeUseCases(eClass)
	}

	protected def void writeEContainments(EClass eClass) {
		val boolean containmentExists = eClass.EAllReferences.exists[isContainment]

		if (containmentExists) {
			writeEContainmentHeader()

			var List<EReference> eContainments = collectEContainments(eClass)
			var Set<? extends EStructuralFeature> inheritedEContainments = collectInheritedEContainments(eClass)

			writeEStructuralFeatures(eContainments, eClass, inheritedEContainments)
		}
	}

	protected def void writeECrossReferences(EClass eClass) {
		val boolean eCrossReferenceExists = eClass.EAllReferences.exists[!isContainment]

		if (eCrossReferenceExists) {
			writeEReferencesHeader()

			var List<EReference> crossReferences = collectECrossReferences(eClass)
			var Set<? extends EStructuralFeature> inheritedECrossReferences = collectInheritedECrossReferences(eClass)

			writeEStructuralFeatures(crossReferences, eClass, inheritedECrossReferences)
		}
	}

	protected def void writeEAttributes(EClass eClass) {
		val boolean eAttributeExists = !eClass.EAllAttributes.isEmpty

		if (eAttributeExists) {
			writeEAttributesHeader()

			var Set<EStructuralFeature> inheritedEAttributes = collectInheritedEAttributes(eClass)

			writeEStructuralFeatures(eClass.EAttributes, eClass, inheritedEAttributes)
		}
	}

	protected def void writeEContainmentHeader() {
		output.append(
		'''
			�newline�
			.Containments
			�tableHeader�
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def void writeSubTypes(EClass currentEClass) {
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

	protected def void writeSuperTypes(EClass eClass) {
		val boolean superTypesExist = !eClass.EAllSuperTypes.isEmpty

		if (superTypesExist) {
			writeSuperTypesHeader()

			for (supertype : eClass.EAllSuperTypes.sortBy[it.name]) {
				writeType(supertype)
			}
		}
	}

	protected def void writeType(EClass eClass) {
		output.append(
		'''
			* �concatLinkTo(eClass)�
		''')
	}

	protected def void writeSubTypesHeader() {
		output.append(
		'''
			�newline�
			.Sub-types
		''')
	}

	protected def void writeSuperTypesHeader() {
		output.append(
		'''
			�newline�
			.Super-types
		''')
	}

	protected def void writeEAttributesHeader() {
		output.append(
		'''
			�newline�
			.Attributes
			�tableHeader�
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def CharSequence tableHeader() {
		'''[cols="<20,<20,<20,<40a",options="header"]'''
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
		eClass.EAllReferences.filter[!isContainment].reject[eClass.EReferences.contains(it)].toSet
	}

	protected def Set<EStructuralFeature> collectInheritedEAttributes(EClass eClass) {
		val Set<EStructuralFeature> inheritedEAttributes = newLinkedHashSet()

		for (superclass : eClass.EAllSuperTypes) {
			inheritedEAttributes.addAll(superclass.EAllAttributes)
		}

		return inheritedEAttributes
	}

	protected def void writeEStructuralFeatures(List<? extends EStructuralFeature> eStructuralFeatures, EClass eClass,
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

	protected def void writeRow(EStructuralFeature eStructuralFeature, EClass eClass) {

		val EClass eStructuralFeatureClass = eStructuralFeature.eContainer as EClass
		val boolean isInherited = (eClass != eStructuralFeatureClass)
		val String eStructuralFeatureName = eStructuralFeature.name
		val String[] inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClass)

		output.append(
		'''
			�newline�
			|�eStructuralFeatureName�[[�inheritedFeatureSegments.join(EcoreDocExtension.ANCHOR_SEPARATOR)�]]�IF isInherited� +�ENDIF�
			�IF isInherited��concatInheritedElement(eStructuralFeature)��ENDIF�
			|�concatFeatureType(eStructuralFeature)�
			|�concatFeatureProperties(eStructuralFeature)�
			|�getDocumentation(eStructuralFeature)�
		''')
	}
	
	protected def CharSequence eReferencePropertiesToString(EReference eReference){
		val CharSequence separator = ''' +�newline�'''
		
		 #[
			defineEKeys(eReference),
			defineResolveProxies(eReference),
			defineContainer(eReference),
			defineContainment(eReference)
			
		].filter[it !== null].join(separator)
	}
	
	protected def CharSequence genericPropertiesToString(EStructuralFeature eStructuralFeature){
		val CharSequence separator = ''' +�newline�'''
		return  concatGenericProperties(eStructuralFeature).filter[it !== null].join(separator)
	}

	protected def dispatch CharSequence concatFeatureProperties(EReference eReference) {
		val CharSequence eReferenceProperties = eReferencePropertiesToString(eReference)
		val CharSequence genericProperties = genericPropertiesToString(eReference)
		
		if(eReferenceProperties != ""){
			return eReferenceProperties + newline + newline +genericProperties
			
		}else{
			return genericProperties
		}	
	}
	
	protected def idToString(EAttribute eAttribute){
		val CharSequence separator = ''' +�newline�'''
		return #[defineId(eAttribute)].filter[it !== null].join(separator)
	}
	
	protected def dispatch CharSequence concatFeatureProperties(EAttribute eAttribute) {
		val CharSequence id = idToString(eAttribute)
		var CharSequence genericProperties = genericPropertiesToString(eAttribute)
		
		if(id != ""){
			return id + newline + newline +genericProperties
			
		}else{
			return genericProperties
		}	
	}

	protected def List<CharSequence> concatGenericProperties(EStructuralFeature eStructuralFeature) {
		#[
			concatBounds(eStructuralFeature),
			concatDefaultValue(eStructuralFeature),
			defineOrdered(eStructuralFeature),
			defineChangeable(eStructuralFeature),
			defineDerived(eStructuralFeature),
			defineTransient(eStructuralFeature),
			defineUnique(eStructuralFeature),
			defineUnsettable(eStructuralFeature),
			defineVolatile(eStructuralFeature)
		]
	}

	protected def dispatch CharSequence concatFeatureType(EReference eReference) {
		'''
			�concatLinkTo(eReference.EType)�
			�getOpposite(eReference)�
		'''
	}

	protected def dispatch CharSequence concatFeatureType(EAttribute eAttribute) {
		'''
			�concatLinkTo(eAttribute.EType)�
		'''
	}

	protected def CharSequence getOpposite(EReference eReference) {
		if (eReference.EOpposite !== null) {
			val String eOppositeName = eReference.EOpposite.name

			'''
				�newline�
				_EOpposite:_ <<�concatAnchor(eReference.EReferenceType)��EcoreDocExtension.ANCHOR_SEPARATOR��eOppositeName�, �eOppositeName�>>
			'''
		}
	}

	protected def CharSequence concatInheritedElement(ENamedElement eNamedElement) {
		'''(<<�concatAnchor(eNamedElement)�, {inherited}�concatReferenceName(eNamedElement.eContainer as EClass)�>>)'''
	}

	protected def void writeEReferencesHeader() {
		output.append(
		'''
			�newline�
			.References
			�tableHeader�
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def CharSequence writeEClassHeader(EClass eClass) {
		val String eClassName = eClass.name

		output.append(
		'''
			�newline�
			[[�concatAnchor(eClass)�]]
			==== �IF eClass.isAbstract && !eClass.isInterface�Abstract �ENDIF��IF eClass.isInterface�Interface�ELSE�Class�ENDIF� �eClassName�
			�newline�
			�getDocumentation(eClass)�
		''')
	}
}
