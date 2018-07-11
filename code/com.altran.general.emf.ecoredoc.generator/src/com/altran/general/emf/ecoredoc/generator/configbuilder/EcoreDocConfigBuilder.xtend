package com.altran.general.emf.ecoredoc.generator.configbuilder

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigFactory
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigPackage
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension
import java.util.Collection
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * Builds a fully populated config hierarchy for all input {@link EPackage}s.
 */
class EcoreDocConfigBuilder {
	extension EcoreDocConfigFactory config = EcoreDocConfigFactory.eINSTANCE
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
		parseAnnotations(createEPackageConfig => [
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
		])
	}
	
	def createConfig(EDataType eDataType) {
		parseAnnotations(createEDataTypeConfig => [
			targetEDataType = eDataType
		])
	}
	
	def createConfig(EEnum eEnum) {
		parseAnnotations(createEEnumConfig => [
			targetEEnum = eEnum
			
			eEnum.ELiterals.forEach[eEnumLiteral |
				EEnumLiterals += eEnumLiteral.createConfig
			]
		])
	}
	
	def createConfig(EEnumLiteral eEnumLiteral) {
		parseAnnotations(createEEnumLiteralConfig => [
			targetEEnumLiteral = eEnumLiteral
		])
	}
	
	def createConfig(EClass eClass) {
		parseAnnotations(createEClassConfig => [
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
		])
	}
	
	def createConfig(EAttribute eAttribute) {
		parseAnnotations(createEAttributeConfig => [
			targetEAttribute = eAttribute
		])
	}
	
	def createContainmentConfig(EReference eContainment) {
		parseAnnotations(createEContainmentConfig => [
			targetEContainment = eContainment	
		])
	}
	
	def createReferenceConfig(EReference eReference) {
		parseAnnotations(createEReferenceConfig => [
			targetEReference = eReference
		])
	}
	
	def <T extends IENamedElementConfig> T parseAnnotations(T config) {
		config.target.EAnnotations
			.filter[source == EcoreDocConfigPackage.eINSTANCE.nsURI]
			.map[details]
			.flatten
			.forEach[
				val feature = config.eClass.getEStructuralFeature(key)
				if (feature instanceof EAttribute) {
					val convertedValue = EcoreUtil.createFromString(feature.EAttributeType, value)
					config.eSet(feature, convertedValue)
				} else {
					throw new IllegalArgumentException('''invalid EcoreDoc annotation "«key»" at «config.target»''')
				}
			]
			
		return config
	}
	
	def EcoreDocGeneratorConfig build() {
		result
	}
}
