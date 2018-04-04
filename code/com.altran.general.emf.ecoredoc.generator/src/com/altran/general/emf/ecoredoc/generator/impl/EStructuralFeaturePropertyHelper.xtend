package com.altran.general.emf.ecoredoc.generator.impl

import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.EReference

// FIXME: Use formatter
class EStructuralFeaturePropertyHelper {
	extension EcoreDocExtension = new EcoreDocExtension
	
	val static String BOLD = "**"
	// FIXME: I think we should do this in the join() methods for ERef / EAttr, so we only and this in between lines
	val static String JOIN = " +"
	
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
	
	// FIXME: Learn the difference between richstring IF and Xtend if, and when to use which one
	def CharSequence definePropertyString(String trueLiteral, String falseLiteral, boolean defaultValue, boolean currentPropertyValue) {
		var CharSequence result =''''''
		val boolean boldify = (defaultValue != currentPropertyValue)
		
		if(currentPropertyValue){
			result = '''«IF boldify»«boldifyString(trueLiteral)»«ELSE»«trueLiteral»«ENDIF»'''
			
		}else{
			result = '''«IF boldify»«boldifyString(falseLiteral)»«ELSE»«falseLiteral»«ENDIF»'''
		}
		
		return result
	}
	
	def CharSequence definePropertyString(String trueLiteral, String falseLiteral, boolean currentPropertyValue) {
		var CharSequence result =''''''
		
		if(currentPropertyValue){
			result = trueLiteral
			
		}else{
			result = falseLiteral
		}
		
		return result
	}
	
	def CharSequence defineChangeable(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = true
		val boolean isChangeable = eStructuralFeature.changeable
		
		'''
			«definePropertyString("changeable", "unchangeable", defaultValue, isChangeable)»«JOIN»
		'''
	}
	
	def CharSequence defineDerived(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isDerived = eStructuralFeature.derived
		
		'''
			«definePropertyString("derived", "underived", defaultValue, isDerived)»«JOIN»
		'''
	}

	def CharSequence defineOrdered(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = true
		val int upperBound = eStructuralFeature.upperBound
		val boolean isOrdered = eStructuralFeature.ordered

		if (upperBound != 1) {
			'''
				«definePropertyString("ordered", "unordered", defaultValue, isOrdered)»«JOIN»
			'''
			
		} else {
			null
		}
	}
	
	def CharSequence defineTransient(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isTransient = eStructuralFeature.transient
		
		'''
			«definePropertyString("transient", "non-transient", defaultValue, isTransient)»«JOIN»
		'''
	}
	
	def CharSequence defineUnique(EStructuralFeature eStructuralFeature) {
		val boolean isUnique = eStructuralFeature.unique
		
		'''
			«definePropertyString("unique", "non-unique", isUnique)»«JOIN»
		'''
	}
	
	def CharSequence defineUnsettable(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isUnsettable = eStructuralFeature.unsettable
		
		'''
			«definePropertyString("unsettable", "settable", defaultValue, isUnsettable)»«JOIN»
		'''
	}
	
	def CharSequence defineVolatile(EStructuralFeature eStructuralFeature) {
		val boolean defaultValue = false
		val boolean isVolatile = eStructuralFeature.volatile
		
		'''
			«definePropertyString("volatile", "non-volatile", defaultValue, isVolatile)»
		'''
	}
	
	def CharSequence defineResolveProxies(EReference eReference){
		val boolean defaultValue = true
		val boolean resolveProxies = eReference.resolveProxies
		val CharSequence separator = '''«JOIN»«newline»'''
		
		'''
			«definePropertyString("resolveProxies", "non-resolveProxies", defaultValue, resolveProxies)»«separator»
		'''
	}

	def CharSequence defineId(EAttribute eAttribute) {
		val boolean isID = eAttribute.isID
		
		if (isID) {
			'''
				*is id*
				«newline»
			'''
			
		} else {
			null
		}
	}
	
	def StringBuilder defineEKeys(EReference eReference){
		val eKeys = eReference.EKeys
		
		// FIXME: You already used join()
		var StringBuilder result = new StringBuilder
		val separator = '''«JOIN»«newline»'''
		
		result.append('''_EKeys:_''')
		
		if(!eKeys.isEmpty){
			for(eKey : eKeys){
				result.append(''' `«eKey.name»`«separator»''')
			}
			
		}else{
			result.append(''' `-`«separator»''')
		}
		
		return result	
	}
	
	// FIXME: Why does Containment do something with container?
	def CharSequence defineContainment(EReference eReference){
		val boolean isContainer = eReference.isContainer
		val boolean isContainment = eReference.isContainment
		val CharSequence separator = '''«JOIN»«newline»«newline»'''
		
		'''
			«definePropertyString("container", "non-container", isContainer)»«JOIN»
			«definePropertyString("containment", "non-containment", isContainment)»«separator»
		'''
	}
	
	def dispatch CharSequence concatDefaultValue(EAttribute eAttribute) {
		val EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.EStructuralFeature_DefaultValueLiteral
		val boolean defaultIsSet = eAttribute.eIsSet(defaultValueLiteral)
		val separator = '''«JOIN»«newline»'''
		
		if (defaultIsSet) {
			val defaultValue = eAttribute.defaultValue
			var result = '''_Default:_ '''
			
			switch (defaultValue) {
				case EEnumLiteral:
					result += '''`<<«concatAnchor(eAttribute.EAttributeType)»«EcoreDocExtension.ANCHOR_SEPARATOR»«defaultValue», «defaultValue»>>`«separator»'''
					
				default:
					result += '''`«defaultValue»`«separator»'''
			}
			
			return result
			
		} else {
			return '''_Default:_ `-`«separator»'''
		}
	}
	
	def dispatch CharSequence concatDefaultValue(EReference eReference) {
		val EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.EStructuralFeature_DefaultValueLiteral
		val boolean defaultIsSet = eReference.eIsSet(defaultValueLiteral)
		val separator = '''«JOIN»«newline»'''
		
		if (defaultIsSet) {
			val defaultValue = eReference.defaultValue
			var result = '''_Default:_ '''
			
			switch (defaultValue) {
				// FIXME: Can an EReference EVER have a literal as default?
				case EEnumLiteral:
					result += '''`<<«concatAnchor(eReference.EReferenceType)»«EcoreDocExtension.ANCHOR_SEPARATOR»«defaultValue», «defaultValue»>>`«separator»'''
					
				default:
					result += '''`«defaultValue»`«separator»'''
			}
			
			return result
			
		} else {
			return '''_Default:_ `-`«separator»'''
		}
	}

	protected def CharSequence defineUpperBound(int upperBound) {
		val boolean upperBoundExists = (upperBound != -1)
		
		if (upperBoundExists) {
			// FIXME: Now you owe me a cake!
			'''«upperBound»'''
			
		} else {
			'''*'''
		}
	}
}
