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
  
  private final static String BOLD = "*";
  
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
          Object _defineUpperBound = this.defineUpperBound(upperBound);
          _builder.append(_defineUpperBound);
        }
      }
      _builder.append("]`");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineChangeable(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean changeable = eStructuralFeature.isChangeable();
      StringConcatenation _builder = new StringConcatenation();
      {
        if (changeable) {
          _builder.append("changeable");
        } else {
          _builder.append(EStructuralFeaturePropertyHelper.BOLD);
          _builder.append("unchangeable");
          _builder.append(EStructuralFeaturePropertyHelper.BOLD);
        }
      }
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineDerived(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean derived = eStructuralFeature.isDerived();
      StringConcatenation _builder = new StringConcatenation();
      {
        if (derived) {
          _builder.append(EStructuralFeaturePropertyHelper.BOLD);
          _builder.append("derived");
          _builder.append(EStructuralFeaturePropertyHelper.BOLD);
        } else {
          _builder.append("underived");
        }
      }
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineOrdered(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final int upperBound = eStructuralFeature.getUpperBound();
      final boolean ordered = eStructuralFeature.isOrdered();
      CharSequence _xifexpression = null;
      if ((upperBound != 1)) {
        StringConcatenation _builder = new StringConcatenation();
        {
          if (ordered) {
            _builder.append("ordered");
          } else {
            _builder.append(EStructuralFeaturePropertyHelper.BOLD);
            _builder.append("unordered");
            _builder.append(EStructuralFeaturePropertyHelper.BOLD);
          }
        }
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
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
      _xifexpression = _builder;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public String concatDefaultValue(final EAttribute eAttribute) {
    boolean _eIsSet = eAttribute.eIsSet(EcorePackage.eINSTANCE.getEStructuralFeature_DefaultValueLiteral());
    if (_eIsSet) {
      final Object defaultValue = eAttribute.getDefaultValue();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_default:_ ");
      _builder.newLine();
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
          result = (_result_1 + _builder_2);
        }
      }
      if (!_matched) {
        String _result_2 = result;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("`");
        _builder_3.append(defaultValue);
        _builder_3.append("`");
        result = (_result_2 + _builder_3);
      }
      return result;
    } else {
      return "";
    }
  }
  
  protected Object defineUpperBound(final int upperBound) {
    Object _xifexpression = null;
    if ((upperBound == (-1))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("*");
      _xifexpression = _builder;
    } else {
      _xifexpression = Integer.valueOf(upperBound);
    }
    return _xifexpression;
  }
}
