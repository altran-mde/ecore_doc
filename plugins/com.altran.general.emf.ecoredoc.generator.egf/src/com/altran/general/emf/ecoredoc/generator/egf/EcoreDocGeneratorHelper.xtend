package com.altran.general.emf.ecoredoc.generator.egf

import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration
import com.google.common.collect.Iterators
import java.util.Map
import org.eclipse.egf.model.domain.DomainFactory
import org.eclipse.egf.model.domain.DomainViewpoint
import org.eclipse.egf.model.fcore.Activity
import org.eclipse.egf.model.fcore.FactoryComponent
import org.eclipse.egf.model.fprod.ProductionPlan
import org.eclipse.egf.model.types.Type
import org.eclipse.egf.model.types.TypesFactory
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject

class EcoreDocGeneratorHelper {
	static extension val DomainFactory f_domain = DomainFactory.eINSTANCE
	static extension val TypesFactory f_types = TypesFactory.eINSTANCE
	
	private new() {
		// Empty for utility classes
	}
	
	def static void addEcoreDocInvocation(FactoryComponent factoryComponent, EcoreDocGeneration ecoreDocGeneration) {
		val resourceSet = factoryComponent.eResource.resourceSet
		val ProductionPlan pp = factoryComponent.getOrchestration() as ProductionPlan
		val Activity activity = resourceSet.getEObject(ecoreDocGeneratorURI, true) as Activity
		
		val dvp = factoryComponent.viewpointContainer.getViewpoint(DomainViewpoint) as DomainViewpoint
		val uri = URI.createPlatformResourceURI(ecoreDocGeneration.modelPath, false)
		
		var Map<String, Type> contract2type = newHashMap
		contract2type.put(EcoreDocGeneratorTask::IN_DOMAIN, createTypeDomain => [
			domain = ActivityInvocationHelper::getDomain(dvp, uri)
		])
		contract2type.put(EcoreDocGeneratorTask::IN_OUTPUT_FOLDER, createTypeString => [
			value = ecoreDocGeneration.outputFolder
		])
		contract2type.put(EcoreDocGeneratorTask::IN_PROJECT_NAME, createTypeString => [
			value = ecoreDocGeneration.projectName
		])
		contract2type.put(EcoreDocGeneratorTask::IN_RESOLVE, createTypeBoolean => [
			value = ecoreDocGeneration.resolve
		])
		
		ActivityInvocationHelper::addInvocation(pp, activity, contract2type)
	}
	
	def static collectInput(Iterable<EObject> content) {
		val eAllSubContents = content.iterator.flatMap[eAllContents]
		return Iterators.concat(content.iterator, eAllSubContents).filter(EClassifier).toSet
	}

	def static package URI getEcoreDocGenerationPatternURI() {
		return ecoreDocFCoreURI.appendFragment("_SV4bABvZEeyUtojcEsGn2w")
	}

	def static package URI getEcoreDocGeneratorURI() {
		return ecoreDocFCoreURI.appendFragment("_IHAmUBukEey30riYJtK3gQ")
	}

	def private static URI getEcoreDocFCoreURI() {
		return URI::createPlatformPluginURI(Activator.getPluginID(), false).appendSegment('egf').appendSegment('ecoredoc.fcore')
	}
}
