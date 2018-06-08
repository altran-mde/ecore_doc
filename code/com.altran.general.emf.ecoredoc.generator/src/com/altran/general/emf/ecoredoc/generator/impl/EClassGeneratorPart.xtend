package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.ecoredoc.generator.config.EAttributeConfig
import com.altran.general.ecoredoc.generator.config.EClassConfig
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.ecoredoc.generator.config.IENamedElementConfig
import com.google.common.collect.Multimap
import java.util.AbstractMap.SimpleEntry
import java.util.List
import java.util.Map
import java.util.Map.Entry
import java.util.Set
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature

import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline

class EClassGeneratorPart extends AEcoreDocGeneratorPart {
	extension EStructuralFeaturePropertyHelper structuralFeaturePropertyHelper
	
	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages) {
		super(config, ePackages)
		
		this.structuralFeaturePropertyHelper = new EStructuralFeaturePropertyHelper(config)
	}

	override StringBuilder write(EPackage ePackage) {
		clearOutput()

		val List<EClass> eClasses = getEPackages().get(ePackage).collectEClasses()

		val eClassMap = eClasses
			.toInvertedMap[getConfig().findConfig(it) as EClassConfig]
			.filter[eClass, config|
				config.shouldRender
			]
		
		writeEClasses(eClassMap)

		return output
	}

	protected def void writeEClasses(Map<EClass, EClassConfig> eClassMap) {
		if (!eClassMap.isEmpty) {
			writeEClassesHeader()

			for (entry : eClassMap.entrySet) {
				writeEClass(entry)
			}
		}
	}

	protected def void writeEClassesHeader() {
		output.append(
		'''
			«newline»
			=== Types
		''')
	}

	protected def void writeEClass(Entry<EClass, EClassConfig> entry) {
		writeEClassHeader(entry)
		
		writeProperties(entry)

		writeSuperTypes(entry)

		writeSubTypes(entry)

		writeEAttributes(entry)

		writeEContainments(entry)

		writeECrossReferences(entry)

		writeUseCases(entry)
	}

	protected def void writeEContainments(Entry<EClass, EClassConfig> entry) {
		val eClass = entry.key
		
		val boolean containmentExists = eClass.EAllReferences.exists[isContainment]

		if (containmentExists) {
			writeEContainmentHeader()

			var List<EReference> eContainments = collectEContainments(eClass)
			var Set<? extends EStructuralFeature> inheritedEContainments = collectInheritedEContainments(entry)

			writeEStructuralFeatures(eContainments, eClass, inheritedEContainments)
		}
	}

	protected def void writeECrossReferences(Entry<EClass, EClassConfig> entry) {
		val eClass = entry.key
		
		val boolean eCrossReferenceExists = eClass.EAllReferences.exists[!isContainment]

		if (eCrossReferenceExists) {
			writeEReferencesHeader()

			var List<EReference> crossReferences = collectECrossReferences(eClass)
			var Set<? extends EStructuralFeature> inheritedECrossReferences = collectInheritedECrossReferences(entry)

			writeEStructuralFeatures(crossReferences, eClass, inheritedECrossReferences)
		}
	}

	protected def void writeEAttributes(Entry<EClass, EClassConfig> entry) {
		val eClass = entry.key
		
		val eAttributesMap = eClass.EAllAttributes
			.toInvertedMap[getConfig().findConfig(it) as EAttributeConfig]
			.filter[eAttribute, config|
				config.shouldRender
			]

		if (!eAttributesMap.isEmpty) {
			writeEAttributesHeader()

			var Set<EStructuralFeature> inheritedEAttributes = collectInheritedEAttributes(entry)

			writeEStructuralFeatures(eClass.EAttributes, eClass, inheritedEAttributes)
		}
	}

	protected def void writeEContainmentHeader() {
		output.append(
		'''
			«newline»
			.Containments
			«tableHeader»
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def void writeSubTypes(Entry<EClass, EClassConfig> entry) {
		val currentEClass = entry.key
		var Set<EClass> subTypes = newLinkedHashSet()

		for (eClass : collectAllEClasses.reject[eClass == currentEClass]) {
			if (eClass.EAllSuperTypes.contains(currentEClass)) {
				subTypes.add(eClass)
			}
		}

		if (!subTypes.isEmpty) {
			writeSubTypesHeader()

			for (eClass : subTypes) {
				writeType(eClass -> (getConfig().findConfig(eClass)))
			}
		}
	}

	protected def void writeSuperTypes(Entry<EClass, EClassConfig> entry) {
		val eClass = entry.key
		
		val tmp = eClass.EAllSuperTypes
		
		val superTypes = collectAllEClasses.filter[tmp.contains(it)]
		
		val boolean superTypesExist = !superTypes.isEmpty

		if (superTypesExist) {
			writeSuperTypesHeader()
			
			val sortedSuperTypes = superTypes.sortBy[it.name ?: ""]

			for (supertype : sortedSuperTypes) {
				writeType(supertype -> getConfig().findConfig(supertype))
			}
		}
	}

	protected def void writeType(Pair<EClass, IENamedElementConfig> pair) {
		writeType(new SimpleEntry(pair.key, pair.value as EClassConfig))
	}

	protected def void writeType(Entry<EClass, EClassConfig> entry) {
		if (!entry.value.shouldRender) {
			return
		}
		
		val eClass = entry.key
		
		output.append(
		'''
			* «concatLinkTo(eClass)»
		''')
	}

	protected def void writeSubTypesHeader() {
		output.append(
		'''
			«newline»
			.Sub-types
		''')
	}

	protected def void writeSuperTypesHeader() {
		output.append(
		'''
			«newline»
			.Super-types
		''')
	}

	protected def void writeEAttributesHeader() {
		output.append(
		'''
			«newline»
			.Attributes
			«tableHeader»
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def CharSequence tableHeader() {
		'''[cols="<20,<20,<20,<40a",options="header"]'''
	}

	protected def List<EReference> collectEContainments(EClass eClass) {
		eClass.EReferences.filter[isContainment]
						  .toList
	}

	protected def Set<? extends EStructuralFeature> collectInheritedEContainments(Entry<EClass, EClassConfig> entry) {
		if (entry.value.shouldRepeatInherited) {
			val eClass = entry.key
			
			eClass.EAllReferences.filter[isContainment]
								 .reject[eClass.EReferences.contains(it)]
								 .toSet
	 	} else {
	 		emptySet
	 	}
	}

	protected def List<EReference> collectECrossReferences(EClass eClass) {
		eClass.EReferences.filter[!isContainment]
						  .toList
	}

	protected def Set<? extends EStructuralFeature> collectInheritedECrossReferences(Entry<EClass, EClassConfig> entry) {
		if (entry.value.shouldRepeatInherited) {
			val eClass = entry.key
			eClass.EAllReferences.filter[!isContainment]
								 .reject[eClass.EReferences.contains(it)]
								 .toSet
	 	} else {
	 		emptySet
	 	}
	}

	protected def Set<EStructuralFeature> collectInheritedEAttributes(Entry<EClass, EClassConfig> entry) {
		val Set<EStructuralFeature> inheritedEAttributes = newLinkedHashSet()

		if (entry.value.shouldRepeatInherited) {
			for (superclass : entry.key.EAllSuperTypes) {
				inheritedEAttributes.addAll(superclass.EAllAttributes)
			}
		}

		return inheritedEAttributes
	}

	protected def void writeEStructuralFeatures(List<? extends EStructuralFeature> eStructuralFeatures, EClass eClass,
		Set<? extends EStructuralFeature> inheritedStructuralFeatures) {
		
		// Iterate through non inherited eStructuralFeatures.
		for (eStructuralFeature : eStructuralFeatures.sortBy[it.name ?: ""]) {
			writeRow(eStructuralFeature, eClass)
		}

		// Iterate through inherited eStructuralFeatures.
		for (eStructuralFeature : inheritedStructuralFeatures.sortBy[it.name ?: ""]) {
			writeRow(eStructuralFeature, eClass)
		}

		output.append(tableFooter())
	}

	protected def void writeRow(EStructuralFeature eStructuralFeature, EClass eClass) {
		val EClass eStructuralFeatureClass = eStructuralFeature.eContainer as EClass
		val boolean isInherited = (eClass != eStructuralFeatureClass)
		val String eStructuralFeatureName = eStructuralFeature.name
		val String[] inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClass) 

		output.append(
		'''
			«newline»
			|`«eStructuralFeatureName»`[[«inheritedFeatureSegments.joinAnchor»]]«IF isInherited» +«ENDIF»
			«IF isInherited»«concatInheritedElement(eStructuralFeature)»«ENDIF»
			|«concatFeatureType(eStructuralFeature)»
			|«concatFeatureProperties(eStructuralFeature)»
			|«getDocumentation(eStructuralFeature)»
		''')
	}
	
	protected def CharSequence concatFeatureProperties(EStructuralFeature eStructuralFeature) {
		val featureProperties = enumerateFeatureProperties(eStructuralFeature)
		val genericProperties = enumerateGenericProperties(eStructuralFeature)
		
		val CharSequence separator = ''' +«newline»'''
		
		return (featureProperties + genericProperties)
			.filterNull
			.join(separator)
	}
	
	protected def dispatch List<CharSequence> enumerateFeatureProperties(EAttribute eAttribute){
		 #[
		 	defineId(eAttribute)
		 ]
	 }
		 
	protected def dispatch List<CharSequence> enumerateFeatureProperties(EReference eReference){
		 #[
			defineEKeys(eReference),
			defineResolveProxies(eReference),
			defineContainer(eReference)
		]
	}
	
	protected def List<CharSequence> enumerateGenericProperties(EStructuralFeature eStructuralFeature) {
		#[
			concatBounds(eStructuralFeature),
			concatDefaultValue(eStructuralFeature),
			defineOrdered(eStructuralFeature),
			defineChangeable(eStructuralFeature),
			defineDerived(eStructuralFeature),
			defineTransient(eStructuralFeature),
			defineUnique(eStructuralFeature),
			defineUnsettable(eStructuralFeature),
			defineVolatile(eStructuralFeature)
		]
	}

	protected def dispatch CharSequence concatFeatureType(EReference eReference) {
		'''
			«concatLinkTo(eReference.EType)»
			«getOpposite(eReference)»
		'''
	}

	protected def dispatch CharSequence concatFeatureType(EAttribute eAttribute) {
		'''
			«concatLinkTo(eAttribute.EType)»
		'''
	}

	protected def CharSequence getOpposite(EReference eReference) {
		val eOpposite = eReference.EOpposite
		
		if (eOpposite !== null) {
			val String eOppositeName = eOpposite.name
			val eReferenceType = eReference.EReferenceType
			
			'''
				«newline»
				_EOpposite:_ `<<«concatAnchor(eReferenceType)»«EcoreDocExtension.ANCHOR_SEPARATOR»«eOppositeName», «eOppositeName»>>`
			'''
		}
	}

	protected def CharSequence concatInheritedElement(ENamedElement eNamedElement) {
		val eClass = eNamedElement.eContainer as EClass
		
		'''(`<<«concatAnchor(eNamedElement)», {inherited}«concatReferenceName(eClass)»>>`)'''
	}

	protected def void writeEReferencesHeader() {
		output.append(
		'''
			«newline»
			.References
			«tableHeader»
			|===
			|Name
			|Type
			|Properties
			|Description
		''')
	}

	protected def void writeEClassHeader(Entry<EClass, EClassConfig> entry) {
		val eClass = entry.key
		
		val String eClassName = eClass.name
		val boolean isAbstract = eClass.isAbstract
		val boolean isInterface = eClass.isInterface
		val boolean notInterface = !isInterface

		output.append(
		'''
			«newline»
			[[«concatAnchor(eClass)»]]
			==== «IF isAbstract && notInterface»Abstract «ENDIF»«IF isInterface»Interface«ELSE»Class«ENDIF» «eClassName»
			«newline»
			«getDocumentation(eClass)»
			«newline»
		''')
	}
	
	protected def void writeProperties(Entry<EClass, EClassConfig> entry) {
		val eClass = entry.key
		
		val properties = newArrayList
		
		if (!eClass.isAbstract) {
			properties += defineDefaultValue(entry)
		}
		
		properties += defineInstanceClassName(entry)
		
		output.append(
			properties
				.filterNull
				.join(EcoreDocExtension.ECLASSIFIER_PROPERTY_SEPARATOR)
		)
		
		output.append(newline)
	}
}
