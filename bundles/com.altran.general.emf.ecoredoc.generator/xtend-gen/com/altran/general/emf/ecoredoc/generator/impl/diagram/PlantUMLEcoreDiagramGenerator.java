package com.altran.general.emf.ecoredoc.generator.impl.diagram;

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.google.common.collect.Iterables;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class PlantUMLEcoreDiagramGenerator {
  private final Set<EClassifier> eClassifiersWithFocus = CollectionLiterals.<EClassifier>newHashSet();
  
  private final Function1<? super ENamedElement, ? extends Boolean> predicate;
  
  private final Set<EClassifier> eClassifiers;
  
  private final Set<EPackage> ePackages;
  
  public PlantUMLEcoreDiagramGenerator(final Iterator<? extends EClassifier> input, final boolean focusInput, final boolean typeHierarchy) {
    this(input, focusInput, typeHierarchy, ((Function1<ENamedElement, Boolean>) (ENamedElement it) -> {
      return Boolean.valueOf(true);
    }));
  }
  
  public PlantUMLEcoreDiagramGenerator(final Iterator<? extends EClassifier> input, final boolean focusInput, final boolean typeHierarchy, final EcoreDocGeneratorConfig config) {
    this(input, focusInput, typeHierarchy, ((Function1<ENamedElement, Boolean>) (ENamedElement element) -> {
      final IENamedElementConfig elementConfig = config.findConfig(element);
      return ((elementConfig == null) || elementConfig.shouldRender());
    }));
  }
  
  public PlantUMLEcoreDiagramGenerator(final Iterator<? extends EClassifier> input, final boolean focusInput, final boolean typeHierarchy, final Function1<? super ENamedElement, ? extends Boolean> predicate) {
    this.predicate = predicate;
    final Set<EClassifier> filteredInput = IteratorExtensions.<EClassifier>toSet(IteratorExtensions.filter(input, ((Function1<? super EClassifier, Boolean>)predicate)));
    LinkedHashSet<EClassifier> _linkedHashSet = new LinkedHashSet<EClassifier>(filteredInput);
    this.eClassifiers = _linkedHashSet;
    if (focusInput) {
      Iterables.<EClassifier>addAll(this.eClassifiersWithFocus, filteredInput);
    }
    if (typeHierarchy) {
      final Function1<EClass, EList<EClass>> _function = (EClass it) -> {
        return it.getEAllSuperTypes();
      };
      Iterable<EClass> _filter = IterableExtensions.<EClass>filter(IterableExtensions.<EClass, EClass>flatMap(Iterables.<EClass>filter(filteredInput, EClass.class), _function), ((Function1<? super EClass, Boolean>)predicate));
      Iterables.<EClassifier>addAll(this.eClassifiers, _filter);
    } else {
      final Function1<EClass, EList<EClass>> _function_1 = (EClass it) -> {
        return it.getESuperTypes();
      };
      Iterable<EClass> _filter_1 = IterableExtensions.<EClass>filter(IterableExtensions.<EClass, EClass>flatMap(Iterables.<EClass>filter(filteredInput, EClass.class), _function_1), ((Function1<? super EClass, Boolean>)predicate));
      Iterables.<EClassifier>addAll(this.eClassifiers, _filter_1);
    }
    final Function1<EClass, EList<EReference>> _function_2 = (EClass it) -> {
      return it.getEReferences();
    };
    final Function1<EReference, EClassifier> _function_3 = (EReference it) -> {
      return it.getEType();
    };
    Iterable<EClassifier> _filter_2 = IterableExtensions.<EClassifier>filter(IterableExtensions.<EReference, EClassifier>map(IterableExtensions.<EReference>filter(IterableExtensions.<EClass, EReference>flatMap(Iterables.<EClass>filter(filteredInput, EClass.class), _function_2), ((Function1<? super EReference, Boolean>)predicate)), _function_3), ((Function1<? super EClassifier, Boolean>)predicate));
    Iterables.<EClassifier>addAll(this.eClassifiers, _filter_2);
    final Function1<EClass, EList<EAttribute>> _function_4 = (EClass it) -> {
      return it.getEAttributes();
    };
    final Function1<EAttribute, EClassifier> _function_5 = (EAttribute it) -> {
      return it.getEType();
    };
    Iterable<EEnum> _filter_3 = IterableExtensions.<EEnum>filter(Iterables.<EEnum>filter(IterableExtensions.<EAttribute, EClassifier>map(IterableExtensions.<EAttribute>filter(IterableExtensions.<EClass, EAttribute>flatMap(Iterables.<EClass>filter(filteredInput, EClass.class), _function_4), ((Function1<? super EAttribute, Boolean>)predicate)), _function_5), EEnum.class), ((Function1<? super EEnum, Boolean>)predicate));
    Iterables.<EClassifier>addAll(this.eClassifiers, _filter_3);
    final Function1<EClassifier, EPackage> _function_6 = (EClassifier it) -> {
      return it.getEPackage();
    };
    this.ePackages = IterableExtensions.<EPackage>toSet(IterableExtensions.<EClassifier, EPackage>map(this.eClassifiers, _function_6));
  }
  
  public void setFocus(final Iterable<? extends EClassifier> focus) {
    Iterables.<EClassifier>addAll(this.eClassifiersWithFocus, focus);
  }
  
  public CharSequence generateDiagram() {
    CharSequence _xblockexpression = null;
    {
      final Function1<EEnum, EList<EEnumLiteral>> _function = (EEnum it) -> {
        return it.getELiterals();
      };
      final Set<EEnumLiteral> eEnumLiterals = IterableExtensions.<EEnumLiteral>toSet(IterableExtensions.<EEnumLiteral>filter(IterableExtensions.<EEnum, EEnumLiteral>flatMap(Iterables.<EEnum>filter(this.eClassifiers, EEnum.class), _function), ((Function1<? super EEnumLiteral, Boolean>)this.predicate)));
      final Set<EClass> eClasses = IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(this.eClassifiers, EClass.class));
      final Function1<EClass, Iterable<Pair<EClass, EClass>>> _function_1 = (EClass it) -> {
        return this.filterSuperTypes(it);
      };
      final Set<Pair<EClass, EClass>> eSuperTypes = IterableExtensions.<Pair<EClass, EClass>>toSet(IterableExtensions.<EClass, Pair<EClass, EClass>>flatMap(eClasses, _function_1));
      final Function1<EClass, Iterable<EOperation>> _function_2 = (EClass it) -> {
        return this.filterOperations(it, this.predicate);
      };
      final Set<EOperation> eOperations = IterableExtensions.<EOperation>toSet(IterableExtensions.<EClass, EOperation>flatMap(eClasses, _function_2));
      final Function1<EClass, Iterable<EStructuralFeature>> _function_3 = (EClass it) -> {
        return this.filterAttributes(it, this.predicate);
      };
      final Set<EStructuralFeature> eAttributes = IterableExtensions.<EStructuralFeature>toSet(IterableExtensions.<EClass, EStructuralFeature>flatMap(eClasses, _function_3));
      final Function1<EClass, Iterable<EReference>> _function_4 = (EClass it) -> {
        return this.filterReferences(it, this.predicate);
      };
      final List<EReference> eReferences = this.<EReference, List<EReference>>removeEOpposites(IterableExtensions.<EReference>toList(IterableExtensions.<EClass, EReference>flatMap(eClasses, _function_4)));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("skinparam Arrow {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Color Black");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Thickness 0.6");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("skinparam Class {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("BackgroundColor <<E>> #white/technology");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("BorderColor Black");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("BorderThickness 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("skinparam Stereotype {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ABackgroundColor motivation");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("CBackgroundColor business");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("EBackgroundColor technology");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("IBackgroundColor motivation");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("skinparam RoundCorner 8");
      _builder.newLine();
      {
        int _size = this.ePackages.size();
        boolean _greaterThan = (_size > 1);
        if (_greaterThan) {
          _builder.append("skinparam Package {");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("FontStyle Plain");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("BorderColor LightSlateGray");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("BorderThickness 1");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("set namespaceSeparator .");
          _builder.newLine();
        }
      }
      _builder.newLine();
      {
        for(final EClassifier eClassifier : this.eClassifiers) {
          String _generateEClassifier = this.generateEClassifier(eClassifier);
          _builder.append(_generateEClassifier);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        for(final EEnumLiteral eEnumLiteral : eEnumLiterals) {
          String _fqn = this.getFqn(eEnumLiteral.getEEnum());
          _builder.append(_fqn);
          _builder.append(" : ");
          String _name = eEnumLiteral.getName();
          _builder.append(_name);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        for(final EStructuralFeature eAttribute : eAttributes) {
          String _fqn_1 = this.getFqn(eAttribute.getEContainingClass());
          _builder.append(_fqn_1);
          _builder.append(" : ");
          CharSequence _generateEAttribute = this.generateEAttribute(eAttribute);
          _builder.append(_generateEAttribute);
          _builder.newLineIfNotEmpty();
          {
            boolean _contains = this.eClassifiers.contains(eAttribute.getEType());
            if (_contains) {
              String _fqn_2 = this.getFqn(eAttribute.getEContainingClass());
              _builder.append(_fqn_2);
              _builder.append(" -[hidden] ");
              String _fqn_3 = this.getFqn(eAttribute.getEType());
              _builder.append(_fqn_3);
            }
          }
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        for(final EOperation eOperation : eOperations) {
          String _fqn_4 = this.getFqn(eOperation.getEContainingClass());
          _builder.append(_fqn_4);
          _builder.append(" : ");
          CharSequence _generateEOperation = this.generateEOperation(eOperation);
          _builder.append(_generateEOperation);
          _builder.newLineIfNotEmpty();
          {
            boolean _contains_1 = this.eClassifiers.contains(eOperation.getEType());
            if (_contains_1) {
              String _fqn_5 = this.getFqn(eOperation.getEContainingClass());
              _builder.append(_fqn_5);
              _builder.append(" -[hidden] ");
              String _fqn_6 = this.getFqn(eOperation.getEType());
              _builder.append(_fqn_6);
            }
          }
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        for(final Pair<EClass, EClass> eSuperType : eSuperTypes) {
          CharSequence _generateESuperType = this.generateESuperType(eSuperType);
          _builder.append(_generateESuperType);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      {
        for(final EReference eReference : eReferences) {
          CharSequence _generateEReference = this.generateEReference(eReference);
          _builder.append(_generateEReference);
          _builder.newLineIfNotEmpty();
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private String generateEClassifier(final EClassifier eClassifier) {
    final boolean focus = this.eClassifiersWithFocus.contains(eClassifier);
    String _switchResult = null;
    final EClassifier it = eClassifier;
    boolean _matched = false;
    if (it instanceof EClass) {
      boolean _isInterface = ((EClass)it).isInterface();
      if (_isInterface) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("interface ");
        String _fqn = this.getFqn(it);
        _builder.append(_fqn);
        _builder.append(" #white/motivation");
        {
          if (focus) {
            _builder.append(" ##[bold]black");
          }
        }
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (it instanceof EClass) {
        boolean _isAbstract = ((EClass)it).isAbstract();
        if (_isAbstract) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("abstract ");
          String _fqn = this.getFqn(it);
          _builder.append(_fqn);
          _builder.append(" #white/motivation");
          {
            if (focus) {
              _builder.append(" ##[bold]black");
            }
          }
          _switchResult = _builder.toString();
        }
      }
    }
    if (!_matched) {
      if (it instanceof EClass) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class ");
        String _fqn = this.getFqn(it);
        _builder.append(_fqn);
        _builder.append(" #white/business");
        {
          if (focus) {
            _builder.append(" ##[bold]black");
          }
        }
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (it instanceof EEnum) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("enum ");
        String _fqn = this.getFqn(it);
        _builder.append(_fqn);
        _builder.append(" #white/technology");
        {
          if (focus) {
            _builder.append(" ##[bold]black");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("hide ");
        String _fqn_1 = this.getFqn(it);
        _builder.append(_fqn_1);
        _builder.append(" methods");
        _builder.newLineIfNotEmpty();
        _switchResult = _builder.toString();
      }
    }
    if (!_matched) {
      if (it instanceof EDataType) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class ");
        String _fqn = this.getFqn(it);
        _builder.append(_fqn);
        _builder.append(" << (D, business) >> #white/business");
        {
          if (focus) {
            _builder.append(" ##[bold]black");
          }
        }
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("//");
        String _instanceClassName = ((EDataType)it).getInstanceClassName();
        _builder.append(_instanceClassName, "\t");
        _builder.append("//");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
        _builder.append("hide ");
        String _fqn_1 = this.getFqn(it);
        _builder.append(_fqn_1);
        _builder.append(" methods");
        _builder.newLineIfNotEmpty();
        _switchResult = _builder.toString();
      }
    }
    return _switchResult;
  }
  
  private CharSequence generateESuperType(final Pair<EClass, EClass> eSuperType) {
    CharSequence _xblockexpression = null;
    {
      final EClass baseType = eSuperType.getKey();
      final EClass superType = eSuperType.getValue();
      StringConcatenation _builder = new StringConcatenation();
      String _fqn = this.getFqn(baseType);
      _builder.append(_fqn);
      _builder.append(" ");
      {
        if ((superType.isInterface() && (!baseType.isInterface()))) {
          _builder.append(".up.");
        } else {
          _builder.append("-up-");
        }
      }
      _builder.append("|> ");
      String _fqn_1 = this.getFqn(superType);
      _builder.append(_fqn_1);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence generateEAttribute(final EStructuralFeature eStructuralFeature) {
    String _xifexpression = null;
    String _defaultValueLiteral = eStructuralFeature.getDefaultValueLiteral();
    boolean _tripleNotEquals = (_defaultValueLiteral != null);
    if (_tripleNotEquals) {
      _xifexpression = eStructuralFeature.getDefaultValueLiteral();
    } else {
      String _xifexpression_1 = null;
      Object _defaultValue = eStructuralFeature.getDefaultValue();
      boolean _tripleNotEquals_1 = (_defaultValue != null);
      if (_tripleNotEquals_1) {
        String _xblockexpression = null;
        {
          final EClassifier eType = eStructuralFeature.getEType();
          String _xifexpression_2 = null;
          if ((eType instanceof EDataType)) {
            _xifexpression_2 = EcoreUtil.convertToString(((EDataType)eType), eStructuralFeature.getDefaultValue());
          } else {
            _xifexpression_2 = String.valueOf(eStructuralFeature.getDefaultValue());
          }
          _xblockexpression = _xifexpression_2;
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    }
    final String defaultValueLiteral = _xifexpression;
    StringConcatenation _builder = new StringConcatenation();
    String _name = eStructuralFeature.getName();
    _builder.append(_name);
    _builder.append(" : ");
    String _name_1 = eStructuralFeature.getEType().getName();
    _builder.append(_name_1);
    {
      if ((defaultValueLiteral != null)) {
        _builder.append(" = ");
        _builder.append(defaultValueLiteral);
      }
    }
    final String text = _builder.toString();
    return this.wrapWithMultiplicity(text, eStructuralFeature);
  }
  
  private CharSequence generateEReference(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final boolean superType = eReference.getEContainingClass().getEAllSuperTypes().contains(eReference.getEType());
      String _switchResult = null;
      final EReference it = eReference;
      boolean _matched = false;
      if ((it.isContainment() && (it.getEOpposite() == null))) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("*-");
        {
          if (superType) {
            _builder.append("up");
          } else {
            _builder.append("down");
          }
        }
        _builder.append("->");
        _switchResult = _builder.toString();
      }
      if (!_matched) {
        if ((it.isContainment() && (it.getEOpposite() != null))) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("*-");
          {
            if (superType) {
              _builder_1.append("up");
            } else {
              _builder_1.append("down");
            }
          }
          _builder_1.append("-");
          _switchResult = _builder_1.toString();
        }
      }
      if (!_matched) {
        if ((it.isContainment() && (it.getEOpposite() == null))) {
          _matched=true;
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("*-");
          {
            if (superType) {
              _builder_2.append("up");
            } else {
              _builder_2.append("down");
            }
          }
          _builder_2.append("->");
          _switchResult = _builder_2.toString();
        }
      }
      if (!_matched) {
        if ((it.isContainment() && (it.getEOpposite() != null))) {
          _matched=true;
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("*-");
          {
            if (superType) {
              _builder_3.append("up");
            } else {
              _builder_3.append("down");
            }
          }
          _builder_3.append("-");
          _switchResult = _builder_3.toString();
        }
      }
      if (!_matched) {
        boolean _isContainer = it.isContainer();
        if (_isContainer) {
          _matched=true;
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("-");
          {
            if (superType) {
              _builder_4.append("down");
            } else {
              _builder_4.append("up");
            }
          }
          _builder_4.append("-*");
          _switchResult = _builder_4.toString();
        }
      }
      if (!_matched) {
        EReference _eOpposite = it.getEOpposite();
        boolean _tripleEquals = (_eOpposite == null);
        if (_tripleEquals) {
          _matched=true;
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("-");
          {
            if (superType) {
              _builder_5.append("up");
            } else {
              _builder_5.append("down");
            }
          }
          _builder_5.append("->");
          _switchResult = _builder_5.toString();
        }
      }
      if (!_matched) {
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("-");
        {
          if (superType) {
            _builder_6.append("up");
          } else {
            _builder_6.append("down");
          }
        }
        _builder_6.append("-");
        _switchResult = _builder_6.toString();
      }
      final String relation = _switchResult;
      final CharSequence eReferenceName = this.wrapWithMultiplicity(eReference.getName(), eReference);
      EReference _eOpposite_1 = eReference.getEOpposite();
      String _name = null;
      if (_eOpposite_1!=null) {
        _name=_eOpposite_1.getName();
      }
      final CharSequence eOppositeName = this.wrapWithMultiplicity(_name, eReference.getEOpposite());
      StringConcatenation _builder_7 = new StringConcatenation();
      String _fqn = this.getFqn(eReference.getEContainingClass());
      _builder_7.append(_fqn);
      _builder_7.append(" ");
      String _quote = this.quote(eOppositeName);
      _builder_7.append(_quote);
      _builder_7.append(" ");
      _builder_7.append(relation);
      _builder_7.append(" ");
      String _quote_1 = this.quote(eReferenceName);
      _builder_7.append(_quote_1);
      _builder_7.append(" ");
      String _fqn_1 = this.getFqn(eReference.getEType());
      _builder_7.append(_fqn_1);
      _xblockexpression = _builder_7;
    }
    return _xblockexpression;
  }
  
  private CharSequence generateEOperation(final EOperation eOperation) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = eOperation.getName();
    _builder.append(_name);
    _builder.append("(");
    {
      EList<EParameter> _eParameters = eOperation.getEParameters();
      boolean _hasElements = false;
      for(final EParameter eParameter : _eParameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name_1 = eParameter.getName();
        _builder.append(_name_1);
        _builder.append(" : ");
        EClassifier _eType = eParameter.getEType();
        String _name_2 = null;
        if (_eType!=null) {
          _name_2=_eType.getName();
        }
        _builder.append(_name_2);
      }
    }
    _builder.append(")");
    {
      EClassifier _eType_1 = eOperation.getEType();
      boolean _tripleNotEquals = (_eType_1 != null);
      if (_tripleNotEquals) {
        _builder.append(" : ");
        String _name_3 = eOperation.getEType().getName();
        _builder.append(_name_3);
      }
    }
    final String text = _builder.toString();
    return this.wrapWithMultiplicity(text, eOperation);
  }
  
  private CharSequence wrapWithMultiplicity(final CharSequence text, final ETypedElement eTypedElement) {
    CharSequence _xblockexpression = null;
    {
      if ((eTypedElement == null)) {
        return text;
      }
      String _switchResult = null;
      final ETypedElement it = eTypedElement;
      boolean _matched = false;
      EClassifier _eType = it.getEType();
      boolean _tripleEquals = (_eType == null);
      if (_tripleEquals) {
        _matched=true;
        _switchResult = "      ";
      }
      if (!_matched) {
        int _upperBound = it.getUpperBound();
        boolean _lessThan = (_upperBound < 0);
        if (_lessThan) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[");
          int _lowerBound = it.getLowerBound();
          _builder.append(_lowerBound);
          _builder.append("..*]");
          _switchResult = _builder.toString();
        }
      }
      if (!_matched) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("[");
        int _lowerBound_1 = it.getLowerBound();
        _builder_1.append(_lowerBound_1);
        _builder_1.append("..");
        int _upperBound_1 = it.getUpperBound();
        _builder_1.append(_upperBound_1);
        _builder_1.append("]");
        _switchResult = _builder_1.toString();
      }
      final String cardinality = _switchResult;
      String _xifexpression = null;
      int _lowerBound_2 = eTypedElement.getLowerBound();
      boolean _greaterThan = (_lowerBound_2 > 0);
      if (_greaterThan) {
        _xifexpression = "**";
      } else {
        _xifexpression = "";
      }
      final String bold = _xifexpression;
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(bold);
      _builder_2.append("<font:monospaced>");
      _builder_2.append(cardinality);
      _builder_2.append("</font> ");
      _builder_2.append(text);
      _builder_2.append(bold);
      _xblockexpression = _builder_2;
    }
    return _xblockexpression;
  }
  
  private String quote(final CharSequence text) {
    String _xifexpression = null;
    if ((text != null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      _builder.append(text);
      _builder.append("\"");
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }
  
  private Iterable<EOperation> filterOperations(final EClass eClass, final Function1<? super ENamedElement, ? extends Boolean> predicate) {
    return IterableExtensions.<EOperation>filter(eClass.getEOperations(), ((Function1<? super EOperation, Boolean>)predicate));
  }
  
  private Iterable<EStructuralFeature> filterAttributes(final EClass eClass, final Function1<? super ENamedElement, ? extends Boolean> predicate) {
    final Function1<EStructuralFeature, Boolean> _function = (EStructuralFeature e) -> {
      return Boolean.valueOf(((e instanceof EReference) && this.eClassifiers.contains(e.getEType())));
    };
    return IterableExtensions.<EStructuralFeature>reject(IterableExtensions.<EStructuralFeature>filter(eClass.getEStructuralFeatures(), ((Function1<? super EStructuralFeature, Boolean>)predicate)), _function);
  }
  
  private Iterable<EReference> filterReferences(final EClass eClass, final Function1<? super ENamedElement, ? extends Boolean> predicate) {
    final Function1<EReference, Boolean> _function = (EReference e) -> {
      return Boolean.valueOf(this.eClassifiers.contains(e.getEType()));
    };
    return IterableExtensions.<EReference>filter(IterableExtensions.<EReference>filter(eClass.getEReferences(), ((Function1<? super EReference, Boolean>)predicate)), _function);
  }
  
  private Iterable<Pair<EClass, EClass>> filterSuperTypes(final EClass eClass) {
    final Function1<EClass, Boolean> _function = (EClass e) -> {
      return Boolean.valueOf(this.eClassifiers.contains(e));
    };
    final Function1<EClass, Pair<EClass, EClass>> _function_1 = (EClass e) -> {
      return Pair.<EClass, EClass>of(eClass, e);
    };
    return IterableExtensions.<EClass, Pair<EClass, EClass>>map(IterableExtensions.<EClass>filter(eClass.getESuperTypes(), _function), _function_1);
  }
  
  private <R extends EReference, C extends List<R>> C removeEOpposites(final C eReferences) {
    for (final ListIterator<R> eReferencesIterator = eReferences.listIterator(eReferences.size()); eReferencesIterator.hasPrevious();) {
      {
        final R eReference = eReferencesIterator.previous();
        boolean _contains = eReferences.contains(eReference.getEOpposite());
        if (_contains) {
          eReferencesIterator.remove();
        }
      }
    }
    return eReferences;
  }
  
  private String getFqn(final EClassifier eClassifier) {
    String _xifexpression = null;
    int _size = this.ePackages.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      String _fqn = this.getFqn(eClassifier.getEPackage());
      String _plus = (_fqn + ".");
      String _name = eClassifier.getName();
      _xifexpression = (_plus + _name);
    } else {
      _xifexpression = eClassifier.getName();
    }
    return _xifexpression;
  }
  
  private String getFqn(final EPackage ePackage) {
    String _xifexpression = null;
    EPackage _eSuperPackage = ePackage.getESuperPackage();
    boolean _tripleEquals = (_eSuperPackage == null);
    if (_tripleEquals) {
      _xifexpression = ePackage.getName();
    } else {
      String _fqn = this.getFqn(ePackage.getESuperPackage());
      String _plus = (_fqn + ".");
      String _name = ePackage.getName();
      _xifexpression = (_plus + _name);
    }
    return _xifexpression;
  }
}
