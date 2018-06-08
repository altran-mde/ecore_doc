package com.altran.general.emf.ecoredoc.test

import com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator
import java.io.File
import org.apache.commons.io.FileUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup
import org.junit.Test

import static org.junit.Assert.assertEquals

class TestBasic {
	@Test
	def testBasic() {
		val injector = new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration
		
		val resourceSet = injector.getInstance(ResourceSet)
		
		val package1 = resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage1.xcore"), true).contents.filter(EPackage).head
		val package2 = resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage2.ecore"), true).contents.filter(EPackage).head
		
		val input = newLinkedHashSet()
		
		input.addAll(package1.EClassifiers)
		input.addAll(package2.EClassifiers)
		
		val generator = new EcoreDocGenerator(input)
		
		val result = generator.generate()
		
		val expected = FileUtils.readFileToString(new File("testData/generator/basic/expectedOutcome/ecoredoc-example.adoc"))
		
		assertEquals(expected, result.toString)
	}
	
	@Test
	def testNoRepeatInherited() {
		val injector = new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration
		
		val resourceSet = injector.getInstance(ResourceSet)
		
		val package1 = resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage1.xcore"), true).contents.filter(EPackage).head
		val package2 = resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage2.ecore"), true).contents.filter(EPackage).head
		
		val input = newLinkedHashSet()
		
		input.addAll(package1.EClassifiers)
		input.addAll(package2.EClassifiers)
		
		val generator = new EcoreDocGenerator(input)
		
		generator.config.repeatInherited = false
		
		val result = generator.generate()
		
		val expected = FileUtils.readFileToString(new File("testData/generator/basic/expectedOutcomeNoRepeatInherited/ecoredoc-example.adoc"))
		
		assertEquals(expected, result.toString)
	}
	
	@Test
	def testMissingReferences() {
		val injector = new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration
		
		val resourceSet = injector.getInstance(ResourceSet)
		
		val package2 = resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage2.ecore"), true).contents.filter(EPackage).head
		
		val input = newLinkedHashSet()
		
		input.addAll(package2.EClassifiers)
		
		val generator = new EcoreDocGenerator(input)
		
		val result = generator.generate()
		
		val expected = FileUtils.readFileToString(new File("testData/generator/basic/expectedOutcomeMissingReferences/missing-references.adoc"))
		
		assertEquals(expected, result.toString)
	}
	
}