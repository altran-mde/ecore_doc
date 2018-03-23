package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EStructuralFeature

abstract class AEcoreDocGeneratorPart {

	val Multimap<EPackage, EClassifier> ePackages

	val output = new StringBuilder()

	new(Multimap<EPackage, EClassifier> ePackages) {
		this.ePackages = ePackages
	}

	def abstract StringBuilder write(EPackage ePackage)

	protected def getEPackages() {
		this.ePackages
	}

	protected def getOutput() {
		this.output
	}

	protected def EPackage getEPackage(EClassifier eClassifier) {
		eClassifier.eContainer as EPackage
	}
	
	protected def CharSequence writeAnchor(ENamedElement eNamedElement){
		writeType(eNamedElement).join("-")
	}
	
	protected def CharSequence writeReferenceName(ENamedElement eNamedElement){
		writeType(eNamedElement).join(".")
	}
	
	protected def CharSequence writeEClassType(EClass eClass){
		'''«writeAnchor(eClass)», «writeReferenceName(eClass)»'''
	}
	protected def CharSequence writeEStructuralFeatureAnchor(EStructuralFeature eAttribute){
		var CharSequence result
		println("eAttributeType.name "+eAttribute.EType+" "+eAttribute.name )
		switch(eAttribute.EType.name) {
			case EcorePackage.eINSTANCE.EInt.name:
				result = '''EInt'''
			
			case EcorePackage.eINSTANCE.EString.name:
				result = '''EString'''
				
			case EcorePackage.eINSTANCE.EDouble.name:
				result = '''EDouble'''
				
			case EcorePackage.eINSTANCE.EChar.name:
				result = '''EChar'''
			
			case EcorePackage.eINSTANCE.EFloat.name:
				result = '''EFloat'''
				
			case EcorePackage.eINSTANCE.ELong.name:
				result = '''ELong'''
				
			case EcorePackage.eINSTANCE.EShort.name:
				result = '''EShort'''
				
			case EcorePackage.eINSTANCE.EBoolean.name:
				result = '''EBoolean'''
				
			case EcorePackage.eINSTANCE.EByte.name:
				result = '''EByte'''
				
			case EcorePackage.eINSTANCE.EDate.name:
				result = '''EDate'''
					
			default:
				result = '''<<«writeAnchor(eAttribute.EType)», «writeReferenceName(eAttribute.EType)»>>'''
		}
		result
	}
	
	protected def CharSequence writeEReferenceType(EReference eReference){
		'''«writeAnchor(eReference)», «writeReferenceName(eReference.eClass)»'''
	}
	protected def CharSequence writeWhereUsed(EStructuralFeature eStructuralFeature, EClass eClassThatInherits){
		'''«writeEStructuralFeatureType(eStructuralFeature, eClassThatInherits).join("-")», «writeEStructuralFeatureType(eStructuralFeature, eClassThatInherits).join(".")»'''
	}
	
	protected def String[] writeEStructuralFeatureType(EStructuralFeature eStructuralFeature, EClass eClassThatInherits){
		
		val ePackageName = getEPackage(eClassThatInherits).name
		val eClassName = eClassThatInherits.name
		val eStructuralFeatureName = eStructuralFeature.name
		
		#[ePackageName, eClassName, eStructuralFeatureName]
	}
	
	protected def dispatch String[] writeType(EClass eClass) {
		val eClassName = eClass.name
		val ePackageName = getEPackage(eClass).name
		
		#[ePackageName, eClassName]
		
	}
	
	protected def dispatch String[] writeType(EStructuralFeature eStructuralFeature){
		val eClass = eStructuralFeature.eContainer as EClass
		val ePackageName = getEPackage(eClass).name
		val eClassName = eClass.name
		val eStructuralFeatureName = eStructuralFeature.name
		
		#[ePackageName, eClassName, eStructuralFeatureName]
	}
	
//	protected def dispatch String[] writeType(EReference eReference){
//		val eClass = eReference.eContainer as EClass
//		val ePackageName = getEPackage(eClass).name
//		val eClassName = eClass.name
//		val eReferenceName = eReference.name
//		
//		#[ePackageName, eClassName, eReferenceName]
//	}
//	
//	protected def dispatch  String[] writeType(EAttribute eAttribute){
//		val eClass = eAttribute.eContainer as EClass
//		val ePackageName = getEPackage(eClass).name
//		val eClassName = eClass.name
//		val eAttributeName = eAttribute.name
//		
//		#[ePackageName, eClassName, eAttributeName]
//	}
	
	protected def dispatch String[] writeType(EEnumLiteral eEnumLiteral) {
		val eEnum = eEnumLiteral.eContainer as EEnum
		val ePackageName = getEPackage(eEnum).name
		
		#[ePackageName, eEnum.name, eEnumLiteral.name]
	}
	protected def writeDataTypes(EDataType eDataType){
		val ePackageName = (eDataType.eContainer as EPackage).name
		val eDataTypeName = eDataType.name
		
		#[ePackageName, eDataTypeName].join("-")
	}
	protected def dispatch String[] writeType(EDataType eDataType) {
		var String[] result
		switch(eDataType) {
			case EcorePackage.eINSTANCE.EInt:
				result = #["EInt"]
			
			case EcorePackage.eINSTANCE.EString:
				result = #["EString"]
				
			case EcorePackage.eINSTANCE.EDouble:
				result = #["EDouble"]
				
			case EcorePackage.eINSTANCE.EChar:
				result = #["EChar"]
			
			case EcorePackage.eINSTANCE.EFloat:
				result = #["EFloat"]
				
			case EcorePackage.eINSTANCE.ELong:
				result = #["ELong"]
				
			case EcorePackage.eINSTANCE.EShort:
				result = #["EShort"]
				
			case EcorePackage.eINSTANCE.EBoolean:
				result = #["EBoolean"]
				
			case EcorePackage.eINSTANCE.EByte:
				result = #["EByte"]
				
			case EcorePackage.eINSTANCE.EDate:
				result = #["EDate"]
					
			default:
				result = #[(eDataType.eContainer as EPackage).name, eDataType.name]
		}
		result
	}
	
	protected def void writeUseCases(EClassifier target) {
		var anyMatch = false

		val eClasses = collectAllEClasses.reject[it == target]

		val useCaseStrings = newArrayList()
		for (eClass : eClasses) {
			for (feature : eClass.EAllStructuralFeatures.sortBy[it.name]) {
				if (feature.EType == target) {
					anyMatch = true
					useCaseStrings.add(
					'''
					* <<«writeWhereUsed(feature, eClass)»>>
					''')
				}

			}
		}

		if (anyMatch) {
			output.append('''
				.Used at
			''')
			for (useCaseString : useCaseStrings.sort) {
				output.append(useCaseString)
			}
			output.append(newline)
		}
	}
	
	// FIXME: Why is this method public? - DONE
	// FIXME: What kind of footer? For Images? Screen stands? Shoe shops? - DONE
	def protected CharSequence writeTableFooter() {
		'''
		|===
		
		'''
	}
	
	// FIXME: Why is this method public? - DONE
	def protected CharSequence getDocumentation(EModelElement modelElement) {
		'''
		«EcoreUtil.getDocumentation(modelElement)
		»
		'''
	}

	protected def String newline() {
		System.getProperty("line.separator")
	}

	protected def Collection<EClass> collectAllEClasses() {
		ePackages.values.filter(EClass).toSet
	}
}
