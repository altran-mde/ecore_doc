package com.altran.general.emf.ecoredoc.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class AEcoreDocGeneratorPart {
  private final Multimap<EPackage, EClassifier> packages;
  
  private final StringBuilder output = new StringBuilder();
  
  public AEcoreDocGeneratorPart(final Multimap<EPackage, EClassifier> packages) {
    this.packages = packages;
  }
  
  public abstract StringBuilder write(final EPackage pack);
  
  protected Multimap<EPackage, EClassifier> getPackages() {
    return this.packages;
  }
  
  protected StringBuilder getOutput() {
    return this.output;
  }
  
  protected EPackage getPackage(final EClassifier eclassifier) {
    EObject _eContainer = eclassifier.eContainer();
    return ((EPackage) _eContainer);
  }
  
  /**
   * Writes in which classes the given EClassifier is used.
   * Goes through every class and then every attribute and it compare the dataType.name with the attribute type name.
   */
  protected void writeUseCases(final EClassifier target) {
    boolean anyMatch = false;
    final Function1<EClass, Boolean> _function = (EClass it) -> {
      return Boolean.valueOf(Objects.equal(it, target));
    };
    final Iterable<EClass> eclasses = IterableExtensions.<EClass>reject(this.collectAllEClasses(), _function);
    final ArrayList<String> useCaseStrings = CollectionLiterals.<String>newArrayList();
    for (final EClass eclass : eclasses) {
      EList<EStructuralFeature> _eAllStructuralFeatures = eclass.getEAllStructuralFeatures();
      for (final EStructuralFeature feature : _eAllStructuralFeatures) {
        EClassifier _eType = feature.getEType();
        boolean _equals = Objects.equal(_eType, target);
        if (_equals) {
          anyMatch = true;
          EObject _eContainer = eclass.eContainer();
          final String packageName = ((EPackage) _eContainer).getName();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("* <<");
          _builder.append(packageName);
          _builder.append("-");
          String _name = eclass.getName();
          _builder.append(_name);
          _builder.append("-");
          String _name_1 = feature.getName();
          _builder.append(_name_1);
          _builder.append(", ");
          _builder.append(packageName);
          _builder.append(".");
          String _name_2 = eclass.getName();
          _builder.append(_name_2);
          _builder.append(".");
          String _name_3 = feature.getName();
          _builder.append(_name_3);
          _builder.append(">>");
          _builder.newLineIfNotEmpty();
          useCaseStrings.add(_builder.toString());
        }
      }
    }
    if (anyMatch) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(".Used at");
      _builder_1.newLine();
      this.output.append(_builder_1);
      List<String> _sort = IterableExtensions.<String>sort(useCaseStrings);
      for (final String useCaseString : _sort) {
        this.output.append(useCaseString);
      }
      this.output.append(this.newline());
    }
  }
  
  protected StringBuilder writeBlockClosure() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|===");
    _builder.newLine();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  protected String getDocumentation(final EClassifier eclassifier) {
    return EcoreUtil.getDocumentation(eclassifier);
  }
  
  protected String newline() {
    return System.getProperty("line.separator");
  }
  
  protected Collection<EClass> collectAllEClasses() {
    return IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(this.packages.values(), EClass.class));
  }
}
