package com.altran.general.emf.ecoredoc.generator.impl.eclass

import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EReference

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

class EContainmentReferenceGeneratorFragment extends AEReferenceGeneratorFragment {
	
	new(EClassGeneratorPart eClassGeneratorPart) {
		super(eClassGeneratorPart)
	}
	
	def void writeEContainments(EClassConfigPair pair) {
		val eClass = pair.element
		
		val containments = collectEContainments(eClass).combineConfigPairs(pair.config)
		val inheritedContainments = collectInheritedEContainments(pair).combineConfigPairs(pair.config)
		
		if (pair.config.hasRenderedEntries(containments, inheritedContainments)) {
			writeEContainmentHeader()

			writeEStructuralFeatures(containments, eClass, inheritedContainments)
		}
	}

	protected def Set<EReference> collectEContainments(EClass eClass) {
		eClass.EReferences
			.filter[isContainment]
			.toSet
	}

	protected def Set<EReference> collectInheritedEContainments(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			
			eClass.EAllReferences
				.filter[isContainment]
				.reject[eClass.EReferences.contains(it)]
				.reject[eReference | eClass.EOperations.exists[it.overridesFeature(eReference)]]
				.toSet
	 	} else {
	 		emptySet
	 	}
	}

	protected def void writeEContainmentHeader() {
		output.append(
		'''
			«newline»
			.Containments
			«tableHeader»
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}
}
