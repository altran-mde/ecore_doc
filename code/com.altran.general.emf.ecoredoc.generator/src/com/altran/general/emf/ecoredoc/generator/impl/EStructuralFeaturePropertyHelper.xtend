package com.altran.general.emf.ecoredoc.generator.impl

import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage

class EStructuralFeaturePropertyHelper {
	extension EcoreDocExtension = new EcoreDocExtension
	
	val static BOLD = '*'
	val static JOIN = " + "
	
	def concatBounds(EStructuralFeature eStructuralFeature) {
		val lowerBound = eStructuralFeature.lowerBound
		val upperBound = eStructuralFeature.upperBound

		'''
			`[«lowerBound»«IF lowerBound != upperBound»..«defineUpperBound(upperBound)»«ENDIF»]`«JOIN»
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
				«definePropertyString("ordered", "unordered", true, isOrdered)»
			'''
			
		} else {
			null
		}
	}
	
	def defineTransient(EStructuralFeature eStructuralFeature) {
		//default: false
		val isTransient = eStructuralFeature.transient
		
		'''
			«definePropertyString("transient", "non-transient", false, isTransient)»
		'''
	}
	
	def defineUnique(EStructuralFeature eStructuralFeature) {
		//default: false
		val isUnique = eStructuralFeature.unique
		
		'''
			«definePropertyString("unique", "non-unique", false, isUnique)»
		'''
	}
	
	def defineUnsettable(EStructuralFeature eStructuralFeature) {
		//default: false
		val isUnsettable = eStructuralFeature.unsettable
		
		'''
			«definePropertyString("unsettable", "settable", false, isUnsettable)»
		'''
	}
	
	def defineVolatile(EStructuralFeature eStructuralFeature) {
		//default: false
		val isVolatile = eStructuralFeature.volatile
		
		'''
			«definePropertyString("volatile", "non-volatile", false, isVolatile)»
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

			var result = '''_default:_ '''

			switch (defaultValue) {
				case EEnumLiteral:
					result += '''`<<«concatAnchor(eAttribute.EAttributeType)»«EcoreDocExtension.ANCHOR_SEPARATOR»«defaultValue», «defaultValue»>>`«newline»'''
					
				case String:
					result += '''`"«defaultValue»"`«newline»'''
					
				default:
					result += '''`«defaultValue»`«newline»'''
			}

			return result
		} else {
			return '''_default:_ -«newline»'''
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
