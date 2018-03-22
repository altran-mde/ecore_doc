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
			println("eClasses.size "+eClasses.size)
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
			* <<«writeAnchorAndReference(superTypeEPackageName, supertype.name)»>>
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
			println("inheritedEAttributes.keySet.size "+inheritedEAttributes.keySet.size)
			//Iterate through non inherited attributes.
			for(eAttribute : eClass.EAllAttributes.sortBy[it.name]){
				if(!inheritedEAttributes.keySet.contains(eAttribute)){
					val eAttributeTypeName = eAttribute.EAttributeType.name
					val lowerBound = eAttribute.lowerBound
					val upperBound = eAttribute.upperBound
					val eAttributeName = eAttribute.name
					output.append(
					'''
					|«eAttributeName»[[«writeAnchor(ePackageName, eClassName, eAttributeName)»]]
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
				val superClassName = inheritedEAttributes.get(eAttribute).name
				val eAttributeTypeName = eAttribute.EAttributeType.name
				val lowerBound = eAttribute.lowerBound
				val upperBound = eAttribute.upperBound
				val eAttributeName = eAttribute.name
				output.append(
				'''
				|«eAttributeName»[[«writeAnchor(packageNameOfInherited, eClassName, eAttributeName)»]] +
				«inheritedAnchorAndReference(packageNameOfInherited, superClassName, eAttributeName)»
				|«eAttributeTypeName»
				|«writeBounds(lowerBound, upperBound)»
				|
				|«getDocumentation(eAttribute)»
				
				''')
			}
			output.append(
			'''
			«writeFooter()»
			''')	
		}
	}
	def inheritedAnchorAndReference(String packageName, String superClassName, String eAttributeName){
		'''(<<«writeAnchor(packageName, superClassName, eAttributeName)», {inherited}«writeReference(packageName, superClassName)»>>)'''
	}
	def writeBounds(int lowerBound, int upperBound){
		'''«lowerBound»«IF lowerBound != upperBound»..«upperBound»«ENDIF»'''
	}
	def writeReferences(EClass eClass) {
		if(eClass.EReferences.size>0){
			writeEReferencesHeader()
			val ePackageName = getEPackage(eClass).name
			val eClassName = eClass.name
			
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
					writeReferenceTable(eReference, false, inheritedEReferences, ePackageName, eClassName)
				}
			}
			//Iterate through inherited references.
			for(eReference : inheritedEReferences.keySet.sortBy[it.name]){
				writeReferenceTable(eReference, true, inheritedEReferences, ePackageName, eClassName)
			}
			output.append(
			'''
			«writeFooter()»
			''')	
		}
	}
	def writeReferenceTable(EReference eReference, boolean inherited, Map<EReference, EClass> inheritedEReferences, String ePackageName, String eClassName){
		val eReferenceTypeName = eReference.EReferenceType.name
		var ePackageNameOfInherited = ""
		var superEClassName = ""
		if(inherited){
			ePackageNameOfInherited = getEPackage(inheritedEReferences.get(eReference)).name
			superEClassName = inheritedEReferences.get(eReference).name
		}
		val lowerBound = eReference.lowerBound
		val upperBound = eReference.upperBound
		val eReferenceName = eReference.name
		
		output.append(
		'''
		|«eReferenceName»[[«IF inherited»«writeAnchor(ePackageNameOfInherited, eClassName, eReferenceName)»]] +«ELSE»«writeAnchor(ePackageName, eClassName, eReferenceName)»]]«ENDIF»
		«IF inherited»«inheritedAnchorAndReference(ePackageNameOfInherited, superEClassName, eReferenceName)»«ENDIF»
		|<<«writeAnchorAndReference(ePackageName, eReferenceTypeName)»>>
		|«writeBounds(lowerBound, upperBound)»
		|«IF eReference.EOpposite !== null»«writeOpposite(eReference, ePackageName, eReferenceTypeName, eReference.EOpposite.name)»«ENDIF»
		|«getDocumentation(eReference)»
		
		''')
	}
	def writeOpposite(EReference eReference, String ePackageName, String eReferenceTypeName, String oppositeName){
		'''<<«writeAnchor(ePackageName, eReferenceTypeName, oppositeName)», «oppositeName»>>'''
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
