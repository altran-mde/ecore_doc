package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EClassGeneratorPart extends AEcoreDocGeneratorPart {
  public EClassGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    super(ePackages);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    final List<EClass> eClasses = this.collectEClasses(ePackage);
    this.writeEClasses(eClasses);
    return this.getOutput();
  }
  
  protected List<EClass> collectEClasses(final EPackage ePackages) {
    final Function1<EClass, String> _function = (EClass it) -> {
      return it.getName();
    };
    return IterableExtensions.<EClass, String>sortBy(Iterables.<EClass>filter(this.getEPackages().get(ePackages), EClass.class), _function);
  }
  
  protected void writeEClasses(final List<EClass> eClasses) {
    boolean _isEmpty = eClasses.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEClassesHeader();
      for (final EClass eClass : eClasses) {
        this.writeEClass(eClass);
      }
    }
  }
  
  protected StringBuilder writeEClassesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Types");
    _builder.newLine();
    String _newline = this.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    return _output.append(_builder);
  }
  
  protected void writeEClass(final EClass eClass) {
    this.writeEClassHeader(eClass);
    this.writeSuperTypes(eClass);
    this.writeSubConcepts(eClass);
    boolean _isEmpty = eClass.getEAllAttributes().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEAttributesHeader();
      this.writeEStructuralFeatures(eClass.getEAllAttributes(), eClass, false);
    }
    boolean _isEmpty_1 = eClass.getEAllReferences().isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      boolean _isEmpty_2 = eClass.eCrossReferences().isEmpty();
      boolean _not_2 = (!_isEmpty_2);
      if (_not_2) {
        this.writeEReferencesHeader();
        this.writeEStructuralFeatures(eClass.getEAllReferences(), eClass, true);
      }
      EList<EReference> _eAllReferences = eClass.getEAllReferences();
      for (final EReference eReference : _eAllReferences) {
        boolean _isContainment = eReference.isContainment();
        if (_isContainment) {
          this.writeEContainmentHeader();
        }
      }
      final Function1<EReference, Boolean> _function = (EReference it) -> {
        return Boolean.valueOf(it.isContainment());
      };
      boolean _exists = IterableExtensions.<EReference>exists(eClass.getEAllReferences(), _function);
      if (_exists) {
        this.writeEContainmentHeader();
      }
    }
    this.concatUseCases(eClass);
  }
  
  protected StringBuilder writeEContainmentHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".Containments");
    _builder.newLine();
    _builder.append("[cols=\"<15m,<15,<15m,<15m,<40a\",options=\"header\"]");
    _builder.newLine();
    _builder.append("|===");
    _builder.newLine();
    _builder.append("|Name");
    _builder.newLine();
    _builder.append("|Type");
    _builder.newLine();
    _builder.append("|Multiplicity{nbsp}/ Order");
    _builder.newLine();
    _builder.append("|Opposite");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    String _newline = this.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeSubConcepts(final EClass currentEClass) {
    StringBuilder _xblockexpression = null;
    {
      Set<EClass> eClassesThatInheritCurrent = CollectionLiterals.<EClass>newLinkedHashSet();
      final Function1<EClass, Boolean> _function = (EClass it) -> {
        EClass _eClass = it.eClass();
        return Boolean.valueOf(Objects.equal(_eClass, currentEClass));
      };
      Iterable<EClass> _reject = IterableExtensions.<EClass>reject(this.collectAllEClasses(), _function);
      for (final EClass eClass : _reject) {
        boolean _contains = eClass.getEAllSuperTypes().contains(currentEClass);
        if (_contains) {
          eClassesThatInheritCurrent.add(eClass);
        }
      }
      boolean _isEmpty = eClassesThatInheritCurrent.isEmpty();
      boolean subConceptExists = (!_isEmpty);
      if (subConceptExists) {
        this.writeSubConceptsHeader();
      }
      for (final EClass eClass_1 : eClassesThatInheritCurrent) {
        this.writeSubConcept(eClass_1);
      }
      StringBuilder _xifexpression = null;
      if (subConceptExists) {
        _xifexpression = this.getOutput().append(this.newline());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeSubConcept(final EClass eClass) {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("* ");
    CharSequence _concatLinkTo = this.concatLinkTo(eClass);
    _builder.append(_concatLinkTo);
    _builder.newLineIfNotEmpty();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeSuperTypes(final EClass eClass) {
    StringBuilder _xifexpression = null;
    boolean _isEmpty = eClass.getEAllSuperTypes().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      String _newline = this.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _builder.append(".Supertypes");
      _builder.newLine();
      {
        final Function1<EClass, String> _function = (EClass it) -> {
          return it.getName();
        };
        List<EClass> _sortBy = IterableExtensions.<EClass, String>sortBy(eClass.getEAllSuperTypes(), _function);
        for(final EClass supertype : _sortBy) {
          _builder.append("* ");
          CharSequence _concatLinkTo = this.concatLinkTo(supertype);
          _builder.append(_concatLinkTo);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _xifexpression = _output.append(_builder);
    } else {
      _xifexpression = this.getOutput().append(this.newline());
    }
    return _xifexpression;
  }
  
  protected StringBuilder writeEAttributesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".Attributes");
    _builder.newLine();
    CharSequence _tableHeader = this.tableHeader();
    _builder.append(_tableHeader);
    _builder.newLineIfNotEmpty();
    _builder.append("|===");
    _builder.newLine();
    _builder.append("|Name");
    _builder.newLine();
    _builder.append("|Type");
    _builder.newLine();
    _builder.append("|Multiplicity{nbsp}/ Order");
    _builder.newLine();
    _builder.append("|Default Value");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    String _newline = this.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    return _output.append(_builder);
  }
  
  protected CharSequence tableHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[cols=\"<15m,<15,<15m,<15m,<40a\",options=\"header\"]");
    return _builder;
  }
  
  protected StringBuilder writeEStructuralFeatures(final List<? extends EStructuralFeature> eStructuralFeatures, final EClass eClass, final boolean isEReference) {
    StringBuilder _xblockexpression = null;
    {
      final Set<EStructuralFeature> inheritedStructuralFeatures = CollectionLiterals.<EStructuralFeature>newLinkedHashSet();
      EList<EClass> _eAllSuperTypes = eClass.getEAllSuperTypes();
      for (final EClass superclass : _eAllSuperTypes) {
        if (isEReference) {
          inheritedStructuralFeatures.addAll(superclass.getEAllReferences());
        } else {
          inheritedStructuralFeatures.addAll(superclass.getEAllAttributes());
        }
      }
      final Function1<EStructuralFeature, String> _function = (EStructuralFeature it) -> {
        return it.getName();
      };
      List<? extends EStructuralFeature> _sortBy = IterableExtensions.sortBy(eStructuralFeatures, _function);
      for (final EStructuralFeature eStructuralFeature : _sortBy) {
        boolean _contains = inheritedStructuralFeatures.contains(eStructuralFeature);
        boolean _not = (!_contains);
        if (_not) {
          this.writeRow(eStructuralFeature, eClass);
        }
      }
      final Function1<EStructuralFeature, String> _function_1 = (EStructuralFeature it) -> {
        return it.getName();
      };
      List<EStructuralFeature> _sortBy_1 = IterableExtensions.<EStructuralFeature, String>sortBy(inheritedStructuralFeatures, _function_1);
      for (final EStructuralFeature eStructuralFeature_1 : _sortBy_1) {
        this.writeRow(eStructuralFeature_1, eClass);
      }
      _xblockexpression = this.getOutput().append(this.tableFooter());
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeRow(final EStructuralFeature eStructuralFeature, final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      EObject _eContainer = eStructuralFeature.eContainer();
      final EClass eStructuralFeatureClass = ((EClass) _eContainer);
      final boolean isInherited = (!Objects.equal(eClass, eStructuralFeatureClass));
      final int lowerBound = eStructuralFeature.getLowerBound();
      final int upperBound = eStructuralFeature.getUpperBound();
      final String eStructuralFeatureName = eStructuralFeature.getName();
      final String[] inheritedFeatureSegments = this.collectInheritedFeatureSegments(eStructuralFeature, eClass);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|");
      _builder.append(eStructuralFeatureName);
      _builder.append("[[");
      String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(inheritedFeatureSegments)), this.getAnchorSeparator());
      _builder.append(_join);
      _builder.append("]]");
      {
        if (isInherited) {
          _builder.append(" +");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        if (isInherited) {
          CharSequence _concatInheritedEStructuralElementType = this.concatInheritedEStructuralElementType(eStructuralFeature);
          _builder.append(_concatInheritedEStructuralElementType);
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _concatLinkTo = this.concatLinkTo(eStructuralFeature.getEType());
      _builder.append(_concatLinkTo);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _concatBounds = this.concatBounds(lowerBound, upperBound);
      _builder.append(_concatBounds);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _dispatchEStructuralFeature = this.dispatchEStructuralFeature(eStructuralFeature);
      _builder.append(_dispatchEStructuralFeature);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _documentation = this.getDocumentation(eStructuralFeature);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      String _newline = this.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected CharSequence _dispatchEStructuralFeature(final EAttribute eAttribute) {
    CharSequence _xifexpression = null;
    if (((!Objects.equal(eAttribute.getDefaultValue(), Integer.valueOf(0))) && (eAttribute.getDefaultValue() != null))) {
      CharSequence _xblockexpression = null;
      {
        final Object eAttributeDefaultvalue = eAttribute.getDefaultValue();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<<");
        CharSequence _concatAnchor = this.concatAnchor(eAttribute.getEAttributeType());
        _builder.append(_concatAnchor);
        String _anchorSeparator = this.getAnchorSeparator();
        _builder.append(_anchorSeparator);
        _builder.append(eAttributeDefaultvalue);
        _builder.append(", ");
        _builder.append(eAttributeDefaultvalue);
        _builder.append(">>");
        _xblockexpression = _builder;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected CharSequence _dispatchEStructuralFeature(final EReference eReference) {
    CharSequence _xifexpression = null;
    EReference _eOpposite = eReference.getEOpposite();
    boolean _tripleNotEquals = (_eOpposite != null);
    if (_tripleNotEquals) {
      _xifexpression = this.concatOpposite(eReference);
    }
    return _xifexpression;
  }
  
  protected CharSequence concatInheritedEStructuralElementType(final ENamedElement eNamedElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(<<");
    CharSequence _concatAnchor = this.concatAnchor(eNamedElement);
    _builder.append(_concatAnchor);
    _builder.append(", {inherited}");
    EObject _eContainer = eNamedElement.eContainer();
    CharSequence _concatReferenceName = this.concatReferenceName(((EClass) _eContainer));
    _builder.append(_concatReferenceName);
    _builder.append(">>)");
    return _builder;
  }
  
  protected CharSequence concatBounds(final int lowerBound, final int upperBound) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(lowerBound);
    {
      if ((lowerBound != upperBound)) {
        _builder.append("..");
        CharSequence _writeUpperBound = this.writeUpperBound(upperBound);
        _builder.append(_writeUpperBound);
      }
    }
    return _builder;
  }
  
  protected CharSequence writeUpperBound(final int upperBound) {
    CharSequence _xifexpression = null;
    if ((upperBound == (-1))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("*{nbsp}/ unordered");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(upperBound);
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  protected CharSequence concatOpposite(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final String eOppositeName = eReference.getEOpposite().getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<<");
      CharSequence _concatAnchor = this.concatAnchor(eReference.getEReferenceType());
      _builder.append(_concatAnchor);
      String _anchorSeparator = this.getAnchorSeparator();
      _builder.append(_anchorSeparator);
      _builder.append(eOppositeName);
      _builder.append(", ");
      _builder.append(eOppositeName);
      _builder.append(">>");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeEReferencesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".References");
    _builder.newLine();
    _builder.append("[cols=\"<15m,<15,<15m,<15m,<40a\",options=\"header\"]");
    _builder.newLine();
    _builder.append("|===");
    _builder.newLine();
    _builder.append("|Name");
    _builder.newLine();
    _builder.append("|Type");
    _builder.newLine();
    _builder.append("|Multiplicity{nbsp}/ Order");
    _builder.newLine();
    _builder.append("|Opposite");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    String _newline = this.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    return _output.append(_builder);
  }
  
  protected CharSequence writeEClassHeader(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      final String eClassName = eClass.getName();
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[[");
      CharSequence _concatAnchor = this.concatAnchor(eClass);
      _builder.append(_concatAnchor);
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
      String _newline = this.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      CharSequence _documentation = this.getDocumentation(eClass);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected CharSequence dispatchEStructuralFeature(final EStructuralFeature eAttribute) {
    if (eAttribute instanceof EAttribute) {
      return _dispatchEStructuralFeature((EAttribute)eAttribute);
    } else if (eAttribute instanceof EReference) {
      return _dispatchEStructuralFeature((EReference)eAttribute);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eAttribute).toString());
    }
  }
}
