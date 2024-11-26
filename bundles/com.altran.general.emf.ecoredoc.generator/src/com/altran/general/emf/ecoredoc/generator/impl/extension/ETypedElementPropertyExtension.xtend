package com.altran.general.emf.ecoredoc.generator.impl.^extension

import com.altran.general.emf.ecoredoc.generator.configbuilder.IETypedElementConfigPair
import org.eclipse.emf.ecore.EReference

class ETypedElementPropertyExtension {
	val static String BOLD = "**"
	
	protected extension AnchorExtension = new AnchorExtension
	
	def CharSequence concatBounds(IETypedElementConfigPair<?,?> pair) {
		val eTypedElement = pair.element
		
		val lowerBound = eTypedElement.lowerBound
		val upperBound = eTypedElement.upperBound
		val lowerNotEqualUpperBound = lowerBound != upperBound
		
		val isSet = if (eTypedElement.isMany) {
			lowerBound !== 0 || upperBound !== -1
		} else {
			lowerBound !== 0 || upperBound !== 1
		}
		
		if (isSet || pair.config.shouldRenderBounds) {
			'''`[«lowerBound»«IF lowerNotEqualUpperBound»..«defineUpperBound(upperBound)»«ENDIF»]`'''
		}
	}

	def CharSequence defineOrdered(IETypedElementConfigPair<?,?> pair) {
		if (pair.element.isMany) {
			pair.definePropertyString("ordered", "unordered", true, pair.element.ordered)
		} else {
			null
		}
	}

	def CharSequence defineUnique(IETypedElementConfigPair<?,?> pair) {
		if (pair.element.isMany) {
			pair.definePropertyString("unique", "non-unique", pair.element instanceof EReference, pair.element.unique)
		} else {
			null
		}
	}

	def CharSequence definePropertyString(
		IETypedElementConfigPair<?,?> pair, 
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

	protected def CharSequence defineUpperBound(int upperBound) {
		val boolean upperBoundExists = (upperBound != -1)

		if (upperBoundExists) {
			upperBound.toString

		} else {
			'''*'''
		}
	}
	
	def CharSequence boldifyString(String string) {
		'''«BOLD»«string»«BOLD»'''
	}
}