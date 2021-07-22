package com.altran.general.emf.ecoredoc.generator.impl.^extension

import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.util.EcoreUtil

class EcoreDocExtension {
	public static val ECLASSIFIER_PROPERTY_SEPARATOR = newline
	
	public static val eClassifierSorter = [EClassifier it | it.EPackage.name + it.name ?: ""]
	public static val eStructuralFeatureSorter = [EStructuralFeature it | it.name ?: ""]
	public static val eOperationSorter = [EOperation it | it.name ?: ""]

	def static String newline() {
		System.getProperty("line.separator")
	}
	
	def CharSequence getDocumentation(EModelElement modelElement) {
		val documentation = EcoreUtil.getDocumentation(modelElement)

		if (documentation !== null) {
			val stripped = documentation.replaceAll("(<[^>]+>)(<[^>]+>)", " ").replaceAll("<[^>]+>", "")
			if (stripped == documentation) {
				documentation + newline
			} else {
				'''
					«newline»
					ifdef::backend-html5[]
					++++
					«documentation»
					++++
					endif::[]
					ifndef::backend-html5[]
					«stripped»
					endif::[]
				'''
			}
		} else {
			""
		}
	}

	def CharSequence tableHeader() {
		'''[cols="<30,<20,<20,<40a",options="header"]'''
	}

	def CharSequence tableFooter() {
		'''
			|===
		'''
	}

	def EPackage getEPackage(EClassifier eClassifier) {
		return eClassifier.eContainer as EPackage
	}
	
	def boolean isDefaultEDataType(EDataType eDataType) {
		EcorePackage.eINSTANCE.nsURI == getEPackage(eDataType)?.nsURI
	}

	def List<EDataType> collectEDataTypes(Collection<EClassifier> classifiers) {
		classifiers.filter(EDataType).filter[!(it instanceof EEnum)].sortBy(eClassifierSorter)
	}
	
	def List<EEnum> collectEEnums(Collection<EClassifier> classifiers) {
		classifiers.filter(EEnum).sortBy(eClassifierSorter)
	}

	def List<EClass> collectEClasses(Collection<EClassifier> classifiers) {
		classifiers.filter(EClass).sortBy(eClassifierSorter)
	}
}
