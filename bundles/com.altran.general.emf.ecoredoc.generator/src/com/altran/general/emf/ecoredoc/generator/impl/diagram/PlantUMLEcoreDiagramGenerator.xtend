package com.altran.general.emf.ecoredoc.generator.impl.diagram

import java.util.Collections
import java.util.LinkedHashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.util.EcoreUtil

class PlantUMLEcoreDiagramGenerator {
	val Set<EClassifier> eClassifiersWithFocus = newHashSet
	
	val (ENamedElement)=>boolean predicate
	val Set<EClassifier> eClassifiers
	val Set<EPackage> ePackages
	
	new(EPackage ePackage, (ENamedElement)=>boolean predicate) {
		this(ePackage.EClassifiers, predicate)
	}
	
	new(EClassifier eClassifier, (ENamedElement)=>boolean predicate) {
		this(Collections::singleton(eClassifier), predicate)
		eClassifiersWithFocus += eClassifier
	}
	
	private new(Iterable<? extends EClassifier> input, (ENamedElement)=>boolean predicate) {
		this.predicate = predicate
		
		val filteredInput = input.filter(predicate).toSet
		eClassifiers = new LinkedHashSet(filteredInput)
		// Add the context that is required to render the classifiers
		eClassifiers += filteredInput.filter(EClass).flatMap[ESuperTypes].filter(predicate)
		eClassifiers += filteredInput.filter(EClass).flatMap[EReferences].filter(predicate).map[EType].filter(predicate)
		
		ePackages = eClassifiers.map[EPackage].toSet
	}
	
	def generateDiagram() {
		val eEnumLiterals = eClassifiers.filter(EEnum).flatMap[ELiterals].filter(predicate).toSet
		val eClasses = eClassifiers.filter(EClass).toSet
		val eSuperTypes = eClasses.flatMap[filterSuperTypes].toSet
		val eOperations = eClasses.flatMap[filterOperations(predicate)].toSet
		val eAttributes = eClasses.flatMap[filterAttributes(predicate)].toSet
		val eReferences = eClasses.flatMap[filterReferences(predicate)].toList.removeEOpposites
				
		'''
		skinparam Arrow {
			Color Black
			Thickness 0.6
		}
		skinparam Class {
			BackgroundColor <<E>> #white/technology
			BorderColor Black
			BorderThickness 1
		}
		skinparam Stereotype {
			ABackgroundColor motivation
			CBackgroundColor business
			EBackgroundColor technology
			IBackgroundColor motivation
		}
		skinparam RoundCorner 8
		«IF ePackages.size > 1»
			skinparam Package {
				FontStyle Plain
				BorderColor LightSlateGray
				BorderThickness 1
			}
			
			set namespaceSeparator .
		«ENDIF»
		
		«FOR eClassifier : eClassifiers»
			«eClassifier.generateEClassifier»
		«ENDFOR»

		«FOR eEnumLiteral : eEnumLiterals»
			«eEnumLiteral.EEnum.fqn» : «eEnumLiteral.name»
		«ENDFOR»

		«FOR eAttribute : eAttributes»
			«eAttribute.EContainingClass.fqn» : «eAttribute.generateEAttribute»
			«IF eClassifiers.contains(eAttribute.EType)»«eAttribute.EContainingClass.fqn» -[hidden]> «eAttribute.EType.fqn»«ENDIF»
		«ENDFOR»

		«FOR eOperation : eOperations»
			«eOperation.EContainingClass.fqn» : «eOperation.generateEOperation»
			«IF eClassifiers.contains(eOperation.EType)»«eOperation.EContainingClass.fqn» -[hidden]> «eOperation.EType.fqn»«ENDIF»
		«ENDFOR»
		
		«FOR eSuperType : eSuperTypes»
			«eSuperType.generateESuperType»
		«ENDFOR»

		«FOR eReference : eReferences»
			«eReference.generateEReference»
		«ENDFOR»
		'''
	}

	private def generateEClassifier(EClassifier eClassifier) {
		val focus = eClassifiersWithFocus.contains(eClassifier)
		return switch it: eClassifier {
			EClass case isInterface: '''interface «fqn» #white/motivation«IF focus» ##[bold]black«ENDIF»'''
			EClass case isAbstract: '''abstract «fqn» #white/motivation«IF focus» ##[bold]black«ENDIF»'''
			EClass: '''class «fqn» #white/business«IF focus» ##[bold]black«ENDIF»'''
			EEnum: '''
				enum «fqn» #white/technology«IF focus» ##[bold]black«ENDIF»
				hide «fqn» methods
			'''
			EDataType: '''
				class «fqn» << (D, business) >> #white/business«IF focus» ##[bold]black«ENDIF» {
					//«instanceClassName»//
				}
				hide «fqn» methods
			'''
		}
	}
	
