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

class EClassGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> ePackages) {
		super(ePackages)
	}

	override write(EPackage ePackage) {
		val eClasses = collectPackageEClasses(ePackage)

		writeEClasses(eClasses)

		return output
	}

	// FIXME: same name as similar methods
	protected def List<EClass> collectPackageEClasses(EPackage ePackages) {
		this.getEPackages.get(ePackages).filter(EClass).sortBy[it.name]
	}

	// FIXME: parameter type is list - DONE
	protected def writeEClasses(List<EClass> eClasses) {
		if (!eClasses.isEmpty) {
			writeEClassesHeader()

			for (eClass : eClasses) {
				writeEClassHeader(eClass)
				writeEClass(eClass)
			}
		}
	}

	// FIXME: Should read "Types"
	protected def writeEClassesHeader() {
		output.append('''=== Classes

			''')
	}

	protected def writeEClassHeader(EClass eClass) {
		val ePackage = getEPackage(eClass)
		output.append(
		'''
			[[«ePackage.name»-«eClass.name»]]
			==== «IF eClass.isAbstract && !eClass.isInterface»Abstract «ENDIF»«IF eClass.isInterface»Interface«ELSE»Class«ENDIF» «eClass.name»
			
		''')
	}

	// FIXME: AttributesHeader must be omitted if there are no attributes - DONE inside writeEAtributes
	def writeEClass(EClass eclass) {
		
		getDocumentation(eclass)
		writeSuperTypes(eclass)
		writeEAttributes(eclass)
		//writeReferences(eclass)
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
			* <<«getEPackage(supertype).name»-«supertype.name», «getEPackage(supertype).name».«supertype.name»>>
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
					output.append(
					'''
					|«eAttribute.name»[[«ePackageName»-«eClass.name»-«eAttribute.name»]]
					|<<«writeAnchorAndReference(ePackageName, eAttributeTypeName)»>>
					|«writeBounds(lowerBound, upperBound)»
					|
					|«getDocumentation(eAttribute)»
					
					''')
				}
			}
			//Iterate through inherited attributes.
			for(eAttribute : inheritedEAttributes.keySet.sortBy[it.name]){
				val packageNameOfInherited = getEPackage(inheritedEAttributes.get(eAttribute)).name
				val superclass = inheritedEAttributes.get(eAttribute)
				val eAttributeTypeName = eAttribute.EAttributeType.name
				val lowerBound = eAttribute.lowerBound
				val upperBound = eAttribute.upperBound
				output.append(
				'''
				|«eAttribute.name»[[«packageNameOfInherited»-«eClass.name»-«eAttribute.name»]] +
				(<<«packageNameOfInherited»-«superclass.name»-«eAttribute.name», {inherited}«packageNameOfInherited».«superclass.name»>>)
				|«eAttributeTypeName»
				|«writeBounds(lowerBound, upperBound)»
				|
				|«getDocumentation(eAttribute)»
				
				''')
			}
			
			writeFooter()
		}
	}
	def writeBounds(int lowerBound, int upperBound){
		'''«lowerBound»«IF lowerBound != upperBound»..«upperBound»«ENDIF»'''
	}
	def writeReferences(EClass eClass) {
		if(eClass.EReferences.size>0){
			writeEReferencesHeader()
			val ePackageName = getEPackage(eClass).name
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
					output.append(
					'''
					|«eReference.name»[[«ePackageName»-«eClass.name»-«eReference.name»]]
					|<<«writeAnchorAndReference(ePackageName, eReference.EReferenceType.name)»>>
					|«writeBounds(eReference.lowerBound, eReference.upperBound)»
					|
					|«getDocumentation(eReference)»
					
					''')
				}
			}
			//Iterate through inherited references.
			for(eReference : inheritedEReferences.keySet.sortBy[it.name]){
				val packageNameOfInherited = getEPackage(inheritedEReferences.get(eReference)).name
				val superclass = inheritedEReferences.get(eReference)
				val eReferenceTypeName = eReference.EReferenceType.name
				val lowerBound = eReference.lowerBound
				val upperBound = eReference.upperBound
		
				output.append(
				'''
				|«eReference.name»[[«packageNameOfInherited»-«eClass.name»-«eReference.name»]] +
				(<<«writeAnchorName(packageNameOfInherited, superclass.name, eReference.name)», {inherited}«writeReferenceName(packageNameOfInherited, superclass.name)»>>)
				|<<«writeAnchorAndReference(ePackageName, eReferenceTypeName)»>>
				|«writeBounds(lowerBound, upperBound)»
				|<<«writeAnchorName(ePackageName, eReferenceTypeName, eReference.EOpposite.name)», «eReference.EOpposite.name»>>
				|«getDocumentation(eReference)»
				
				''')
			}
			
			writeFooter()
		}
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
