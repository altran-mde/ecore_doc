package com.altran.general.emf.ecoredoc.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
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
  private final Multimap<EPackage, EClassifier> ePackages;
  
  private final StringBuilder output = new StringBuilder();
  
  public AEcoreDocGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    this.ePackages = ePackages;
  }
  
  public abstract StringBuilder write(final EPackage ePackage);
  
  protected Multimap<EPackage, EClassifier> getEPackages() {
    return this.ePackages;
  }
  
  protected StringBuilder getOutput() {
    return this.output;
  }
  
  protected EPackage getEPackage(final EClassifier eClassifier) {
    EObject _eContainer = eClassifier.eContainer();
    return ((EPackage) _eContainer);
  }
  
  /**
   * Writes in which classes the given EClassifier is used.
   * Goes through every class and then every attribute and it compare the dataType.name with the attribute type name.
   */
  protected CharSequence writeAnchor(final String... toAnchor) {
    StringConcatenation _builder = new StringConcatenation();
    String anchor = _builder.toString();
    int counter = 0;
    for (final String name : toAnchor) {
      {
        StringConcatenation _builder_1 = new StringConcatenation();
        {
          if ((counter != 0)) {
            _builder_1.append("-");
          }
        }
        String _plus = (anchor + _builder_1);
        String _plus_1 = (_plus + name);
        anchor = _plus_1;
        counter++;
      }
    }
    return anchor;
  }
  
  protected CharSequence writeReference(final String... toReference) {
    StringConcatenation _builder = new StringConcatenation();
    String reference = _builder.toString();
    int counter = 0;
    for (final String name : toReference) {
      {
        StringConcatenation _builder_1 = new StringConcatenation();
        {
          if ((counter != 0)) {
            _builder_1.append(".");
          }
        }
        String _plus = (reference + _builder_1);
        String _plus_1 = (_plus + name);
        reference = _plus_1;
        counter++;
      }
    }
    return reference;
  }
  
  protected CharSequence writeAnchorAndReference(final String... names) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeAnchor = this.writeAnchor(names);
    _builder.append(_writeAnchor);
    _builder.append(", ");
    CharSequence _writeReference = this.writeReference(names);
    _builder.append(_writeReference);
    return _builder;
  }
  
  protected void writeUseCases(final EClassifier target) {
    boolean anyMatch = false;
    final Function1<EClass, Boolean> _function = (EClass it) -> {
      return Boolean.valueOf(Objects.equal(it, target));
    };
    final Iterable<EClass> eClasses = IterableExtensions.<EClass>reject(this.collectAllEClasses(), _function);
    final ArrayList<String> useCaseStrings = CollectionLiterals.<String>newArrayList();
    for (final EClass eClass : eClasses) {
      EList<EStructuralFeature> _eAllStructuralFeatures = eClass.getEAllStructuralFeatures();
      for (final EStructuralFeature feature : _eAllStructuralFeatures) {
        EClassifier _eType = feature.getEType();
        boolean _equals = Objects.equal(_eType, target);
        if (_equals) {
          anyMatch = true;
          EObject _eContainer = eClass.eContainer();
          final String ePackageName = ((EPackage) _eContainer).getName();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("* <<");
          CharSequence _writeAnchorAndReference = this.writeAnchorAndReference(ePackageName, eClass.getName(), feature.getName());
          _builder.append(_writeAnchorAndReference);
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
  
  protected CharSequence _writeEClassifierHeader(final EDataType eDataType) {
    CharSequence _xblockexpression = null;
    {
      final String ePackageName = this.getEPackage(eDataType).getName();
      final String eDataTypeName = eDataType.getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[[");
      CharSequence _writeAnchor = this.writeAnchor(ePackageName, eDataTypeName);
      _builder.append(_writeAnchor);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("==== ");
      String _name = eDataType.getName();
      _builder.append(_name);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _writeEClassifierHeader(final EClass eClass) {
    CharSequence _xblockexpression = null;
    {
      final String ePackageName = this.getEPackage(eClass).getName();
      final String eClassName = eClass.getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[[");
      CharSequence _writeAnchor = this.writeAnchor(ePackageName, eClassName);
      _builder.append(_writeAnchor);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("==== ");
      {
        if ((eClass.isAbstract() && (!eClass.isInterface()))) {
          _builder.append("Abstract ");
        }
      }
      {
        boolean _isInterface = eClass.isInterface();
        if (_isInterface) {
          _builder.append("Interface");
        } else {
          _builder.append("Class");
        }
      }
      _builder.append(" ");
      _builder.append(eClassName);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence writeFooter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|===");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getDocumentation(final EModelElement modelElement) {
    StringConcatenation _builder = new StringConcatenation();
    String _documentation = EcoreUtil.getDocumentation(modelElement);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected String newline() {
    return System.getProperty("line.separator");
  }
  
  protected Collection<EClass> collectAllEClasses() {
    return IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(this.ePackages.values(), EClass.class));
  }
  
  public CharSequence writeEClassifierHeader(final EClassifier eClass) {
    if (eClass instanceof EClass) {
      return _writeEClassifierHeader((EClass)eClass);
    } else if (eClass instanceof EDataType) {
      return _writeEClassifierHeader((EDataType)eClass);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eClass).toString());
    }
  }
}
