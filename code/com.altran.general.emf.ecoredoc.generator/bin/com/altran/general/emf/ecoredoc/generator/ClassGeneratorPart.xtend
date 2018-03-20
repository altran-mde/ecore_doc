package com.altran.general.emf.ecoredoc.generator

import com.google.common.collect.Multimap
import java.util.Collection
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil

class ClassGeneratorPart extends AEcoreDocGeneratorPart {

	new(Multimap<EPackage, EClassifier> packages) {
		super(packages)
	}

	override write(EPackage pack) {
		val eclasses = collectPackageEClasses(pack)

		writeClasses(eclasses)

		return output
	}

	// FIXME: same name as similar methods
	protected def List<EClass> collectPackageEClasses(EPackage pack) {
		this.packages.get(pack).filter(EClass).sortBy[it.name]
	}

	// FIXME: parameter type is list
	protected def writeClasses(Collection<EClass> classes) {
		if (!classes.isEmpty) {
			writeClassesHeader()

			for (eclass : classes) {
				writeEClassHeader(eclass)
				writeEClass(eclass)
			}
		}
	}

	// FIXME: Should read "Types"
	protected def writeClassesHeader() {
		output.append('''=== Classes

			''')
	}

	protected def writeEClassHeader(EClass eclass) {
		val pack = getPackage(eclass)
		output.append(
		'''
			[[«pack.name»-«eclass.name»]]
			==== «IF eclass.isAbstract && !eclass.isInterface»Abstract «ENDIF»«IF eclass.isInterface»Interface«ELSE»Class«ENDIF» «eclass.name»
			
		''')
	}

	// FIXME: AttributesHeader must be omitted if there are no attributes
	protected def writeEClass(EClass eclass) {
		output.append(
		'''
			«getDocumentation(eclass)»
			
			«writeSuperTypes(eclass)»
			«writeAttributesHeader(eclass)»
			
		''')
		writeAttributes(eclass)
	}

	// FIXME: Supertypes must be omitted if empty
	protected def writeSuperTypes(EClass eclass) {
		// FIXME: Why type check? Can never be false
		// FIXME: Supertypes must be sorted
		'''
			.Supertypes
			«FOR supertype : eclass.EAllSuperTypes»
				* <<«IF supertype instanceof EClass»«getPackage(supertype).name»-«supertype.name», «getPackage(supertype).name».«supertype.name»«ENDIF»>>
			«ENDFOR»
			
		'''
	}

	protected def writeAttributesHeader(EClass eclass) {
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

	// FIXME: This is the header of a table in AsciiDoc. Use appropriate method name.
	protected def writeCols() {
		'''[cols="<15m,<15,<15m,<15m,<40a",options="header"]'''
	}

	protected def writeAttributes(EClass eclass) {
		val packageName = getPackage(eclass).name
		for (attr : eclass.EAllAttributes) {
			// FIXME: Use getDocumentation()
			// FIXME: Why use attr.EAttributeType.name? Even twice??
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

}
