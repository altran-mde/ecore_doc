package com.altran.general.emf.ecoredoc.generator.impl

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

class EcoreDocExtension {
	public static val CharSequence ANCHOR_SEPARATOR = '-'

	public static val CharSequence REFERENCE_SEPARATOR = '.'

	def String newline() {
		System.getProperty("line.separator")
	}

	def CharSequence getDocumentation(EModelElement modelElement) {
		val CharSequence documentation = EcoreUtil.getDocumentation(modelElement)

		if (documentation !== null) {
			return documentation + newline

		} else {
			return ""
		}
	}

	def EPackage getEPackage(EClassifier eClassifier) {
		eClassifier.eContainer as EPackage
	}

	def dispatch CharSequence concatAnchor(ENamedElement eNamedElement) {
		collectTypeSegments(eNamedElement).join(ANCHOR_SEPARATOR)
	}

	// Special handling for default EDataTypes: Don't create anchor
	def dispatch CharSequence concatAnchor(EDataType eDataType) {
		if (!isDefaultEDataType(eDataType)) {
			collectTypeSegments(eDataType).join(ANCHOR_SEPARATOR)

		} else {
			""
		}
	}

	def dispatch String[] collectTypeSegments(EClass eClass) {
		val String eClassName = eClass.name
		val String ePackageName = getEPackage(eClass).name

		#[ePackageName, eClassName]

	}

	def dispatch String[] collectTypeSegments(EStructuralFeature eStructuralFeature) {
		val EClass eClass = eStructuralFeature.eContainer as EClass
		val String ePackageName = getEPackage(eClass).name
		val String eClassName = eClass.name
		val String eStructuralFeatureName = eStructuralFeature.name

		#[ePackageName, eClassName, eStructuralFeatureName]
	}

	def dispatch String[] collectTypeSegments(EEnumLiteral eEnumLiteral) {
		val EEnum eEnum = eEnumLiteral.eContainer as EEnum
		val String ePackageName = getEPackage(eEnum).name

		#[ePackageName, eEnum.name, eEnumLiteral.name]
	}

	def dispatch String[] collectTypeSegments(EDataType eDataType) {
		val String eDataTypeName = eDataType.name
		val boolean defaultEDataType = isDefaultEDataType(eDataType)

		if (defaultEDataType) {
			#[eDataTypeName]

		} else {
			val String eDataTypePackageName = getEPackage(eDataType).name

			#[eDataTypePackageName, eDataTypeName]	
		}
	}

	def boolean isDefaultEDataType(EDataType eDataType) {
		EcorePackage.eINSTANCE.nsURI == getEPackage(eDataType).nsURI
	}
}
