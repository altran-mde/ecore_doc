package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference

class EClassGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> ePackages) {
		super(ePackages)
	}

	override write(EPackage ePackage) {
		val eClasses = collectEPackageEClasses(ePackage)

		writeEClasses(eClasses)

		return output
	}

	// FIXME: same name as similar methods
	protected def List<EClass> collectEPackageEClasses(EPackage ePackages) {
		this.getEPackages.get(ePackages).filter(EClass).sortBy[it.name]
	}

	protected def writeEClasses(List<EClass> eClasses) {
		if (!eClasses.isEmpty) {
			writeEClassesHeader()
			
			for (eClass : eClasses) {
				writeEClass(eClass)
			}
		}
	}

	protected def writeEClassesHeader() {
		output.append('''=== Types

			''')
	}

	def protected writeEClass(EClass eClass) {
		writeEClassHeader(eClass)
		writeSuperTypes(eClass)
		writeEAttributes(eClass)
		writeEReferences(eClass)
	}

	def protected writeSuperTypes(EClass eClass) {
		if(!eClass.EAllSuperTypes.isEmpty){
			output.append(
			'''
			
			.Supertypes
			«FOR supertype : eClass.EAllSuperTypes.sortBy[it.name]»
				* «concatLinkTo(supertype)»
			«ENDFOR»
			
			''')
		} else {
			output.append(newline)
		}
	}

	protected def writeEAttributesHeader() {
		output.append(
		'''
		.Attributes
		«tableHeader»
		|===
		|Name
		|Type
		|Multiplicity{nbsp}/ Order
		|Default Value
		|Description
		
		''')
	}

	protected def tableHeader() {
		'''[cols="<15m,<15,<15m,<15m,<40a",options="header"]'''
	}
	
	protected def writeEAttributes(EClass eClass) {
		if(!eClass.EAllAttributes.isEmpty){
			writeEAttributesHeader()
			
			//Gather all inherited attributes and their classes.
			
			val List<EAttribute> inheritedEAttributes = new ArrayList<EAttribute>
			for(superclass : eClass.EAllSuperTypes){
				// FIXME: superclass can never be of any other type
				if(superclass instanceof EClass){
					// FIXME: Why bother sorting? We're not relying on the order of inheritedEAttributes
					// FIXME: In deep inheritance hierarchies, this leads to lots of duplicated entries in inheritedEAttributes. Explain why, fix it.
					for(eAttribute : superclass.EAllAttributes.sortBy[it.name]){
						inheritedEAttributes.add(eAttribute)
					}
				}	
			}
			
			//Iterate through non inherited attributes.
			for(eAttribute : eClass.EAllAttributes.sortBy[it.name]){
				if(!inheritedEAttributes.contains(eAttribute)){
				
					writeEAttributeRow(eAttribute, eClass)
				}
			}
			
			//Iterate through inherited attributes.
			for(eAttribute : inheritedEAttributes.sortBy[it.name]){
				writeEAttributeRow(eAttribute, eClass)
			}
			// FIXME: Yet another useless richstring. Find all of them, fix!
			output.append('''«tableFooter()»''')	
		}
	}
	
	def protected writeEAttributeRow(EAttribute eAttribute, EClass eClass){
		//FIXME: Use debugger, not println
		println(eAttribute.name+" "+eClass.name+" "+(eAttribute.eContainer as EClass).name)
		//FIXME: rewrite as an understandable expression, also at other places
		val inherited = !(eClass == eAttribute.eContainer as EClass) 
		val lowerBound = eAttribute.lowerBound
		val upperBound = eAttribute.upperBound
		val eAttributeName = eAttribute.name
		output.append(
		'''
		|«eAttributeName»[[«collectInheritedFeatureSegments(eAttribute, eClass).join("-")»]]«IF inherited» +«ENDIF»
		«IF inherited»«concatInheritedEStructuralElementType(eAttribute)»«ENDIF»
		|«concatLinkTo(eAttribute.EType)»
		|«concatBounds(lowerBound, upperBound)»
		|
		|«getDocumentation(eAttribute)»
		
		''')
	}
	
	def protected concatInheritedEStructuralElementType(ENamedElement eNamedElement){
		'''(<<«concatAnchor(eNamedElement)», {inherited}«concatReferenceName(eNamedElement.eContainer as EClass)»>>)'''
	}

	def protected concatBounds(int lowerBound, int upperBound){
		'''«lowerBound»«IF lowerBound != upperBound»..«upperBound»«ENDIF»'''
	}
	
	def protected writeEReferences(EClass eClass) {
		// FIXME: What's wrong here? You fixed it at other places
		if(eClass.EReferences.size>0){
			writeEReferencesHeader()
			//Gather all inherited attributes and their classes.
			// FIXME: Same issues as for attributes
			val List<EReference> inheritedEReferences = new ArrayList<EReference>
			for(superclass : eClass.EAllSuperTypes){
				if(superclass instanceof EClass){
					for(eReference : superclass.EReferences.sortBy[it.name]){
						inheritedEReferences.add(eReference)
					}
				}	
			}
			
			//Iterate through non inherited references.
			for(eReference : eClass.EReferences.sortBy[it.name]){
				if(!inheritedEReferences.contains(eReference)){
					writeEReferenceRow(eReference, eClass)
				}
			}
			
			//Iterate through inherited references.
			for(eReference : inheritedEReferences.sortBy[it.name]){
				writeEReferenceRow(eReference, eClass)
			}
			// FIXME: !!!!!
			output.append('''«tableFooter()»''')	
		}
	}
	
	def protected writeEReferenceRow(EReference eReference, EClass eClass){
		val inherited = !(eClass == eReference.eContainer as EClass) 
		val lowerBound = eReference.lowerBound
		val upperBound = eReference.upperBound
		val eReferenceName = eReference.name
		
		output.append(
		'''
		|«eReferenceName»[[«collectInheritedFeatureSegments(eReference, eClass).join("-")»]]«IF inherited» +«ENDIF»
		«IF inherited»«concatInheritedEStructuralElementType(eReference)»«ENDIF»
		|«concatLinkTo(eReference.EType)»
		|«concatBounds(lowerBound, upperBound)»
		|«IF eReference.EOpposite !== null»«concatOpposite(eReference)»«ENDIF»
		|«getDocumentation(eReference)»
		
		''')
	}

	def protected concatOpposite(EReference eReference){
		val eOppositeName = eReference.EOpposite.name
		// I'm pretty sure this will not produce the right outcome
		'''<<«concatAnchor(eReference.EReferenceType)»-«eOppositeName», «eOppositeName»>>'''
	}

	def protected writeEReferencesHeader() {
		output.append(
		'''
		.References
		[cols="<15m,<15,<15m,<15m,<40a",options="header"]
		|===
		|Name
		|Type
		|Multiplicity{nbsp}/ Order
		|Opposite
		|Description
		
		'''
		)
	}
	def protected CharSequence writeEClassHeader(EClass eClass) {
		
		val eClassName = eClass.name
		output.append(
		'''
		[[«concatAnchor(eClass)»]]
		==== «IF eClass.isAbstract && !eClass.isInterface»Abstract «ENDIF»«IF eClass.isInterface»Interface«ELSE»Class«ENDIF» «eClassName»
		
		«getDocumentation(eClass)»
		''')
	}
}