	private def generateESuperType(Pair<EClass, EClass> eSuperType) {
		val baseType = eSuperType.key
		val superType = eSuperType.value
		
		'''«baseType.fqn» «IF superType.interface && !baseType.interface».up.«ELSE»-up-«ENDIF»|> «superType.fqn»'''
	}

	private def generateEAttribute(EStructuralFeature eStructuralFeature) {
		val defaultValueLiteral = if (eStructuralFeature.defaultValueLiteral !== null) {
			eStructuralFeature.defaultValueLiteral
		} else if (eStructuralFeature.defaultValue !== null) {
			val eType = eStructuralFeature.EType
			if (eType instanceof EDataType) {
				EcoreUtil::convertToString(eType, eStructuralFeature.defaultValue)
			} else {
				String::valueOf(eStructuralFeature.defaultValue)
			}
		}
		val text = '''«eStructuralFeature.name» : «eStructuralFeature.EType.name»«IF defaultValueLiteral !== null» = «defaultValueLiteral»«ENDIF»'''
		return text.wrapWithMultiplicity(eStructuralFeature)
	} 

	private def generateEReference(EReference eReference) {
		val relation = switch it: eReference {
			case containment && EOpposite === null: '*-down->'
			case containment && EOpposite !== null: '*-down-'
			case container: '-up-*'
			case EOpposite === null: '-down->'
			default: '-down-'
		}
		val eReferenceName = eReference.name.wrapWithMultiplicity(eReference)
		val eOppositeName = eReference.EOpposite?.name.wrapWithMultiplicity(eReference.EOpposite)
		
		'''«eReference.EContainingClass.fqn» «eOppositeName.quote» «relation» «eReferenceName.quote» «eReference.EType.fqn»'''
	}

	private def generateEOperation(EOperation eOperation) {
		val text = '''«eOperation.name»(«FOR eParameter : eOperation.EParameters SEPARATOR ', '»«eParameter.name» : «eParameter.EType?.name»«ENDFOR»)«IF eOperation.EType !== null» : «eOperation.EType.name»«ENDIF»'''
		return text.wrapWithMultiplicity(eOperation)
	} 
	
	private def wrapWithMultiplicity(CharSequence text, ETypedElement eTypedElement) {
		if (eTypedElement === null) {
			return text
		}
		val cardinality = switch it: eTypedElement {
			case EType === null: '      '
			case upperBound < 0: '''[«lowerBound»..*]'''
			default: '''[«lowerBound»..«upperBound»]'''
		}
		val bold = eTypedElement.lowerBound > 0 ? '**' : ''
		
		'''«bold»<font:monospaced>«cardinality»</font> «text»«bold»'''
	}
	
	private def quote(CharSequence text) {
		return if (text !== null) '''"«text»"'''
	}
	
	private def filterOperations(EClass eClass, (ENamedElement)=>boolean predicate) {
		eClass.EOperations.filter(predicate)
	}
	
	private def filterAttributes(EClass eClass, (ENamedElement)=>boolean predicate) {
		// EReferences of which the EType is not visible are visualized as attributes
		eClass.EStructuralFeatures.filter(predicate).reject[ e | e instanceof EReference && eClassifiers.contains(e.EType)]
	}
	
	private def filterReferences(EClass eClass, (ENamedElement)=>boolean predicate) {
		eClass.EReferences.filter(predicate).filter[ e | eClassifiers.contains(e.EType)]
	}
	
	private def filterSuperTypes(EClass eClass) {
		return eClass.ESuperTypes.filter[e | eClassifiers.contains(e)].map[e | Pair::of(eClass, e)]
	}

	private def <R extends EReference, C extends List<R>> C removeEOpposites(C eReferences) {
		for (val eReferencesIterator = eReferences.listIterator(eReferences.size); eReferencesIterator.hasPrevious;) {
			val eReference = eReferencesIterator.previous
		 	if (eReferences.contains(eReference.EOpposite)) {
				eReferencesIterator.remove
			}
		}
		return eReferences
	}
	
	private def String getFqn(EClassifier eClassifier) {
		ePackages.size > 1 ? eClassifier.EPackage.fqn + '.' + eClassifier.name : eClassifier.name
	}

	private def String getFqn(EPackage ePackage) {
		ePackage.ESuperPackage === null ? ePackage.name : ePackage.ESuperPackage.fqn + '.' + ePackage.name
	}
}