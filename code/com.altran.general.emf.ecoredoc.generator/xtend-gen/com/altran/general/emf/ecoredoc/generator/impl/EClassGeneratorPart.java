package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EStructuralFeaturePropertyHelper;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.Arrays;
import java.util.Collections;
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
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EClassGeneratorPart extends AEcoreDocGeneratorPart {
  @Extension
  private EStructuralFeaturePropertyHelper _eStructuralFeaturePropertyHelper = new EStructuralFeaturePropertyHelper();
  
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
  
  protected void writeEClassesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("=== Types");
    _builder.newLine();
    _output.append(_builder);
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
  
  protected void writeEContainments(final EClass eClass) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      return Boolean.valueOf(it.isContainment());
    };
    final boolean containmentExists = IterableExtensions.<EReference>exists(eClass.getEAllReferences(), _function);
    if (containmentExists) {
      this.writeEContainmentHeader();
      List<EReference> eContainments = this.collectEContainments(eClass);
      Set<? extends EStructuralFeature> inheritedEContainments = this.collectInheritedEContainments(eClass);
      this.writeEStructuralFeatures(eContainments, eClass, inheritedEContainments);
    }
  }
  
  protected void writeECrossReferences(final EClass eClass) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      boolean _isContainment = it.isContainment();
      return Boolean.valueOf((!_isContainment));
    };
    final boolean eCrossReferenceExists = IterableExtensions.<EReference>exists(eClass.getEAllReferences(), _function);
    if (eCrossReferenceExists) {
      this.writeEReferencesHeader();
      List<EReference> crossReferences = this.collectECrossReferences(eClass);
      Set<? extends EStructuralFeature> inheritedECrossReferences = this.collectInheritedECrossReferences(eClass);
      this.writeEStructuralFeatures(crossReferences, eClass, inheritedECrossReferences);
    }
  }
  
  protected void writeEAttributes(final EClass eClass) {
    boolean _isEmpty = eClass.getEAllAttributes().isEmpty();
    final boolean eAttributeExists = (!_isEmpty);
    if (eAttributeExists) {
      this.writeEAttributesHeader();
      Set<EStructuralFeature> inheritedEAttributes = this.collectInheritedEAttributes(eClass);
      this.writeEStructuralFeatures(eClass.getEAttributes(), eClass, inheritedEAttributes);
    }
  }
  
  protected void writeEContainmentHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Containments");
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
    _builder.append("|Properties");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    _output.append(_builder);
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
  
  protected void writeType(final EClass eClass) {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("* ");
    CharSequence _concatLinkTo = this.concatLinkTo(eClass);
    _builder.append(_concatLinkTo);
    _builder.newLineIfNotEmpty();
    _output.append(_builder);
  }
  
  protected void writeSubTypesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Sub-types");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected void writeSuperTypesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Super-types");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected void writeEAttributesHeader() {
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
    _builder.append("|Properties");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected CharSequence tableHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[cols=\"<20,<20,<20,<40a\",options=\"header\"]");
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
  
  protected void writeEStructuralFeatures(final List<? extends EStructuralFeature> eStructuralFeatures, final EClass eClass, final Set<? extends EStructuralFeature> inheritedStructuralFeatures) {
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
    this.getOutput().append(this.tableFooter());
  }
  
  protected void writeRow(final EStructuralFeature eStructuralFeature, final EClass eClass) {
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
    String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(inheritedFeatureSegments)), EcoreDocExtension.ANCHOR_SEPARATOR);
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
    CharSequence _concatFeatureType = this.concatFeatureType(eStructuralFeature);
    _builder.append(_concatFeatureType);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    CharSequence _concatFeatureProperties = this.concatFeatureProperties(eStructuralFeature);
    _builder.append(_concatFeatureProperties);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eStructuralFeature);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    _output.append(_builder);
  }
  
  protected CharSequence _concatFeatureProperties(final EReference eReference) {
    CharSequence _concatBounds = this._eStructuralFeaturePropertyHelper.concatBounds(eReference);
    CharSequence _defineOrdered = this._eStructuralFeaturePropertyHelper.defineOrdered(eReference);
    CharSequence _defineChangeable = this._eStructuralFeaturePropertyHelper.defineChangeable(eReference);
    CharSequence _defineDerived = this._eStructuralFeaturePropertyHelper.defineDerived(eReference);
    CharSequence _defineTransient = this._eStructuralFeaturePropertyHelper.defineTransient(eReference);
    CharSequence _defineUnique = this._eStructuralFeaturePropertyHelper.defineUnique(eReference);
    CharSequence _defineUnsettable = this._eStructuralFeaturePropertyHelper.defineUnsettable(eReference);
    CharSequence _defineVolatile = this._eStructuralFeaturePropertyHelper.defineVolatile(eReference);
    final Function1<CharSequence, Boolean> _function = (CharSequence it) -> {
      return Boolean.valueOf((it != null));
    };
    return IterableExtensions.join(IterableExtensions.<CharSequence>filter(Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_concatBounds, _defineOrdered, _defineChangeable, _defineDerived, _defineTransient, _defineUnique, _defineUnsettable, _defineVolatile)), _function));
  }
  
  protected CharSequence _concatFeatureProperties(final EAttribute eAttribute) {
    CharSequence _defineId = this._eStructuralFeaturePropertyHelper.defineId(eAttribute);
    CharSequence _concatBounds = this._eStructuralFeaturePropertyHelper.concatBounds(eAttribute);
    CharSequence _concatDefaultValue = this._eStructuralFeaturePropertyHelper.concatDefaultValue(eAttribute);
    CharSequence _defineOrdered = this._eStructuralFeaturePropertyHelper.defineOrdered(eAttribute);
    CharSequence _defineChangeable = this._eStructuralFeaturePropertyHelper.defineChangeable(eAttribute);
    CharSequence _defineDerived = this._eStructuralFeaturePropertyHelper.defineDerived(eAttribute);
    CharSequence _defineTransient = this._eStructuralFeaturePropertyHelper.defineTransient(eAttribute);
    CharSequence _defineUnique = this._eStructuralFeaturePropertyHelper.defineUnique(eAttribute);
    CharSequence _defineUnsettable = this._eStructuralFeaturePropertyHelper.defineUnsettable(eAttribute);
    CharSequence _defineVolatile = this._eStructuralFeaturePropertyHelper.defineVolatile(eAttribute);
    final Function1<CharSequence, Boolean> _function = (CharSequence it) -> {
      return Boolean.valueOf((it != null));
    };
    return IterableExtensions.join(IterableExtensions.<CharSequence>filter(Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineId, _concatBounds, _concatDefaultValue, _defineOrdered, _defineChangeable, _defineDerived, _defineTransient, _defineUnique, _defineUnsettable, _defineVolatile)), _function));
  }
  
  protected CharSequence _concatFeatureType(final EReference eReference) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _concatLinkTo = this.concatLinkTo(eReference.getEType());
    _builder.append(_concatLinkTo);
    _builder.newLineIfNotEmpty();
    CharSequence _opposite = this.getOpposite(eReference);
    _builder.append(_opposite);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _concatFeatureType(final EAttribute eAttribute) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _concatLinkTo = this.concatLinkTo(eAttribute.getEType());
    _builder.append(_concatLinkTo);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence getOpposite(final EReference eReference) {
    CharSequence _xifexpression = null;
    EReference _eOpposite = eReference.getEOpposite();
    boolean _tripleNotEquals = (_eOpposite != null);
    if (_tripleNotEquals) {
      CharSequence _xblockexpression = null;
      {
        final String eOppositeName = eReference.getEOpposite().getName();
        StringConcatenation _builder = new StringConcatenation();
        String _newline = this._ecoreDocExtension.newline();
        _builder.append(_newline);
        _builder.newLineIfNotEmpty();
        _builder.append("_opposite_ <<");
        CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eReference.getEReferenceType());
        _builder.append(_concatAnchor);
        _builder.append(EcoreDocExtension.ANCHOR_SEPARATOR);
        _builder.append(eOppositeName);
        _builder.append(", ");
        _builder.append(eOppositeName);
        _builder.append(">>");
        _builder.newLineIfNotEmpty();
        _xblockexpression = _builder;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected CharSequence concatInheritedElement(final ENamedElement eNamedElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(<<");
    CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eNamedElement);
    _builder.append(_concatAnchor);
    _builder.append(", {inherited}");
    EObject _eContainer = eNamedElement.eContainer();
    CharSequence _concatReferenceName = this.concatReferenceName(((EClass) _eContainer));
    _builder.append(_concatReferenceName);
    _builder.append(">>)");
    return _builder;
  }
  
  protected void writeEReferencesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".References");
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
    _builder.append("|Properties");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    _output.append(_builder);
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
      CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eClass);
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
  
  protected CharSequence concatFeatureProperties(final EStructuralFeature eAttribute) {
    if (eAttribute instanceof EAttribute) {
      return _concatFeatureProperties((EAttribute)eAttribute);
    } else if (eAttribute instanceof EReference) {
      return _concatFeatureProperties((EReference)eAttribute);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eAttribute).toString());
    }
  }
  
  protected CharSequence concatFeatureType(final EStructuralFeature eAttribute) {
    if (eAttribute instanceof EAttribute) {
      return _concatFeatureType((EAttribute)eAttribute);
    } else if (eAttribute instanceof EReference) {
      return _concatFeatureType((EReference)eAttribute);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eAttribute).toString());
    }
  }
}
