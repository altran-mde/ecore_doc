package com.altran.general.emf.ecoredoc.generator.impl.eclass

import com.altran.general.emf.ecoredoc.generator.config.EClassConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.EAttributeConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair
import java.util.Set
import org.eclipse.emf.ecore.EAttribute

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

class EAttributeGeneratorFragment extends AEStructuralFeatureGeneratorFragment<EAttribute, EAttributeConfigPair> {
	
	new(EClassGeneratorPart eClassGeneratorPart) {
		super(eClassGeneratorPart)
	}
	
	def void writeEAttributes(EClassConfigPair pair) {
		val eClass = pair.element
		
		val eAttributes = eClass.EAttributes.combineConfigPairs(pair.config)
		val inheritedEAttributes = collectInheritedEAttributes(pair).combineConfigPairs(pair.config)
		
		if (pair.config.hasRenderedEntries(eAttributes, inheritedEAttributes)) {
			writeEAttributesHeader()
			
			writeEStructuralFeatures(eAttributes, eClass, inheritedEAttributes)
		}
	}
	
	protected def void writeEAttributesHeader() {
		output.append(
		'''
			«newline»
			.Attributes
			«tableHeader»
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def Set<EAttribute> collectInheritedEAttributes(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			
			eClass.EAllAttributes
				.reject[eClass.EAttributes.contains(it)]
				.reject[eAttribute | eClass.EOperations.exists[it.overridesFeature(eAttribute)]]
				.toSet
	 	} else {
	 		emptySet
	 	}
	}
	
	override protected enumerateFeatureProperties(EAttributeConfigPair pair) {
		 #[
		 	defineId(pair)
		 ]
	}
	
	override protected combineConfigPair(EAttribute eAttribute, EClassConfig classConfig) {
		new EAttributeConfigPair(eAttribute, classConfig.EAttributes.findFirst[id == eAttribute.name])
	}
	
	override protected concatFeatureType(EAttribute eAttribute) {
		'''
			«this.eClassGeneratorPart.concatLinkTo(eAttribute.EType)»
		'''
	}
}
