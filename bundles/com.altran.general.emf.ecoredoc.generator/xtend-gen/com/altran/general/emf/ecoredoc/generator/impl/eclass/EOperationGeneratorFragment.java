package com.altran.general.emf.ecoredoc.generator.impl.eclass;

import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EOperationConfig;
import com.altran.general.emf.ecoredoc.generator.config.EParameterConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EOperationConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EParameterConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.IETypedElementConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.AEClassMemberGeneratorFragment;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.extension.ETypedElementPropertyExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Injector;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
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

@SuppressWarnings("all")
public class EOperationGeneratorFragment extends AEClassMemberGeneratorFragment {
  public static final Comparator<EOperation> eOperationBodyComparator = ((Comparator<EOperation>) (EOperation a, EOperation b) -> {
    String _name = a.getName();
    String _name_1 = b.getName();
    boolean _equals = Objects.equal(_name, _name_1);
    if (_equals) {
      int _size = a.getEParameters().size();
      int _size_1 = b.getEParameters().size();
      boolean _notEquals = (_size != _size_1);
      if (_notEquals) {
        return Integer.valueOf(a.getEParameters().size()).compareTo(Integer.valueOf(b.getEParameters().size()));
      } else {
        for (int i = 0; (i < a.getEParameters().size()); i++) {
          {
            final int r = a.getEParameters().get(i).getEType().getName().compareTo(b.getEParameters().get(i).getName());
            if ((r != 0)) {
              return r;
            }
          }
        }
        final String aBody = EOperationGeneratorFragment.getBodyFromAnnotation(a);
        final String bBody = EOperationGeneratorFragment.getBodyFromAnnotation(b);
        if ((aBody != null)) {
          if ((bBody != null)) {
            return aBody.compareTo(bBody);
          } else {
            return (-1);
          }
        } else {
          if ((bBody != null)) {
            return 1;
          } else {
            return 0;
          }
        }
      }
    } else {
      return a.getName().compareTo(b.getName());
    }
  });
  
  public static final Function2<EOperation, EOperation, Integer> eOperationComparator = ((Function2<EOperation, EOperation, Integer>) (EOperation a, EOperation b) -> {
    String _name = a.getName();
    String _name_1 = b.getName();
    boolean _equals = Objects.equal(_name, _name_1);
    if (_equals) {
      int _size = a.getEParameters().size();
      int _size_1 = b.getEParameters().size();
      boolean _notEquals = (_size != _size_1);
      if (_notEquals) {
        return Integer.valueOf(a.getEParameters().size()).compareTo(Integer.valueOf(b.getEParameters().size()));
      } else {
        for (int i = 0; (i < a.getEParameters().size()); i++) {
          {
            final int r = a.getEParameters().get(i).getEType().getName().compareTo(b.getEParameters().get(i).getName());
            if ((r != 0)) {
              return r;
            }
          }
        }
        return 0;
      }
    } else {
      return a.getName().compareTo(b.getName());
    }
  });
  
  protected static String getBodyFromAnnotation(final EOperation eOperation) {
    final EAnnotation genModelAnnotation = eOperation.getEAnnotation(GenModelPackage.eNS_URI);
    EMap<String, String> _details = null;
    if (genModelAnnotation!=null) {
      _details=genModelAnnotation.getDetails();
    }
    String _get = null;
    if (_details!=null) {
      _get=_details.get("body");
    }
    return _get;
  }
  
  @Extension
  private ETypedElementPropertyExtension _eTypedElementPropertyExtension = new ETypedElementPropertyExtension();
  
  public EOperationGeneratorFragment(final EClassGeneratorPart eClassGeneratorPart) {
    super(eClassGeneratorPart);
  }
  
