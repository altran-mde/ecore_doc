package com.altran.general.emf.ecoredoc.generator.impl

import com.altran.general.emf.ecoredoc.generator.config.EClassConfig
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.EAttributeConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.EOperationConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.EReferenceConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEStructuralFeatureConfigPair
import com.google.common.collect.Multimap
import com.google.inject.Injector
import java.util.Collection
import java.util.List
import java.util.Map
import java.util.Set
import org.apache.commons.lang3.StringUtils
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.xcore.mappings.XcoreMapper
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XbasePackage

import static com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension.newline
import com.altran.general.emf.ecoredoc.generator.configbuilder.EParameterConfigPair
import org.eclipse.emf.ecore.EParameter
import com.altran.general.emf.ecoredoc.generator.config.EOperationConfig
import com.altran.general.emf.ecoredoc.generator.config.EParameterConfig

class EClassGeneratorPart extends AEcoreDocGeneratorPart {
	extension EStructuralFeaturePropertyHelper structuralFeaturePropertyHelper
	
	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages, Injector xcoreInjector) {
		super(config, ePackages, xcoreInjector)
		
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
		
		writeEOperations(pair)

		writeUseCases(pair)
	}

	protected def void writeEContainments(EClassConfigPair pair) {
		val eClass = pair.element
		
		val containments = collectEContainments(eClass).combineConfigPairs(pair.config)
		val inheritedContainments = collectInheritedEContainments(pair).combineConfigPairs(pair.config)
		
		if (pair.config.hasRenderedEntries(containments, inheritedContainments)) {
			writeEContainmentHeader()

			writeEStructuralFeatures(containments, eClass, inheritedContainments)
		}
	}

	protected def void writeECrossReferences(EClassConfigPair pair) {
		val eClass = pair.element
		
		val crossReferences = collectECrossReferences(eClass).combineConfigPairs(pair.config)
		val inheritedCrossReferences = collectInheritedECrossReferences(pair).combineConfigPairs(pair.config)
		
		if (pair.config.hasRenderedEntries(crossReferences, inheritedCrossReferences)) {
			writeEReferencesHeader()

			writeEStructuralFeatures(crossReferences, eClass, inheritedCrossReferences)
		}
	}

	protected def void writeEAttributes(EClassConfigPair pair) {
		val eClass = pair.element
		
		val eAttributes = eClass.EAttributes.combineConfigPairs(pair.config)
		val inheritedEAttributes = collectInheritedEAttributes(pair).combineConfigPairs(pair.config)
		
		if (pair.config.hasRenderedEntries(eAttributes, inheritedEAttributes)) {
			writeEAttributesHeader()
			
			writeEStructuralFeatures(eAttributes, eClass, inheritedEAttributes)
		}
	}
	
	protected def void writeEOperations(EClassConfigPair pair) {
		val eClass = pair.element
		
		val eOperations = eClass.EOperations.combineOperationConfigPairs(pair.config)
		val inheritedEOperations = collectInheritedEOperations(pair).combineOperationConfigPairs(pair.config)
		
		if(pair.config.hasRenderedOperations(eOperations, inheritedEOperations)) {
			writeEOperationsHeader()
			
			for (op: eOperations.sortBy[EcoreDocExtension::eOperationSorter.apply(element)]) {
				writeEOperation(op, eClass, false)
			}
	
			for (op : inheritedEOperations.sortBy[EcoreDocExtension::eOperationSorter.apply(element)]) {
				writeEOperation(op, eClass, true)
			}
	
			output.append(tableFooter)
		}
	}

	protected def void writeEOperation(EOperationConfigPair pair, EClass eClass, boolean inherited) {
		if (!pair.config.shouldRender) {
			return
		}
		
		val eOperation = pair.element
		
		var String language = null
		var String body = null
		
		if (xcoreInjector !== null) {
			val mapper = xcoreInjector.getInstance(XcoreMapper)
			val xOp = mapper.getXOperation(eOperation)
			if (xOp.body !== null) {
				language = "xtend"
				val text = NodeModelUtils.findNodesForFeature(xOp.body, XbasePackage.Literals::XBLOCK_EXPRESSION__EXPRESSIONS)
					.map[text]
					.join
				val lines = StringUtils.split(text, newline)
				body = if (lines.size > 1) {
					val prefix = StringUtils.getCommonPrefix(lines)
					lines.map[StringUtils.removeStart(it, prefix)].join(newline)
				} else {
					lines.join.trim
				}
			}
		}
		
		if (StringUtils.isBlank(body)) {
			val genModelAnnotation = eOperation.getEAnnotation(GenModelPackage.eNS_URI)
			val bodyAnnotation = genModelAnnotation?.details?.get("body")
			language = "java"
			body = StringUtils.defaultString(bodyAnnotation).trim
		}
		
		val lineCount = 1 
			+ eOperation.EParameters.size 
			+ eOperation.EExceptions.size
			+ if(body.isEmpty) 0 else 1 
		
		val overrides = eClass.EAllSuperTypes
			.map[EOperations]
			.flatten
			.filter[it !== eOperation && eOperation.isOverrideOf(it)]
		
		val inheritedFeatureSegments = collectInheritedFeatureSegments(eOperation, eClass)
		 
		output.append(
			'''
			.«lineCount»+|«IF body.isEmpty»_abstract_ «ENDIF»`«eOperation.name»(«
			FOR param : eOperation.EParameters BEFORE "{zwsp}" SEPARATOR ", " AFTER "{zwsp}"»«param.name»«ENDFOR
			»)`[[«inheritedFeatureSegments.joinAnchor»]]«IF inherited» +
				«concatInheritedElement(eOperation)»
			«ENDIF»«IF !overrides.isEmpty» +
				«FOR override : overrides SEPARATOR " +" + newline»
					`<<«concatAnchor(override)», {override}«concatReferenceName(pair.element)»>>`
				«ENDFOR»
			«ENDIF»
			|_returns_ +
			«concatLinkTo(eOperation.EType)»
			|«IF eOperation.EType !== null»`[«eOperation.lowerBound»..«eOperation.upperBound»]`«ENDIF»
			|«getDocumentation(eOperation)»
			«newline»
			'''
		)
		
		for(param : eOperation.EParameters) {
			output.append(
				'''
				|`«param.name»` +
				«concatLinkTo(param.EType)»
				|`[«param.lowerBound»..«param.upperBound»]`
				|«getDocumentation(param)»
				«newline»
				'''
			)
		}
		
		for (ex : eOperation.EExceptions) {
			output.append(
				'''
				|_throws_ +
				«concatLinkTo(ex)»
				|
				|
				«newline»
				'''
			)
		}
		
		if(!body.isEmpty) {
			output.append(
				'''
				3+a|
				[source,«language»]
				----
				«body»
				----
				«newline»
				'''
			)
		}
	}
	
	protected def hasRenderedEntries(EClassConfig classConfig, Collection<IEStructuralFeatureConfigPair<?,?>> eStructuralFeatures, Collection<IEStructuralFeatureConfigPair<?,?>> inheritedEStructuralFeatures) {
		eStructuralFeatures.exists[it.config.shouldRender]
		||
		(
			classConfig.shouldRepeatInherited
			&&
			inheritedEStructuralFeatures.exists[it.config.shouldRender]
		)
	}
	
	protected def hasRenderedOperations(EClassConfig classConfig, Collection<EOperationConfigPair> eOperations, Collection<EOperationConfigPair> inheritedEOperations) {
		eOperations.exists[it.config.shouldRender]
		||
		(
			classConfig.shouldRepeatInherited
			&&
			inheritedEOperations.exists[it.config.shouldRender]
		)
	}
	
	protected def List<IEStructuralFeatureConfigPair<?,?>> combineConfigPairs(Collection<? extends EStructuralFeature> eStructuralFeatures, EClassConfig classConfig) {
		eStructuralFeatures
			.map[combineConfigPair(classConfig) as IEStructuralFeatureConfigPair<?,?>]
			.toList
	}
	
	protected def List<EOperationConfigPair> combineOperationConfigPairs(Collection<? extends EOperation> eOperations, EClassConfig classConfig) {
		eOperations
			.map[op|new EOperationConfigPair(op, classConfig.EOperations.findFirst[id == op.name])]
			.toList
	}
	
	protected def List<EParameterConfigPair> combineParameterConfigPairs(Collection<? extends EParameter> eParameters, EOperationConfig operationConfig) {
		eParameters
			.map[param| new EParameterConfigPair(param, operationConfig.EParameters.findFirst[id == param.name])]
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
		if (!pair.config.shouldRenderSubTypes()) {
			return
		}
		
		val currentEClass = pair.element
		var Set<EClass> subTypes = newLinkedHashSet()

		for (eClass : collectAllEClasses.reject[eClass == currentEClass]) {
			if (eClass.EAllSuperTypes.contains(currentEClass)) {
				subTypes.add(eClass)
			}
		}

		if (!subTypes.isEmpty) {
			writeSubTypesHeader()

			for (subType : subTypes.sortBy(EcoreDocExtension::eClassifierSorter)) {
				writeType(new EClassConfigPair(subType, getConfig().findConfig(subType) as EClassConfig))
			}
		}
	}

	protected def void writeSuperTypes(EClassConfigPair pair) {
		if (!pair.config.shouldRenderSuperTypes()) {
			return
		}
		
		val eClass = pair.element
		
		val tmp = eClass.EAllSuperTypes
		
		val superTypes = collectAllEClasses.filter[tmp.contains(it)]
		
		val boolean superTypesExist = !superTypes.isEmpty

		if (superTypesExist) {
			writeSuperTypesHeader()
			
			val sortedSuperTypes = superTypes.sortBy(EcoreDocExtension::eClassifierSorter)

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

	protected def Set<EReference> collectEContainments(EClass eClass) {
		eClass.EReferences.filter[isContainment]
						  .toSet
	}

	protected def Set<EReference> collectInheritedEContainments(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			
			eClass.EAllReferences.filter[isContainment]
								 .reject[eClass.EReferences.contains(it)]
								 .toSet
	 	} else {
	 		emptySet
	 	}
	}

	protected def Set<EReference> collectECrossReferences(EClass eClass) {
		eClass.EReferences.filter[!isContainment]
						  .toSet
	}

	protected def Set<EReference> collectInheritedECrossReferences(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			
			eClass.EAllReferences.filter[!isContainment]
								 .reject[eClass.EReferences.contains(it)]
								 .toSet
	 	} else {
	 		emptySet
	 	}
	}

	protected def Set<EAttribute> collectInheritedEAttributes(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			
			eClass.EAllAttributes.reject[eClass.EAttributes.contains(it)]
								 .toSet
	 	} else {
	 		emptySet
	 	}
	}

	protected def Set<EOperation> collectInheritedEOperations(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			
			eClass.EAllOperations
				.reject[eClass.EOperations.contains(it)]
				.reject[op | eClass.EOperations.exists[it.isOverrideOf(op)]]
				.toSet
	 	} else {
	 		emptySet
	 	}
	}

	protected def void writeEStructuralFeatures(
		Collection<IEStructuralFeatureConfigPair<?,?>> ownEStructuralFeatures, 
		EClass eClass,
		Collection<IEStructuralFeatureConfigPair<?,?>> inheritedEStructuralFeatures) {
		
		// Iterate through non inherited eStructuralFeatures.
		for (entry: ownEStructuralFeatures.sortBy[EcoreDocExtension::eStructuralFeatureSorter.apply(element)]) {
			writeRow(entry, eClass, false)
		}

		// Iterate through inherited eStructuralFeatures.
		for (entry : inheritedEStructuralFeatures.sortBy[EcoreDocExtension::eStructuralFeatureSorter.apply(element)]) {
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
		val inheritedFeatureSegments = collectInheritedFeatureSegments(eStructuralFeature, eClass) 

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
		
		'''`<<«concatAnchor(eNamedElement)», {inherited}«concatReferenceName(eClass)»>>`'''
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

	protected def void writeEOperationsHeader() {
		output.append(
		'''
			«newline»
			.Operations
			«tableHeader»
			|===
			|Name
			|Aspect and Type
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
