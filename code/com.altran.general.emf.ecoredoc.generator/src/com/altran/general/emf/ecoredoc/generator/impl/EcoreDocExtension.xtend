package com.altran.general.emf.ecoredoc.generator.impl

import java.util.Collection
import java.util.List
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
import org.eclipse.emf.ecore.EOperation

class EcoreDocExtension {
	public static val ANCHOR_SEPARATOR = '-'

	public static val REFERENCE_SEPARATOR = '.{zwsp}'
	
	public static val ECLASSIFIER_PROPERTY_SEPARATOR = newline
	
	public static val eClassifierSorter = [EClassifier it | it.EPackage.name + it.name ?: ""]
	public static val eStructuralFeatureSorter = [EStructuralFeature it | it.name ?: ""]
	public static val eOperationSorter = [EOperation it | it.name ?: ""]

	def static String newline() {
		System.getProperty("line.separator")
	}
	
	def CharSequence getDocumentation(EModelElement modelElement) {
		val documentation = EcoreUtil.getDocumentation(modelElement)

		if (documentation !== null) {
			val stripped = documentation.replaceAll("(<[^>]+>)(<[^>]+>)", " ").replaceAll("<[^>]+>", "")
			if (stripped == documentation) {
				documentation + newline
			} else {
				'''
					«newline»
					ifdef::backend-html5[]
					++++
					«documentation»
					++++
					endif::[]
					ifndef::backend-html5[]
					«stripped»
					endif::[]
				'''
			}
		} else {
			""
		}
	}

	def EPackage getEPackage(EClassifier eClassifier) {
		return eClassifier.eContainer as EPackage
	}
	
	def CharSequence joinAnchor(Collection<? extends CharSequence> segments) {
		segments
			.map[toString]
			.filter[!isNullOrEmpty]
			.map[it.replaceAll("[^a-zA-Z0-9_-]", ":")]
			.join(ANCHOR_SEPARATOR)
	}
	
	def CharSequence joinReference(Collection<? extends CharSequence> segments) {
		segments
			.map[toString]
			.filter[!isNullOrEmpty]
			.join(REFERENCE_SEPARATOR)
	}

	def dispatch CharSequence concatAnchor(ENamedElement eNamedElement) {
		collectTypeSegments(eNamedElement).joinAnchor
	}

	// Special handling for default EDataTypes: Don't create anchor
	def dispatch CharSequence concatAnchor(EDataType eDataType) {
		if (!isDefaultEDataType(eDataType)) {
			collectTypeSegments(eDataType).joinAnchor

		} else {
			""
		}
	}

	def dispatch String[] collectTypeSegments(Void voidType) {
		#[ getAssuredName(null) ]
	}
	
	def dispatch String[] collectTypeSegments(EPackage ePackage) {
		#[ getAssuredName(ePackage) ]
	}
	
	def dispatch String[] collectTypeSegments(EClass eClass) {
		val String eClassName = getAssuredName(eClass)

		_collectTypeSegments(getEPackage(eClass)) + #[eClassName]
	}

	def dispatch String[] collectTypeSegments(EStructuralFeature eStructuralFeature) {
		val EClass eClass = eStructuralFeature.eContainer as EClass
		val String eStructuralFeatureName = getAssuredName(eStructuralFeature)

		collectTypeSegments(eClass) + #[eStructuralFeatureName]
	}

	def dispatch String[] collectTypeSegments(EEnumLiteral eEnumLiteral) {
		val EEnum eEnum = eEnumLiteral.eContainer as EEnum

		collectTypeSegments(eEnum) + #[ getAssuredName(eEnumLiteral) ]
	}

	def dispatch String[] collectTypeSegments(EDataType eDataType) {
		val String eDataTypeName = getAssuredName(eDataType)
		val boolean defaultEDataType = isDefaultEDataType(eDataType)

		if (defaultEDataType) {
			#[eDataTypeName]
		} else {
			_collectTypeSegments(getEPackage(eDataType)) + #[eDataTypeName]	
		}
	}

	def dispatch String[] collectTypeSegments(EOperation eOperation) {
		collectTypeSegments(eOperation.eContainer as EClass) + #[getAssuredName(eOperation)]
	}
	
	def protected String getAssuredName(ENamedElement eNamedElement) {
		if (eNamedElement === null) {
			""
		}else if (eNamedElement.name.isNullOrEmpty) {
			'''[«EcoreUtil.getURI(eNamedElement).fragment»]'''
		} else {
			eNamedElement.name
		}
	}

	def boolean isDefaultEDataType(EDataType eDataType) {
		EcorePackage.eINSTANCE.nsURI == getEPackage(eDataType)?.nsURI
	}

	def List<EDataType> collectEDataTypes(Collection<EClassifier> classifiers) {
		classifiers.filter(EDataType).filter[!(it instanceof EEnum)].sortBy(eClassifierSorter)
	}
	
	def List<EEnum> collectEEnums(Collection<EClassifier> classifiers) {
		classifiers.filter(EEnum).sortBy(eClassifierSorter)
	}

	def List<EClass> collectEClasses(Collection<EClassifier> classifiers) {
		classifiers.filter(EClass).sortBy(eClassifierSorter)
	}
}
