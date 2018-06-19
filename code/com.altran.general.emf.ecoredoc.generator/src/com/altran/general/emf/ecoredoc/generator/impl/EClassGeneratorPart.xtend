package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig
import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfigPair
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig
import com.altran.general.emf.ecoredoc.generator.config.EClassConfigPair
import com.altran.general.emf.ecoredoc.generator.config.EReferenceConfigPair
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfigPair
import com.google.common.collect.Maps
import com.google.common.collect.Multimap
import java.util.Collection
import java.util.List
import java.util.Map
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
				writeEClass(new EClassConfigPair(entry))
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

	protected def void writeEClass(EClassConfigPair pair) {
		writeEClassHeader(pair)
		
		writeProperties(pair)

		writeSuperTypes(pair)

		writeSubTypes(pair)

		writeEAttributes(pair)

		writeEContainments(pair)

		writeECrossReferences(pair)

		writeUseCases(pair)
	}

	protected def void writeEContainments(EClassConfigPair pair) {
		val eClass = pair.element
		
		val boolean containmentExists = eClass.EAllReferences.exists[isContainment]

		if (containmentExists) {
			writeEContainmentHeader()

			var List<EReference> eContainments = collectEContainments(eClass)
			var Set<? extends EStructuralFeature> inheritedEContainments = collectInheritedEContainments(pair)

			writeEStructuralFeatures(eContainments.combineConfigPairs(pair.config), eClass, inheritedEContainments.combineConfigPairs(pair.config))
		}
	}

	protected def void writeECrossReferences(EClassConfigPair pair) {
		val eClass = pair.element
		
		val boolean eCrossReferenceExists = eClass.EAllReferences.exists[!isContainment]

		if (eCrossReferenceExists) {
			writeEReferencesHeader()

			var List<EReference> crossReferences = collectECrossReferences(eClass)
			var Set<? extends EStructuralFeature> inheritedECrossReferences = collectInheritedECrossReferences(pair)

			writeEStructuralFeatures(crossReferences.combineConfigPairs(pair.config), eClass, inheritedECrossReferences.combineConfigPairs(pair.config))
		}
	}

	protected def void writeEAttributes(EClassConfigPair pair) {
		val eClass = pair.element
		
		val eAttributesMap = Maps::newLinkedHashMap(eClass.EAllAttributes
			.toInvertedMap[eAttribute | pair.config.EAttributes.findFirst[id == eAttribute.name] as EAttributeConfig]
			.filter[eAttribute, config|
				config.shouldRender
			])
			
		if (!eAttributesMap.isEmpty) {
			writeEAttributesHeader()

			val inheritedEAttributes = collectInheritedEAttributes(pair)
				
			val eAttributes = eClass.EAttributes
			
			writeEStructuralFeatures(eAttributes.combineConfigPairs(pair.config), eClass, inheritedEAttributes.combineConfigPairs(pair.config))
		}
	}
	
	protected def List<IEStructuralFeatureConfigPair<?,?>> combineConfigPairs(Collection<? extends EStructuralFeature> eStructuralFeatures, EClassConfig classConfig) {
		eStructuralFeatures
			.map[combineConfigPair(classConfig) as IEStructuralFeatureConfigPair<?,?>]
			.toList
	}
	
	protected def dispatch combineConfigPair(EAttribute eAttribute, EClassConfig classConfig) {
		new EAttributeConfigPair(eAttribute, classConfig.EAttributes.findFirst[id == eAttribute.name])
	}

	protected def dispatch combineConfigPair(EReference eReference, EClassConfig classConfig) {
		new EReferenceConfigPair(eReference, (classConfig.EContainments + classConfig.EReferences).findFirst[id == eReference.name])
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

	protected def void writeSubTypes(EClassConfigPair pair) {
		val currentEClass = pair.element
		var Set<EClass> subTypes = newLinkedHashSet()

		for (eClass : collectAllEClasses.reject[eClass == currentEClass]) {
			if (eClass.EAllSuperTypes.contains(currentEClass)) {
				subTypes.add(eClass)
			}
		}

		if (!subTypes.isEmpty) {
			writeSubTypesHeader()

			for (subType : subTypes) {
				writeType(new EClassConfigPair(subType, getConfig().findConfig(subType) as EClassConfig))
			}
		}
	}

	protected def void writeSuperTypes(EClassConfigPair pair) {
		val eClass = pair.element
		
		val tmp = eClass.EAllSuperTypes
		
		val superTypes = collectAllEClasses.filter[tmp.contains(it)]
		
		val boolean superTypesExist = !superTypes.isEmpty

		if (superTypesExist) {
			writeSuperTypesHeader()
			
			val sortedSuperTypes = superTypes.sortBy[it.name ?: ""]

			for (supertype : sortedSuperTypes) {
				writeType(new EClassConfigPair(supertype, getConfig().findConfig(supertype) as EClassConfig))
			}
		}
	}

	protected def void writeType(EClassConfigPair pair) {
		if (!pair.config.shouldRender) {
			return
		}
		
		val eClass = pair.element
		
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

	protected def Set<? extends EStructuralFeature> collectInheritedEContainments(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			
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

	protected def Set<? extends EStructuralFeature> collectInheritedECrossReferences(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			eClass.EAllReferences.filter[!isContainment]
								 .reject[eClass.EReferences.contains(it)]
								 .toSet
	 	} else {
	 		emptySet
	 	}
	}

	protected def Set<EStructuralFeature> collectInheritedEAttributes(EClassConfigPair pair) {
		val Set<EStructuralFeature> inheritedEAttributes = newLinkedHashSet()

		if (pair.config.shouldRepeatInherited) {
			for (superclass : pair.element.EAllSuperTypes) {
				inheritedEAttributes.addAll(superclass.EAllAttributes)
			}
		}

		return inheritedEAttributes
	}

	protected def void writeEStructuralFeatures(
		Collection<IEStructuralFeatureConfigPair<?,?>> ownEStructuralFeatures, 
		EClass eClass,
		Collection<IEStructuralFeatureConfigPair<?,?>> inheritedEStructuralFeatures) {
		
		// Iterate through non inherited eStructuralFeatures.
		for (entry: ownEStructuralFeatures.sortBy[it.element.name ?: ""]) {
			writeRow(entry, eClass, false)
		}

		// Iterate through inherited eStructuralFeatures.
		for (entry : inheritedEStructuralFeatures.sortBy[it.element.name ?: ""]) {
			writeRow(entry, eClass, true)
		}

		output.append(tableFooter())
	}

	protected def void writeRow(IEStructuralFeatureConfigPair<?,?> pair, EClass eClass, boolean inherited) {
		if (!pair.config.shouldRender) {
			return
		}
		
		val eStructuralFeature = pair.element
		val String eStructuralFeatureName = eStructuralFeature.name
		val String[] inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClass) 

		output.append(
		'''
			«newline»
			|`«eStructuralFeatureName»`[[«inheritedFeatureSegments.joinAnchor»]]«IF inherited» +«ENDIF»
			«IF inherited»«concatInheritedElement(eStructuralFeature)»«ENDIF»
			|«concatFeatureType(eStructuralFeature)»
			|«concatFeatureProperties(pair)»
			|«getDocumentation(eStructuralFeature)»
		''')
	}
	
	protected def CharSequence concatFeatureProperties(IEStructuralFeatureConfigPair<?,?> pair) {
		val featureProperties = enumerateFeatureProperties(pair)
		val genericProperties = enumerateGenericProperties(pair)
		
		val CharSequence separator = ''' +«newline»'''
		
		return (featureProperties + genericProperties)
			.filterNull
			.join(separator)
	}
	
	def dispatch List<CharSequence> enumerateFeatureProperties(IEStructuralFeatureConfigPair<?,?> pair) {
		// dummy to satisfy Xtend
	}

	protected def dispatch List<CharSequence> enumerateFeatureProperties(EAttributeConfigPair pair) {
		 #[
		 	defineId(pair)
		 ]
	 }
		 
	protected def dispatch List<CharSequence> enumerateFeatureProperties(EReferenceConfigPair pair) {
		 #[
			defineEKeys(pair),
			defineResolveProxies(pair),
			defineContainer(pair)
		]
	}
	
	protected def List<CharSequence> enumerateGenericProperties(IEStructuralFeatureConfigPair<?,?> pair) {
		#[
			concatBounds(pair),
			concatDefaultValue(pair),
			defineOrdered(pair),
			defineChangeable(pair),
			defineDerived(pair),
			defineTransient(pair),
			defineUnique(pair),
			defineUnsettable(pair),
			defineVolatile(pair)
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

	protected def void writeEClassHeader(EClassConfigPair pair) {
		val eClass = pair.element
		
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
	
	protected def void writeProperties(EClassConfigPair pair) {
		val eClass = pair.element
		
		val properties = newArrayList
		
		if (!eClass.isAbstract) {
			properties += defineDefaultValue(pair)
		}
		
		properties += defineInstanceClassName(pair)
		
		output.append(
			properties
				.filterNull
				.join(EcoreDocExtension.ECLASSIFIER_PROPERTY_SEPARATOR)
		)
		
		output.append(newline)
	}
}
