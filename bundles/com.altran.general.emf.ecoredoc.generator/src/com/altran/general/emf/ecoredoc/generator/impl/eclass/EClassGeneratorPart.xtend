package com.altran.general.emf.ecoredoc.generator.impl.eclass

import com.altran.general.emf.ecoredoc.generator.config.EClassConfig
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig
import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorEClassifierPart
import com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension
import com.google.common.collect.Multimap
import com.google.inject.Injector
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage

import static com.altran.general.emf.ecoredoc.generator.impl.^extension.EcoreDocExtension.newline

class EClassGeneratorPart extends AEcoreDocGeneratorEClassifierPart {
	val EAttributeGeneratorFragment eAttributeGeneratorFragment
	val EContainmentReferenceGeneratorFragment eContainmentReferenceGeneratorFragment
	val ECrossReferenceReferenceGeneratorFragment eCrossReferenceReferenceGeneratorFragment
	val EOperationGeneratorFragment eOperationGeneratorFragment
	
	new(EcoreDocGeneratorConfig config, Multimap<EPackage, EClassifier> ePackages, Injector xcoreInjector) {
		super(config, ePackages, xcoreInjector)
		
		this.eAttributeGeneratorFragment = new EAttributeGeneratorFragment(this)
		this.eContainmentReferenceGeneratorFragment = new EContainmentReferenceGeneratorFragment(this)
		this.eCrossReferenceReferenceGeneratorFragment = new ECrossReferenceReferenceGeneratorFragment(this)
		this.eOperationGeneratorFragment = new EOperationGeneratorFragment(this)
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
	
	def Set<EClass> collectAllSubTypes(EClass parent) {
		collectAllEClasses
			.filter[EAllSuperTypes.contains(parent)]
			.reject[eClass == parent]
			.toSet
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
		
		writeDiagram(pair)
		
		writeProperties(pair)

		writeSuperTypes(pair)

		writeSubTypes(pair)

		this.eAttributeGeneratorFragment.writeEAttributes(pair)

		this.eContainmentReferenceGeneratorFragment.writeEContainments(pair)

		this.eCrossReferenceReferenceGeneratorFragment.writeECrossReferences(pair)
		
		this.eOperationGeneratorFragment.writeEOperations(pair)

		writeUseCases(pair)
	}

	protected def void writeSubTypes(EClassConfigPair pair) {
		if (!pair.config.shouldRenderSubTypes()) {
			return
		}
		
		var Set<EClass> subTypes = collectAllSubTypes(pair.element)

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
