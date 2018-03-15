package com.altran.general.emf.ecoredoc.generator

import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EEnum

class EcoreDocGenerator {

	val Collection<? extends EClassifier> input
	
	val output = new StringBuilder

	new(Collection<? extends EClassifier> input) {
		this.input = input
	}

	def CharSequence generate() {
		
		for(classifier : input) {
			render(classifier)
		}
		
		return output.toString
	}
	
	def dispatch void render(EClass clazz) {
		
	}
	
	def dispatch void render(EEnum eenum) {
		
	}
	
//	def dispatch void render(PrimitiveT clazz) {
//		
//	}
	
}
