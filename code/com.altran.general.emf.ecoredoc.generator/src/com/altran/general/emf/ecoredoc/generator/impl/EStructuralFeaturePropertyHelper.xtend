package com.altran.general.emf.ecoredoc.generator.impl

import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl

class EStructuralFeaturePropertyHelper {
	extension EcoreDocExtension = new EcoreDocExtension

	val static String BOLD = "**"

	def CharSequence concatBounds(EStructuralFeature eStructuralFeature) {
		val int lowerBound = eStructuralFeature.lowerBound
		val int upperBound = eStructuralFeature.upperBound
		val boolean lowerNotEqualUpperBound = lowerBound != upperBound

		'''`[«lowerBound»«IF lowerNotEqualUpperBound»..«defineUpperBound(upperBound)»«ENDIF»]`'''

	}

	def CharSequence boldifyString(String string) {
		'''«BOLD»«string»«BOLD»'''
	}

	def CharSequence definePropertyString(String trueLiteral, String falseLiteral, boolean defaultValue,
		boolean currentPropertyValue) { 
		val boolean boldify = (defaultValue != currentPropertyValue)

		if (currentPropertyValue) {
			if(boldify){
				return boldifyString(trueLiteral)
				
			}else{
				return trueLiteral
			}

		} else {
			if(boldify){
				return boldifyString(falseLiteral)
				
			}else{
				return falseLiteral
			}	
		}
	}

	def CharSequence definePropertyString(String trueLiteral, String falseLiteral, boolean currentPropertyValue) {
		if (currentPropertyValue) {
			return trueLiteral

		} else {
			return falseLiteral
		}
	}

	def CharSequence defineChangeable(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = true
		val boolean isChangeable = eStructuralFeature.changeable

		definePropertyString("changeable", "unchangeable", defaultValue, isChangeable)

	}

	def CharSequence defineDerived(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isDerived = eStructuralFeature.derived

		definePropertyString("derived", "underived", defaultValue, isDerived)

	}

	def CharSequence defineOrdered(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = true
		val int upperBound = eStructuralFeature.upperBound
		val boolean isOrdered = eStructuralFeature.ordered

		if (upperBound != 1) {
			definePropertyString("ordered", "unordered", defaultValue, isOrdered)

		} else {
			null
		}
	}

	def CharSequence defineTransient(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isTransient = eStructuralFeature.transient

		definePropertyString("transient", "non-transient", defaultValue, isTransient)
	}

	def CharSequence defineUnique(EStructuralFeature eStructuralFeature) {
		val boolean isUnique = eStructuralFeature.unique

		definePropertyString("unique", "non-unique", isUnique)
	}

	def CharSequence defineUnsettable(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isUnsettable = eStructuralFeature.unsettable

		definePropertyString("unsettable", "settable", defaultValue, isUnsettable)

	}

	def CharSequence defineVolatile(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isVolatile = eStructuralFeature.volatile

		definePropertyString("volatile", "non-volatile", defaultValue, isVolatile)
	}

	def CharSequence defineResolveProxies(EReference eReference) {
		//val isDefault = eReference.eIsSet(EcorePackage.eINSTANCE.EReference_ResolveProxies)
		val boolean defaultValue = true
		val boolean resolveProxies = eReference.resolveProxies

		definePropertyString("resolveProxies", "non-resolveProxies", defaultValue, resolveProxies)
	}
	
	def CharSequence defineContainer(EReference eReference){
		val boolean isContainer = eReference.isContainer
		
		definePropertyString("container", "non-container", isContainer)
	}
	
	def CharSequence defineContainment(EReference eReference) {
		val boolean isContainment = eReference.isContainment
		
		definePropertyString("containment", "non-containment", isContainment)
	}
	
	def CharSequence defineId(EAttribute eAttribute) {
		val boolean isID = eAttribute.isID

		if (isID) {
			'''*is id*'''

		} else {
			null
		}
	}

	def CharSequence defineEKeys(EReference eReference) {
		val eKeys = eReference.EKeys
		val boolean eKeysExist = !eKeys.isEmpty

		'''_EKeys:_«IF eKeysExist» «eKeys.join("`", ", ", "`") [name]»«ELSE» `-`«ENDIF»'''
	}

	def dispatch CharSequence concatDefaultValue(EAttribute eAttribute) {
		val EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.EStructuralFeature_DefaultValueLiteral
		val boolean defaultIsSet = eAttribute.eIsSet(defaultValueLiteral)
		var result = '''_Default:_ '''
		
		if (defaultIsSet) {
			val defaultValue = eAttribute.defaultValue
			
			switch (defaultValue) {
				EEnumLiteralImpl:
					result += '''`<<«concatAnchor(eAttribute.EAttributeType)»«EcoreDocExtension.ANCHOR_SEPARATOR»«defaultValue», «defaultValue»>>`'''
						
				default:
					result += '''`«defaultValue»`'''
			}

		} else {
			result += '''`-`'''
		}

		return result 
	}

	def dispatch CharSequence concatDefaultValue(EReference eReference) {
		val EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.EStructuralFeature_DefaultValueLiteral
		val boolean defaultIsSet = eReference.eIsSet(defaultValueLiteral)

		if (defaultIsSet) {
			val defaultValue = eReference.defaultValue
			return '''_Default:_ `«defaultValue»`'''

		} else {
			return '''_Default:_ `-`'''
		}
	}

	protected def CharSequence defineUpperBound(int upperBound) {
		val boolean upperBoundExists = (upperBound != -1)

		if (upperBoundExists) {
			upperBound.toString

		} else {
			'''*'''
		}
	}
}
