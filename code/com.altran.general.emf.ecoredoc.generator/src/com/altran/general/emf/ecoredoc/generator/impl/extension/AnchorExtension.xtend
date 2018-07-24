package com.altran.general.emf.ecoredoc.generator.impl.^extension

import java.util.Collection
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EClass

class AnchorExtension {
	public static val ANCHOR_SEPARATOR = '-'
	public static val REFERENCE_SEPARATOR = '.{zwsp}'
	
	extension EcoreDocExtension = new EcoreDocExtension
	extension TypeSegmentsCollector = new TypeSegmentsCollector
	extension InheritedEClassMemberSegmentsCollector = new InheritedEClassMemberSegmentsCollector
	
	def CharSequence joinAnchor(Collection<? extends CharSequence> segments) {
		segments
			.map[toString]
			.filter[!isNullOrEmpty]
			.map[it.replaceAll("[^a-zA-Z0-9_-]", ":")]
			.join(ANCHOR_SEPARATOR)
	}
	
	def CharSequence joinReference(Collection<? extends CharSequence> segments) {
		segments
			.map[toString]
			.filter[!isNullOrEmpty]
			.join(REFERENCE_SEPARATOR)
	}

	def dispatch CharSequence concatAnchor(ENamedElement eNamedElement) {
		collectTypeSegments(eNamedElement).joinAnchor
	}

	// Special handling for default EDataTypes: Don't create anchor
	def dispatch CharSequence concatAnchor(EDataType eDataType) {
		if (!isDefaultEDataType(eDataType)) {
			collectTypeSegments(eDataType).joinAnchor

		} else {
			""
		}
	}

	def dispatch CharSequence concatAnchor(EOperation eOperation) {
		collectInheritedEClassMemberSegments(eOperation, eOperation.eContainer as EClass).joinAnchor
	}

	def dispatch CharSequence concatReferenceName(ENamedElement eNamedElement) {
		collectTypeSegments(eNamedElement).joinReference
	}

	def dispatch CharSequence concatReferenceName(EOperation eOperation) {
		collectTypeSegments(eOperation).joinReference + "(" + eOperation.EParameters.map[name].join(", ") + ")"
	}

}
