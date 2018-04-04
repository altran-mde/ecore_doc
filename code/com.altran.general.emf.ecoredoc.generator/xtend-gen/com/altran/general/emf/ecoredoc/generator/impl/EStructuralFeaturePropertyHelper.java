package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EStructuralFeaturePropertyHelper {
  @Extension
  private EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  private final static String BOLD = "**";
  
  public CharSequence concatBounds(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final int lowerBound = eStructuralFeature.getLowerBound();
      final int upperBound = eStructuralFeature.getUpperBound();
      final boolean lowerNotEqualUpperBound = (lowerBound != upperBound);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("`[");
      _builder.append(lowerBound);
      {
        if (lowerNotEqualUpperBound) {
          _builder.append("..");
          CharSequence _defineUpperBound = this.defineUpperBound(upperBound);
          _builder.append(_defineUpperBound);
        }
      }
      _builder.append("]`");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence boldifyString(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(EStructuralFeaturePropertyHelper.BOLD);
    _builder.append(string);
    _builder.append(EStructuralFeaturePropertyHelper.BOLD);
    return _builder;
  }
  
  public CharSequence definePropertyString(final String trueLiteral, final String falseLiteral, final boolean defaultValue, final boolean currentPropertyValue) {
    final boolean boldify = (defaultValue != currentPropertyValue);
    if (currentPropertyValue) {
      if (boldify) {
        return this.boldifyString(trueLiteral);
      } else {
        return trueLiteral;
      }
    } else {
      if (boldify) {
        return this.boldifyString(falseLiteral);
      } else {
        return falseLiteral;
      }
    }
  }
  
  public CharSequence definePropertyString(final String trueLiteral, final String falseLiteral, final boolean currentPropertyValue) {
    if (currentPropertyValue) {
      return trueLiteral;
    } else {
      return falseLiteral;
    }
  }
  
  public CharSequence defineChangeable(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = true;
      final boolean isChangeable = eStructuralFeature.isChangeable();
      _xblockexpression = this.definePropertyString("changeable", "unchangeable", defaultValue, isChangeable);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineDerived(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isDerived = eStructuralFeature.isDerived();
      _xblockexpression = this.definePropertyString("derived", "underived", defaultValue, isDerived);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineOrdered(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = true;
      final int upperBound = eStructuralFeature.getUpperBound();
      final boolean isOrdered = eStructuralFeature.isOrdered();
      CharSequence _xifexpression = null;
      if ((upperBound != 1)) {
        _xifexpression = this.definePropertyString("ordered", "unordered", defaultValue, isOrdered);
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineTransient(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isTransient = eStructuralFeature.isTransient();
      _xblockexpression = this.definePropertyString("transient", "non-transient", defaultValue, isTransient);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineUnique(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean isUnique = eStructuralFeature.isUnique();
      _xblockexpression = this.definePropertyString("unique", "non-unique", isUnique);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineUnsettable(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isUnsettable = eStructuralFeature.isUnsettable();
      _xblockexpression = this.definePropertyString("unsettable", "settable", defaultValue, isUnsettable);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineVolatile(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isVolatile = eStructuralFeature.isVolatile();
      _xblockexpression = this.definePropertyString("volatile", "non-volatile", defaultValue, isVolatile);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineResolveProxies(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = true;
      final boolean resolveProxies = eReference.isResolveProxies();
      _xblockexpression = this.definePropertyString("resolveProxies", "non-resolveProxies", defaultValue, resolveProxies);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineContainer(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final boolean isContainer = eReference.isContainer();
      _xblockexpression = this.definePropertyString("container", "non-container", isContainer);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineContainment(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final boolean isContainment = eReference.isContainment();
      _xblockexpression = this.definePropertyString("containment", "non-containment", isContainment);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineId(final EAttribute eAttribute) {
    CharSequence _xblockexpression = null;
    {
      final boolean isID = eAttribute.isID();
      CharSequence _xifexpression = null;
      if (isID) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("*is id*");
        _xifexpression = _builder;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineEKeys(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final EList<EAttribute> eKeys = eReference.getEKeys();
      boolean _isEmpty = eKeys.isEmpty();
      final boolean eKeysExist = (!_isEmpty);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_EKeys:_");
      {
        if (eKeysExist) {
          final Function1<EAttribute, CharSequence> _function = (EAttribute it) -> {
            return it.getName();
          };
          String _join = IterableExtensions.<EAttribute>join(eKeys, "`", ", ", "`", _function);
          _builder.append(_join);
        } else {
          _builder.append(" `-`");
        }
      }
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _concatDefaultValue(final EAttribute eAttribute) {
    final CharSequence separator = EcoreDocExtension.ANCHOR_SEPARATOR;
    final EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.getEStructuralFeature_DefaultValueLiteral();
    final boolean defaultIsSet = eAttribute.eIsSet(defaultValueLiteral);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("_Default:_ ");
    String result = _builder.toString();
    if (defaultIsSet) {
      final Object defaultValue = eAttribute.getDefaultValue();
      Class<?> _class = defaultValue.getClass();
      boolean _matched = false;
      if (Objects.equal(_class, EEnumLiteralImpl.class)) {
        _matched=true;
        String _result = result;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("`<<");
        CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eAttribute.getEAttributeType());
        _builder_1.append(_concatAnchor);
        _builder_1.append(separator);
        _builder_1.append(defaultValue);
        _builder_1.append(", ");
        _builder_1.append(defaultValue);
        _builder_1.append(">>`");
        result = (_result + _builder_1);
      }
      if (!_matched) {
        String _result_1 = result;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("`");
        _builder_2.append(defaultValue);
        _builder_2.append("`");
        result = (_result_1 + _builder_2);
      }
    } else {
      String _result_2 = result;
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("`-`");
      result = (_result_2 + _builder_3);
    }
    return result;
  }
  
  protected CharSequence _concatDefaultValue(final EReference eReference) {
    final EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.getEStructuralFeature_DefaultValueLiteral();
    final boolean defaultIsSet = eReference.eIsSet(defaultValueLiteral);
    if (defaultIsSet) {
      final Object defaultValue = eReference.getDefaultValue();
      final CharSequence separator = EcoreDocExtension.ANCHOR_SEPARATOR;
      final EClass eReferenceType = eReference.getEReferenceType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_Default:_ ");
      String result = _builder.toString();
      Class<?> _class = defaultValue.getClass();
      boolean _matched = false;
      if (Objects.equal(_class, EEnumLiteralImpl.class)) {
        _matched=true;
        String _result = result;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("`<<");
        CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eReferenceType);
        _builder_1.append(_concatAnchor);
        _builder_1.append(separator);
        _builder_1.append(defaultValue);
        _builder_1.append(", ");
        _builder_1.append(defaultValue);
        _builder_1.append(">>`");
        result = (_result + _builder_1);
      }
      if (!_matched) {
        String _result_1 = result;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("`");
        _builder_2.append(defaultValue);
        _builder_2.append("`");
        result = (_result_1 + _builder_2);
      }
      return result;
    } else {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("_Default:_ `-`");
      return _builder_3;
    }
  }
  
  protected CharSequence defineUpperBound(final int upperBound) {
    CharSequence _xblockexpression = null;
    {
      final boolean upperBoundExists = (upperBound != (-1));
      CharSequence _xifexpression = null;
      if (upperBoundExists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(upperBound);
        _xifexpression = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("*");
        _xifexpression = _builder_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence concatDefaultValue(final EStructuralFeature eAttribute) {
    if (eAttribute instanceof EAttribute) {
      return _concatDefaultValue((EAttribute)eAttribute);
    } else if (eAttribute instanceof EReference) {
      return _concatDefaultValue((EReference)eAttribute);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eAttribute).toString());
    }
  }
}
