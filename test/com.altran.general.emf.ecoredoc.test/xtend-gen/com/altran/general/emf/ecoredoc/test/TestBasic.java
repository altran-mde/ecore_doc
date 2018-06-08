package com.altran.general.emf.ecoredoc.test;

import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import java.io.File;
import java.util.LinkedHashSet;
import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestBasic {
  @Test
  public void testBasic() {
    try {
      final Injector injector = new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
      final ResourceSet resourceSet = injector.<ResourceSet>getInstance(ResourceSet.class);
      final EPackage package1 = IterableExtensions.<EPackage>head(Iterables.<EPackage>filter(resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage1.xcore"), true).getContents(), EPackage.class));
      final EPackage package2 = IterableExtensions.<EPackage>head(Iterables.<EPackage>filter(resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage2.ecore"), true).getContents(), EPackage.class));
      final LinkedHashSet<EClassifier> input = CollectionLiterals.<EClassifier>newLinkedHashSet();
      input.addAll(package1.getEClassifiers());
      input.addAll(package2.getEClassifiers());
      final EcoreDocGenerator generator = new EcoreDocGenerator(input);
      final CharSequence result = generator.generate();
      File _file = new File("testData/generator/basic/expectedOutcome/ecoredoc-example.adoc");
      final String expected = FileUtils.readFileToString(_file);
      Assert.assertEquals(expected, result.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoRepeatInherited() {
    try {
      final Injector injector = new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
      final ResourceSet resourceSet = injector.<ResourceSet>getInstance(ResourceSet.class);
      final EPackage package1 = IterableExtensions.<EPackage>head(Iterables.<EPackage>filter(resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage1.xcore"), true).getContents(), EPackage.class));
      final EPackage package2 = IterableExtensions.<EPackage>head(Iterables.<EPackage>filter(resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage2.ecore"), true).getContents(), EPackage.class));
      final LinkedHashSet<EClassifier> input = CollectionLiterals.<EClassifier>newLinkedHashSet();
      input.addAll(package1.getEClassifiers());
      input.addAll(package2.getEClassifiers());
      final EcoreDocGenerator generator = new EcoreDocGenerator(input);
      EcoreDocGeneratorConfig _config = generator.getConfig();
      _config.setRepeatInherited(false);
      final CharSequence result = generator.generate();
      File _file = new File("testData/generator/basic/expectedOutcomeNoRepeatInherited/ecoredoc-example.adoc");
      final String expected = FileUtils.readFileToString(_file);
      Assert.assertEquals(expected, result.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDefaults() {
    try {
      final Injector injector = new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
      final ResourceSet resourceSet = injector.<ResourceSet>getInstance(ResourceSet.class);
      final EPackage package1 = IterableExtensions.<EPackage>head(Iterables.<EPackage>filter(resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage1.xcore"), true).getContents(), EPackage.class));
      final EPackage package2 = IterableExtensions.<EPackage>head(Iterables.<EPackage>filter(resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage2.ecore"), true).getContents(), EPackage.class));
      final LinkedHashSet<EClassifier> input = CollectionLiterals.<EClassifier>newLinkedHashSet();
      input.addAll(package1.getEClassifiers());
      input.addAll(package2.getEClassifiers());
      final EcoreDocGenerator generator = new EcoreDocGenerator(input);
      EcoreDocGeneratorConfig _config = generator.getConfig();
      _config.setRenderDefaults(false);
      final CharSequence result = generator.generate();
      File _file = new File("testData/generator/basic/expectedOutcomeNoDefaults/ecoredoc-example.adoc");
      final String expected = FileUtils.readFileToString(_file);
      Assert.assertEquals(expected, result.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoDefaultsButBounds() {
    try {
      final Injector injector = new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
      final ResourceSet resourceSet = injector.<ResourceSet>getInstance(ResourceSet.class);
      final EPackage package1 = IterableExtensions.<EPackage>head(Iterables.<EPackage>filter(resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage1.xcore"), true).getContents(), EPackage.class));
      final EPackage package2 = IterableExtensions.<EPackage>head(Iterables.<EPackage>filter(resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage2.ecore"), true).getContents(), EPackage.class));
      final LinkedHashSet<EClassifier> input = CollectionLiterals.<EClassifier>newLinkedHashSet();
      input.addAll(package1.getEClassifiers());
      input.addAll(package2.getEClassifiers());
      final EcoreDocGenerator generator = new EcoreDocGenerator(input);
      EcoreDocGeneratorConfig _config = generator.getConfig();
      _config.setRenderDefaults(false);
      EcoreDocGeneratorConfig _config_1 = generator.getConfig();
      _config_1.setRenderBounds(true);
      final CharSequence result = generator.generate();
      File _file = new File("testData/generator/basic/expectedOutcomeNoDefaultsButBounds/ecoredoc-example.adoc");
      final String expected = FileUtils.readFileToString(_file);
      Assert.assertEquals(expected, result.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMissingReferences() {
    try {
      final Injector injector = new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
      final ResourceSet resourceSet = injector.<ResourceSet>getInstance(ResourceSet.class);
      final EPackage package2 = IterableExtensions.<EPackage>head(Iterables.<EPackage>filter(resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage2.ecore"), true).getContents(), EPackage.class));
      final LinkedHashSet<EClassifier> input = CollectionLiterals.<EClassifier>newLinkedHashSet();
      input.addAll(package2.getEClassifiers());
      final EcoreDocGenerator generator = new EcoreDocGenerator(input);
      final CharSequence result = generator.generate();
      File _file = new File("testData/generator/basic/expectedOutcomeMissingReferences/missing-references.adoc");
      final String expected = FileUtils.readFileToString(_file);
      Assert.assertEquals(expected, result.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
