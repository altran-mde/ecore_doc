package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfigPair
import com.google.common.collect.Multimap
import java.util.ArrayList
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage

import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline

abstract class AEcoreDocGeneratorPart {

	protected extension EcoreDocExtension = new EcoreDocExtension

	val EcoreDocGeneratorConfig config
	val Multimap<EPackage, EClassifier> ePackages

	var StringBuilder output

	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages) {
		this.config = config
		this.ePackages = ePackages
	}

	def abstract StringBuilder write(EPackage ePackage)

	protected def void clearOutput() {
		this.output = new StringBuilder()
	}

	protected def Multimap<EPackage, EClassifier> getEPackages() {
		this.ePackages
	}
	
	protected def getConfig() {
		this.config
	}

	protected def StringBuilder getOutput() {
		if (this.output === null) {
			throw new IllegalStateException("Tried to write to output before clearing it")
		}

		this.output
	}

	protected def CharSequence concatReferenceName(ENamedElement eNamedElement) {
		collectTypeSegments(eNamedElement).joinReference
	}

	protected def dispatch CharSequence concatLinkTo(ENamedElement eNamedElement) {
		'''`<<«concatAnchor(eNamedElement)», «concatReferenceName(eNamedElement)»>>`'''
	}

	// Special handling for default EDataTypes: Don't create anchor
	protected def dispatch CharSequence concatLinkTo(EDataType eDataType) {
		val boolean defaultDataType = isDefaultEDataType(eDataType)
		
		if (defaultDataType) {
			'''`«eDataType.name»`'''

		} else {
			'''`<<«concatAnchor(eDataType)», «concatReferenceName(eDataType)»>>`'''
			
		}
	}

	protected def CharSequence concatUsedLink(EStructuralFeature eStructuralFeature, EClass eClassThatInherits) {
		val String[] inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClassThatInherits)
		val CharSequence anchor = '''«inheritedFeatureSegments.joinAnchor»'''
		val CharSequence reference = '''«inheritedFeatureSegments.joinReference»'''

		'''`<<«anchor», «reference»>>`'''
	}

	protected def String[] collectInheritedFeatureSegments(EStructuralFeature eStructuralFeature,
		EClass eClassThatInherits) {
		val String ePackageName = getEPackage(eClassThatInherits).name
		val String eClassName = eClassThatInherits.name
		val String eStructuralFeatureName = eStructuralFeature.name

		#[ePackageName, eClassName, eStructuralFeatureName]
	}

	protected def void writeUseCases(IEClassifierConfigPair<?, ?> pair) {
		if (!pair.config.shouldRenderUseCases) {
			return
		}

		val target = pair.element
		
		var boolean anyMatch = false
		val Collection<EClass> eClasses = collectAllEClasses()
		val ArrayList<String> useCaseStrings = newArrayList()
		val List<EClass> sortedEClasses = eClasses.sortBy(EcoreDocExtension::eClassifierSorter)

		for (eClass : sortedEClasses) {
			val List<EStructuralFeature> sortedEStructuralFeatures = eClass.EAllStructuralFeatures.sortBy(EcoreDocExtension::eStructuralFeatureSorter)
			
			for (feature : sortedEStructuralFeatures) {
				if (feature.EType == target) {
					anyMatch = true

					useCaseStrings.add(
					'''
						* «concatUsedLink(feature, eClass)»
					''')
				}
			}
		}

		if (anyMatch) {
			output.append(
			'''
				«newline»
				.Used at
			''')

			for (useCaseString : useCaseStrings.sort) {
				output.append(useCaseString)
			}
		}
	}
	
	protected def defineDefaultValue(IEClassifierConfigPair<?,?> pair) {
		val eClassifier = pair.element
		
		val defaultValue = '''_undefined_'''
		val value = if (eClassifier.eIsSet(EcorePackage.eINSTANCE.EClassifier_DefaultValue)) '''`«eClassifier.defaultValue»`''' else null

		concatProperty("Default Value", defaultValue, value, pair)
	}
	
	protected def defineInstanceClassName(IEClassifierConfigPair<?,?> pair) {
		val eClassifier = pair.element
		
		val defaultValue = '''_undefined_'''
		val value = if (eClassifier.eIsSet(EcorePackage.eINSTANCE.EClassifier_InstanceClassName)) '''`«eClassifier.instanceClassName»`''' else null

		concatProperty("Instance Type Name", defaultValue, value, pair)
	}
	
	protected def concatProperty(String name, String defaultValue, String value, IEClassifierConfigPair<?,?> pair) {
		if (value !== null || pair.config.shouldRenderDefaults) {
			'''«name»:: «IF value !== null»«value»«ELSE»«defaultValue»«ENDIF»'''
		}
	}
	
	protected def CharSequence tableFooter() {
		'''
			|===
		'''
	}

	protected def Collection<EClass> collectAllEClasses() {
		ePackages.values
			.filter(EClass)
			.filter[getConfig().findConfig(it).shouldRender]
			.toSet
	}
}
