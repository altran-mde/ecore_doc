package com.altran.general.emf.ecoredoc.generator.impl.^extension

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EParameter

class InheritedEClassMemberSegmentsCollector {
	extension EcoreDocExtension = new EcoreDocExtension

	def dispatch String[] collectInheritedEClassMemberSegments(EOperation eOperation, EClass eClassThatInherits) {
		val String ePackageName = getEPackage(eClassThatInherits).name
		val String eClassName = eClassThatInherits.name
		val String eStructuralFeatureName = eOperation.name

		#[ePackageName, eClassName, eStructuralFeatureName]
		 + eOperation.EParameters.map[getEPackage(EType).name + "_" + EType.name]
	}

	def dispatch String[] collectInheritedEClassMemberSegments(EStructuralFeature eStructuralFeature, EClass eClassThatInherits) {
		val String ePackageName = getEPackage(eClassThatInherits).name
		val String eClassName = eClassThatInherits.name
		val String eStructuralFeatureName = eStructuralFeature.name

		#[ePackageName, eClassName, eStructuralFeatureName]
	}

	def dispatch String[] collectInheritedEClassMemberSegments(EParameter eParameter, EClass eClassThatInherits) {
		_collectInheritedEClassMemberSegments(eParameter.eContainer as EOperation, eClassThatInherits) + #[eParameter.name]
	}
}
