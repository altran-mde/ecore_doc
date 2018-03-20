package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import com.google.common.collect.TreeMultimap
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EEnumLiteral
import java.util.SortedSet
import java.util.Collections
import com.google.common.collect.Sets
import com.google.common.collect.LinkedHashMultiset
import com.google.common.collect.LinkedHashMultimap
import java.util.List

class EcoreDocGenerator {

	val Collection<? extends EClassifier> input
	
	val output = new StringBuilder
	var Multimap<EPackage, EClassifier> packages = TreeMultimap.create(
		[o1, o2 | o1.name.compareTo(o2.name)], 
		[o1, o2 | o1.name.compareTo(o2.name)]
	);

	new(Collection<? extends EClassifier> input) {
		this.input = input
	}

	def CharSequence generate() {
		writeIntro()
		collectPackages()
		for(pack : packages.keySet){
			
			writePackageIntro(pack.name)
			
			val dataTypes = collectDataTypes(pack)
			val eclasses = collectPackageEClasses(pack)
			val eenums = collectEEnums(pack)
			
			writeDataTypes(dataTypes)
			writeEnumerations(eenums)
			writeClasses(eclasses)
			for (ec : eclasses) {
				output.append(
					'''
					EClass «ec.name»
					
					«writeDescription(ec)»
					'''
				)
			}	
			
		}
		
		return output.toString
	}
	
	def writeClasses(Collection<EClass> classes) {
		if(!classes.isEmpty){
			writeClassesHeader()
			val pack = getPackage(classes.get(0))
			for(eclass : classes){
				writeEClassHeader(eclass)
				writeEClass(eclass)
//				writeEnumLiterals(eenum, pack)
//				writeUseCases(eenum)
			}
		}
	}
	
	def writeAttributes(EClass eclass) {
		val packageName = getPackage(eclass).name
		for(attr : eclass.EAllAttributes){
			output.append(
			'''
			|«attr.name»[[«packageName»-«eclass.name»-«attr.name»]]
			|<<«packageName»-«attr.EAttributeType.name», «packageName».«attr.EAttributeType.name»>>
			|
			|
			|«EcoreUtil.getDocumentation(attr)»
			''')
		}
	}
	
	def writeAttributesHeader(EClass eclass) {
		'''
		.Attributes
		«writeCols»
		|===
		|Name
		|Type
		|Multiplicity{nbsp}/ Order
		|Default Value
		|Description
		
		'''
	}
	
	def writeCols() {
		'''[cols="<15m,<15,<15m,<15m,<40a",options="header"]'''
	}
	
	def writeEClass(EClass eclass) {
		output.append(
		'''
		«writeDescription(eclass)»
		
		«writeSuperTypes(eclass)»
		«writeAttributesHeader(eclass)»

		''')	
		writeAttributes(eclass)
	}
	
	def writeSuperTypes(EClass eclass) {
		'''
		.Supertypes
		«FOR supertype : eclass.EAllSuperTypes»
		* <<«IF supertype instanceof EClass»«getPackage(supertype).name»-«supertype.name», «getPackage(supertype).name».«supertype.name»«ENDIF»>>
		«ENDFOR»
		
		'''
	}
	
	def writeClassesHeader() {
		output.append('''=== Classes

			''')
	}
	
	def writeIntro() {
		output.append('''
		// White Up-Pointing Triangle
		:wupt: &#9651;
		
		:inherited: {wupt}{nbsp}
		
		:table-caption!:
		
		= Ecore Documentation
		:toc:
		:toclevels: 4
		
		''')
	}
	
	def writePackageIntro(String packageName) {
		output.append('''
			 [[«packageName»]]
			 == Contents of «packageName»
			 
			''')
	}
	
	def void writeEnumerations(Collection<EEnum> eenums){
		if(!eenums.isEmpty){
			writeEnumerationsHeader()
			val pack = getPackage(eenums.get(0))
			for(eenum : eenums){
				writeEnumHeader(eenum)
				writeEnumLiterals(eenum, pack)
				writeUseCases(eenum)
			}
		}
	}
	
	def writeEnumHeader(EEnum eenum) {
		
		writeEClassifierHeader(eenum)
		output.append(
		'''
		«writeDescription(eenum)
		»
		
		.Literals
		[cols="<20m,>10m,<70a",options="header"]
		|===
		|Symbol
		|Value
		|Description
		
		''')
	}
	
