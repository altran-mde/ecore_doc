package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EStructuralFeaturePropertyHelper {
  @Extension
  private EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  private final static String BOLD = "**";
  
  private final static String JOIN = " +";
  
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
    StringConcatenation _builder = new StringConcatenation();
    CharSequence result = _builder;
    final boolean boldify = (defaultValue != currentPropertyValue);
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
      result = _builder_1;
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
      result = _builder_2;
    }
    return result;
  }
  
  public CharSequence definePropertyString(final String trueLiteral, final String falseLiteral, final boolean currentPropertyValue) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence result = _builder;
    if (currentPropertyValue) {
      result = trueLiteral;
    } else {
      result = falseLiteral;
    }
    return result;
  }
  
  public CharSequence defineChangeable(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = true;
      final boolean isChangeable = eStructuralFeature.isChangeable();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("changeable", "unchangeable", defaultValue, isChangeable);
      _builder.append(_definePropertyString);
      _builder.append(EStructuralFeaturePropertyHelper.JOIN);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineDerived(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isDerived = eStructuralFeature.isDerived();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("derived", "underived", defaultValue, isDerived);
      _builder.append(_definePropertyString);
      _builder.append(EStructuralFeaturePropertyHelper.JOIN);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
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
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _definePropertyString = this.definePropertyString("ordered", "unordered", defaultValue, isOrdered);
        _builder.append(_definePropertyString);
        _builder.append(EStructuralFeaturePropertyHelper.JOIN);
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
      final boolean defaultValue = false;
      final boolean isTransient = eStructuralFeature.isTransient();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("transient", "non-transient", defaultValue, isTransient);
      _builder.append(_definePropertyString);
      _builder.append(EStructuralFeaturePropertyHelper.JOIN);
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
      CharSequence _definePropertyString = this.definePropertyString("unique", "non-unique", isUnique);
      _builder.append(_definePropertyString);
      _builder.append(EStructuralFeaturePropertyHelper.JOIN);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineUnsettable(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isUnsettable = eStructuralFeature.isUnsettable();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("unsettable", "settable", defaultValue, isUnsettable);
      _builder.append(_definePropertyString);
      _builder.append(EStructuralFeaturePropertyHelper.JOIN);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineVolatile(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isVolatile = eStructuralFeature.isVolatile();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("volatile", "non-volatile", defaultValue, isVolatile);
      _builder.append(_definePropertyString);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence defineResolveProxies(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = true;
      final boolean resolveProxies = eReference.isResolveProxies();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(EStructuralFeaturePropertyHelper.JOIN);
      String _newline = this._ecoreDocExtension.newline();
      _builder.append(_newline);
      final CharSequence separator = _builder;
      StringConcatenation _builder_1 = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("resolveProxies", "non-resolveProxies", defaultValue, resolveProxies);
      _builder_1.append(_definePropertyString);
      _builder_1.append(separator);
      _builder_1.newLineIfNotEmpty();
      _xblockexpression = _builder_1;
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
        _builder.newLine();
        String _newline = this._ecoreDocExtension.newline();
        _builder.append(_newline);
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder;
      } else {
        _xifexpression = null;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public StringBuilder defineEKeys(final EReference eReference) {
    final EList<EAttribute> eKeys = eReference.getEKeys();
    StringBuilder result = new StringBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(EStructuralFeaturePropertyHelper.JOIN);
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    final String separator = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("_EKeys:_");
    result.append(_builder_1);
    boolean _isEmpty = eKeys.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      for (final EAttribute eKey : eKeys) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(" ");
        _builder_2.append("`");
        String _name = eKey.getName();
        _builder_2.append(_name, " ");
        _builder_2.append("`");
        _builder_2.append(separator, " ");
        result.append(_builder_2);
      }
    } else {
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(" ");
      _builder_3.append("`-`");
      _builder_3.append(separator, " ");
      result.append(_builder_3);
    }
    return result;
  }
  
  public CharSequence defineContainment(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final boolean isContainer = eReference.isContainer();
      final boolean isContainment = eReference.isContainment();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(EStructuralFeaturePropertyHelper.JOIN);
      String _newline = this._ecoreDocExtension.newline();
      _builder.append(_newline);
      String _newline_1 = this._ecoreDocExtension.newline();
      _builder.append(_newline_1);
      final CharSequence separator = _builder;
      StringConcatenation _builder_1 = new StringConcatenation();
      CharSequence _definePropertyString = this.definePropertyString("container", "non-container", isContainer);
      _builder_1.append(_definePropertyString);
      _builder_1.append(EStructuralFeaturePropertyHelper.JOIN);
      _builder_1.newLineIfNotEmpty();
      CharSequence _definePropertyString_1 = this.definePropertyString("containment", "non-containment", isContainment);
      _builder_1.append(_definePropertyString_1);
      _builder_1.append(separator);
      _builder_1.newLineIfNotEmpty();
      _xblockexpression = _builder_1;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _concatDefaultValue(final EAttribute eAttribute) {
    final EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.getEStructuralFeature_DefaultValueLiteral();
    final boolean defaultIsSet = eAttribute.eIsSet(defaultValueLiteral);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(EStructuralFeaturePropertyHelper.JOIN);
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    final String separator = _builder.toString();
    if (defaultIsSet) {
      final Object defaultValue = eAttribute.getDefaultValue();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("_Default:_ ");
      String result = _builder_1.toString();
      boolean _matched = false;
      if (Objects.equal(defaultValue, EEnumLiteral.class)) {
        _matched=true;
        String _result = result;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("`<<");
        CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eAttribute.getEAttributeType());
        _builder_2.append(_concatAnchor);
        _builder_2.append(EcoreDocExtension.ANCHOR_SEPARATOR);
        _builder_2.append(defaultValue);
        _builder_2.append(", ");
        _builder_2.append(defaultValue);
        _builder_2.append(">>`");
        _builder_2.append(separator);
        result = (_result + _builder_2);
      }
      if (!_matched) {
        String _result_1 = result;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("`");
        _builder_3.append(defaultValue);
        _builder_3.append("`");
        _builder_3.append(separator);
        result = (_result_1 + _builder_3);
      }
      return result;
    } else {
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("_Default:_ `-`");
      _builder_4.append(separator);
      return _builder_4;
    }
  }
  
  protected CharSequence _concatDefaultValue(final EReference eReference) {
    final EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.getEStructuralFeature_DefaultValueLiteral();
    final boolean defaultIsSet = eReference.eIsSet(defaultValueLiteral);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(EStructuralFeaturePropertyHelper.JOIN);
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    final String separator = _builder.toString();
    if (defaultIsSet) {
      final Object defaultValue = eReference.getDefaultValue();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("_Default:_ ");
      String result = _builder_1.toString();
      boolean _matched = false;
      if (Objects.equal(defaultValue, EEnumLiteral.class)) {
        _matched=true;
        String _result = result;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("`<<");
        CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eReference.getEReferenceType());
        _builder_2.append(_concatAnchor);
        _builder_2.append(EcoreDocExtension.ANCHOR_SEPARATOR);
        _builder_2.append(defaultValue);
        _builder_2.append(", ");
        _builder_2.append(defaultValue);
        _builder_2.append(">>`");
        _builder_2.append(separator);
        result = (_result + _builder_2);
      }
      if (!_matched) {
        String _result_1 = result;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("`");
        _builder_3.append(defaultValue);
        _builder_3.append("`");
        _builder_3.append(separator);
        result = (_result_1 + _builder_3);
      }
      return result;
    } else {
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("_Default:_ `-`");
      _builder_4.append(separator);
      return _builder_4;
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
