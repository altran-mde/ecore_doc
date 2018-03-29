package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorPart;
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
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
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
    this.clearOutput();
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
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("=== Types");
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected void writeEClass(final EClass eClass) {
    this.writeEClassHeader(eClass);
    this.writeSuperTypes(eClass);
    this.writeSubTypes(eClass);
    this.writeEAttributes(eClass);
    this.writeEContainments(eClass);
    this.writeECrossReferences(eClass);
    this.writeUseCases(eClass);
  }
  
  protected StringBuilder writeEContainments(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      final Function1<EReference, Boolean> _function = (EReference it) -> {
        return Boolean.valueOf(it.isContainment());
      };
      final boolean containmentExists = IterableExtensions.<EReference>exists(eClass.getEAllReferences(), _function);
      StringBuilder _xifexpression = null;
      if (containmentExists) {
        StringBuilder _xblockexpression_1 = null;
        {
          this.writeEContainmentHeader();
          List<EReference> eContainments = this.collectEContainments(eClass);
          Set<? extends EStructuralFeature> inheritedEContainments = this.collectInheritedEContainments(eClass);
          _xblockexpression_1 = this.writeEStructuralFeatures(eContainments, eClass, inheritedEContainments);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeECrossReferences(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      final Function1<EReference, Boolean> _function = (EReference it) -> {
        boolean _isContainment = it.isContainment();
        return Boolean.valueOf((!_isContainment));
      };
      final boolean eCrossReferenceExists = IterableExtensions.<EReference>exists(eClass.getEAllReferences(), _function);
      StringBuilder _xifexpression = null;
      if (eCrossReferenceExists) {
        StringBuilder _xblockexpression_1 = null;
        {
          this.writeEReferencesHeader();
          List<EReference> crossReferences = this.collectECrossReferences(eClass);
          Set<? extends EStructuralFeature> inheritedECrossReferences = this.collectInheritedECrossReferences(eClass);
          _xblockexpression_1 = this.writeEStructuralFeatures(crossReferences, eClass, inheritedECrossReferences);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeEAttributes(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      boolean _isEmpty = eClass.getEAllAttributes().isEmpty();
      final boolean eAttributeExists = (!_isEmpty);
      StringBuilder _xifexpression = null;
      if (eAttributeExists) {
        StringBuilder _xblockexpression_1 = null;
        {
          this.writeEAttributesHeader();
          Set<EStructuralFeature> inheritedEAttributes = this.collectInheritedEAttributes(eClass);
          _xblockexpression_1 = this.writeEStructuralFeatures(eClass.getEAttributes(), eClass, inheritedEAttributes);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeEContainmentHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
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
    return _output.append(_builder);
  }
  
  protected void writeSubTypes(final EClass currentEClass) {
    Set<EClass> subTypes = CollectionLiterals.<EClass>newLinkedHashSet();
    final Function1<EClass, Boolean> _function = (EClass it) -> {
      EClass _eClass = it.eClass();
      return Boolean.valueOf(Objects.equal(_eClass, currentEClass));
    };
    Iterable<EClass> _reject = IterableExtensions.<EClass>reject(this.collectAllEClasses(), _function);
    for (final EClass eClass : _reject) {
      boolean _contains = eClass.getEAllSuperTypes().contains(currentEClass);
      if (_contains) {
        subTypes.add(eClass);
      }
    }
    boolean _isEmpty = subTypes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeSubTypesHeader();
      for (final EClass eClass_1 : subTypes) {
        this.writeType(eClass_1);
      }
    }
  }
  
  protected void writeSuperTypes(final EClass eClass) {
    boolean _isEmpty = eClass.getEAllSuperTypes().isEmpty();
    final boolean superTypesExist = (!_isEmpty);
    if (superTypesExist) {
      this.writeSuperTypesHeader();
      final Function1<EClass, String> _function = (EClass it) -> {
        return it.getName();
      };
      List<EClass> _sortBy = IterableExtensions.<EClass, String>sortBy(eClass.getEAllSuperTypes(), _function);
      for (final EClass supertype : _sortBy) {
        this.writeType(supertype);
      }
    }
  }
  
  protected StringBuilder writeType(final EClass eClass) {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("* ");
    CharSequence _concatLinkTo = this.concatLinkTo(eClass);
    _builder.append(_concatLinkTo);
    _builder.newLineIfNotEmpty();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeSubTypesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Sub-types");
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeSuperTypesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Super-types");
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeEAttributesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
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
    return _output.append(_builder);
  }
  
  protected CharSequence tableHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[cols=\"<15m,<15,<15m,<15m,<40a\",options=\"header\"]");
    return _builder;
  }
  
  protected List<EReference> collectEContainments(final EClass eClass) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      return Boolean.valueOf(it.isContainment());
    };
    return IterableExtensions.<EReference>toList(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function));
  }
  
  protected Set<? extends EStructuralFeature> collectInheritedEContainments(final EClass eClass) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      return Boolean.valueOf(it.isContainment());
    };
    final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
      return Boolean.valueOf(eClass.getEReferences().contains(it));
    };
    return IterableExtensions.<EReference>toSet(IterableExtensions.<EReference>reject(IterableExtensions.<EReference>filter(eClass.getEAllReferences(), _function), _function_1));
  }
  
  protected List<EReference> collectECrossReferences(final EClass eClass) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      boolean _isContainment = it.isContainment();
      return Boolean.valueOf((!_isContainment));
    };
    return IterableExtensions.<EReference>toList(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function));
  }
  
  protected Set<? extends EStructuralFeature> collectInheritedECrossReferences(final EClass eClass) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      boolean _isContainment = it.isContainment();
      return Boolean.valueOf((!_isContainment));
    };
    final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
      return Boolean.valueOf(eClass.getEReferences().contains(it));
    };
    return IterableExtensions.<EReference>toSet(IterableExtensions.<EReference>reject(IterableExtensions.<EReference>filter(eClass.getEAllReferences(), _function), _function_1));
  }
  
  protected Set<EStructuralFeature> collectInheritedEAttributes(final EClass eClass) {
    final Set<EStructuralFeature> inheritedEAttributes = CollectionLiterals.<EStructuralFeature>newLinkedHashSet();
    EList<EClass> _eAllSuperTypes = eClass.getEAllSuperTypes();
    for (final EClass superclass : _eAllSuperTypes) {
      inheritedEAttributes.addAll(superclass.getEAllAttributes());
    }
    return inheritedEAttributes;
  }
  
  protected StringBuilder writeEStructuralFeatures(final List<? extends EStructuralFeature> eStructuralFeatures, final EClass eClass, final Set<? extends EStructuralFeature> inheritedStructuralFeatures) {
    StringBuilder _xblockexpression = null;
    {
      final Function1<EStructuralFeature, String> _function = (EStructuralFeature it) -> {
        return it.getName();
      };
      List<? extends EStructuralFeature> _sortBy = IterableExtensions.sortBy(eStructuralFeatures, _function);
      for (final EStructuralFeature eStructuralFeature : _sortBy) {
        this.writeRow(eStructuralFeature, eClass);
      }
      final Function1<EStructuralFeature, String> _function_1 = (EStructuralFeature it) -> {
        return it.getName();
      };
      List<? extends EStructuralFeature> _sortBy_1 = IterableExtensions.sortBy(inheritedStructuralFeatures, _function_1);
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
      final String eStructuralFeatureName = eStructuralFeature.getName();
      final String[] inheritedFeatureSegments = this.collectInheritedFeatureSegments(eStructuralFeature, eClass);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      String _newline = this._ecoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      _builder.append(eStructuralFeatureName);
      _builder.append("[[");
      String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(inheritedFeatureSegments)), AEcoreDocGeneratorPart.ANCHOR_SEPARATOR);
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
          CharSequence _concatInheritedElement = this.concatInheritedElement(eStructuralFeature);
          _builder.append(_concatInheritedElement);
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _concatLinkTo = this.concatLinkTo(eStructuralFeature.getEType());
      _builder.append(_concatLinkTo);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _concatBounds = this.concatBounds(eStructuralFeature);
      _builder.append(_concatBounds);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _writeOppositeOrDefaultValue = this.writeOppositeOrDefaultValue(eStructuralFeature);
      _builder.append(_writeOppositeOrDefaultValue);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eStructuralFeature);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected CharSequence _writeOppositeOrDefaultValue(final EAttribute eAttribute) {
    CharSequence _xblockexpression = null;
    {
      final Object defaultValue = eAttribute.getDefaultValue();
      CharSequence _xifexpression = null;
      boolean _eIsSet = eAttribute.eIsSet(EcorePackage.eINSTANCE.getEStructuralFeature_DefaultValueLiteral());
      if (_eIsSet) {
        CharSequence _xifexpression_1 = null;
        if ((defaultValue instanceof EEnumLiteral)) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("<<");
          CharSequence _concatAnchor = this.concatAnchor(eAttribute.getEAttributeType());
          _builder.append(_concatAnchor);
          _builder.append(AEcoreDocGeneratorPart.ANCHOR_SEPARATOR);
          _builder.append(((EEnumLiteral)defaultValue));
          _builder.append(", ");
          _builder.append(((EEnumLiteral)defaultValue));
          _builder.append(">>");
          _xifexpression_1 = _builder;
        } else {
          CharSequence _xifexpression_2 = null;
          if ((defaultValue instanceof String)) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("\"");
            _builder_1.append(((String)defaultValue));
            _builder_1.append("\"");
            _xifexpression_2 = _builder_1;
          } else {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append(defaultValue);
            _xifexpression_2 = _builder_2;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _writeOppositeOrDefaultValue(final EReference eReference) {
    CharSequence _xifexpression = null;
    EReference _eOpposite = eReference.getEOpposite();
    boolean _tripleNotEquals = (_eOpposite != null);
    if (_tripleNotEquals) {
      _xifexpression = this.concatOpposite(eReference);
    }
    return _xifexpression;
  }
  
  protected CharSequence concatInheritedElement(final ENamedElement eNamedElement) {
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
  
  protected CharSequence concatBounds(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final int lowerBound = eStructuralFeature.getLowerBound();
      final int upperBound = eStructuralFeature.getUpperBound();
      final boolean ordered = eStructuralFeature.isOrdered();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(lowerBound);
      {
        if ((lowerBound != upperBound)) {
          _builder.append("..");
          Object _defineUpperBound = this.defineUpperBound(upperBound);
          _builder.append(_defineUpperBound);
          {
            if (((upperBound == (-1)) || (upperBound > 1))) {
              CharSequence _defineOrdered = this.defineOrdered(ordered);
              _builder.append(_defineOrdered);
            }
          }
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected Object defineUpperBound(final int upperBound) {
    Object _xifexpression = null;
    if ((upperBound == (-1))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("*{nbsp}");
      _xifexpression = _builder;
    } else {
      _xifexpression = Integer.valueOf(upperBound);
    }
    return _xifexpression;
  }
  
  protected CharSequence defineOrdered(final boolean ordered) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/ ");
    {
      if (ordered) {
        _builder.append("ordered");
      } else {
        _builder.append("unordered");
      }
    }
    return _builder;
  }
  
  protected CharSequence concatOpposite(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final String eOppositeName = eReference.getEOpposite().getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<<");
      CharSequence _concatAnchor = this.concatAnchor(eReference.getEReferenceType());
      _builder.append(_concatAnchor);
      _builder.append(AEcoreDocGeneratorPart.ANCHOR_SEPARATOR);
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
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
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
    return _output.append(_builder);
  }
  
  protected CharSequence writeEClassHeader(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      final String eClassName = eClass.getName();
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      String _newline = this._ecoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
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
      String _newline_1 = this._ecoreDocExtension.newline();
      _builder.append(_newline_1);
      _builder.newLineIfNotEmpty();
      CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eClass);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected CharSequence writeOppositeOrDefaultValue(final EStructuralFeature eAttribute) {
    if (eAttribute instanceof EAttribute) {
      return _writeOppositeOrDefaultValue((EAttribute)eAttribute);
    } else if (eAttribute instanceof EReference) {
      return _writeOppositeOrDefaultValue((EReference)eAttribute);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eAttribute).toString());
    }
  }
}
