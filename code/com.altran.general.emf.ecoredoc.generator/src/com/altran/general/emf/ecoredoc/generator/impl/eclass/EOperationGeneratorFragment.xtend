package com.altran.general.emf.ecoredoc.generator.impl.eclass

import com.altran.general.emf.ecoredoc.generator.config.EClassConfig
import com.altran.general.emf.ecoredoc.generator.config.EOperationConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.EOperationConfigPair
import com.altran.general.emf.ecoredoc.generator.configbuilder.EParameterConfigPair
import com.altran.general.emf.ecoredoc.generator.impl.^extension.ETypedElementPropertyExtension
import com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension
import com.google.common.collect.Sets
import java.util.Collection
import java.util.Comparator
import java.util.List
import java.util.Set
import org.apache.commons.lang3.StringUtils
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EParameter
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.xcore.mappings.XcoreMapper
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XbasePackage

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline
import com.altran.general.emf.ecoredoc.generator.configbuilder.IETypedElementConfigPair

class EOperationGeneratorFragment extends AEClassMemberGeneratorFragment {
	public static val Comparator<EOperation> eOperationBodyComparator = [a, b |
		if (a.name == b.name) {
			if (a.EParameters.size != b.EParameters.size) {
				return a.EParameters.size.compareTo(b.EParameters.size)
			} else {
				for(var i = 0; i < a.EParameters.size; i++) {
					val r = a.EParameters.get(i).EType.name.compareTo(b.EParameters.get(i).name)
					if (r != 0) {
						return r
					}
				}
				
				val aBody = a.bodyFromAnnotation
				val bBody = b.bodyFromAnnotation
				
				if (aBody !== null) {
					if (bBody !== null) {
						return aBody.compareTo(bBody)
					} else {
						return -1
					}
				} else if (bBody !== null) {
					return 1
				} else {
					return 0
				}
			}
		} else {
			return a.name.compareTo(b.name)
		}
	]

	public static val eOperationComparator = [EOperation a, EOperation b |
		if (a.name == b.name) {
			if (a.EParameters.size != b.EParameters.size) {
				return a.EParameters.size.compareTo(b.EParameters.size)
			} else {
				for(var i = 0; i < a.EParameters.size; i++) {
					val r = a.EParameters.get(i).EType.name.compareTo(b.EParameters.get(i).name)
					if (r != 0) {
						return r
					}
				}
				
				return 0
			}
		} else {
			return a.name.compareTo(b.name)
		}
	]
	
	protected static def getBodyFromAnnotation(EOperation eOperation) {
		val genModelAnnotation = eOperation.getEAnnotation(GenModelPackage.eNS_URI)
		return genModelAnnotation?.details?.get("body")
	}
	
	extension ETypedElementPropertyExtension = new ETypedElementPropertyExtension
	
	new(EClassGeneratorPart eClassGeneratorPart) {
		super(eClassGeneratorPart)
	}
	
	protected def void writeEOperations(EClassConfigPair pair) {
		val eClass = pair.element
		
		val eOperations = eClass.EOperations.combineConfigPairs(pair.config)
		val inheritedEOperations = collectInheritedEOperations(pair).combineConfigPairs(pair.config)
		
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
		
		val body = new StringBuilder
		val language = eOperation.extractBody(body)
		val hasBody = !StringUtils.isBlank(body)
		
		writeNameAndReturnType(pair, hasBody, eClass, inherited)
		
		writeParameters(pair)
		
		writeExceptions(eOperation)
		
		writeBody(hasBody, language, body)
	}
	