	def writeDescription(EClassifier eclassifier) {
        EcoreUtil.getDocumentation(eclassifier)  
	}
	
	def writeEClassifierHeader(EClassifier eclassifier) {
		val pack = getPackage(eclassifier)
		output.append(
		'''
		[[«pack.name»-«eclassifier.name»]]
		==== «eclassifier.name»
		
		''')
	}
	
	def writeEClassHeader(EClass eclass) {
		val pack = getPackage(eclass)
		output.append(
		'''
		[[«pack.name»-«eclass.name»]]
		==== «IF eclass.isAbstract && !eclass.isInterface»Abstract «ENDIF
		»«IF eclass.isInterface»Interface«ELSE»Class«ENDIF
		» «eclass.name»
		
		''')
	}
	
	def writeEnumerationsHeader() {
		output.append('''=== Enumerations

			''')
	}
	
	def writeEnumLiterals(EEnum eenum, EPackage pack) {
		for(literal :  eenum.ELiterals){
			writeLiteral(literal)
		}
		writeBlockClosure()
	}
	
	def writeBlockClosure() {
		output.append('''|===

		''')
	}
	
	def writeLiteral(EEnumLiteral literal) {
		val eenum = literal.eContainer as EEnum
		val pack = eenum.eContainer as EPackage
		output.append(
			'''
			|«literal.name»[[«pack.name»-«eenum.name»-«literal.name»]]
			|«literal.value»
			|«EcoreUtil.getDocumentation(literal)
			»
			
			''')
	}
	def EPackage getPackage(EClassifier eclassifier){
		eclassifier.eContainer as EPackage
	}
	/*
	 * Displays the dataTypes of the EPackage and where they are used in.
	 */
	def void writeDataTypes(Collection<EDataType> dataTypes){
		
		if (!dataTypes.isEmpty) {
			writeDataTypesHeader()
			val pack = getPackage(dataTypes.get(0))
			for (dataType : dataTypes) {
				writeDataType(pack.name, dataType.name)
				writeUseCases(dataType)
			}
		}
	}
	
	def writeDataType(String packageName, String dataTypeName) {
		output.append('''
				[[«packageName»-«dataTypeName»]]
				==== «dataTypeName»
				
				''')
	}
	
	def writeDataTypesHeader() {
		output.append('''
			 === Data Types
			 
			 TODO: Create template for EDataType
			 
			''')
	}
	
	/*
	 * Displays in which classes the given dataType is used. 
	 * Goes through every class and then every attribute and it compare the dataType.name with the attribute type name.
	 */
	def void writeUseCases(EClassifier target){
		var anyMatch = false

		val eclasses = collectAllEClasses.reject[it == target]
		
		val useCaseStrings = newArrayList()
		for(eclass : eclasses){
			for(feature : eclass.EAllStructuralFeatures){
				if(feature.EType == target){
					anyMatch = true
					val packageName = (eclass.eContainer as EPackage).name
					useCaseStrings.add(
					'''
					* <<«packageName»-«eclass.name»-«feature.name», «packageName».«eclass.name».«feature.name»>>
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
	
	def String newline() {
		System.getProperty("line.separator")
	}
	
	def void collectPackages() {
		for(eclassifier : input){
			packages.put(eclassifier.eContainer as EPackage, eclassifier)
		}
	}
	
	def Collection<EEnum> collectEEnums(EPackage pack) {
		this.packages.get(pack)
			.filter(EEnum)
			.toSet
	}
	def Collection<EClass> collectAllEClasses() {
		packages.values.filter(EClass).toSet
	}
	
	def List<EClass> collectPackageEClasses(EPackage pack) {
		this.packages.get(pack)
			.filter(EClass)
			.sortBy[it.name]
	}
	
	def Collection<EDataType> collectDataTypes(EPackage pack) {
		this.packages.get(pack)
			.filter(EDataType)
			.filter[!(it instanceof EEnum)]
			.toSet
	}
	
	def dispatch CharSequence writeEClassifierType(EClass clazz) {
		'''Class'''
	}
	
	def dispatch CharSequence writeEClassifierType(EEnum eenum) {
		'''Enum'''
	}
	
	def dispatch CharSequence writeEClassifierType(EDataType dataType) {
		
	}
	
	
//	def dispatch void render(PrimitiveT clazz) {
//		
//	}
	
}
