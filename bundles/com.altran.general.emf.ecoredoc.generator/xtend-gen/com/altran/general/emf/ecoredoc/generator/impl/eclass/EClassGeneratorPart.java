package com.altran.general.emf.ecoredoc.generator.impl.eclass;

import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.EAttributeGeneratorFragment;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.EContainmentReferenceGeneratorFragment;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.ECrossReferenceReferenceGeneratorFragment;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.EOperationGeneratorFragment;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Multimap;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;

@SuppressWarnings("all")
public class EClassGeneratorPart extends AEcoreDocGeneratorPart {
  private final EAttributeGeneratorFragment eAttributeGeneratorFragment;
  
  private final EContainmentReferenceGeneratorFragment eContainmentReferenceGeneratorFragment;
  
  private final ECrossReferenceReferenceGeneratorFragment eCrossReferenceReferenceGeneratorFragment;
  
  private final EOperationGeneratorFragment eOperationGeneratorFragment;
  
  public EClassGeneratorPart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages, final Injector xcoreInjector) {
    super(config, ePackages, xcoreInjector);
    EAttributeGeneratorFragment _eAttributeGeneratorFragment = new EAttributeGeneratorFragment(this);
    this.eAttributeGeneratorFragment = _eAttributeGeneratorFragment;
    EContainmentReferenceGeneratorFragment _eContainmentReferenceGeneratorFragment = new EContainmentReferenceGeneratorFragment(this);
    this.eContainmentReferenceGeneratorFragment = _eContainmentReferenceGeneratorFragment;
    ECrossReferenceReferenceGeneratorFragment _eCrossReferenceReferenceGeneratorFragment = new ECrossReferenceReferenceGeneratorFragment(this);
    this.eCrossReferenceReferenceGeneratorFragment = _eCrossReferenceReferenceGeneratorFragment;
    EOperationGeneratorFragment _eOperationGeneratorFragment = new EOperationGeneratorFragment(this);
    this.eOperationGeneratorFragment = _eOperationGeneratorFragment;
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    this.clearOutput();
    final List<EClass> eClasses = this._ecoreDocExtension.collectEClasses(this.getEPackages().get(ePackage));
    final Function1<EClass, EClassConfig> _function = (EClass it) -> {
      IENamedElementConfig _findConfig = this.getConfig().findConfig(it);
      return ((EClassConfig) _findConfig);
    };
    final Function2<EClass, EClassConfig, Boolean> _function_1 = (EClass eClass, EClassConfig config) -> {
      return Boolean.valueOf(config.shouldRender());
    };
    final Map<EClass, EClassConfig> eClassMap = MapExtensions.<EClass, EClassConfig>filter(IterableExtensions.<EClass, EClassConfig>toInvertedMap(eClasses, _function), _function_1);
    this.writeEClasses(eClassMap);
    return this.getOutput();
  }
  
  public Set<EClass> collectAllSubTypes(final EClass parent) {
    final Function1<EClass, Boolean> _function = (EClass it) -> {
      return Boolean.valueOf(it.getEAllSuperTypes().contains(parent));
    };
    final Function1<EClass, Boolean> _function_1 = (EClass it) -> {
      EClass _eClass = it.eClass();
      return Boolean.valueOf(Objects.equal(_eClass, parent));
    };
    return IterableExtensions.<EClass>toSet(IterableExtensions.<EClass>reject(IterableExtensions.<EClass>filter(this.collectAllEClasses(), _function), _function_1));
  }
  
  protected void writeEClasses(final Map<EClass, EClassConfig> eClassMap) {
    boolean _isEmpty = eClassMap.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEClassesHeader();
      Set<Map.Entry<EClass, EClassConfig>> _entrySet = eClassMap.entrySet();
      for (final Map.Entry<EClass, EClassConfig> entry : _entrySet) {
        EClassConfigPair _eClassConfigPair = new EClassConfigPair(entry);
        this.writeEClass(_eClassConfigPair);
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
  
  protected void writeEClass(final EClassConfigPair pair) {
    this.writeEClassHeader(pair);
    this.writeProperties(pair);
    this.writeSuperTypes(pair);
    this.writeSubTypes(pair);
    this.eAttributeGeneratorFragment.writeEAttributes(pair);
    this.eContainmentReferenceGeneratorFragment.writeEContainments(pair);
    this.eCrossReferenceReferenceGeneratorFragment.writeECrossReferences(pair);
    this.eOperationGeneratorFragment.writeEOperations(pair);
    this.writeUseCases(pair);
  }
  
  protected void writeSubTypes(final EClassConfigPair pair) {
    boolean _shouldRenderSubTypes = pair.getConfig().shouldRenderSubTypes();
    boolean _not = (!_shouldRenderSubTypes);
    if (_not) {
      return;
    }
    Set<EClass> subTypes = this.collectAllSubTypes(pair.getElement());
    boolean _isEmpty = subTypes.isEmpty();
    boolean _not_1 = (!_isEmpty);
    if (_not_1) {
      this.writeSubTypesHeader();
      List<EClass> _sortBy = IterableExtensions.<EClass, String>sortBy(subTypes, EcoreDocExtension.eClassifierSorter);
      for (final EClass subType : _sortBy) {
        IENamedElementConfig _findConfig = this.getConfig().findConfig(subType);
        EClassConfigPair _eClassConfigPair = new EClassConfigPair(subType, ((EClassConfig) _findConfig));
        this.writeType(_eClassConfigPair);
      }
    }
  }
  
  protected void writeSuperTypes(final EClassConfigPair pair) {
    boolean _shouldRenderSuperTypes = pair.getConfig().shouldRenderSuperTypes();
    boolean _not = (!_shouldRenderSuperTypes);
    if (_not) {
      return;
    }
    final EClass eClass = pair.getElement();
    final EList<EClass> tmp = eClass.getEAllSuperTypes();
    final Function1<EClass, Boolean> _function = (EClass it) -> {
      return Boolean.valueOf(tmp.contains(it));
    };
    final Iterable<EClass> superTypes = IterableExtensions.<EClass>filter(this.collectAllEClasses(), _function);
    boolean _isEmpty = IterableExtensions.isEmpty(superTypes);
    final boolean superTypesExist = (!_isEmpty);
    if (superTypesExist) {
      this.writeSuperTypesHeader();
      final List<EClass> sortedSuperTypes = IterableExtensions.<EClass, String>sortBy(superTypes, EcoreDocExtension.eClassifierSorter);
      for (final EClass supertype : sortedSuperTypes) {
        IENamedElementConfig _findConfig = this.getConfig().findConfig(supertype);
        EClassConfigPair _eClassConfigPair = new EClassConfigPair(supertype, ((EClassConfig) _findConfig));
        this.writeType(_eClassConfigPair);
      }
    }
  }
  
  protected void writeType(final EClassConfigPair pair) {
    boolean _shouldRender = pair.getConfig().shouldRender();
    boolean _not = (!_shouldRender);
    if (_not) {
      return;
    }
    final EClass eClass = pair.getElement();
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
  
  protected void writeEClassHeader(final EClassConfigPair pair) {
    final EClass eClass = pair.getElement();
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
    CharSequence _concatAnchor = this._anchorExtension.concatAnchor(eClass);
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
  
  protected void writeProperties(final EClassConfigPair pair) {
    final EClass eClass = pair.getElement();
    final ArrayList<CharSequence> properties = CollectionLiterals.<CharSequence>newArrayList();
    boolean _isAbstract = eClass.isAbstract();
    boolean _not = (!_isAbstract);
    if (_not) {
      CharSequence _defineDefaultValue = this.defineDefaultValue(pair);
      properties.add(_defineDefaultValue);
    }
    CharSequence _defineInstanceClassName = this.defineInstanceClassName(pair);
    properties.add(_defineInstanceClassName);
    this.getOutput().append(
      IterableExtensions.join(IterableExtensions.<CharSequence>filterNull(properties), EcoreDocExtension.ECLASSIFIER_PROPERTY_SEPARATOR));
    this.getOutput().append(EcoreDocExtension.newline());
  }
}
