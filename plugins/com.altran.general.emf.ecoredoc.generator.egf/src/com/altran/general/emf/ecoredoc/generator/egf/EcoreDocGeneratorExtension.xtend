package com.altran.general.emf.ecoredoc.generator.egf

import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionFactory
import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage
import java.util.Collections
import java.util.List
import java.util.Map
import org.eclipse.egf.core.domain.TargetPlatformResourceSet
import org.eclipse.egf.model.pattern.Pattern
import org.eclipse.egf.model.pattern.PatternFactory
import org.eclipse.egf.model.pattern.Substitution
import org.eclipse.egf.portfolio.genchain.^extension.ExtensionHelper
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement

import static com.altran.general.emf.ecoredoc.generator.egf.EcoreDocGeneratorHelper.getEcoreDocGenerationPatternURI

class EcoreDocGeneratorExtension extends ExtensionHelper {
	static extension val PatternFactory f_pattern = PatternFactory.eINSTANCE
	static extension val EcoredocExtensionFactory f_ecoredoc_ext = EcoredocExtensionFactory.eINSTANCE
	static extension val EcoredocExtensionPackage p_ecoredoc_ext = EcoredocExtensionPackage.eINSTANCE
	
	override String getLabel() {
		return "Emf EcoreDoc"
	}

	override protected void computeDefaultProperties(Map<String, String> context) {
		val project = context.get(CONTEXT_PROJECT_NAME)
		properties.put(ecoreDocGeneration_ProjectName, '''«project».doc''')
		properties.put(ecoreDocGeneration_OutputFolder, 'output')
		properties.put(ecoreDocGeneration_Resolve, 'false')
	}

	override EcoreElement createEcoreElement(Map<String, String> context) {
		return createEcoreDocGeneration => [
			modelPath = context.get(MODEL_PATH)
			outputFolder = context.get(ecoreDocGeneration_OutputFolder.name)
			projectName = context.get(ecoreDocGeneration_ProjectName.name)
			resolve = Boolean.parseBoolean(context.get(ecoreDocGeneration_Resolve.name))
		]
	}

	override List<Substitution> getSubstitutions() {
		val resourceSet = new TargetPlatformResourceSet()
		val substitution = createSubstitution => [
			replacement += resourceSet.getEObject(ecoreDocGenerationPatternURI, true) as Pattern
		]
		return Collections::singletonList(substitution)
	}
}
