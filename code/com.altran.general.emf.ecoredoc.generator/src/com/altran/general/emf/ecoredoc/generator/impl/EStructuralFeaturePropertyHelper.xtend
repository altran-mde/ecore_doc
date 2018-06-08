package com.altran.general.emf.ecoredoc.generator.impl

import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.ecoredoc.generator.config.IEStructuralFeatureConfig

class EStructuralFeaturePropertyHelper {
	val static String BOLD = "**"
	
	extension EcoreDocExtension = new EcoreDocExtension
	
	val EcoreDocGeneratorConfig config
	
	new(EcoreDocGeneratorConfig config) {
		this.config = config
	}

	def CharSequence concatBounds(EStructuralFeature eStructuralFeature) {
		val int lowerBound = eStructuralFeature.lowerBound
		val int upperBound = eStructuralFeature.upperBound
		val boolean lowerNotEqualUpperBound = lowerBound != upperBound
		
		val isSet = if (eStructuralFeature.isMany) {
			lowerBound === 1 && upperBound === -1
		} else {
			lowerBound === 0 && upperBound === 1
		}
		
		if (isSet || eStructuralFeature.shouldRenderDefaults) {
			'''`[«lowerBound»«IF lowerNotEqualUpperBound»..«defineUpperBound(upperBound)»«ENDIF»]`'''
		}
	}

	def CharSequence boldifyString(String string) {
		'''«BOLD»«string»«BOLD»'''
	}

	def CharSequence definePropertyString(
		EStructuralFeature eStructuralFeature, 
		String trueLiteral, 
		String falseLiteral, 
		boolean defaultValue,
		boolean currentPropertyValue) { 
		val boolean isSet = (defaultValue != currentPropertyValue)

		if(isSet || eStructuralFeature.shouldRenderDefaults) {
			if(currentPropertyValue) {
				if(isSet) {
					return boldifyString(trueLiteral)
				} else {
					return trueLiteral
				}
			} else {
				if(isSet) {
					return boldifyString(falseLiteral)
				} else {
					return falseLiteral
				}
			}
		}
	}

	def CharSequence defineChangeable(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = true
		val boolean isChangeable = eStructuralFeature.changeable

		eStructuralFeature.definePropertyString("changeable", "unchangeable", defaultValue, isChangeable)
	}

	def CharSequence defineDerived(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isDerived = eStructuralFeature.derived

		eStructuralFeature.definePropertyString("derived", "underived", defaultValue, isDerived)
	}

	def CharSequence defineOrdered(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = true
		val int upperBound = eStructuralFeature.upperBound
		val boolean isOrdered = eStructuralFeature.ordered

		if (upperBound != 1) {
			eStructuralFeature.definePropertyString("ordered", "unordered", defaultValue, isOrdered)
		} else {
			null
		}
	}

	def CharSequence defineTransient(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isTransient = eStructuralFeature.transient

		eStructuralFeature.definePropertyString("transient", "non-transient", defaultValue, isTransient)
	}

	def CharSequence defineUnique(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = eStructuralFeature instanceof EReference
		val boolean isUnique = eStructuralFeature.unique

		eStructuralFeature.definePropertyString("unique", "non-unique", defaultValue, isUnique)
	}

	def CharSequence defineUnsettable(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isUnsettable = eStructuralFeature.unsettable

		eStructuralFeature.definePropertyString("unsettable", "settable", defaultValue, isUnsettable)
	}

	def CharSequence defineVolatile(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isVolatile = eStructuralFeature.volatile

		eStructuralFeature.definePropertyString("volatile", "non-volatile", defaultValue, isVolatile)
	}

	def CharSequence defineResolveProxies(EReference eReference) {
		//val isDefault = eReference.eIsSet(EcorePackage.eINSTANCE.EReference_ResolveProxies)
		val boolean defaultValue = true
		val boolean resolveProxies = eReference.resolveProxies

		eReference.definePropertyString("resolveProxies", "non-resolveProxies", defaultValue, resolveProxies)
	}
	
	def CharSequence defineContainer(EReference eReference){
		val boolean defaultValue = false
		val boolean isContainer = eReference.isContainer
		
		eReference.definePropertyString("container", "non-container", defaultValue, isContainer)
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
		
		if (eKeysExist || eReference.shouldRenderDefaults) {
			'''_EKeys:_«IF eKeysExist» «eKeys.join("`", ", ", "`") [name]»«ELSE» `-`«ENDIF»'''
		}
	}

	def dispatch CharSequence concatDefaultValue(EAttribute eAttribute) {
		val EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.EStructuralFeature_DefaultValueLiteral
		val boolean defaultIsSet = eAttribute.eIsSet(defaultValueLiteral)
		
		if (defaultIsSet) {
			val defaultValue = eAttribute.defaultValue
			
			switch (defaultValue) {
				EEnumLiteralImpl:
					return '''_Default:_ `<<«concatAnchor(eAttribute.EAttributeType)»«EcoreDocExtension.ANCHOR_SEPARATOR»«defaultValue», «defaultValue»>>`'''
						
				default:
					return '''_Default:_ `«defaultValue»`'''
			}

		} else if (eAttribute.shouldRenderDefaults) {
			return '''_Default:_ `-`'''
		} else {
			return null
		}
	}

	def dispatch CharSequence concatDefaultValue(EReference eReference) {
		val EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.EStructuralFeature_DefaultValueLiteral
		val boolean defaultIsSet = eReference.eIsSet(defaultValueLiteral)

		if (defaultIsSet) {
			val defaultValue = eReference.defaultValue
			return '''_Default:_ `«defaultValue»`'''

		} else if (eReference.shouldRenderDefaults) {
			return '''_Default:_ `-`'''
		} else {
			return null
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
	
	protected def shouldRenderDefaults(EStructuralFeature eStructuralFeature) {
		(getConfig().findConfig(eStructuralFeature) as IEStructuralFeatureConfig).shouldRenderDefaults
	}
	
	protected def getConfig() {
		this.config
	}
}
