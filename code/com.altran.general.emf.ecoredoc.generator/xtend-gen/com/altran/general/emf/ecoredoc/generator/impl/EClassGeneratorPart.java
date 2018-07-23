package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.config.AEReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.emf.ecoredoc.generator.config.EOperationConfig;
import com.altran.general.emf.ecoredoc.generator.config.EParameterConfig;
import com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.AEcoreDocConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EAttributeConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EOperationConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EParameterConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EReferenceConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEStructuralFeatureConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EStructuralFeaturePropertyHelper;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xcore.XOperation;
import org.eclipse.emf.ecore.xcore.mappings.XcoreMapper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;

@SuppressWarnings("all")
public class EClassGeneratorPart extends AEcoreDocGeneratorPart {
  @Extension
  private EStructuralFeaturePropertyHelper structuralFeaturePropertyHelper;
  
  public EClassGeneratorPart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages, final Injector xcoreInjector) {
    super(config, ePackages, xcoreInjector);
    EStructuralFeaturePropertyHelper _eStructuralFeaturePropertyHelper = new EStructuralFeaturePropertyHelper(config);
    this.structuralFeaturePropertyHelper = _eStructuralFeaturePropertyHelper;
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
    this.writeEAttributes(pair);
    this.writeEContainments(pair);
    this.writeECrossReferences(pair);
    this.writeEOperations(pair);
    this.writeUseCases(pair);
  }
  
  protected void writeEContainments(final EClassConfigPair pair) {
    final EClass eClass = pair.getElement();
    final List<IEStructuralFeatureConfigPair<?, ?>> containments = this.combineConfigPairs(this.collectEContainments(eClass), pair.getConfig());
    final List<IEStructuralFeatureConfigPair<?, ?>> inheritedContainments = this.combineConfigPairs(this.collectInheritedEContainments(pair), pair.getConfig());
    boolean _hasRenderedEntries = this.hasRenderedEntries(pair.getConfig(), containments, inheritedContainments);
    if (_hasRenderedEntries) {
      this.writeEContainmentHeader();
      this.writeEStructuralFeatures(containments, eClass, inheritedContainments);
    }
  }
  
  protected void writeECrossReferences(final EClassConfigPair pair) {
    final EClass eClass = pair.getElement();
    final List<IEStructuralFeatureConfigPair<?, ?>> crossReferences = this.combineConfigPairs(this.collectECrossReferences(eClass), pair.getConfig());
    final List<IEStructuralFeatureConfigPair<?, ?>> inheritedCrossReferences = this.combineConfigPairs(this.collectInheritedECrossReferences(pair), pair.getConfig());
    boolean _hasRenderedEntries = this.hasRenderedEntries(pair.getConfig(), crossReferences, inheritedCrossReferences);
    if (_hasRenderedEntries) {
      this.writeEReferencesHeader();
      this.writeEStructuralFeatures(crossReferences, eClass, inheritedCrossReferences);
    }
  }
  
  protected void writeEAttributes(final EClassConfigPair pair) {
    final EClass eClass = pair.getElement();
    final List<IEStructuralFeatureConfigPair<?, ?>> eAttributes = this.combineConfigPairs(eClass.getEAttributes(), pair.getConfig());
    final List<IEStructuralFeatureConfigPair<?, ?>> inheritedEAttributes = this.combineConfigPairs(this.collectInheritedEAttributes(pair), pair.getConfig());
    boolean _hasRenderedEntries = this.hasRenderedEntries(pair.getConfig(), eAttributes, inheritedEAttributes);
    if (_hasRenderedEntries) {
      this.writeEAttributesHeader();
      this.writeEStructuralFeatures(eAttributes, eClass, inheritedEAttributes);
    }
  }
  
  protected void writeEOperations(final EClassConfigPair pair) {
    final EClass eClass = pair.getElement();
    final List<EOperationConfigPair> eOperations = this.combineOperationConfigPairs(eClass.getEOperations(), pair.getConfig());
    final List<EOperationConfigPair> inheritedEOperations = this.combineOperationConfigPairs(this.collectInheritedEOperations(pair), pair.getConfig());
    boolean _hasRenderedOperations = this.hasRenderedOperations(pair.getConfig(), eOperations, inheritedEOperations);
    if (_hasRenderedOperations) {
      this.writeEOperationsHeader();
      final Function1<EOperationConfigPair, String> _function = (EOperationConfigPair it) -> {
        return EcoreDocExtension.eOperationSorter.apply(it.getElement());
      };
      List<EOperationConfigPair> _sortBy = IterableExtensions.<EOperationConfigPair, String>sortBy(eOperations, _function);
      for (final EOperationConfigPair op : _sortBy) {
        this.writeEOperation(op, eClass, false);
      }
      final Function1<EOperationConfigPair, String> _function_1 = (EOperationConfigPair it) -> {
        return EcoreDocExtension.eOperationSorter.apply(it.getElement());
      };
      List<EOperationConfigPair> _sortBy_1 = IterableExtensions.<EOperationConfigPair, String>sortBy(inheritedEOperations, _function_1);
      for (final EOperationConfigPair op_1 : _sortBy_1) {
        this.writeEOperation(op_1, eClass, true);
      }
      this.getOutput().append(this.tableFooter());
    }
  }
  
  protected void writeEOperation(final EOperationConfigPair pair, final EClass eClass, final boolean inherited) {
    boolean _shouldRender = pair.getConfig().shouldRender();
    boolean _not = (!_shouldRender);
    if (_not) {
      return;
    }
    final EOperation eOperation = pair.getElement();
    String language = null;
    String body = null;
    Injector _xcoreInjector = this.getXcoreInjector();
    boolean _tripleNotEquals = (_xcoreInjector != null);
    if (_tripleNotEquals) {
      final XcoreMapper mapper = this.getXcoreInjector().<XcoreMapper>getInstance(XcoreMapper.class);
      final XOperation xOp = mapper.getXOperation(eOperation);
      XBlockExpression _body = xOp.getBody();
      boolean _tripleNotEquals_1 = (_body != null);
      if (_tripleNotEquals_1) {
        language = "xtend";
        final Function1<INode, String> _function = (INode it) -> {
          return it.getText();
        };
        final String text = IterableExtensions.join(ListExtensions.<INode, String>map(NodeModelUtils.findNodesForFeature(xOp.getBody(), XbasePackage.Literals.XBLOCK_EXPRESSION__EXPRESSIONS), _function));
        final String[] lines = StringUtils.split(text, EcoreDocExtension.newline());
        String _xifexpression = null;
        int _size = ((List<String>)Conversions.doWrapArray(lines)).size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          String _xblockexpression = null;
          {
            final String prefix = StringUtils.getCommonPrefix(lines);
            final Function1<String, String> _function_1 = (String it) -> {
              return StringUtils.removeStart(it, prefix);
            };
            _xblockexpression = IterableExtensions.join(ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(lines)), _function_1), EcoreDocExtension.newline());
          }
          _xifexpression = _xblockexpression;
        } else {
          _xifexpression = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(lines))).trim();
        }
        body = _xifexpression;
      }
    }
    boolean _isBlank = StringUtils.isBlank(body);
    if (_isBlank) {
      final EAnnotation genModelAnnotation = eOperation.getEAnnotation(GenModelPackage.eNS_URI);
      EMap<String, String> _details = null;
      if (genModelAnnotation!=null) {
        _details=genModelAnnotation.getDetails();
      }
      String _get = null;
      if (_details!=null) {
        _get=_details.get("body");
      }
      final String bodyAnnotation = _get;
      language = "java";
      body = StringUtils.defaultString(bodyAnnotation).trim();
    }
    int _size_1 = eOperation.getEParameters().size();
    int _plus = (1 + _size_1);
    int _size_2 = eOperation.getEExceptions().size();
    int _plus_1 = (_plus + _size_2);
    int _xifexpression_1 = (int) 0;
    boolean _isEmpty = body.isEmpty();
    if (_isEmpty) {
      _xifexpression_1 = 0;
    } else {
      _xifexpression_1 = 1;
    }
    final int lineCount = (_plus_1 + _xifexpression_1);
    final Function1<EClass, EList<EOperation>> _function_1 = (EClass it) -> {
      return it.getEOperations();
    };
    final Function1<EOperation, Boolean> _function_2 = (EOperation it) -> {
      return Boolean.valueOf(((it != eOperation) && eOperation.isOverrideOf(it)));
    };
    final Iterable<EOperation> overrides = IterableExtensions.<EOperation>filter(Iterables.<EOperation>concat(ListExtensions.<EClass, EList<EOperation>>map(eClass.getEAllSuperTypes(), _function_1)), _function_2);
    final String[] inheritedFeatureSegments = this.collectInheritedFeatureSegments(eOperation, eClass);
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".");
    _builder.append(lineCount);
    _builder.append("+|");
    {
      boolean _isEmpty_1 = body.isEmpty();
      if (_isEmpty_1) {
        _builder.append("_abstract_ ");
      }
    }
    _builder.append("`");
    String _name = eOperation.getName();
    _builder.append(_name);
    _builder.append("(");
    {
      EList<EParameter> _eParameters = eOperation.getEParameters();
      boolean _hasElements = false;
      for(final EParameter param : _eParameters) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("{zwsp}");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name_1 = param.getName();
        _builder.append(_name_1);
      }
      if (_hasElements) {
        _builder.append("{zwsp}");
      }
    }
    _builder.append(")`[[");
    CharSequence _joinAnchor = this._ecoreDocExtension.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(inheritedFeatureSegments)));
    _builder.append(_joinAnchor);
    _builder.append("]]");
    {
      if (inherited) {
        _builder.append(" +");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        CharSequence _concatInheritedElement = this.concatInheritedElement(eOperation);
        _builder.append(_concatInheritedElement, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isEmpty_2 = IterableExtensions.isEmpty(overrides);
      boolean _not_1 = (!_isEmpty_2);
      if (_not_1) {
        _builder.append(" +");
        _builder.newLineIfNotEmpty();
        {
          boolean _hasElements_1 = false;
          for(final EOperation override : overrides) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              String _newline = EcoreDocExtension.newline();
              String _plus_2 = (" +" + _newline);
              _builder.appendImmediate(_plus_2, "\t");
            }
            _builder.append("\t");
            _builder.append("`<<");
            CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(override);
            _builder.append(_concatAnchor, "\t");
            _builder.append(", {override}");
            CharSequence _concatReferenceName = this.concatReferenceName(pair.getElement());
            _builder.append(_concatReferenceName, "\t");
            _builder.append(">>`");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("|_returns_ +");
    _builder.newLine();
    CharSequence _concatLinkTo = this.concatLinkTo(eOperation.getEType());
    _builder.append(_concatLinkTo);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    {
      EClassifier _eType = eOperation.getEType();
      boolean _tripleNotEquals_2 = (_eType != null);
      if (_tripleNotEquals_2) {
        _builder.append("`[");
        int _lowerBound = eOperation.getLowerBound();
        _builder.append(_lowerBound);
        _builder.append("..");
        int _upperBound = eOperation.getUpperBound();
        _builder.append(_upperBound);
        _builder.append("]`");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eOperation);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    String _newline_1 = EcoreDocExtension.newline();
    _builder.append(_newline_1);
    _builder.newLineIfNotEmpty();
    _output.append(_builder);
    EList<EParameter> _eParameters_1 = eOperation.getEParameters();
    for (final EParameter param_1 : _eParameters_1) {
      StringBuilder _output_1 = this.getOutput();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("|`");
      String _name_2 = param_1.getName();
      _builder_1.append(_name_2);
      _builder_1.append("` +");
      _builder_1.newLineIfNotEmpty();
      CharSequence _concatLinkTo_1 = this.concatLinkTo(param_1.getEType());
      _builder_1.append(_concatLinkTo_1);
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("|`[");
      int _lowerBound_1 = param_1.getLowerBound();
      _builder_1.append(_lowerBound_1);
      _builder_1.append("..");
      int _upperBound_1 = param_1.getUpperBound();
      _builder_1.append(_upperBound_1);
      _builder_1.append("]`");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("|");
      CharSequence _documentation_1 = this._ecoreDocExtension.getDocumentation(param_1);
      _builder_1.append(_documentation_1);
      _builder_1.newLineIfNotEmpty();
      String _newline_2 = EcoreDocExtension.newline();
      _builder_1.append(_newline_2);
      _builder_1.newLineIfNotEmpty();
      _output_1.append(_builder_1);
    }
    EList<EClassifier> _eExceptions = eOperation.getEExceptions();
    for (final EClassifier ex : _eExceptions) {
      StringBuilder _output_2 = this.getOutput();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("|_throws_ +");
      _builder_2.newLine();
      CharSequence _concatLinkTo_2 = this.concatLinkTo(ex);
      _builder_2.append(_concatLinkTo_2);
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("|");
      _builder_2.newLine();
      _builder_2.append("|");
      _builder_2.newLine();
      String _newline_3 = EcoreDocExtension.newline();
      _builder_2.append(_newline_3);
      _builder_2.newLineIfNotEmpty();
      _output_2.append(_builder_2);
    }
    boolean _isEmpty_3 = body.isEmpty();
    boolean _not_2 = (!_isEmpty_3);
    if (_not_2) {
      StringBuilder _output_3 = this.getOutput();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("3+a|");
      _builder_3.newLine();
      _builder_3.append("[source,");
      _builder_3.append(language);
      _builder_3.append("]");
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("----");
      _builder_3.newLine();
      _builder_3.append(body);
      _builder_3.newLineIfNotEmpty();
      _builder_3.append("----");
      _builder_3.newLine();
      String _newline_4 = EcoreDocExtension.newline();
      _builder_3.append(_newline_4);
      _builder_3.newLineIfNotEmpty();
      _output_3.append(_builder_3);
    }
  }
  
  protected boolean hasRenderedEntries(final EClassConfig classConfig, final Collection<IEStructuralFeatureConfigPair<?, ?>> eStructuralFeatures, final Collection<IEStructuralFeatureConfigPair<?, ?>> inheritedEStructuralFeatures) {
    return (IterableExtensions.<IEStructuralFeatureConfigPair<?, ?>>exists(eStructuralFeatures, ((Function1<IEStructuralFeatureConfigPair<?, ?>, Boolean>) (IEStructuralFeatureConfigPair<?, ?> it) -> {
      return Boolean.valueOf(it.getConfig().shouldRender());
    })) || 
      (classConfig.shouldRepeatInherited() && 
        IterableExtensions.<IEStructuralFeatureConfigPair<?, ?>>exists(inheritedEStructuralFeatures, ((Function1<IEStructuralFeatureConfigPair<?, ?>, Boolean>) (IEStructuralFeatureConfigPair<?, ?> it) -> {
          return Boolean.valueOf(it.getConfig().shouldRender());
        }))));
  }
  
  protected boolean hasRenderedOperations(final EClassConfig classConfig, final Collection<EOperationConfigPair> eOperations, final Collection<EOperationConfigPair> inheritedEOperations) {
    return (IterableExtensions.<EOperationConfigPair>exists(eOperations, ((Function1<EOperationConfigPair, Boolean>) (EOperationConfigPair it) -> {
      return Boolean.valueOf(it.getConfig().shouldRender());
    })) || 
      (classConfig.shouldRepeatInherited() && 
        IterableExtensions.<EOperationConfigPair>exists(inheritedEOperations, ((Function1<EOperationConfigPair, Boolean>) (EOperationConfigPair it) -> {
          return Boolean.valueOf(it.getConfig().shouldRender());
        }))));
  }
  
  protected List<IEStructuralFeatureConfigPair<?, ?>> combineConfigPairs(final Collection<? extends EStructuralFeature> eStructuralFeatures, final EClassConfig classConfig) {
    final Function1<EStructuralFeature, IEStructuralFeatureConfigPair<?, ?>> _function = (EStructuralFeature it) -> {
      AEcoreDocConfigPair<? extends EStructuralFeature, ? extends IEStructuralFeatureConfig> _combineConfigPair = this.combineConfigPair(it, classConfig);
      return ((IEStructuralFeatureConfigPair<?, ?>) _combineConfigPair);
    };
    return IterableExtensions.<IEStructuralFeatureConfigPair<?, ?>>toList(IterableExtensions.map(eStructuralFeatures, _function));
  }
  
  protected List<EOperationConfigPair> combineOperationConfigPairs(final Collection<? extends EOperation> eOperations, final EClassConfig classConfig) {
    final Function1<EOperation, EOperationConfigPair> _function = (EOperation op) -> {
      final Function1<EOperationConfig, Boolean> _function_1 = (EOperationConfig it) -> {
        String _id = it.getId();
        String _name = op.getName();
        return Boolean.valueOf(Objects.equal(_id, _name));
      };
      EOperationConfig _findFirst = IterableExtensions.<EOperationConfig>findFirst(classConfig.getEOperations(), _function_1);
      return new EOperationConfigPair(op, _findFirst);
    };
    return IterableExtensions.<EOperationConfigPair>toList(IterableExtensions.map(eOperations, _function));
  }
  
  protected List<EParameterConfigPair> combineParameterConfigPairs(final Collection<? extends EParameter> eParameters, final EOperationConfig operationConfig) {
    final Function1<EParameter, EParameterConfigPair> _function = (EParameter param) -> {
      final Function1<EParameterConfig, Boolean> _function_1 = (EParameterConfig it) -> {
        String _id = it.getId();
        String _name = param.getName();
        return Boolean.valueOf(Objects.equal(_id, _name));
      };
      EParameterConfig _findFirst = IterableExtensions.<EParameterConfig>findFirst(operationConfig.getEParameters(), _function_1);
      return new EParameterConfigPair(param, _findFirst);
    };
    return IterableExtensions.<EParameterConfigPair>toList(IterableExtensions.map(eParameters, _function));
  }
  
  protected AEcoreDocConfigPair<? extends EStructuralFeature, ? extends IEStructuralFeatureConfig> _combineConfigPair(final EAttribute eAttribute, final EClassConfig classConfig) {
    final Function1<EAttributeConfig, Boolean> _function = (EAttributeConfig it) -> {
      String _id = it.getId();
      String _name = eAttribute.getName();
      return Boolean.valueOf(Objects.equal(_id, _name));
    };
    EAttributeConfig _findFirst = IterableExtensions.<EAttributeConfig>findFirst(classConfig.getEAttributes(), _function);
    return new EAttributeConfigPair(eAttribute, _findFirst);
  }
  
  protected AEcoreDocConfigPair<? extends EStructuralFeature, ? extends IEStructuralFeatureConfig> _combineConfigPair(final EReference eReference, final EClassConfig classConfig) {
    EList<EContainmentConfig> _eContainments = classConfig.getEContainments();
    EList<EReferenceConfig> _eReferences = classConfig.getEReferences();
    final Function1<AEReferenceConfig, Boolean> _function = (AEReferenceConfig it) -> {
      String _id = it.getId();
      String _name = eReference.getName();
      return Boolean.valueOf(Objects.equal(_id, _name));
    };
    AEReferenceConfig _findFirst = IterableExtensions.<AEReferenceConfig>findFirst(Iterables.<AEReferenceConfig>concat(_eContainments, _eReferences), _function);
    return new EReferenceConfigPair(eReference, _findFirst);
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
  
  protected void writeSubTypes(final EClassConfigPair pair) {
    boolean _shouldRenderSubTypes = pair.getConfig().shouldRenderSubTypes();
    boolean _not = (!_shouldRenderSubTypes);
    if (_not) {
      return;
    }
    final EClass currentEClass = pair.getElement();
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
  
  protected Set<EReference> collectEContainments(final EClass eClass) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      return Boolean.valueOf(it.isContainment());
    };
    return IterableExtensions.<EReference>toSet(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function));
  }
  
  protected Set<EReference> collectInheritedEContainments(final EClassConfigPair pair) {
    Set<EReference> _xifexpression = null;
    boolean _shouldRepeatInherited = pair.getConfig().shouldRepeatInherited();
    if (_shouldRepeatInherited) {
      Set<EReference> _xblockexpression = null;
      {
        final EClass eClass = pair.getElement();
        final Function1<EReference, Boolean> _function = (EReference it) -> {
          return Boolean.valueOf(it.isContainment());
        };
        final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
          return Boolean.valueOf(eClass.getEReferences().contains(it));
        };
        _xblockexpression = IterableExtensions.<EReference>toSet(IterableExtensions.<EReference>reject(IterableExtensions.<EReference>filter(eClass.getEAllReferences(), _function), _function_1));
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = CollectionLiterals.<EReference>emptySet();
    }
    return _xifexpression;
  }
  
  protected Set<EReference> collectECrossReferences(final EClass eClass) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      boolean _isContainment = it.isContainment();
      return Boolean.valueOf((!_isContainment));
    };
    return IterableExtensions.<EReference>toSet(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function));
  }
  
  protected Set<EReference> collectInheritedECrossReferences(final EClassConfigPair pair) {
    Set<EReference> _xifexpression = null;
    boolean _shouldRepeatInherited = pair.getConfig().shouldRepeatInherited();
    if (_shouldRepeatInherited) {
      Set<EReference> _xblockexpression = null;
      {
        final EClass eClass = pair.getElement();
        final Function1<EReference, Boolean> _function = (EReference it) -> {
          boolean _isContainment = it.isContainment();
          return Boolean.valueOf((!_isContainment));
        };
        final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
          return Boolean.valueOf(eClass.getEReferences().contains(it));
        };
        _xblockexpression = IterableExtensions.<EReference>toSet(IterableExtensions.<EReference>reject(IterableExtensions.<EReference>filter(eClass.getEAllReferences(), _function), _function_1));
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = CollectionLiterals.<EReference>emptySet();
    }
    return _xifexpression;
  }
  
  protected Set<EAttribute> collectInheritedEAttributes(final EClassConfigPair pair) {
    Set<EAttribute> _xifexpression = null;
    boolean _shouldRepeatInherited = pair.getConfig().shouldRepeatInherited();
    if (_shouldRepeatInherited) {
      Set<EAttribute> _xblockexpression = null;
      {
        final EClass eClass = pair.getElement();
        final Function1<EAttribute, Boolean> _function = (EAttribute it) -> {
          return Boolean.valueOf(eClass.getEAttributes().contains(it));
        };
        _xblockexpression = IterableExtensions.<EAttribute>toSet(IterableExtensions.<EAttribute>reject(eClass.getEAllAttributes(), _function));
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = CollectionLiterals.<EAttribute>emptySet();
    }
    return _xifexpression;
  }
  
  protected Set<EOperation> collectInheritedEOperations(final EClassConfigPair pair) {
    Set<EOperation> _xifexpression = null;
    boolean _shouldRepeatInherited = pair.getConfig().shouldRepeatInherited();
    if (_shouldRepeatInherited) {
      Set<EOperation> _xblockexpression = null;
      {
        final EClass eClass = pair.getElement();
        final Function1<EOperation, Boolean> _function = (EOperation it) -> {
          return Boolean.valueOf(eClass.getEOperations().contains(it));
        };
        final Function1<EOperation, Boolean> _function_1 = (EOperation op) -> {
          final Function1<EOperation, Boolean> _function_2 = (EOperation it) -> {
            return Boolean.valueOf(it.isOverrideOf(op));
          };
          return Boolean.valueOf(IterableExtensions.<EOperation>exists(eClass.getEOperations(), _function_2));
        };
        _xblockexpression = IterableExtensions.<EOperation>toSet(IterableExtensions.<EOperation>reject(IterableExtensions.<EOperation>reject(eClass.getEAllOperations(), _function), _function_1));
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = CollectionLiterals.<EOperation>emptySet();
    }
    return _xifexpression;
  }
  
  protected void writeEStructuralFeatures(final Collection<IEStructuralFeatureConfigPair<?, ?>> ownEStructuralFeatures, final EClass eClass, final Collection<IEStructuralFeatureConfigPair<?, ?>> inheritedEStructuralFeatures) {
    final Function1<IEStructuralFeatureConfigPair<?, ?>, String> _function = (IEStructuralFeatureConfigPair<?, ?> it) -> {
      return EcoreDocExtension.eStructuralFeatureSorter.apply(it.getElement());
    };
    List<IEStructuralFeatureConfigPair<?, ?>> _sortBy = IterableExtensions.<IEStructuralFeatureConfigPair<?, ?>, String>sortBy(ownEStructuralFeatures, _function);
    for (final IEStructuralFeatureConfigPair<?, ?> entry : _sortBy) {
      this.writeRow(entry, eClass, false);
    }
    final Function1<IEStructuralFeatureConfigPair<?, ?>, String> _function_1 = (IEStructuralFeatureConfigPair<?, ?> it) -> {
      return EcoreDocExtension.eStructuralFeatureSorter.apply(it.getElement());
    };
    List<IEStructuralFeatureConfigPair<?, ?>> _sortBy_1 = IterableExtensions.<IEStructuralFeatureConfigPair<?, ?>, String>sortBy(inheritedEStructuralFeatures, _function_1);
    for (final IEStructuralFeatureConfigPair<?, ?> entry_1 : _sortBy_1) {
      this.writeRow(entry_1, eClass, true);
    }
    this.getOutput().append(this.tableFooter());
  }
  
  protected void writeRow(final IEStructuralFeatureConfigPair<?, ?> pair, final EClass eClass, final boolean inherited) {
    boolean _shouldRender = pair.getConfig().shouldRender();
    boolean _not = (!_shouldRender);
    if (_not) {
      return;
    }
    final EStructuralFeature eStructuralFeature = pair.getElement();
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
      if (inherited) {
        _builder.append(" +");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      if (inherited) {
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
    CharSequence _concatFeatureProperties = this.concatFeatureProperties(pair);
    _builder.append(_concatFeatureProperties);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eStructuralFeature);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    _output.append(_builder);
  }
  
  protected CharSequence concatFeatureProperties(final IEStructuralFeatureConfigPair<?, ?> pair) {
    final List<CharSequence> featureProperties = this.enumerateFeatureProperties(pair);
    final List<CharSequence> genericProperties = this.enumerateGenericProperties(pair);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" ");
    _builder.append("+");
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline, " ");
    final CharSequence separator = _builder;
    return IterableExtensions.join(IterableExtensions.<CharSequence>filterNull(Iterables.<CharSequence>concat(featureProperties, genericProperties)), separator);
  }
  
  protected List<CharSequence> _enumerateFeatureProperties(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return null;
  }
  
  protected List<CharSequence> _enumerateFeatureProperties(final EAttributeConfigPair pair) {
    CharSequence _defineId = this.structuralFeaturePropertyHelper.defineId(pair);
    return Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineId));
  }
  
  protected List<CharSequence> _enumerateFeatureProperties(final EReferenceConfigPair pair) {
    CharSequence _defineEKeys = this.structuralFeaturePropertyHelper.defineEKeys(pair);
    CharSequence _defineResolveProxies = this.structuralFeaturePropertyHelper.defineResolveProxies(pair);
    CharSequence _defineContainer = this.structuralFeaturePropertyHelper.defineContainer(pair);
    return Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineEKeys, _defineResolveProxies, _defineContainer));
  }
  
  protected List<CharSequence> enumerateGenericProperties(final IEStructuralFeatureConfigPair<?, ?> pair) {
    CharSequence _concatBounds = this.structuralFeaturePropertyHelper.concatBounds(pair);
    CharSequence _concatDefaultValue = this.structuralFeaturePropertyHelper.concatDefaultValue(pair);
    CharSequence _defineOrdered = this.structuralFeaturePropertyHelper.defineOrdered(pair);
    CharSequence _defineChangeable = this.structuralFeaturePropertyHelper.defineChangeable(pair);
    CharSequence _defineDerived = this.structuralFeaturePropertyHelper.defineDerived(pair);
    CharSequence _defineTransient = this.structuralFeaturePropertyHelper.defineTransient(pair);
    CharSequence _defineUnique = this.structuralFeaturePropertyHelper.defineUnique(pair);
    CharSequence _defineUnsettable = this.structuralFeaturePropertyHelper.defineUnsettable(pair);
    CharSequence _defineVolatile = this.structuralFeaturePropertyHelper.defineVolatile(pair);
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
      _builder.append("`<<");
      CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eNamedElement);
      _builder.append(_concatAnchor);
      _builder.append(", {inherited}");
      CharSequence _concatReferenceName = this.concatReferenceName(eClass);
      _builder.append(_concatReferenceName);
      _builder.append(">>`");
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
  
  protected void writeEOperationsHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Operations");
    _builder.newLine();
    CharSequence _tableHeader = this.tableHeader();
    _builder.append(_tableHeader);
    _builder.newLineIfNotEmpty();
    _builder.append("|===");
    _builder.newLine();
    _builder.append("|Name");
    _builder.newLine();
    _builder.append("|Aspect and Type");
    _builder.newLine();
    _builder.append("|Properties");
    _builder.newLine();
    _builder.append("|Description");
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
  
  protected AEcoreDocConfigPair<? extends EStructuralFeature, ? extends IEStructuralFeatureConfig> combineConfigPair(final EStructuralFeature eAttribute, final EClassConfig classConfig) {
    if (eAttribute instanceof EAttribute) {
      return _combineConfigPair((EAttribute)eAttribute, classConfig);
    } else if (eAttribute instanceof EReference) {
      return _combineConfigPair((EReference)eAttribute, classConfig);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eAttribute, classConfig).toString());
    }
  }
  
  public List<CharSequence> enumerateFeatureProperties(final IEStructuralFeatureConfigPair<?, ?> pair) {
    if (pair instanceof EAttributeConfigPair) {
      return _enumerateFeatureProperties((EAttributeConfigPair)pair);
    } else if (pair instanceof EReferenceConfigPair) {
      return _enumerateFeatureProperties((EReferenceConfigPair)pair);
    } else if (pair != null) {
      return _enumerateFeatureProperties(pair);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(pair).toString());
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
