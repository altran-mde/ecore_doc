package com.altran.general.emf.ecoredoc.generator.impl

import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.util.EcoreUtil

class EcoreDocExtension {
	def String newline() {
		System.getProperty("line.separator")
	}
	
	def CharSequence getDocumentation(EModelElement modelElement) {
		val documentation = EcoreUtil.getDocumentation(modelElement)
		if (documentation !== null) {
			return documentation + newline 
		} else {
			return ""
		}
	}
}