  protected void writeEOperations(final EClassConfigPair pair) {
    final EClass eClass = pair.getElement();
    final List<EOperationConfigPair> eOperations = this.combineConfigPairs(eClass.getEOperations(), pair.getConfig());
    final List<EOperationConfigPair> inheritedEOperations = this.combineConfigPairs(this.collectInheritedEOperations(pair), pair.getConfig());
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
      this.getOutput().append(this._ecoreDocExtension.tableFooter());
    }
  }
  
  protected void writeEOperation(final EOperationConfigPair pair, final EClass eClass, final boolean inherited) {
    boolean _shouldRender = pair.getConfig().shouldRender();
    boolean _not = (!_shouldRender);
    if (_not) {
      return;
    }
    final EOperation eOperation = pair.getElement();
    final StringBuilder body = new StringBuilder();
    final String language = this.extractBody(eOperation, body);
    boolean _isBlank = StringUtils.isBlank(body);
    final boolean hasBody = (!_isBlank);
    this.writeNameAndReturnType(pair, hasBody, eClass, inherited);
    this.writeParameters(pair);
    this.writeExceptions(eOperation);
    this.writeBody(hasBody, language, body);
  }
  
  protected StringBuilder writeBody(final boolean hasBody, final String language, final StringBuilder body) {
    StringBuilder _xifexpression = null;
    if (hasBody) {
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("3+a|");
      _builder.newLine();
      _builder.append("[source,");
      _builder.append(language);
      _builder.append("]");
      _builder.newLineIfNotEmpty();
      _builder.append("----");
      _builder.newLine();
      _builder.append(body);
      _builder.newLineIfNotEmpty();
      _builder.append("----");
      _builder.newLine();
      String _newline = EcoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _xifexpression = _output.append(_builder);
    }
    return _xifexpression;
  }
  
  protected void writeExceptions(final EOperation eOperation) {
    EList<EClassifier> _eExceptions = eOperation.getEExceptions();
    for (final EClassifier ex : _eExceptions) {
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|_throws_ +");
      _builder.newLine();
      CharSequence _concatLinkTo = this.concatLinkTo(ex);
      _builder.append(_concatLinkTo);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      _builder.newLine();
      _builder.append("|");
      _builder.newLine();
      String _newline = EcoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _output.append(_builder);
    }
  }
  
  protected void writeParameters(final EOperationConfigPair pair) {
    final List<EParameterConfigPair> eParameters = this.combineConfigPairs(pair.getElement().getEParameters(), pair.getConfig());
    for (final EParameterConfigPair paramPair : eParameters) {
      {
        final EParameter param = paramPair.getElement();
        StringBuilder _output = this.getOutput();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("|`");
        String _name = param.getName();
        _builder.append(_name);
        _builder.append("` +");
        _builder.newLineIfNotEmpty();
        CharSequence _concatLinkTo = this.concatLinkTo(param.getEType());
        _builder.append(_concatLinkTo);
        _builder.newLineIfNotEmpty();
        _builder.append("|");
        String _concatProperties = this.concatProperties(paramPair);
        _builder.append(_concatProperties);
        _builder.newLineIfNotEmpty();
        _builder.append("|");
        CharSequence _documentation = this._ecoreDocExtension.getDocumentation(param);
        _builder.append(_documentation);
        _builder.newLineIfNotEmpty();
        String _newline = EcoreDocExtension.newline();
        _builder.append(_newline);
        _builder.newLineIfNotEmpty();
        _output.append(_builder);
      }
    }
  }
  
  protected StringBuilder writeNameAndReturnType(final EOperationConfigPair pair, final boolean hasBody, final EClass eClass, final boolean inherited) {
    StringBuilder _xblockexpression = null;
    {
      final EOperation eOperation = pair.getElement();
      final int lineCount = this.calculateLineSpan(eOperation, hasBody);
      final String[] inheritedFeatureSegments = this._inheritedEClassMemberSegmentsCollector.collectInheritedEClassMemberSegments(eOperation, eClass);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(".");
      _builder.append(lineCount);
      _builder.append("+|");
      {
        if ((!hasBody)) {
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
      }
      _builder.append(")`[[");
      CharSequence _joinAnchor = this._anchorExtension.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(inheritedFeatureSegments)));
      _builder.append(_joinAnchor);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      String _concatOverridesFeatures = this.concatOverridesFeatures(eOperation, eClass);
      _builder.append(_concatOverridesFeatures);
      _builder.newLineIfNotEmpty();
      String _concatOverrides = this.concatOverrides(eOperation, eClass, inherited);
      _builder.append(_concatOverrides);
      _builder.newLineIfNotEmpty();
      String _concatSubOverridesFeatures = this.concatSubOverridesFeatures(eOperation, eClass);
      _builder.append(_concatSubOverridesFeatures);
      _builder.newLineIfNotEmpty();
      String _concatSubOverrides = this.concatSubOverrides(eOperation, eClass);
      _builder.append(_concatSubOverrides);
      _builder.newLineIfNotEmpty();
      _builder.append("|_returns_ +");
      _builder.newLine();
      CharSequence _concatLinkTo = this.concatLinkTo(eOperation.getEType());
      _builder.append(_concatLinkTo);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      String _concatProperties = this.concatProperties(pair);
      _builder.append(_concatProperties);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eOperation);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      String _newline = EcoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected List<CharSequence> enumerateProperties(final IETypedElementConfigPair<?, ?> pair) {
    CharSequence _concatBounds = this._eTypedElementPropertyExtension.concatBounds(pair);
    CharSequence _defineOrdered = this._eTypedElementPropertyExtension.defineOrdered(pair);
    CharSequence _defineUnique = this._eTypedElementPropertyExtension.defineUnique(pair);
    return Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_concatBounds, _defineOrdered, _defineUnique));
  }
  
  protected String concatProperties(final IETypedElementConfigPair<?, ?> pair) {
    return IterableExtensions.join(IterableExtensions.<CharSequence>filterNull(this.enumerateProperties(pair)), AEClassMemberGeneratorFragment.PROPERTY_SEPARATOR);
  }
  
  protected String concatOverridesFeatures(final EOperation eOperation, final EClass eClass) {
    String _xblockexpression = null;
    {
      final Set<EStructuralFeature> overridesFeatures = this.collectOverriddenFeatures(eClass, eOperation);
      final Function1<EStructuralFeature, CharSequence> _function = (EStructuralFeature it) -> {
        return this.concatLinkTo(it, "{override}");
      };
      _xblockexpression = this.joinInheritance(IterableExtensions.<EStructuralFeature, CharSequence>map(overridesFeatures, _function));
    }
    return _xblockexpression;
  }
  
  protected String concatOverrides(final EOperation eOperation, final EClass eClass, final boolean inherited) {
    String _xblockexpression = null;
    {
      final Set<EOperation> overrides = this.collectOverrides(eClass, eOperation);
      final Function1<EOperation, CharSequence> _function = (EOperation it) -> {
        String _xifexpression = null;
        if (inherited) {
          _xifexpression = "{inherited}";
        } else {
          _xifexpression = "{override}";
        }
        return this.concatLinkTo(it, _xifexpression);
      };
      _xblockexpression = this.joinInheritance(IterableExtensions.<EOperation, CharSequence>map(overrides, _function));
    }
    return _xblockexpression;
  }
  
  protected String concatSubOverridesFeatures(final EOperation eOperation, final EClass eClass) {
    String _xblockexpression = null;
    {
      final Set<EStructuralFeature> subOverridesFeatures = this.collectOverriddenFeatures(this.collectAllSubTypes(eClass), eOperation);
      final Function1<EStructuralFeature, CharSequence> _function = (EStructuralFeature it) -> {
        return this.concatLinkTo(it, "{overriddenBy}");
      };
      _xblockexpression = this.joinInheritance(IterableExtensions.<EStructuralFeature, CharSequence>map(subOverridesFeatures, _function));
    }
    return _xblockexpression;
  }
  
  protected String concatSubOverrides(final EOperation eOperation, final EClass eClass) {
    String _xblockexpression = null;
    {
      final Set<EOperation> subOverrides = this.collectOverrides(this.collectAllSubTypes(eClass), eOperation);
      final Function1<EOperation, CharSequence> _function = (EOperation it) -> {
        return this.concatLinkTo(it, "{overriddenBy}");
      };
      _xblockexpression = this.joinInheritance(IterableExtensions.<EOperation, CharSequence>map(subOverrides, _function));
    }
    return _xblockexpression;
  }
  
  protected Set<EStructuralFeature> collectOverriddenFeatures(final Iterable<EClass> eClasses, final EOperation eOperation) {
    final Function1<EClass, EList<EStructuralFeature>> _function = (EClass it) -> {
      return it.getEStructuralFeatures();
    };
    final Function1<EStructuralFeature, Boolean> _function_1 = (EStructuralFeature it) -> {
      return Boolean.valueOf(this._eOperationEStructuralFeatureInteractionExtension.overridesFeature(eOperation, it));
    };
    return IterableExtensions.<EStructuralFeature>toSet(IterableExtensions.<EStructuralFeature>filter(Iterables.<EStructuralFeature>concat(IterableExtensions.<EClass, EList<EStructuralFeature>>map(eClasses, _function)), _function_1));
  }
  
  protected Set<EOperation> collectOverrides(final Iterable<EClass> eClasses, final EOperation eOperation) {
    final Function1<EClass, EList<EOperation>> _function = (EClass it) -> {
      return it.getEOperations();
    };
    final Function1<EOperation, Boolean> _function_1 = (EOperation it) -> {
      Integer _apply = EOperationGeneratorFragment.eOperationComparator.apply(it, eOperation);
      return Boolean.valueOf(((_apply).intValue() == 0));
    };
    return IterableExtensions.<EOperation>toSet(IterableExtensions.<EOperation>filter(Iterables.<EOperation>concat(IterableExtensions.<EClass, EList<EOperation>>map(eClasses, _function)), _function_1));
  }
  
  protected Set<EStructuralFeature> collectOverriddenFeatures(final EClass eClass, final EOperation eOperation) {
    return this.collectOverriddenFeatures(eClass.getEAllSuperTypes(), eOperation);
  }
  
  protected Set<EOperation> collectOverrides(final EClass eClass, final EOperation eOperation) {
    final Set<EOperation> result = this.collectOverrides(eClass.getEAllSuperTypes(), eOperation);
    EObject _eContainer = eOperation.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer, eClass));
    if (_notEquals) {
      result.add(eOperation);
    }
    return result;
  }
  
  protected int calculateLineSpan(final EOperation eOperation, final boolean hasBody) {
    int _size = eOperation.getEParameters().size();
    int _plus = (1 + _size);
    int _size_1 = eOperation.getEExceptions().size();
    int _plus_1 = (_plus + _size_1);
    int _xifexpression = (int) 0;
    if (hasBody) {
      _xifexpression = 1;
    } else {
      _xifexpression = 0;
    }
    return (_plus_1 + _xifexpression);
  }
  
  protected String extractBody(final EOperation eOperation, final StringBuilder body) {
    String language = null;
    Injector _xcoreInjector = this.getXcoreInjector();
    boolean _tripleNotEquals = (_xcoreInjector != null);
    if (_tripleNotEquals) {
      final XcoreMapper mapper = this.getXcoreInjector().<XcoreMapper>getInstance(XcoreMapper.class);
      final XOperation xOp = mapper.getXOperation(eOperation);
      XBlockExpression _body = null;
      if (xOp!=null) {
        _body=xOp.getBody();
      }
      boolean _tripleNotEquals_1 = (_body != null);
      if (_tripleNotEquals_1) {
        language = "xtend";
        final Function1<INode, String> _function = (INode it) -> {
          return it.getText();
        };
        final String text = this.normalizeNewline(IterableExtensions.join(ListExtensions.<INode, String>map(NodeModelUtils.findNodesForFeature(xOp.getBody(), XbasePackage.Literals.XBLOCK_EXPRESSION__EXPRESSIONS), _function)));
        final String[] lines = StringUtils.split(text, "\n");
        int _size = ((List<String>)Conversions.doWrapArray(lines)).size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          final String prefix = StringUtils.getCommonPrefix(lines);
          final Function1<String, String> _function_1 = (String it) -> {
            return StringUtils.removeStart(it, prefix);
          };
          body.append(IterableExtensions.join(ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(lines)), _function_1), EcoreDocExtension.newline()));
        } else {
          body.append(IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(lines))).trim());
        }
      }
    }
    boolean _isBlank = StringUtils.isBlank(body);
    if (_isBlank) {
      language = "java";
      body.append(StringUtils.defaultString(EOperationGeneratorFragment.getBodyFromAnnotation(eOperation)).trim());
    }
    return language;
  }
  
  private String normalizeNewline(final String text) {
    return StringUtils.replaceEach(text, 
      new String[] { "\r\n", "\n\r", "\r" }, 
      new String[] { "\n", "\n", "\n" });
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
  
  protected List<EOperationConfigPair> combineConfigPairs(final Collection<? extends EOperation> eOperations, final EClassConfig classConfig) {
    final Function1<EOperation, EOperationConfigPair> _function = (EOperation op) -> {
      final Function1<EOperationConfig, Boolean> _function_1 = (EOperationConfig it) -> {
        String _id = it.getId();
        String _joinId = it.joinId(op);
        return Boolean.valueOf(Objects.equal(_id, _joinId));
      };
      EOperationConfig _findFirst = IterableExtensions.<EOperationConfig>findFirst(classConfig.getEOperations(), _function_1);
      return new EOperationConfigPair(op, _findFirst);
    };
    return IterableExtensions.<EOperationConfigPair>toList(IterableExtensions.map(eOperations, _function));
  }
  
  protected List<EParameterConfigPair> combineConfigPairs(final Collection<? extends EParameter> eParameters, final EOperationConfig operationConfig) {
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
  
  protected void writeEOperationsHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Operations");
    _builder.newLine();
    CharSequence _tableHeader = this._ecoreDocExtension.tableHeader();
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
  
  protected Set<EOperation> collectInheritedEOperations(final EClassConfigPair pair) {
    Set<EOperation> _xifexpression = null;
    boolean _shouldRepeatInherited = pair.getConfig().shouldRepeatInherited();
    if (_shouldRepeatInherited) {
      final EClass eClass = pair.getElement();
      final TreeSet<EOperation> result = Sets.<EOperation>newTreeSet(EOperationGeneratorFragment.eOperationBodyComparator);
      final Function1<EOperation, Boolean> _function = (EOperation it) -> {
        return Boolean.valueOf(eClass.getEOperations().contains(it));
      };
      final Function1<EOperation, Boolean> _function_1 = (EOperation it) -> {
        EObject _eContainer = it.eContainer();
        return Boolean.valueOf(Objects.equal(EcorePackage.Literals.EOBJECT, _eContainer));
      };
      final Function1<EOperation, Boolean> _function_2 = (EOperation op) -> {
        final Function1<EOperation, Boolean> _function_3 = (EOperation it) -> {
          return Boolean.valueOf(it.isOverrideOf(op));
        };
        return Boolean.valueOf(IterableExtensions.<EOperation>exists(eClass.getEOperations(), _function_3));
      };
      final Function1<EOperation, Boolean> _function_3 = (EOperation op) -> {
        final Function1<EStructuralFeature, Boolean> _function_4 = (EStructuralFeature it) -> {
          return Boolean.valueOf(this._eOperationEStructuralFeatureInteractionExtension.implementsOperation(it, op));
        };
        return Boolean.valueOf(IterableExtensions.<EStructuralFeature>exists(eClass.getEStructuralFeatures(), _function_4));
      };
      Iterables.<EOperation>addAll(result, 
        IterableExtensions.<EOperation>reject(IterableExtensions.<EOperation>reject(IterableExtensions.<EOperation>reject(IterableExtensions.<EOperation>reject(eClass.getEAllOperations(), _function), _function_1), _function_2), _function_3));
      final Function1<EOperation, String> _function_4 = (EOperation it) -> {
        String _name = it.getName();
        final Function1<EParameter, String> _function_5 = (EParameter it_1) -> {
          return it_1.getEType().getName();
        };
        String _join = IterableExtensions.join(ListExtensions.<EParameter, String>map(it.getEParameters(), _function_5));
        return (_name + _join);
      };
      final Function1<List<EOperation>, EOperation> _function_5 = (List<EOperation> it) -> {
        return IterableExtensions.<EOperation>head(ListExtensions.<EOperation>sortInplace(it, EOperationGeneratorFragment.eOperationBodyComparator));
      };
      return IterableExtensions.<EOperation>toSet(IterableExtensions.<List<EOperation>, EOperation>map(IterableExtensions.<String, EOperation>groupBy(result, _function_4).values(), _function_5));
    } else {
      _xifexpression = CollectionLiterals.<EOperation>emptySet();
    }
    return _xifexpression;
  }
  
  protected Injector getXcoreInjector() {
    return this.eClassGeneratorPart.getXcoreInjector();
  }
}
