package com.altran.general.emf.ecoredoc.generator.impl.^extension

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.util.EcoreUtil

class TypeSegmentsCollector {
	extension EcoreDocExtension = new EcoreDocExtension
	
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

	
}
