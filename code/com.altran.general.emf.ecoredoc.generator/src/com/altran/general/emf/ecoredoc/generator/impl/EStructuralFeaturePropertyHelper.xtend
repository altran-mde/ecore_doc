package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.EAttributeConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.EReferenceConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEStructuralFeatureConfigPair
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl

class EStructuralFeaturePropertyHelper {
	val static String BOLD = "**"
	
	extension EcoreDocExtension = new EcoreDocExtension
	
	val EcoreDocGeneratorConfig config
	
	new(EcoreDocGeneratorConfig config) {
		this.config = config
	}

	def CharSequence concatBounds(IEStructuralFeatureConfigPair<?,?> pair) {
		val eStructuralFeature = pair.element
		
		val lowerBound = eStructuralFeature.lowerBound
		val upperBound = eStructuralFeature.upperBound
		val lowerNotEqualUpperBound = lowerBound != upperBound
		
		val isSet = if (eStructuralFeature.isMany) {
			lowerBound !== 0 || upperBound !== -1
		} else {
			lowerBound !== 0 || upperBound !== 1
		}
		
		if (isSet || pair.config.shouldRenderBounds) {
			'''`[«lowerBound»«IF lowerNotEqualUpperBound»..«defineUpperBound(upperBound)»«ENDIF»]`'''
		}
	}

	def CharSequence boldifyString(String string) {
		'''«BOLD»«string»«BOLD»'''
	}

	def CharSequence definePropertyString(
		IEStructuralFeatureConfigPair<?,?> pair, 
		String trueLiteral, 
		String falseLiteral, 
		boolean defaultValue,
		boolean currentPropertyValue) { 
			
		val isSet = (defaultValue != currentPropertyValue)
		val shouldRenderDefaults = pair.config.shouldRenderDefaults
		
		if(isSet || shouldRenderDefaults) {
			if(currentPropertyValue) {
				if(isSet && shouldRenderDefaults) {
					return boldifyString(trueLiteral)
				} else {
					return trueLiteral
				}
			} else {
				if(isSet && shouldRenderDefaults) {
					return boldifyString(falseLiteral)
				} else {
					return falseLiteral
				}
			}
		}
	}

	def CharSequence defineChangeable(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.definePropertyString("changeable", "unchangeable", true, pair.element.changeable)
	}

	def CharSequence defineDerived(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.definePropertyString("derived", "underived", false, pair.element.derived)
	}

	def CharSequence defineOrdered(IEStructuralFeatureConfigPair<?,?> pair) {
		if (pair.element.upperBound != 1) {
			pair.definePropertyString("ordered", "unordered", true, pair.element.ordered)
		} else {
			null
		}
	}

	def CharSequence defineTransient(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.definePropertyString("transient", "non-transient", false, pair.element.transient)
	}

	def CharSequence defineUnique(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.definePropertyString("unique", "non-unique", pair.element instanceof EReference, pair.element.unique)
	}

	def CharSequence defineUnsettable(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.definePropertyString("unsettable", "settable", false, pair.element.unsettable)
	}

	def CharSequence defineVolatile(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.definePropertyString("volatile", "non-volatile", false, pair.element.volatile)
	}

	def CharSequence defineResolveProxies(EReferenceConfigPair pair) {
		pair.definePropertyString("resolveProxies", "non-resolveProxies", !pair.element.containment, pair.element.resolveProxies)
	}
	
	def CharSequence defineContainer(EReferenceConfigPair pair){
		if (pair.element.isContainer) {
			'''*container*'''

		} else if(pair.config.shouldRenderDefaults) {
			'''non-container'''
		} else {
			null
		}
	}
	
	def CharSequence defineId(EAttributeConfigPair pair) {
		val boolean isID = pair.element.isID

		if (isID) {
			'''*is id*'''

		} else {
			null
		}
	}

	def CharSequence defineEKeys(EReferenceConfigPair pair) {
		val eKeys = pair.element.EKeys
		
		val boolean eKeysExist = !eKeys.isEmpty
		
		if (eKeysExist || pair.shouldRenderDefaults) {
			'''_EKeys:_«IF eKeysExist» «eKeys.join("`", ", ", "`") [name]»«ELSE» `-`«ENDIF»'''
		}
	}

	def dispatch CharSequence concatDefaultValue(IEStructuralFeatureConfigPair<?,?> pair) {
		// dummy to satisfy Xtend
	}

	def dispatch CharSequence concatDefaultValue(EAttributeConfigPair pair) {
		val eAttribute = pair.element
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

		} else if (pair.shouldRenderDefaults) {
			return '''_Default:_ `-`'''
		} else {
			return null
		}
	}

	def dispatch CharSequence concatDefaultValue(EReferenceConfigPair pair) {
		val eReference = pair.element
		val EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.EStructuralFeature_DefaultValueLiteral
		val boolean defaultIsSet = eReference.eIsSet(defaultValueLiteral)

		if (defaultIsSet) {
			val defaultValue = eReference.defaultValue
			return '''_Default:_ `«defaultValue»`'''

		} else if (pair.shouldRenderDefaults) {
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
	
	protected def shouldRenderDefaults(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.config.shouldRenderDefaults
	}
	
	protected def getConfig() {
		this.config
	}
}
