package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import java.util.Map
import java.util.HashMap
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtend.lib.macro.declaration.NamedElement
import org.eclipse.emf.ecore.ENamedElement

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

	// FIXME: parameter type is list - DONE
	protected def writeEClasses(List<EClass> eClasses) {
		if (!eClasses.isEmpty) {
			writeEClassesHeader()
			for (eClass : eClasses) {
				writeEClass(eClass)
			}
		}
	}

	// FIXME: Should read "Types" - DONE
	protected def writeEClassesHeader() {
		output.append('''=== Types

			''')
	}

	// FIXME: AttributesHeader must be omitted if there are no attributes - DONE (inside writeEAtributes)
	def writeEClass(EClass eClass) {
		
		output.append('''«writeEClassifierHeader(eClass)»''')
		output.append('''«getDocumentation(eClass)»''')
		writeSuperTypes(eClass)
		writeEAttributes(eClass)
		writeReferences(eClass)
	}

	// FIXME: Supertypes must be omitted if empty - DONE
	// FIXME: Why type check? Can never be false - DONE
	// FIXME: Supertypes must be sorted - DONE
	
	def writeSuperTypes(EClass eClass) {
		if(eClass.EAllSuperTypes.size>0){
			output.append(
			'''
			
			.Supertypes
			«FOR supertype : eClass.EAllSuperTypes.sortBy[it.name]»
			«var superTypeEPackageName = getEPackage(supertype).name
			»
			* <<«writeAnchorAndReference(supertype)»>>
			«ENDFOR»
			
			''')
		}else{
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

	// FIXME: This is the header of a table in AsciiDoc. Use appropriate method name. - DONE
	protected def writeTableHeader() {
		'''[cols="<15m,<15,<15m,<15m,<40a",options="header"]'''
	}
	// FIXME: Use getDocumentation() - DONE
	// FIXME: Why use attr.EAttributeType.name? Even twice?? - DONE
	def writeEAttributes(EClass eClass) {
		if(eClass.EAllAttributes.size>0){
			writeEAttributesHeader()
			val eClassName = eClass.name
			val ePackageName = getEPackage(eClass).name
			//Gather all inherited attributes and their classes.
			var Map<EAttribute, EClass> inheritedEAttributes = new HashMap<EAttribute, EClass>
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
	def inheritedAnchorAndReference(ENamedElement eNamedElement){
		'''(<<«writeAnchor(eNamedElement)», {inherited}«writeReferenceName(eNamedElement)»>>)'''
	}
	def writeBounds(int lowerBound, int upperBound){
		'''«lowerBound»«IF lowerBound != upperBound»..«upperBound»«ENDIF»'''
	}
	
	def writeReferences(EClass eClass) {
		if(eClass.EReferences.size>0){
			writeEReferencesHeader()
			//Gather all inherited attributes and their classes.
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
//	writeTable(){
//		
//	}
	def writeOpposite(EReference eReference){
		val eOppositeName = eReference.EOpposite.name
		'''<<«writeAnchor(eReference)»-«eOppositeName», «eOppositeName»>>'''
	}
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
