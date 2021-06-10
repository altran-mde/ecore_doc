package com.altran.general.emf.ecoredoc.generator.impl.eclass

import com.altran.general.emf.ecoredoc.generator.config.EClassConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEStructuralFeatureConfigPair
import com.altran.general.emf.ecoredoc.generator.impl.^extension.EStructuralFeaturePropertyExtension
import com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EStructuralFeature

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

abstract class AEStructuralFeatureGeneratorFragment<F extends EStructuralFeature, P extends IEStructuralFeatureConfigPair<F, ?>> extends AEClassMemberGeneratorFragment {
	protected extension EStructuralFeaturePropertyExtension = new EStructuralFeaturePropertyExtension
	
	new(EClassGeneratorPart eClassGeneratorPart) {
		super(eClassGeneratorPart)
	}
	
	protected def hasRenderedEntries(EClassConfig classConfig, Collection<P> eStructuralFeatures, Collection<P> inheritedEStructuralFeatures) {
		eStructuralFeatures.exists[it.config.shouldRender]
		||
		(
			classConfig.shouldRepeatInherited
			&&
			inheritedEStructuralFeatures.exists[it.config.shouldRender]
		)
	}
	
	protected def List<P> combineConfigPairs(Collection<F> eStructuralFeatures, EClassConfig classConfig) {
		eStructuralFeatures
			.map[combineConfigPair(classConfig) as P]
			.toList
	}
	
	protected def void writeEStructuralFeatures(
		Collection<P> ownEStructuralFeatures, 
		EClass eClass,
		Collection<P> inheritedEStructuralFeatures) {
		
		for (entry: ownEStructuralFeatures.sortBy[EcoreDocExtension::eStructuralFeatureSorter.apply(element)]) {
			writeRow(entry, eClass, false)
		}

		for (entry : inheritedEStructuralFeatures.sortBy[EcoreDocExtension::eStructuralFeatureSorter.apply(element)]) {
			writeRow(entry, eClass, true)
		}

		output.append(tableFooter())
	}

	protected def void writeRow(P pair, EClass eClass, boolean inherited) {
		if (!pair.config.shouldRender) {
			return
		}
		
		val eStructuralFeature = pair.element
		val String eStructuralFeatureName = eStructuralFeature.name
		
		val inheritedFeatureSegments = collectInheritedEClassMemberSegments(eStructuralFeature, eClass) 

		output.append(
		'''
			«newline»
			|`«eStructuralFeatureName»`[[«inheritedFeatureSegments.joinAnchor»]]
			«IF inherited»
				
				«concatInheritedElement(eStructuralFeature)»
			«ENDIF»
			«concatOverridesOperations(eStructuralFeature, eClass)»
			«concatOverridenByOperations(eStructuralFeature, eClass)»
			|«concatFeatureType(eStructuralFeature)»
			|«concatFeatureProperties(pair)»
			|«getDocumentation(eStructuralFeature)»
		''')
	}
	
	protected def concatOverridesOperations(F eStructuralFeature, EClass eClass) {
		val overridesOperations = eClass.EAllSuperTypes
			.map[EOperations]
			.flatten
			.filter[eStructuralFeature.implementsOperation(it)]
			.toSet
			
		overridesOperations
			.map[concatLinkTo("{override}")]
			.joinInheritance
	}
	
	protected def concatOverridenByOperations(F eStructuralFeature, EClass eClass) {
		val overriddenByOperations = collectAllSubTypes(eClass)
			.map[EOperations]
			.flatten
			.filter[it.overridesFeature(eStructuralFeature)]
			.toSet
			
		overriddenByOperations
			.map[concatLinkTo("{overriddenBy}")]
			.joinInheritance
	}
	
	protected def CharSequence concatFeatureProperties(P pair) {
		val featureProperties = enumerateFeatureProperties(pair)
		val genericProperties = enumerateGenericProperties(pair)
		
		return (featureProperties + genericProperties)
			.filterNull
			.join(PROPERTY_SEPARATOR)
	}

	protected def CharSequence concatInheritedElement(ENamedElement eNamedElement) {
		concatLinkTo(eNamedElement, "{inherited}")
	}
	
	protected def List<CharSequence> enumerateGenericProperties(P pair) {
		#[
			concatBounds(pair),
			concatDefaultValue(pair),
			defineOrdered(pair),
			defineChangeable(pair),
			defineDerived(pair),
			defineTransient(pair),
			defineUnique(pair),
			defineUnsettable(pair),
			defineVolatile(pair)
		]
	}
	
	abstract protected def List<CharSequence> enumerateFeatureProperties(P pair)

	abstract protected def P combineConfigPair(F eStructuralFeature, EClassConfig classConfig)

	abstract protected def CharSequence concatFeatureType(F eStructuralFeature)
}
