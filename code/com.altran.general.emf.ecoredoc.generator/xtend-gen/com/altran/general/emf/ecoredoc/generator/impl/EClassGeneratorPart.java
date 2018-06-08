package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.ecoredoc.generator.config.EClassConfig;
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.ecoredoc.generator.config.IEcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EStructuralFeaturePropertyHelper;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class EClassGeneratorPart extends AEcoreDocGeneratorPart {
  @Extension
  private EStructuralFeaturePropertyHelper _eStructuralFeaturePropertyHelper = new EStructuralFeaturePropertyHelper();
  
  public EClassGeneratorPart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages) {
    super(config, ePackages);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    this.clearOutput();
    final List<EClass> eClasses = this._ecoreDocExtension.collectEClasses(this.getEPackages().get(ePackage));
    final Function1<EClass, EClassConfig> _function = (EClass it) -> {
      IEcoreDocGeneratorConfig _findConfig = this.getConfig().findConfig(it);
      return ((EClassConfig) _findConfig);
    };
    final Function2<EClass, EClassConfig, Boolean> _function_1 = (EClass eClass, EClassConfig config) -> {
      return Boolean.valueOf(config.shouldRender());
    };
    final Map<EClass, EClassConfig> eClassMap = MapExtensions.<EClass, EClassConfig>filter(IterableExtensions.<EClass, EClassConfig>toInvertedMap(eClasses, _function), _function_1);
    this.writeEClasses(eClassMap);
    return this.getOutput();
  }
  
  protected void writeEClasses(final Map<EClass, EClassConfig> eClassMap) {
    boolean _isEmpty = eClassMap.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEClassesHeader();
      Set<Map.Entry<EClass, EClassConfig>> _entrySet = eClassMap.entrySet();
      for (final Map.Entry<EClass, EClassConfig> entry : _entrySet) {
        this.writeEClass(entry);
      }
    }
  }
  
  protected void writeEClassesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("=== Types");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected void writeEClass(final Map.Entry<EClass, EClassConfig> entry) {
    this.writeEClassHeader(entry);
    this.writeProperties(entry);
    this.writeSuperTypes(entry);
    this.writeSubTypes(entry);
    this.writeEAttributes(entry);
    this.writeEContainments(entry);
    this.writeECrossReferences(entry);
    this.writeUseCases(entry);
  }
  
  protected void writeEContainments(final Map.Entry<EClass, EClassConfig> entry) {
    final EClass eClass = entry.getKey();
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
  
  protected void writeECrossReferences(final Map.Entry<EClass, EClassConfig> entry) {
    final EClass eClass = entry.getKey();
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
  
  protected void writeEAttributes(final Map.Entry<EClass, EClassConfig> entry) {
    final EClass eClass = entry.getKey();
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
    String _newline = EcoreDocExtension.newline();
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
  
  protected void writeSubTypes(final Map.Entry<EClass, EClassConfig> entry) {
    final EClass currentEClass = entry.getKey();
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
        IEcoreDocGeneratorConfig _findConfig = this.getConfig().findConfig(eClass_1);
        Pair<EClass, IEcoreDocGeneratorConfig> _mappedTo = Pair.<EClass, IEcoreDocGeneratorConfig>of(eClass_1, _findConfig);
        this.writeType(_mappedTo);
      }
    }
  }
  
  protected void writeSuperTypes(final Map.Entry<EClass, EClassConfig> entry) {
    final EClass eClass = entry.getKey();
    boolean _isEmpty = eClass.getEAllSuperTypes().isEmpty();
    final boolean superTypesExist = (!_isEmpty);
    if (superTypesExist) {
      this.writeSuperTypesHeader();
      final Function1<EClass, String> _function = (EClass it) -> {
        String _elvis = null;
        String _name = it.getName();
        if (_name != null) {
          _elvis = _name;
        } else {
          _elvis = "";
        }
        return _elvis;
      };
      final List<EClass> sortedSuperTypes = IterableExtensions.<EClass, String>sortBy(eClass.getEAllSuperTypes(), _function);
      for (final EClass supertype : sortedSuperTypes) {
        IEcoreDocGeneratorConfig _findConfig = this.getConfig().findConfig(supertype);
        Pair<EClass, IEcoreDocGeneratorConfig> _mappedTo = Pair.<EClass, IEcoreDocGeneratorConfig>of(supertype, _findConfig);
        this.writeType(_mappedTo);
      }
    }
  }
  
  protected void writeType(final Pair<EClass, IEcoreDocGeneratorConfig> pair) {
    EClass _key = pair.getKey();
    IEcoreDocGeneratorConfig _value = pair.getValue();
    AbstractMap.SimpleEntry<EClass, EClassConfig> _simpleEntry = new AbstractMap.SimpleEntry<EClass, EClassConfig>(_key, ((EClassConfig) _value));
    this.writeType(_simpleEntry);
  }
  
  protected void writeType(final Map.Entry<EClass, EClassConfig> entry) {
    final EClass eClass = entry.getKey();
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
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Sub-types");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected void writeSuperTypesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Super-types");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected void writeEAttributesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
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
      String _elvis = null;
      String _name = it.getName();
      if (_name != null) {
        _elvis = _name;
      } else {
        _elvis = "";
      }
      return _elvis;
    };
    List<? extends EStructuralFeature> _sortBy = IterableExtensions.sortBy(eStructuralFeatures, _function);
    for (final EStructuralFeature eStructuralFeature : _sortBy) {
      this.writeRow(eStructuralFeature, eClass);
    }
    final Function1<EStructuralFeature, String> _function_1 = (EStructuralFeature it) -> {
      String _elvis = null;
      String _name = it.getName();
      if (_name != null) {
        _elvis = _name;
      } else {
        _elvis = "";
      }
      return _elvis;
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
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("|`");
    _builder.append(eStructuralFeatureName);
    _builder.append("`[[");
    CharSequence _joinAnchor = this._ecoreDocExtension.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(inheritedFeatureSegments)));
    _builder.append(_joinAnchor);
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
  
  protected CharSequence concatFeatureProperties(final EStructuralFeature eStructuralFeature) {
    final List<CharSequence> featureProperties = this.enumerateFeatureProperties(eStructuralFeature);
    final List<CharSequence> genericProperties = this.enumerateGenericProperties(eStructuralFeature);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("+");
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline, " ");
    final CharSequence separator = _builder;
    return IterableExtensions.join(IterableExtensions.<CharSequence>filterNull(Iterables.<CharSequence>concat(featureProperties, genericProperties)), separator);
  }
  
  protected List<CharSequence> _enumerateFeatureProperties(final EAttribute eAttribute) {
    CharSequence _defineId = this._eStructuralFeaturePropertyHelper.defineId(eAttribute);
    return Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineId));
  }
  
  protected List<CharSequence> _enumerateFeatureProperties(final EReference eReference) {
    CharSequence _defineEKeys = this._eStructuralFeaturePropertyHelper.defineEKeys(eReference);
    CharSequence _defineResolveProxies = this._eStructuralFeaturePropertyHelper.defineResolveProxies(eReference);
    CharSequence _defineContainer = this._eStructuralFeaturePropertyHelper.defineContainer(eReference);
    CharSequence _defineContainment = this._eStructuralFeaturePropertyHelper.defineContainment(eReference);
    return Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineEKeys, _defineResolveProxies, _defineContainer, _defineContainment));
  }
  
  protected List<CharSequence> enumerateGenericProperties(final EStructuralFeature eStructuralFeature) {
    CharSequence _concatBounds = this._eStructuralFeaturePropertyHelper.concatBounds(eStructuralFeature);
    CharSequence _concatDefaultValue = this._eStructuralFeaturePropertyHelper.concatDefaultValue(eStructuralFeature);
    CharSequence _defineOrdered = this._eStructuralFeaturePropertyHelper.defineOrdered(eStructuralFeature);
    CharSequence _defineChangeable = this._eStructuralFeaturePropertyHelper.defineChangeable(eStructuralFeature);
    CharSequence _defineDerived = this._eStructuralFeaturePropertyHelper.defineDerived(eStructuralFeature);
    CharSequence _defineTransient = this._eStructuralFeaturePropertyHelper.defineTransient(eStructuralFeature);
    CharSequence _defineUnique = this._eStructuralFeaturePropertyHelper.defineUnique(eStructuralFeature);
    CharSequence _defineUnsettable = this._eStructuralFeaturePropertyHelper.defineUnsettable(eStructuralFeature);
    CharSequence _defineVolatile = this._eStructuralFeaturePropertyHelper.defineVolatile(eStructuralFeature);
    return Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_concatBounds, _concatDefaultValue, _defineOrdered, _defineChangeable, _defineDerived, _defineTransient, _defineUnique, _defineUnsettable, _defineVolatile));
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
    CharSequence _xblockexpression = null;
    {
      final EReference eOpposite = eReference.getEOpposite();
      CharSequence _xifexpression = null;
      if ((eOpposite != null)) {
        CharSequence _xblockexpression_1 = null;
        {
          final String eOppositeName = eOpposite.getName();
          final EClass eReferenceType = eReference.getEReferenceType();
          StringConcatenation _builder = new StringConcatenation();
          String _newline = EcoreDocExtension.newline();
          _builder.append(_newline);
          _builder.newLineIfNotEmpty();
          _builder.append("_EOpposite:_ `<<");
          CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eReferenceType);
          _builder.append(_concatAnchor);
          _builder.append(EcoreDocExtension.ANCHOR_SEPARATOR);
          _builder.append(eOppositeName);
          _builder.append(", ");
          _builder.append(eOppositeName);
          _builder.append(">>`");
          _builder.newLineIfNotEmpty();
          _xblockexpression_1 = _builder;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatInheritedElement(final ENamedElement eNamedElement) {
    CharSequence _xblockexpression = null;
    {
      EObject _eContainer = eNamedElement.eContainer();
      final EClass eClass = ((EClass) _eContainer);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(`<<");
      CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eNamedElement);
      _builder.append(_concatAnchor);
      _builder.append(", {inherited}");
      CharSequence _concatReferenceName = this.concatReferenceName(eClass);
      _builder.append(_concatReferenceName);
      _builder.append(">>`)");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected void writeEReferencesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
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
  
  protected void writeEClassHeader(final Map.Entry<EClass, EClassConfig> entry) {
    final EClass eClass = entry.getKey();
    final String eClassName = eClass.getName();
    final boolean isAbstract = eClass.isAbstract();
    final boolean isInterface = eClass.isInterface();
    final boolean notInterface = (!isInterface);
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("[[");
    CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eClass);
    _builder.append(_concatAnchor);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("==== ");
    {
      if ((isAbstract && notInterface)) {
        _builder.append("Abstract ");
      }
    }
    {
      if (isInterface) {
        _builder.append("Interface");
      } else {
        _builder.append("Class");
      }
    }
    _builder.append(" ");
    _builder.append(eClassName);
    _builder.newLineIfNotEmpty();
    String _newline_1 = EcoreDocExtension.newline();
    _builder.append(_newline_1);
    _builder.newLineIfNotEmpty();
    CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eClass);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    String _newline_2 = EcoreDocExtension.newline();
    _builder.append(_newline_2);
    _builder.newLineIfNotEmpty();
    _output.append(_builder);
  }
  
  protected void writeProperties(final Map.Entry<EClass, EClassConfig> entry) {
    final EClass eClass = entry.getKey();
    final ArrayList<CharSequence> properties = CollectionLiterals.<CharSequence>newArrayList();
    boolean _isAbstract = eClass.isAbstract();
    boolean _not = (!_isAbstract);
    if (_not) {
      CharSequence _defineDefaultValue = this.defineDefaultValue(eClass);
      properties.add(_defineDefaultValue);
    }
    CharSequence _defineInstanceClassName = this.defineInstanceClassName(eClass);
    properties.add(_defineInstanceClassName);
    this.getOutput().append(
      IterableExtensions.join(IterableExtensions.<CharSequence>filterNull(properties), EcoreDocExtension.ECLASSIFIER_PROPERTY_SEPARATOR));
    this.getOutput().append(EcoreDocExtension.newline());
  }
  
  protected List<CharSequence> enumerateFeatureProperties(final EStructuralFeature eAttribute) {
    if (eAttribute instanceof EAttribute) {
      return _enumerateFeatureProperties((EAttribute)eAttribute);
    } else if (eAttribute instanceof EReference) {
      return _enumerateFeatureProperties((EReference)eAttribute);
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
