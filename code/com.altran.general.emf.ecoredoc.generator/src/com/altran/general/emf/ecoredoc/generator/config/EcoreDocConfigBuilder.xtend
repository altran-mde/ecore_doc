package com.altran.general.emf.ecoredoc.generator.config

import com.altran.general.emf.ecoredoc.generator.config.ConfigFactory
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension
import java.util.Collection
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference

/**
 * Builds a fully populated config hierarchy for all input {@link EPackage}s.
 */
class EcoreDocConfigBuilder {
	extension ConfigFactory config = ConfigFactory.eINSTANCE
	extension EcoreDocExtension = new EcoreDocExtension
	
	val result = createEcoreDocGeneratorConfig
	
	new() {
		
	}
	
	new(Collection<EPackage> ePackages) {
		ePackages.forEach[add]
	}
	
	def add(EPackage ePackage) {
		result.EPackages += ePackage.createConfig
	}
	
	def createConfig(EPackage ePackage) {
		createEPackageConfig => [
			targetEPackage = ePackage
			
			ePackage.EClassifiers.collectEDataTypes.forEach[eDataType |
				EDataTypes += eDataType.createConfig
			]
			
			ePackage.EClassifiers.collectEEnums.forEach[eEnum |
				EEnums += eEnum.createConfig
			]
			
			ePackage.EClassifiers.collectEClasses.forEach[eClass |
				EClasses += eClass.createConfig
			]
		]
	}
	
	def createConfig(EDataType eDataType) {
		createEDataTypeConfig => [
			targetEDataType = eDataType
		]
	}
	
	def createConfig(EEnum eEnum) {
		createEEnumConfig => [
			targetEEnum = eEnum
			
			eEnum.ELiterals.forEach[eEnumLiteral |
				EEnumLiterals += eEnumLiteral.createConfig
			]
		]
	}
	
	def createConfig(EEnumLiteral eEnumLiteral) {
		createEEnumLiteralConfig => [
			targetEEnumLiteral = eEnumLiteral
		]
	}
	
	def createConfig(EClass eClass) {
		createEClassConfig => [
			targetEClass = eClass
			
			eClass.EAllAttributes.forEach[eAttribute |
				EAttributes += eAttribute.createConfig
			]
			
			eClass.EAllContainments.forEach[eContainment |
				EContainments += eContainment.createContainmentConfig
			]
			
			eClass.EAllReferences.filter[!isContainment].forEach[eReference |
				EReferences += eReference.createReferenceConfig
			]
		]
	}
	
	def createConfig(EAttribute eAttribute) {
		createEAttributeConfig => [
			targetEAttribute = eAttribute
		]
	}
	
	def createContainmentConfig(EReference eContainment) {
		createEContainmentConfig => [
			targetEContainment = eContainment	
		]
	}
	
	def createReferenceConfig(EReference eReference) {
		createEReferenceConfig => [
			targetEReference = eReference
		]
	}
	
	def EcoreDocGeneratorConfig build() {
		result
	}	
}