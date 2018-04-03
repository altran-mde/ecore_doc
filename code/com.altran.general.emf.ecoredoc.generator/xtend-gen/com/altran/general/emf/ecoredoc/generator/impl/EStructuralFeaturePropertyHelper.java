package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EStructuralFeaturePropertyHelper {
  @Extension
  private EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  private final static Character BOLD = Character.valueOf('*');
  
  private final static String JOIN = " + ";
  
  public CharSequence concatBounds(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final int lowerBound = eStructuralFeature.getLowerBound();
      final int upperBound = eStructuralFeature.getUpperBound();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("`[");
      _builder.append(lowerBound);
      {
        if ((lowerBound != upperBound)) {
          _builder.append("..");
          CharSequence _defineUpperBound = this.defineUpperBound(upperBound);
          _builder.append(_defineUpperBound);
        }
      }
      _builder.append("]`");
      _builder.append(EStructuralFeaturePropertyHelper.JOIN);
      _builder.newLineIfNotEmpty();
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
    CharSequence _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      CharSequence result = _builder;
      final boolean boldify = (defaultValue != currentPropertyValue);
      CharSequence _xifexpression = null;
      if (currentPropertyValue) {
        StringConcatenation _builder_1 = new StringConcatenation();
        {
          if (boldify) {
            CharSequence _boldifyString = this.boldifyString(trueLiteral);
            _builder_1.append(_boldifyString);
          } else {
            _builder_1.append(trueLiteral);
          }
        }
        _builder_1.append(EStructuralFeaturePropertyHelper.JOIN);
        _xifexpression = result = _builder_1;
      } else {
        StringConcatenation _builder_2 = new StringConcatenation();
        {
          if (boldify) {
            CharSequence _boldifyString_1 = this.boldifyString(falseLiteral);
            _builder_2.append(_boldifyString_1);
          } else {
            _builder_2.append(falseLiteral);
          }
        }
        _builder_2.append(EStructuralFeaturePropertyHelper.JOIN);
        _xifexpression = result = _builder_2;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineChangeable(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean isChangeable = eStructuralFeature.isChangeable();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("changeable", "unchangeable", true, isChangeable);
      _builder.append(_definePropertyString);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineDerived(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean isDerived = eStructuralFeature.isDerived();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("derived", "underived", false, isDerived);
      _builder.append(_definePropertyString);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineOrdered(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final int upperBound = eStructuralFeature.getUpperBound();
      final boolean isOrdered = eStructuralFeature.isOrdered();
      CharSequence _xifexpression = null;
      if ((upperBound != 1)) {
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _definePropertyString = this.definePropertyString("ordered", "unordered", true, isOrdered);
        _builder.append(_definePropertyString);
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder;
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
      final boolean isTransient = eStructuralFeature.isTransient();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("transient", "non-transient", false, isTransient);
      _builder.append(_definePropertyString);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineUnique(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean isUnique = eStructuralFeature.isUnique();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("unique", "non-unique", false, isUnique);
      _builder.append(_definePropertyString);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineUnsettable(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean isUnsettable = eStructuralFeature.isUnsettable();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("unsettable", "settable", false, isUnsettable);
      _builder.append(_definePropertyString);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineVolatile(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean isVolatile = eStructuralFeature.isVolatile();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("volatile", "non-volatile", false, isVolatile);
      _builder.append(_definePropertyString);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineId(final EAttribute eAttribute) {
    CharSequence _xifexpression = null;
    boolean _isID = eAttribute.isID();
    if (_isID) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("*is id*");
      _builder.newLine();
      String _newline = this._ecoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _xifexpression = _builder;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public CharSequence concatDefaultValue(final EAttribute eAttribute) {
    boolean _eIsSet = eAttribute.eIsSet(EcorePackage.eINSTANCE.getEStructuralFeature_DefaultValueLiteral());
    if (_eIsSet) {
      final Object defaultValue = eAttribute.getDefaultValue();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_default:_ ");
      String result = _builder.toString();
      boolean _matched = false;
      if (Objects.equal(defaultValue, EEnumLiteral.class)) {
        _matched=true;
        String _result = result;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("`<<");
        CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eAttribute.getEAttributeType());
        _builder_1.append(_concatAnchor);
        _builder_1.append(EcoreDocExtension.ANCHOR_SEPARATOR);
        _builder_1.append(defaultValue);
        _builder_1.append(", ");
        _builder_1.append(defaultValue);
        _builder_1.append(">>`");
        String _newline = this._ecoreDocExtension.newline();
        _builder_1.append(_newline);
        result = (_result + _builder_1);
      }
      if (!_matched) {
        if (Objects.equal(defaultValue, String.class)) {
          _matched=true;
          String _result_1 = result;
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("`\"");
          _builder_2.append(defaultValue);
          _builder_2.append("\"`");
          String _newline_1 = this._ecoreDocExtension.newline();
          _builder_2.append(_newline_1);
          result = (_result_1 + _builder_2);
        }
      }
      if (!_matched) {
        String _result_2 = result;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("`");
        _builder_3.append(defaultValue);
        _builder_3.append("`");
        String _newline_2 = this._ecoreDocExtension.newline();
        _builder_3.append(_newline_2);
        result = (_result_2 + _builder_3);
      }
      return result;
    } else {
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("_default:_ -");
      String _newline_3 = this._ecoreDocExtension.newline();
      _builder_4.append(_newline_3);
      return _builder_4;
    }
  }
  
  protected CharSequence defineUpperBound(final int upperBound) {
    CharSequence _xifexpression = null;
    if ((upperBound == (-1))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("*");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(upperBound);
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
}