	protected def StringBuilder writeBody(boolean hasBody, String language, StringBuilder body) {
		if(hasBody) {
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
	
	protected def void writeExceptions(EOperation eOperation) {
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
	}
	
	protected def void writeParameters(EOperationConfigPair pair) {
		val eParameters = pair.element.EParameters.combineConfigPairs(pair.config)
		
		for(paramPair : eParameters) {
			val param = paramPair.element
			
			output.append(
				'''
					|`«param.name»` +
					«concatLinkTo(param.EType)»
					|«concatProperties(paramPair)»
					|«getDocumentation(param)»
					«newline»
				'''
			)
		}
	}
	
	protected def StringBuilder writeNameAndReturnType(EOperationConfigPair pair, boolean hasBody, EClass eClass, boolean inherited) {
		val eOperation = pair.element
		
		val lineCount = calculateLineSpan(eOperation, hasBody) 
		
		val inheritedFeatureSegments = collectInheritedEClassMemberSegments(eOperation, eClass)
		 
		output.append(
			'''
				.«lineCount»+|«IF !hasBody»_abstract_ «ENDIF»`«eOperation.name»(«
				FOR param : eOperation.EParameters BEFORE "{zwsp}" SEPARATOR ", "»«param.name»«ENDFOR
				»)`[[«inheritedFeatureSegments.joinAnchor»]]
				«concatOverridesFeatures(eOperation, eClass)»
				«concatOverrides(eOperation, eClass, inherited)»
				«concatSubOverridesFeatures(eOperation, eClass)»
				«concatSubOverrides(eOperation, eClass)»
				|_returns_ +
				«concatLinkTo(eOperation.EType)»
				|«concatProperties(pair)»
				|«getDocumentation(eOperation)»
				«newline»
			'''
		)
	}

	protected def enumerateProperties(IETypedElementConfigPair<?,?> pair) {
		#[
			concatBounds(pair),
			defineOrdered(pair),
			defineUnique(pair)
		]	
	}
	
	protected def concatProperties(IETypedElementConfigPair<?,?> pair) {
		enumerateProperties(pair)
			.filterNull
			.join(PROPERTY_SEPARATOR)
	}
	
	protected def concatOverridesFeatures(EOperation eOperation, EClass eClass) {
		val overridesFeatures = collectOverriddenFeatures(eClass, eOperation)
		
		overridesFeatures
			.map[concatLinkTo("{override}")]
			.joinInheritance
	}
	
	protected def concatOverrides(EOperation eOperation, EClass eClass, boolean inherited) {
		val overrides = collectOverrides(eClass, eOperation)
		
		overrides
			.map[concatLinkTo(if (inherited) "{inherited}" else "{override}")]
			.joinInheritance
	}
	
	protected def concatSubOverridesFeatures(EOperation eOperation, EClass eClass) {
		val subOverridesFeatures = collectOverriddenFeatures(eClass.collectAllSubTypes, eOperation)
		
		subOverridesFeatures
			.map[concatLinkTo("{overriddenBy}")]
			.joinInheritance
	}
	
	protected def concatSubOverrides(EOperation eOperation, EClass eClass) {
		val subOverrides = collectOverrides(eClass.collectAllSubTypes, eOperation)
		
		subOverrides
			.map[concatLinkTo("{overriddenBy}")]
			.joinInheritance
	}
	
	protected def collectOverriddenFeatures(Iterable<EClass> eClasses, EOperation eOperation) {
		eClasses
			.map[EStructuralFeatures]
			.flatten
			.filter[eOperation.overridesFeature(it)]
			.toSet
	}
	
	protected def collectOverrides(Iterable<EClass> eClasses, EOperation eOperation) {
		eClasses
			.map[EOperations]
			.flatten
			.filter[eOperationComparator.apply(it, eOperation) == 0]
			.toSet
	}
	
	protected def Set<EStructuralFeature> collectOverriddenFeatures(EClass eClass, EOperation eOperation) {
		eClass.EAllSuperTypes
			.collectOverriddenFeatures(eOperation)
	}
	
	protected def Set<EOperation> collectOverrides(EClass eClass, EOperation eOperation) {
		val result = eClass.EAllSuperTypes
					.collectOverrides(eOperation)

		if (eOperation.eContainer != eClass) {
			result.add(eOperation)
		}
		
		return result
	}
	
	protected def int calculateLineSpan(EOperation eOperation, boolean hasBody) {
		1 
			+ eOperation.EParameters.size 
			+ eOperation.EExceptions.size
			+ if(hasBody) 1 else 0
	}
	
	protected def String extractBody(EOperation eOperation, StringBuilder body) {
		var String language = null
		
		if (xcoreInjector !== null) {
			val mapper = xcoreInjector.getInstance(XcoreMapper)
			val xOp = mapper.getXOperation(eOperation)
			if (xOp?.body !== null) {
				language = "xtend"
				val text = NodeModelUtils.findNodesForFeature(xOp.body, XbasePackage.Literals::XBLOCK_EXPRESSION__EXPRESSIONS)
					.map[text]
					.join
					.normalizeNewline
				val lines = StringUtils.split(text, "\n")
				if (lines.size > 1) {
					val prefix = StringUtils.getCommonPrefix(lines)
					body.append(lines.map[StringUtils.removeStart(it, prefix)].join(newline))
				} else {
					body.append(lines.join.trim)
				}
			}
		}
		
		if (StringUtils.isBlank(body)) {
			language = "java"
			body.append(StringUtils.defaultString(eOperation.bodyFromAnnotation).trim)
		}
		
		return language
	}
	
	// FIXME: Move to Espilce Commons
	private def String normalizeNewline(String text) {
		return StringUtils.replaceEach(
				text,
				#["\r\n", "\n\r", "\r" ],
				#["\n", "\n", "\n" ]);
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
	
	protected def List<EOperationConfigPair> combineConfigPairs(Collection<? extends EOperation> eOperations, EClassConfig classConfig) {
		eOperations
			.map[op|new EOperationConfigPair(op, classConfig.EOperations.findFirst[id == joinId(op)])]
			.toList
	}
	
	protected def List<EParameterConfigPair> combineConfigPairs(Collection<? extends EParameter> eParameters, EOperationConfig operationConfig) {
		eParameters
			.map[param| new EParameterConfigPair(param, operationConfig.EParameters.findFirst[id == param.name])]
			.toList
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
	
	protected def Set<EOperation> collectInheritedEOperations(EClassConfigPair pair) {
		if (pair.config.shouldRepeatInherited) {
			val eClass = pair.element
			
			val result = Sets.newTreeSet(eOperationBodyComparator)
			
			result.addAll(eClass.EAllOperations
				.reject[eClass.EOperations.contains(it)]
				.reject[EcorePackage.Literals::EOBJECT == eContainer]
				.reject[op | eClass.EOperations.exists[it.isOverrideOf(op)]]
				.reject[op | eClass.EStructuralFeatures.exists[it.implementsOperation(op)]]
			)
			
			// make sure to pick an inherited EOperation with a body, if it exists
			return result
				.groupBy[name + EParameters.map[EType.name].join]
				.values
				.map[sortInplace(eOperationBodyComparator).head]
				.toSet
	 	} else {
	 		emptySet
	 	}
	}

	protected def getXcoreInjector() {
		this.eClassGeneratorPart.xcoreInjector
	}
}
