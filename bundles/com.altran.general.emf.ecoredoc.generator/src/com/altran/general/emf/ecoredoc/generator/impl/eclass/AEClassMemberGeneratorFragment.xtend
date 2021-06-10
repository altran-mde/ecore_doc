package com.altran.general.emf.ecoredoc.generator.impl.eclass

import com.altran.general.emf.ecoredoc.generator.impl.^extension.AnchorExtension
import com.altran.general.emf.ecoredoc.generator.impl.^extension.EOperationEStructuralFeatureInteractionExtension
import com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension
import com.altran.general.emf.ecoredoc.generator.impl.^extension.InheritedEClassMemberSegmentsCollector
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.ENamedElement

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

abstract class AEClassMemberGeneratorFragment {
	protected static val PROPERTY_SEPARATOR = ''' +«newline»'''

	protected extension AnchorExtension = new AnchorExtension
	protected extension EcoreDocExtension = new EcoreDocExtension
	protected extension InheritedEClassMemberSegmentsCollector = new InheritedEClassMemberSegmentsCollector
	protected extension EOperationEStructuralFeatureInteractionExtension = new EOperationEStructuralFeatureInteractionExtension

	protected val EClassGeneratorPart eClassGeneratorPart
	
	new(EClassGeneratorPart eClassGeneratorPart) {
		this.eClassGeneratorPart = eClassGeneratorPart
	}

	protected def getOutput() {
		this.eClassGeneratorPart.getOutput()
	}
	
	protected def CharSequence concatLinkTo(ENamedElement eNamedElement) {
		this.eClassGeneratorPart.concatLinkTo(eNamedElement)
	}
	
	protected def CharSequence concatLinkTo(ENamedElement eNamedElement, String prefix) {
		this.eClassGeneratorPart.concatLinkTo(eNamedElement, prefix)
	}
	
	protected def collectAllSubTypes(EClass parent) {
		this.eClassGeneratorPart.collectAllSubTypes(parent)
	}
	
	protected def joinInheritance(Iterable<?> objects) {
		objects.join(newline, newline + newline, "", [toString])
	}
}
