package com.altran.general.emf.ecoredoc.generator.impl

import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage

class EStructuralFeaturePropertyHelper {
	extension EcoreDocExtension = new EcoreDocExtension

	def concatBounds(EStructuralFeature eStructuralFeature) {
		val lowerBound = eStructuralFeature.lowerBound
		val upperBound = eStructuralFeature.upperBound

		'''
			`[«lowerBound»«IF lowerBound != upperBound»..«defineUpperBound(upperBound)»«ENDIF»]`
		'''
	}

	def defineOrdered(EStructuralFeature eStructuralFeature) {
		val upperBound = eStructuralFeature.upperBound
		val ordered = eStructuralFeature.ordered

		if (upperBound != 1) {
			'''
				«IF ordered»ordered«ELSE»unordered«ENDIF»
			'''
		} else {
			null
		}
	}

	def defineId(EAttribute eAttribute) {
		if (eAttribute.isID) {
			'''
				*is id*
			'''
		} else {
			null
		}
	}

	def concatDefaultValue(EAttribute eAttribute) {

		if (eAttribute.eIsSet(EcorePackage.eINSTANCE.EStructuralFeature_DefaultValueLiteral)) {
			val defaultValue = eAttribute.defaultValue

			var result = '''
				_default:_ 
			'''

			switch (defaultValue) {
				case EEnumLiteral:
					result +=
						'''`<<«concatAnchor(eAttribute.EAttributeType)»«EcoreDocExtension.ANCHOR_SEPARATOR»«defaultValue», «defaultValue»>>`'''
				case String:
					result += '''`"«defaultValue»"`'''
				default:
					result += '''`«defaultValue»`'''
			}

			return result
		} else {
			return ""
		}
	}

	protected def defineUpperBound(int upperBound) {
		if (upperBound == -1) {
			'''*'''

		} else {
			upperBound
		}
	}

}
