package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEClassifierConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.extension.AnchorExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EOperationEStructuralFeatureInteractionExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.InheritedEClassMemberSegmentsCollector;
import com.altran.general.emf.ecoredoc.generator.impl.extension.TypeSegmentsCollector;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Injector;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public abstract class AEcoreDocGeneratorPart {
  @Extension
  protected EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  @Extension
  protected AnchorExtension _anchorExtension = new AnchorExtension();
  
  @Extension
  protected InheritedEClassMemberSegmentsCollector _inheritedEClassMemberSegmentsCollector = new InheritedEClassMemberSegmentsCollector();
  
  @Extension
  private EOperationEStructuralFeatureInteractionExtension _eOperationEStructuralFeatureInteractionExtension = new EOperationEStructuralFeatureInteractionExtension();
  
  @Extension
  private TypeSegmentsCollector _typeSegmentsCollector = new TypeSegmentsCollector();
  
  private final EcoreDocGeneratorConfig config;
  
  private final Multimap<EPackage, EClassifier> ePackages;
  
  private final Injector xcoreInjector;
  
  private StringBuilder output;
  
  public AEcoreDocGeneratorPart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages, final Injector xcoreInjector) {
    this.config = config;
    this.ePackages = ePackages;
    this.xcoreInjector = xcoreInjector;
  }
  
  public abstract StringBuilder write(final EPackage ePackage);
  
  public void clearOutput() {
    StringBuilder _stringBuilder = new StringBuilder();
    this.output = _stringBuilder;
  }
  
  public Multimap<EPackage, EClassifier> getEPackages() {
    return this.ePackages;
  }
  
  public EcoreDocGeneratorConfig getConfig() {
    return this.config;
  }
  
  public Injector getXcoreInjector() {
    return this.xcoreInjector;
  }
  
  public StringBuilder getOutput() {
    StringBuilder _xblockexpression = null;
    {
      if ((this.output == null)) {
        throw new IllegalStateException("Tried to write to output before clearing it");
      }
      _xblockexpression = this.output;
    }
    return _xblockexpression;
  }
  
  public CharSequence concatLinkTo(final ENamedElement eNamedElement) {
    return this.concatLinkTo(eNamedElement, "");
  }
  
  protected CharSequence _concatLinkTo(final ENamedElement eNamedElement, final String prefix) {
    CharSequence _xblockexpression = null;
    {
      final IENamedElementConfig cfg = this.getConfig().findConfig(eNamedElement);
      CharSequence _xifexpression = null;
      boolean _shouldRender = false;
      if (cfg!=null) {
        _shouldRender=cfg.shouldRender();
      }
      if (_shouldRender) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("`<<");
        CharSequence _concatAnchor = this._anchorExtension.concatAnchor(eNamedElement);
        _builder.append(_concatAnchor);
        _builder.append(", ");
        _builder.append(prefix);
        CharSequence _concatReferenceName = this._anchorExtension.concatReferenceName(eNamedElement);
        _builder.append(_concatReferenceName);
        _builder.append(">>`");
        _xifexpression = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("`");
        _builder_1.append(prefix);
        CharSequence _concatReferenceName_1 = this._anchorExtension.concatReferenceName(eNamedElement);
        _builder_1.append(_concatReferenceName_1);
        _builder_1.append("`");
        _xifexpression = _builder_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _concatLinkTo(final EDataType eDataType, final String prefix) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultDataType = this._ecoreDocExtension.isDefaultEDataType(eDataType);
      CharSequence _xifexpression = null;
      if (defaultDataType) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("`");
        String _name = eDataType.getName();
        _builder.append(_name);
        _builder.append("`");
        _xifexpression = _builder;
      } else {
        CharSequence _xblockexpression_1 = null;
        {
          final IENamedElementConfig cfg = this.getConfig().findConfig(eDataType);
          CharSequence _xifexpression_1 = null;
          boolean _shouldRender = false;
          if (cfg!=null) {
            _shouldRender=cfg.shouldRender();
          }
          if (_shouldRender) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("`<<");
            CharSequence _concatAnchor = this._anchorExtension.concatAnchor(eDataType);
            _builder_1.append(_concatAnchor);
            _builder_1.append(", ");
            _builder_1.append(prefix);
            CharSequence _concatReferenceName = this._anchorExtension.concatReferenceName(eDataType);
            _builder_1.append(_concatReferenceName);
            _builder_1.append(">>`");
            _xifexpression_1 = _builder_1;
          } else {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("`");
            _builder_2.append(prefix);
            CharSequence _concatReferenceName_1 = this._anchorExtension.concatReferenceName(eDataType);
            _builder_2.append(_concatReferenceName_1);
            _builder_2.append("`");
            _xifexpression_1 = _builder_2;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _concatLinkTo(final Void eDataType, final String prefix) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(prefix);
    _builder.append("`void`");
    return _builder;
  }
  
  protected CharSequence _concatUsedLink(final ETypedElement eTypedElement, final EClass eClassThatInherits) {
    CharSequence _xblockexpression = null;
    {
      final String[] inheritedFeatureSegments = this._inheritedEClassMemberSegmentsCollector.collectInheritedEClassMemberSegments(eTypedElement, eClassThatInherits);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("`<<");
      CharSequence _joinAnchor = this._anchorExtension.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(inheritedFeatureSegments)));
      _builder.append(_joinAnchor);
      _builder.append(", ");
      CharSequence _joinReference = this._anchorExtension.joinReference(((Collection<? extends CharSequence>)Conversions.doWrapArray(inheritedFeatureSegments)));
      _builder.append(_joinReference);
      _builder.append(">>`");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _concatUsedLink(final EOperation eOperation, final EClass eClassThatInherits) {
    CharSequence _xblockexpression = null;
    {
      final String[] inheritedFeatureSegments = this._inheritedEClassMemberSegmentsCollector.collectInheritedEClassMemberSegments(eOperation, eClassThatInherits);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("`<<");
      CharSequence _joinAnchor = this._anchorExtension.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(inheritedFeatureSegments)));
      _builder.append(_joinAnchor);
      _builder.append(", ");
      CharSequence _joinReference = this._anchorExtension.joinReference(((Collection<? extends CharSequence>)Conversions.doWrapArray(this._typeSegmentsCollector.collectTypeSegments(eOperation))));
      _builder.append(_joinReference);
      _builder.append("(");
      {
        EList<EParameter> _eParameters = eOperation.getEParameters();
        boolean _hasElements = false;
        for(final EParameter param : _eParameters) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(", ", "");
          }
          String _name = param.getName();
          _builder.append(_name);
        }
      }
      _builder.append(")>>`");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected void writeUseCases(final IEClassifierConfigPair<?, ?> pair) {
    boolean _shouldRenderUseCases = pair.getConfig().shouldRenderUseCases();
    boolean _not = (!_shouldRenderUseCases);
    if (_not) {
      return;
    }
    final EClassifier target = pair.getElement();
    final Function1<EClass, Iterable<Pair<EClass, ETypedElement>>> _function = (EClass eClass) -> {
      Iterable<Pair<EClass, ETypedElement>> _xblockexpression = null;
      {
        final Set<ETypedElement> members = CollectionLiterals.<ETypedElement>newLinkedHashSet();
        final Function1<EStructuralFeature, Boolean> _function_1 = (EStructuralFeature feat) -> {
          final Function1<EOperation, Boolean> _function_2 = (EOperation it) -> {
            return Boolean.valueOf(this._eOperationEStructuralFeatureInteractionExtension.overridesFeature(it, feat));
          };
          return Boolean.valueOf(IterableExtensions.<EOperation>exists(eClass.getEOperations(), _function_2));
        };
        List<EStructuralFeature> _sortBy = IterableExtensions.<EStructuralFeature, String>sortBy(IterableExtensions.<EStructuralFeature>reject(eClass.getEAllStructuralFeatures(), _function_1), EcoreDocExtension.eStructuralFeatureSorter);
        Iterables.<ETypedElement>addAll(members, _sortBy);
        final Function1<EOperation, Boolean> _function_2 = (EOperation it) -> {
          EObject _eContainer = it.eContainer();
          return Boolean.valueOf(Objects.equal(EcorePackage.Literals.EOBJECT, _eContainer));
        };
        final Function1<EOperation, Boolean> _function_3 = (EOperation op) -> {
          final Function1<EStructuralFeature, Boolean> _function_4 = (EStructuralFeature it) -> {
            return Boolean.valueOf(this._eOperationEStructuralFeatureInteractionExtension.implementsOperation(it, op));
          };
          return Boolean.valueOf(IterableExtensions.<EStructuralFeature>exists(eClass.getEStructuralFeatures(), _function_4));
        };
        final List<EOperation> eOperations = IterableExtensions.<EOperation, String>sortBy(IterableExtensions.<EOperation>reject(IterableExtensions.<EOperation>reject(eClass.getEAllOperations(), _function_2), _function_3), EcoreDocExtension.eOperationSorter);
        Iterables.<ETypedElement>addAll(members, eOperations);
        final Function1<ETypedElement, Pair<EClass, ETypedElement>> _function_4 = (ETypedElement it) -> {
          return Pair.<EClass, ETypedElement>of(eClass, it);
        };
        _xblockexpression = IterableExtensions.<ETypedElement, Pair<EClass, ETypedElement>>map(members, _function_4);
      }
      return _xblockexpression;
    };
    final Function1<Pair<EClass, ETypedElement>, Boolean> _function_1 = (Pair<EClass, ETypedElement> it) -> {
      boolean _xblockexpression = false;
      {
        final ETypedElement v = it.getValue();
        boolean _switchResult = false;
        boolean _matched = false;
        if (v instanceof EOperation) {
          _matched=true;
          _switchResult = ((Objects.equal(target, ((EOperation)v).getEType()) || ((EOperation)v).getEExceptions().contains(target)) || ListExtensions.<EParameter, EClassifier>map(((EOperation)v).getEParameters(), ((Function1<EParameter, EClassifier>) (EParameter it_1) -> {
            return it_1.getEType();
          })).contains(target));
        }
        if (!_matched) {
          EClassifier _eType = v.getEType();
          _switchResult = Objects.equal(target, _eType);
        }
        _xblockexpression = _switchResult;
      }
      return Boolean.valueOf(_xblockexpression);
    };
    final Function1<Pair<EClass, ETypedElement>, String> _function_2 = (Pair<EClass, ETypedElement> it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("* ");
      CharSequence _concatUsedLink = this.concatUsedLink(it.getValue(), it.getKey());
      _builder.append(_concatUsedLink);
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    };
    final String usages = IterableExtensions.join(IterableExtensions.<String>toSet(IterableExtensions.<Pair<EClass, ETypedElement>, String>map(IterableExtensions.<Pair<EClass, ETypedElement>>filter(Iterables.<Pair<EClass, ETypedElement>>concat(ListExtensions.<EClass, Iterable<Pair<EClass, ETypedElement>>>map(IterableExtensions.<EClass, String>sortBy(this.collectAllEClasses(), EcoreDocExtension.eClassifierSorter), _function)), _function_1), _function_2)));
    boolean _isEmpty = usages.isEmpty();
    boolean _not_1 = (!_isEmpty);
    if (_not_1) {
      StringConcatenation _builder = new StringConcatenation();
      String _newline = EcoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _builder.append(".Used at");
      _builder.newLine();
      _builder.append(usages);
      _builder.newLineIfNotEmpty();
      this.output.append(_builder);
    }
  }
  
  protected CharSequence defineDefaultValue(final IEClassifierConfigPair<?, ?> pair) {
    CharSequence _xblockexpression = null;
    {
      final EClassifier eClassifier = pair.getElement();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_undefined_");
      final String defaultValue = _builder.toString();
      String _xifexpression = null;
      boolean _eIsSet = eClassifier.eIsSet(EcorePackage.eINSTANCE.getEClassifier_DefaultValue());
      if (_eIsSet) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("`");
        Object _defaultValue = eClassifier.getDefaultValue();
        _builder_1.append(_defaultValue);
        _builder_1.append("`");
        _xifexpression = _builder_1.toString();
      } else {
        _xifexpression = null;
      }
      final String value = _xifexpression;
      _xblockexpression = this.concatProperty("Default Value", defaultValue, value, pair);
    }
    return _xblockexpression;
  }
  
  protected CharSequence defineInstanceClassName(final IEClassifierConfigPair<?, ?> pair) {
    CharSequence _xblockexpression = null;
    {
      final EClassifier eClassifier = pair.getElement();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_undefined_");
      final String defaultValue = _builder.toString();
      String _xifexpression = null;
      boolean _eIsSet = eClassifier.eIsSet(EcorePackage.eINSTANCE.getEClassifier_InstanceClassName());
      if (_eIsSet) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("`");
        String _instanceClassName = eClassifier.getInstanceClassName();
        _builder_1.append(_instanceClassName);
        _builder_1.append("`");
        _xifexpression = _builder_1.toString();
      } else {
        _xifexpression = null;
      }
      final String value = _xifexpression;
      _xblockexpression = this.concatProperty("Instance Type Name", defaultValue, value, pair);
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatProperty(final String name, final String defaultValue, final String value, final IEClassifierConfigPair<?, ?> pair) {
    CharSequence _xifexpression = null;
    if (((value != null) || pair.getConfig().shouldRenderDefaults())) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(name);
      _builder.append(":: ");
      {
        if ((value != null)) {
          _builder.append(value);
        } else {
          _builder.append(defaultValue);
        }
      }
      _xifexpression = _builder;
    }
    return _xifexpression;
  }
  
  protected Collection<EClass> collectAllEClasses() {
    final Function1<EClass, Boolean> _function = (EClass it) -> {
      return Boolean.valueOf(this.getConfig().findConfig(it).shouldRender());
    };
    return IterableExtensions.<EClass>toSet(IterableExtensions.<EClass>filter(Iterables.<EClass>filter(this.ePackages.values(), EClass.class), _function));
  }
  
  public CharSequence concatLinkTo(final ENamedElement eDataType, final String prefix) {
    if (eDataType instanceof EDataType) {
      return _concatLinkTo((EDataType)eDataType, prefix);
    } else if (eDataType != null) {
      return _concatLinkTo(eDataType, prefix);
    } else if (eDataType == null) {
      return _concatLinkTo((Void)null, prefix);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eDataType, prefix).toString());
    }
  }
  
  protected CharSequence concatUsedLink(final ETypedElement eOperation, final EClass eClassThatInherits) {
    if (eOperation instanceof EOperation) {
      return _concatUsedLink((EOperation)eOperation, eClassThatInherits);
    } else if (eOperation != null) {
      return _concatUsedLink(eOperation, eClassThatInherits);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eOperation, eClassThatInherits).toString());
    }
  }
}
