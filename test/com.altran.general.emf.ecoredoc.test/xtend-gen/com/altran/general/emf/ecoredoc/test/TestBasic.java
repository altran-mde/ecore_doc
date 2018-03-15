package com.altran.general.emf.ecoredoc.test;

import com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator;
import com.google.common.collect.Iterators;
import com.google.inject.Injector;
import java.io.File;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xcore.XcoreStandaloneSetup;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestBasic {
  @Test
  public void testBasic() {
    try {
      final Injector injector = new XcoreStandaloneSetup().createInjectorAndDoEMFRegistration();
      final ResourceSet resourceSet = injector.<ResourceSet>getInstance(ResourceSet.class);
      resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage1.xcore"), true);
      resourceSet.getResource(URI.createURI("testData/generator/basic/EPackage2.ecore"), true);
      final Set<EClassifier> input = IteratorExtensions.<EClassifier>toSet(Iterators.<EClassifier>filter(resourceSet.getAllContents(), EClassifier.class));
      final EcoreDocGenerator generator = new EcoreDocGenerator(input);
      final CharSequence result = generator.generate();
      File _file = new File("testData/generator/basic/expectedOutcome/ecoredoc-example.adoc");
      final String expected = FileUtils.readFileToString(_file);
      Assert.assertEquals(expected, result.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
