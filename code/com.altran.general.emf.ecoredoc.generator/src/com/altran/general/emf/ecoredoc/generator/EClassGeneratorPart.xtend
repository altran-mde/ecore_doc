package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.HashMap
import java.util.List
import java.util.Map
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

	// FIXME: Why is this method public?
	// FIXME: Don't mix calls of different granularity in one method
	// FIXME: The documentation is part of the header
	// FIXME: Why wrap the call to header and documentation into a richstring?
	def writeEClass(EClass eClass) {
		
		output.append('''«writeEClassifierHeader(eClass)»''')
		output.append('''«getDocumentation(eClass)»''')
		writeSuperTypes(eClass)
		writeEAttributes(eClass)
		writeReferences(eClass)
	}

	// FIXME: Why is this method public?
	def writeSuperTypes(EClass eClass) {
		// FIXME: use isEmpty, also in similar cases
		if(eClass.EAllSuperTypes.size>0){
			output.append(
			'''
			
			.Supertypes
			«FOR supertype : eClass.EAllSuperTypes.sortBy[it.name]»
			«
			//FIXME: There is a warning for a reason. Act on it. In all cases!
			var superTypeEPackageName = getEPackage(supertype).name
			»
			* <<«writeAnchorAndReference(supertype)»>>
			«ENDFOR»
			
			''')
		} else {
			output.append(
				'''
				
				''')
		}
	}

	protected def writeEAttributesHeader() {
		output.append(
		'''
		.Attributes
		«writeTableHeader»
		|===
		|Name
		|Type
		|Multiplicity{nbsp}/ Order
		|Default Value
		|Description
		
		''')
	}

	protected def writeTableHeader() {
		'''[cols="<15m,<15,<15m,<15m,<40a",options="header"]'''
	}
	
	// FIXME: Why is this method public?
	def writeEAttributes(EClass eClass) {
		if(eClass.EAllAttributes.size>0){
			writeEAttributesHeader()
			val eClassName = eClass.name
			val ePackageName = getEPackage(eClass).name
			//Gather all inherited attributes and their classes.
			
			//FIXME: Why is this a map? I don't see any usage of the values
			//FIXME: Why variable, not constant? Value never changes
			var Map<EAttribute, EClass> inheritedEAttributes = new HashMap<EAttribute, EClass>
			// FIXME: All this sorting is useless as long your're using a HashMap. Learn why, fix it!
			for(superclass : eClass.EAllSuperTypes){
				if(superclass instanceof EClass){
					for(eAttribute : superclass.EAllAttributes.sortBy[it.name]){
						inheritedEAttributes.put(eAttribute, superclass)
					}
				}	
			}
			
			//Iterate through non inherited attributes.
			for(eAttribute : eClass.EAllAttributes.sortBy[it.name]){
				if(!inheritedEAttributes.keySet.contains(eAttribute)){
					val eAttributeTypeName = eAttribute.EAttributeType.name
					val lowerBound = eAttribute.lowerBound
					val upperBound = eAttribute.upperBound
					val eAttributeName = eAttribute.name
					//writeReferenceTable(eAttributeName, false, inheritedEAttributes, )

					// FIXME: Why is there an empty cell?
					output.append(
					'''
					|«eAttributeName»[[«writeAnchor(eAttribute)»]]
					|<<«writeAnchorAndReference(eAttribute)»>>
					|«writeBounds(lowerBound, upperBound)»
					|
					|«getDocumentation(eAttribute)»
					
					''')
				}
			}
			
			//Iterate through inherited attributes.
			for(eAttribute : inheritedEAttributes.keySet.sortBy[it.name]){
				// FIXME: This is almost the same code as above. Refactor and reuse
				val eAttributeTypeName = eAttribute.EAttributeType.name
				val lowerBound = eAttribute.lowerBound
				val upperBound = eAttribute.upperBound
				val eAttributeName = eAttribute.name
				output.append(
				'''
				|«eAttributeName»[[«writeAnchor(eAttribute)»]] +
				«inheritedAnchorAndReference(eAttribute)»
				|«eAttributeTypeName»
				|«writeBounds(lowerBound, upperBound)»
				|
				|«getDocumentation(eAttribute)»
				
				''')
			}
			output.append('''«writeFooter()»''')	
		}
	}
	
	// FIXME: Why is this method public?
	def inheritedAnchorAndReference(ENamedElement eNamedElement){
		'''(<<«writeAnchor(eNamedElement)», {inherited}«writeReferenceName(eNamedElement)»>>)'''
	}

	// FIXME: Why is this method public?
	def writeBounds(int lowerBound, int upperBound){
		'''«lowerBound»«IF lowerBound != upperBound»..«upperBound»«ENDIF»'''
	}
	
	// FIXME: Why is this method public?
	def writeReferences(EClass eClass) {
		if(eClass.EReferences.size>0){
			writeEReferencesHeader()
			//Gather all inherited attributes and their classes.
			// FIXME: Same as for attributes
			var Map<EReference, EClass> inheritedEReferences = new HashMap<EReference, EClass>
			for(superclass : eClass.EAllSuperTypes){
				if(superclass instanceof EClass){
					for(eReference : superclass.EReferences.sortBy[it.name]){
						inheritedEReferences.put(eReference, superclass)
					}
				}	
			}
			
			//Iterate through non inherited references.
			for(eReference : eClass.EReferences.sortBy[it.name]){
				if(!inheritedEReferences.keySet.contains(eReference)){
					writeReferenceRow(eReference, false, eClass.name)
				}
			}
			
			//Iterate through inherited references.
			for(eReference : inheritedEReferences.keySet.sortBy[it.name]){
				writeReferenceRow(eReference, true, eClass.name)
			}
			output.append('''«writeFooter()»''')	
		}
	}
	
	// FIXME: Why is this method public?
	// FIXME: eClassName is not used --> Use or remove
	def writeReferenceRow(EReference eReference, boolean inherited, String eClassName){
		val lowerBound = eReference.lowerBound
		val upperBound = eReference.upperBound
		val eReferenceName = eReference.name
		
		output.append(
		'''
		|«eReferenceName»[[«IF inherited»«writeAnchor(eReference)»]] +«ELSE»«writeAnchor(eReference)»]]«ENDIF»
		«IF inherited»«inheritedAnchorAndReference(eReference)»«ENDIF»
		|<<«writeAnchorAndReference(eReference)»>>
		|«writeBounds(lowerBound, upperBound)»
		|«IF eReference.EOpposite !== null»«writeOpposite(eReference)»«ENDIF»
		|«getDocumentation(eReference)»
		
		''')
	}

	// FIXME: Why is this method public?
	def writeOpposite(EReference eReference){
		val eOppositeName = eReference.EOpposite.name
		// I'm pretty sure this will not produce the right outcome
		'''<<«writeAnchor(eReference)»-«eOppositeName», «eOppositeName»>>'''
	}

	// FIXME: Why is this method public?
	def writeEReferencesHeader() {
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
}
