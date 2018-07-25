package com.altran.general.emf.ecoredoc.generator.impl.eclass

import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EReference

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

class ECrossReferenceReferenceGeneratorFragment extends AEReferenceGeneratorFragment {
	
	new(EClassGeneratorPart eClassGeneratorPart) {
		super(eClassGeneratorPart)
	}
	
	def void writeECrossReferences(EClassConfigPair pair) {
		val eClass = pair.element
		
		val crossReferences = collectECrossReferences(eClass).combineConfigPairs(pair.config)
		val inheritedCrossReferences = collectInheritedECrossReferences(pair).combineConfigPairs(pair.config)
		
		if (pair.config.hasRenderedEntries(crossReferences, inheritedCrossReferences)) {
			writeEReferencesHeader()

			writeEStructuralFeatures(crossReferences, eClass, inheritedCrossReferences)
		}
	}

	protected def void writeEReferencesHeader() {
		output.append(
		'''
			«newline»
			.References
			«tableHeader»
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def Set<EReference> collectECrossReferences(EClass eClass) {
		eClass.EReferences
			.filter[!isContainment]
			.toSet
	}

	protected def Set<EReference> collectInheritedECrossReferences(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			
			eClass.EAllReferences
				.filter[!isContainment]
				.reject[eClass.EReferences.contains(it)]
				.reject[eReference | eClass.EOperations.exists[it.overridesFeature(eReference)]]
				.toSet
	 	} else {
	 		emptySet
	 	}
	}
}
