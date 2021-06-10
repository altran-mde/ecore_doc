package com.altran.general.emf.ecoredoc.generator.impl.^extension

import com.altran.general.emf.ecoredoc.generator.configbuilder.EAttributeConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.EReferenceConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEStructuralFeatureConfigPair
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl

class EStructuralFeaturePropertyExtension extends ETypedElementPropertyExtension {
	def CharSequence defineChangeable(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.definePropertyString("changeable", "unchangeable", true, pair.element.changeable)
	}

	def CharSequence defineDerived(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.definePropertyString("derived", "underived", false, pair.element.derived)
	}

	def CharSequence defineTransient(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.definePropertyString("transient", "non-transient", false, pair.element.transient)
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
					return '''_Default:_ `<<«concatAnchor(eAttribute.EAttributeType)»«AnchorExtension.ANCHOR_SEPARATOR»«defaultValue», «defaultValue»>>`'''
						
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

	protected def shouldRenderDefaults(IEStructuralFeatureConfigPair<?,?> pair) {
		pair.config.shouldRenderDefaults
	}
}
