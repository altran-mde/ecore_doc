package com.altran.general.emf.ecoredoc.generator.impl.^extension

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtext.EcoreUtil2

class EOperationEStructuralFeatureInteractionExtension {
	def overridesFeature(EOperation eOperation, EStructuralFeature eStructuralFeature) {
		var getter = true
		
		val simpleName = if (
				eOperation.EParameters.size == 1 
				&& eOperation.EParameters.get(0).upperBound == 1
				&& eOperation.EType === null
			) {
				getter = false
				eOperation.name
					.replaceFirst("^set", "")
					.toFirstLower
			} else if (
				eOperation.EParameters.size == 0
				&& eOperation.EType !== null
			) {
				getter = true
				eOperation.name
					.replaceFirst("^get", "")
					.toFirstLower
			} else {
				return false
			}
			
		if (eStructuralFeature.name != simpleName) {
			return false
		}
		
		val compare = if (getter) {
			eOperation
		} else {
			eOperation.EParameters.head
		}
		
		if (eStructuralFeature.isMany != compare.isMany) {
			return false
		}
		
		val featureInstanceClass = eStructuralFeature.EType?.instanceClass
		val opInstanceClass = compare.EType?.instanceClass
		
		if (featureInstanceClass !== null && opInstanceClass !== null) {
			return featureInstanceClass.isAssignableFrom(opInstanceClass)
		}
		
		if (eStructuralFeature.EType instanceof EClass && compare.EType instanceof EClass) {
			return EcoreUtil2.isAssignableFrom(eStructuralFeature.EType as EClass, compare.EType as EClass)
		}
		
		return false
	}
	
	def implementsOperation(EStructuralFeature eStructuralFeature, EOperation eOperation) {
		val getterName = "get" + eStructuralFeature.name.toFirstUpper 
		val setterName = if (eStructuralFeature.isMany) null else "set" + eStructuralFeature.name.toFirstUpper
		
		val compare = if (eOperation.name == getterName) {
				if (!eOperation.EParameters.isEmpty) {
					return false
				}
				
				eOperation
			} else if (eOperation.name == setterName) {
				if (eOperation.EType !== null) {
					return false
				}
				
				if (eOperation.EParameters.size != 1) {
					return false
				}
				
				eOperation.EParameters.head
			} else {
				return false
			}
		
		if (eStructuralFeature.isMany != compare.isMany) {
			return false
		}
		
		val featureInstanceClass = eStructuralFeature.EType?.instanceClass
		val opInstanceClass = compare.EType?.instanceClass
		
		if (featureInstanceClass !== null && opInstanceClass !== null) {
			return opInstanceClass.isAssignableFrom(featureInstanceClass)
		}
		
		if (eStructuralFeature.EType instanceof EClass && compare.EType instanceof EClass) {
			return EcoreUtil2.isAssignableFrom(compare.EType as EClass, eStructuralFeature.EType as EClass)
		}
		
		return false
	}
}