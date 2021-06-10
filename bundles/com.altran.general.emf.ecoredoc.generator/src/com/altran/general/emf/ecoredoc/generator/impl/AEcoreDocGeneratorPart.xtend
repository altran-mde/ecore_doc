package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEClassifierConfigPair
import com.altran.general.emf.ecoredoc.generator.impl.^extension.AnchorExtension
import com.altran.general.emf.ecoredoc.generator.impl.^extension.EOperationEStructuralFeatureInteractionExtension
import com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension
import com.altran.general.emf.ecoredoc.generator.impl.^extension.InheritedEClassMemberSegmentsCollector
import com.altran.general.emf.ecoredoc.generator.impl.^extension.TypeSegmentsCollector
import com.google.common.collect.Multimap
import com.google.inject.Injector
import java.util.Collection
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EcorePackage

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

abstract class AEcoreDocGeneratorPart {

	protected extension EcoreDocExtension = new EcoreDocExtension
	protected extension AnchorExtension = new AnchorExtension
	protected extension InheritedEClassMemberSegmentsCollector = new InheritedEClassMemberSegmentsCollector
	
	extension EOperationEStructuralFeatureInteractionExtension = new EOperationEStructuralFeatureInteractionExtension
	extension TypeSegmentsCollector = new TypeSegmentsCollector
	
	val EcoreDocGeneratorConfig config
	val Multimap<EPackage, EClassifier> ePackages
	val Injector xcoreInjector

	var StringBuilder output

	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages, Injector xcoreInjector) {
		this.config = config
		this.ePackages = ePackages
		this.xcoreInjector = xcoreInjector
	}

	def abstract StringBuilder write(EPackage ePackage)

	def void clearOutput() {
		this.output = new StringBuilder()
	}

	def Multimap<EPackage, EClassifier> getEPackages() {
		this.ePackages
	}
	
	def getConfig() {
		this.config
	}
	
	def getXcoreInjector() {
		this.xcoreInjector
	}

	def StringBuilder getOutput() {
		if (this.output === null) {
			throw new IllegalStateException("Tried to write to output before clearing it")
		}

		this.output
	}
	
	def CharSequence concatLinkTo(ENamedElement eNamedElement) {
		concatLinkTo(eNamedElement, "")
	}

	def dispatch CharSequence concatLinkTo(ENamedElement eNamedElement, String prefix) {
		val cfg = getConfig().findConfig(eNamedElement)
		
		// prevent creating links to non-rendered targets
		if (cfg?.shouldRender) {
			'''`<<«concatAnchor(eNamedElement)», «prefix»«concatReferenceName(eNamedElement)»>>`'''
		} else {
			'''`«prefix»«concatReferenceName(eNamedElement)»`'''
		}
	}

	// Special handling for default EDataTypes: Don't create anchor
	def dispatch CharSequence concatLinkTo(EDataType eDataType, String prefix) {
		val boolean defaultDataType = isDefaultEDataType(eDataType)
		
		if (defaultDataType) {
			'''`«eDataType.name»`'''

		} else {
			val cfg = getConfig().findConfig(eDataType)
			
			// prevent creating links to non-rendered targets
			if (cfg?.shouldRender) {
				'''`<<«concatAnchor(eDataType)», «prefix»«concatReferenceName(eDataType)»>>`'''
			} else {
				'''`«prefix»«concatReferenceName(eDataType)»`'''
			}
		}
	}

	def dispatch CharSequence concatLinkTo(Void eDataType, String prefix) {
		'''«prefix»`void`'''
	}

	protected def dispatch CharSequence concatUsedLink(ETypedElement eTypedElement, EClass eClassThatInherits) {
		val String[] inheritedFeatureSegments = collectInheritedEClassMemberSegments(eTypedElement, eClassThatInherits)

		'''`<<«inheritedFeatureSegments.joinAnchor», «inheritedFeatureSegments.joinReference»>>`'''
	}

	protected def dispatch CharSequence concatUsedLink(EOperation eOperation, EClass eClassThatInherits) {
		val String[] inheritedFeatureSegments = collectInheritedEClassMemberSegments(eOperation, eClassThatInherits)

		'''
			`<<«inheritedFeatureSegments.joinAnchor», «collectTypeSegments(eOperation).joinReference»(«
			FOR param : eOperation.EParameters SEPARATOR ", "
				»«param.name»«
			ENDFOR»)>>`'''
	}

	protected def void writeUseCases(IEClassifierConfigPair<?, ?> pair) {
		if (!pair.config.shouldRenderUseCases) {
			return
		}

		val target = pair.element
		
		val usages = collectAllEClasses
			.sortBy(EcoreDocExtension::eClassifierSorter)
			.map[ eClass |
				val Set<ETypedElement> members = newLinkedHashSet()
				
				members += eClass.EAllStructuralFeatures
					.reject[feat | eClass.EOperations.exists[it.overridesFeature(feat)]]
					.sortBy(EcoreDocExtension::eStructuralFeatureSorter)
				
				val eOperations = eClass.EAllOperations
					.reject[EcorePackage.Literals::EOBJECT == eContainer]
					.reject[op | eClass.EStructuralFeatures.exists[it.implementsOperation(op)]]
					.sortBy(EcoreDocExtension::eOperationSorter)
				
				members += eOperations
				
				members.map[eClass -> it]
			]
			.flatten
			.filter[
				val v = value
				
				switch(v) {
					EOperation:
						target == v.EType || v.EExceptions.contains(target) || v.EParameters.map[EType].contains(target)
					
					default:
						target == v.EType
				}
			]
			.map[
				'''
					* «concatUsedLink(value, key)»
				'''
			]
			.toSet
			.join()
		
		if (!usages.isEmpty) {
			output.append(
			'''
				«newline»
				.Used at
				«usages»
			''')
			
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
	
	protected def Collection<EClass> collectAllEClasses() {
		ePackages.values
			.filter(EClass)
			.filter[getConfig().findConfig(it).shouldRender]
			.toSet
	}
}
