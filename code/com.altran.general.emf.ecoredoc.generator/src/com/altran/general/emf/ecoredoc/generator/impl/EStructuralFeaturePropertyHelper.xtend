package com.altran.general.emf.ecoredoc.generator.impl

import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage

class EStructuralFeaturePropertyHelper {
	extension EcoreDocExtension = new EcoreDocExtension
	
	val static Character BOLD = '*'
	val static String JOIN = " + "
	
	def CharSequence concatBounds(EStructuralFeature eStructuralFeature) {
		val int lowerBound = eStructuralFeature.lowerBound
		val int upperBound = eStructuralFeature.upperBound
		val boolean lowerNotEqualUpperBound = lowerBound != upperBound

		'''
			`[«lowerBound»«IF lowerNotEqualUpperBound»..«defineUpperBound(upperBound)»«ENDIF»]`«JOIN»
		'''
	}
	
	def CharSequence boldifyString(String string){
		'''«BOLD»«string»«BOLD»'''
	}
	
	def CharSequence definePropertyString(String trueLiteral, String falseLiteral, boolean defaultValue, boolean currentPropertyValue) {
		var CharSequence result =''''''
		val boolean boldify = (defaultValue != currentPropertyValue)
		
		if(currentPropertyValue){
			result = '''«IF boldify»«boldifyString(trueLiteral)»«ELSE»«trueLiteral»«ENDIF»«JOIN»'''
			
		}else{
			result = '''«IF boldify»«boldifyString(falseLiteral)»«ELSE»«falseLiteral»«ENDIF»«JOIN»'''
		}
	}
	
	def CharSequence defineChangeable(EStructuralFeature eStructuralFeature) {
		//default: true
		val boolean isChangeable = eStructuralFeature.changeable
		
		'''
			«definePropertyString("changeable", "unchangeable", true, isChangeable)»
		'''
	}
	
	def CharSequence defineDerived(EStructuralFeature eStructuralFeature) {
		//default: false
		val boolean isDerived = eStructuralFeature.derived
		
		'''
			«definePropertyString("derived", "underived", false, isDerived)»
		'''
	}

	def CharSequence defineOrdered(EStructuralFeature eStructuralFeature) {
		//default: true
		val int upperBound = eStructuralFeature.upperBound
		val boolean isOrdered = eStructuralFeature.ordered

		if (upperBound != 1) {
			'''
				«definePropertyString("ordered", "unordered", true, isOrdered)»
			'''
			
		} else {
			null
		}
	}
	
	def CharSequence defineTransient(EStructuralFeature eStructuralFeature) {
		//default: false
		val boolean isTransient = eStructuralFeature.transient
		
		'''
			«definePropertyString("transient", "non-transient", false, isTransient)»
		'''
	}
	
	def CharSequence defineUnique(EStructuralFeature eStructuralFeature) {
		//default: false
		val boolean isUnique = eStructuralFeature.unique
		
		'''
			«definePropertyString("unique", "non-unique", false, isUnique)»
		'''
	}
	
	def CharSequence defineUnsettable(EStructuralFeature eStructuralFeature) {
		//default: false
		val boolean isUnsettable = eStructuralFeature.unsettable
		
		'''
			«definePropertyString("unsettable", "settable", false, isUnsettable)»
		'''
	}
	
	def CharSequence defineVolatile(EStructuralFeature eStructuralFeature) {
		//default: false
		val boolean isVolatile = eStructuralFeature.volatile
		
		'''
			«definePropertyString("volatile", "non-volatile", false, isVolatile)»
		'''
	}

	def CharSequence defineId(EAttribute eAttribute) {
		if (eAttribute.isID) {
			'''
				*is id*
				«newline»
			'''
		} else {
			null
		}
	}

	def CharSequence concatDefaultValue(EAttribute eAttribute) {
		val EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.EStructuralFeature_DefaultValueLiteral
		val boolean defaultIsSet = eAttribute.eIsSet(defaultValueLiteral)
		
		if (defaultIsSet) {
			val defaultValue = eAttribute.defaultValue

			var result = '''_Default:_ '''

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
			return '''_Default:_ -«newline»'''
		}
	}

	protected def CharSequence defineUpperBound(int upperBound) {
		if (upperBound == -1) {
			'''*'''

		} else {
			'''«upperBound»'''
		}
	}

}
