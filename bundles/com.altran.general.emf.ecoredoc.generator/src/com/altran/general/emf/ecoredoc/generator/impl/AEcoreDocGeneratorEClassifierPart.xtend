package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.AEcoreDocConfigPair
import com.altran.general.emf.ecoredoc.generator.impl.diagram.PlantUMLEcoreDiagramGenerator
import com.google.common.collect.Multimap
import com.google.inject.Injector
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline
import static com.google.common.collect.Iterators.singletonIterator

abstract class AEcoreDocGeneratorEClassifierPart extends AEcoreDocGeneratorPart {

	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages, Injector xcoreInjector) {
		super(config, ePackages, xcoreInjector)
	}
	
	protected def void writeDiagram(AEcoreDocConfigPair<? extends EClassifier, ? extends IEClassifierConfig> pair) {
		if (!pair.config.shouldRenderDiagrams) {
			return
		}
		
		val eClassifier = pair.element
		val diagramGenerator = new PlantUMLEcoreDiagramGenerator(singletonIterator(eClassifier), true, false, config)
		
		output.append(
		'''
			«newline»
			.Class diagram of «eClassifier.name»
			[plantuml, «getConfig().diagramsOutputPath»/«eClassifier.EPackage.name»_«eClassifier.name», «config.diagramsOutputFormat»]
			----
		''')
		output.append(diagramGenerator.generateDiagram)
		output.append(
		'''
			----
			«newline»
		''')
	}
}