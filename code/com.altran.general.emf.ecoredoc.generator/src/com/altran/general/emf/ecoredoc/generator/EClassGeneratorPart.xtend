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
import java.util.ArrayList

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

	// FIXME: Why is this method public? - DONE
	// FIXME: Don't mix calls of different granularity in one method - DONE
	// FIXME: The documentation is part of the header - DONE
	// FIXME: Why wrap the call to header and documentation into a richstring? - DONE
	def protected writeEClass(EClass eClass) {
		
		writeEClassHeader(eClass)
		writeSuperTypes(eClass)
		writeEAttributes(eClass)
		writeEReferences(eClass)
	}

	// FIXME: Why is this method public? - DONE
	def protected writeSuperTypes(EClass eClass) {
		// FIXME: use isEmpty, also in similar cases - DONE
		if(!eClass.EAllSuperTypes.isEmpty){
			output.append(
			'''
			
			.Supertypes
			«FOR supertype : eClass.EAllSuperTypes.sortBy[it.name]»
			* <<«writeEClassType(supertype)»>>
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
	
	// FIXME: Why is this method public? - DONE
	def protected writeEAttributes(EClass eClass) {
		if(!eClass.EAllAttributes.isEmpty){
			writeEAttributesHeader()
			
			//Gather all inherited attributes and their classes.
			
			//FIXME: Why is this a map? I don't see any usage of the values - DONE
			//FIXME: Why variable, not constant? Value never changes - DONE
			val List<EAttribute> inheritedEAttributes = new ArrayList<EAttribute>
			// FIXME: All this sorting is useless as long your're using a HashMap. Learn why, fix it! - DONE
			for(superclass : eClass.EAllSuperTypes){
				if(superclass instanceof EClass){
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
				// FIXME: This is almost the same code as above. Refactor and reuse - DONE
				writeEAttributeRow(eAttribute, eClass)
			}
			output.append('''«writeTableFooter()»''')	
		}
	}
	
	def protected writeEAttributeRow(EAttribute eAttribute, EClass eClass){
		println(eAttribute.name+" "+eClass.name+" "+(eAttribute.eContainer as EClass).name)
		val inherited = !(eClass == eAttribute.eContainer as EClass) 
		val lowerBound = eAttribute.lowerBound
		val upperBound = eAttribute.upperBound
		val eAttributeName = eAttribute.name
		output.append(
		'''
		|«eAttributeName»[[«writeEStructuralFeatureType(eAttribute, eClass).join("-")»]]«IF inherited» +«ENDIF»
		«IF inherited»«writeInheretedEStructuralElementType(eAttribute)»«ENDIF»
		|«writeEStructuralFeatureAnchor(eAttribute)»
		|«writeBounds(lowerBound, upperBound)»
		|
		|«getDocumentation(eAttribute)»
		
		''')
	}
	
	// FIXME: Why is this method public? - DONE
	def protected writeInheretedEStructuralElementType(ENamedElement eNamedElement){
		'''(<<«writeAnchor(eNamedElement)», {inherited}«writeReferenceName(eNamedElement.eContainer as EClass)»>>)'''
	}

	// FIXME: Why is this method public? - DONE
	def protected writeBounds(int lowerBound, int upperBound){
		'''«lowerBound»«IF lowerBound != upperBound»..«upperBound»«ENDIF»'''
	}
	
	// FIXME: Why is this method public? - DONE
	def protected writeEReferences(EClass eClass) {
		if(eClass.EReferences.size>0){
			writeEReferencesHeader()
			//Gather all inherited attributes and their classes.
			// FIXME: Same as for attributes - DONE
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
			output.append('''«writeTableFooter()»''')	
		}
	}
	
	// FIXME: Why is this method public? - DONE
	// FIXME: eClassName is not used --> Use or remove - DONE
	def protected writeEReferenceRow(EReference eReference, EClass eClass){
		val inherited = !(eClass == eReference.eContainer as EClass) 
		val lowerBound = eReference.lowerBound
		val upperBound = eReference.upperBound
		val eReferenceName = eReference.name
		
		output.append(
		'''
		|«eReferenceName»[[«writeEStructuralFeatureType(eReference, eClass).join("-")»]]«IF inherited» +«ENDIF»
		«IF inherited»«writeInheretedEStructuralElementType(eReference)»«ENDIF»
		|«writeEStructuralFeatureAnchor(eReference)»
		|«writeBounds(lowerBound, upperBound)»
		|«IF eReference.EOpposite !== null»«writeOpposite(eReference)»«ENDIF»
		|«getDocumentation(eReference)»
		
		''')
	}

	// FIXME: Why is this method public? - DONE
	def protected writeOpposite(EReference eReference){
		val eOppositeName = eReference.EOpposite.name
		// I'm pretty sure this will not produce the right outcome
		'''<<«writeAnchor(eReference.EReferenceType)»-«eOppositeName», «eOppositeName»>>'''
	}

	// FIXME: Why is this method public? - DONE
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
	// FIXME: Why is this method public? - DONE
	def protected CharSequence writeEClassHeader(EClass eClass) {
		
		val eClassName = eClass.name
		output.append(
		'''
		[[«writeAnchor(eClass)»]]
		==== «IF eClass.isAbstract && !eClass.isInterface»Abstract «ENDIF»«IF eClass.isInterface»Interface«ELSE»Class«ENDIF» «eClassName»
		
		«getDocumentation(eClass)»
		''')
	}
}
