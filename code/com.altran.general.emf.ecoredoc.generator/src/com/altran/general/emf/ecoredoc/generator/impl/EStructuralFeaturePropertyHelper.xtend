package com.altran.general.emf.ecoredoc.generator.impl

import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage

class EStructuralFeaturePropertyHelper {
	extension EcoreDocExtension = new EcoreDocExtension
	
	val static BOLD = '*'
	val static JOIN = " +"
	
	def concatBounds(EStructuralFeature eStructuralFeature) {
		val lowerBound = eStructuralFeature.lowerBound
		val upperBound = eStructuralFeature.upperBound

		'''
			`[«lowerBound»«IF lowerBound != upperBound»..«defineUpperBound(upperBound)»«ENDIF»]`
		'''
	}
	
	def boldifyString(String string){
		'''«BOLD»«string»«BOLD»'''
	}
	
	def definePropertyString(String trueLiteral, String falseLiteral, boolean defaultValue, boolean currentPropertyValue) {
		var result =''''''
		val boldify = (defaultValue != currentPropertyValue)
		
		if(currentPropertyValue){
			result = '''«IF boldify»«boldifyString(trueLiteral)»«ELSE»«trueLiteral»«ENDIF»«JOIN»'''
			
		}else{
			result = '''«IF boldify»«boldifyString(falseLiteral)»«ELSE»«falseLiteral»«ENDIF»«JOIN»'''
		}
	}
	
	def defineChangeable(EStructuralFeature eStructuralFeature) {
		//default: true
		val isChangeable = eStructuralFeature.changeable
		
		'''
			«definePropertyString("changeable", "unchangeable", true, isChangeable)»
		'''
	}
	
	def defineDerived(EStructuralFeature eStructuralFeature) {
		//default: false
		val isDerived = eStructuralFeature.derived
		
		'''
			«definePropertyString("derived", "underived", false, isDerived)»
		'''
	}

	def defineOrdered(EStructuralFeature eStructuralFeature) {
		//default: true
		val upperBound = eStructuralFeature.upperBound
		val isOrdered = eStructuralFeature.ordered

		if (upperBound != 1) {
			'''
				«definePropertyString("derived", "underived", true, isOrdered)»
			'''
			
		} else {
			null
		}
	}
	
	def defineTransient(EStructuralFeature eStructuralFeature) {
		//default: true
		val isTransient = eStructuralFeature.transient
		
		'''
			«definePropertyString("transient", "non-transient", true, isTransient)»
		'''
	}

	def defineId(EAttribute eAttribute) {
		if (eAttribute.isID) {
			'''
				*is id*
				«newline»
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
