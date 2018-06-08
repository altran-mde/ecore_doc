package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.ecoredoc.generator.config.IEStructuralFeatureConfig;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
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
  private final static String BOLD = "**";
  
  @Extension
  private EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  private final EcoreDocGeneratorConfig config;
  
  public EStructuralFeaturePropertyHelper(final EcoreDocGeneratorConfig config) {
    this.config = config;
  }
  
  public CharSequence concatBounds(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final int lowerBound = eStructuralFeature.getLowerBound();
      final int upperBound = eStructuralFeature.getUpperBound();
      final boolean lowerNotEqualUpperBound = (lowerBound != upperBound);
      boolean _xifexpression = false;
      boolean _isMany = eStructuralFeature.isMany();
      if (_isMany) {
        _xifexpression = ((lowerBound != 0) || (upperBound != (-1)));
      } else {
        _xifexpression = ((lowerBound != 0) || (upperBound != 1));
      }
      final boolean isSet = _xifexpression;
      CharSequence _xifexpression_1 = null;
      if ((isSet || this.shouldRenderDefaults(eStructuralFeature))) {
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
        _xifexpression_1 = _builder;
      }
      _xblockexpression = _xifexpression_1;
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
  
  public CharSequence definePropertyString(final EStructuralFeature eStructuralFeature, final String trueLiteral, final String falseLiteral, final boolean defaultValue, final boolean currentPropertyValue) {
    final boolean isSet = (defaultValue != currentPropertyValue);
    final boolean shouldRenderDefaults = this.shouldRenderDefaults(eStructuralFeature);
    if ((isSet || shouldRenderDefaults)) {
      if (currentPropertyValue) {
        if ((isSet && shouldRenderDefaults)) {
          return this.boldifyString(trueLiteral);
        } else {
          return trueLiteral;
        }
      } else {
        if ((isSet && shouldRenderDefaults)) {
          return this.boldifyString(falseLiteral);
        } else {
          return falseLiteral;
        }
      }
    }
    return null;
  }
  
  public CharSequence defineChangeable(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = true;
      final boolean isChangeable = eStructuralFeature.isChangeable();
      _xblockexpression = this.definePropertyString(eStructuralFeature, "changeable", "unchangeable", defaultValue, isChangeable);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineDerived(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isDerived = eStructuralFeature.isDerived();
      _xblockexpression = this.definePropertyString(eStructuralFeature, "derived", "underived", defaultValue, isDerived);
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
        _xifexpression = this.definePropertyString(eStructuralFeature, "ordered", "unordered", defaultValue, isOrdered);
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
      _xblockexpression = this.definePropertyString(eStructuralFeature, "transient", "non-transient", defaultValue, isTransient);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineUnique(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = (eStructuralFeature instanceof EReference);
      final boolean isUnique = eStructuralFeature.isUnique();
      _xblockexpression = this.definePropertyString(eStructuralFeature, "unique", "non-unique", defaultValue, isUnique);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineUnsettable(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isUnsettable = eStructuralFeature.isUnsettable();
      _xblockexpression = this.definePropertyString(eStructuralFeature, "unsettable", "settable", defaultValue, isUnsettable);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineVolatile(final EStructuralFeature eStructuralFeature) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isVolatile = eStructuralFeature.isVolatile();
      _xblockexpression = this.definePropertyString(eStructuralFeature, "volatile", "non-volatile", defaultValue, isVolatile);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineResolveProxies(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = true;
      final boolean resolveProxies = eReference.isResolveProxies();
      _xblockexpression = this.definePropertyString(eReference, "resolveProxies", "non-resolveProxies", defaultValue, resolveProxies);
    }
    return _xblockexpression;
  }
  
  public CharSequence defineContainer(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultValue = false;
      final boolean isContainer = eReference.isContainer();
      _xblockexpression = this.definePropertyString(eReference, "container", "non-container", defaultValue, isContainer);
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
      CharSequence _xifexpression = null;
      if ((eKeysExist || this.shouldRenderDefaults(eReference))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("_EKeys:_");
        {
          if (eKeysExist) {
            _builder.append(" ");
            final Function1<EAttribute, CharSequence> _function = (EAttribute it) -> {
              return it.getName();
            };
            String _join = IterableExtensions.<EAttribute>join(eKeys, "`", ", ", "`", _function);
            _builder.append(_join);
          } else {
            _builder.append(" `-`");
          }
        }
        _xifexpression = _builder;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _concatDefaultValue(final EAttribute eAttribute) {
    final EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.getEStructuralFeature_DefaultValueLiteral();
    final boolean defaultIsSet = eAttribute.eIsSet(defaultValueLiteral);
    if (defaultIsSet) {
      final Object defaultValue = eAttribute.getDefaultValue();
      boolean _matched = false;
      if (defaultValue instanceof EEnumLiteralImpl) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("_Default:_ `<<");
        CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eAttribute.getEAttributeType());
        _builder.append(_concatAnchor);
        _builder.append(EcoreDocExtension.ANCHOR_SEPARATOR);
        _builder.append(((EEnumLiteralImpl)defaultValue));
        _builder.append(", ");
        _builder.append(((EEnumLiteralImpl)defaultValue));
        _builder.append(">>`");
        return _builder;
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_Default:_ `");
      _builder.append(defaultValue);
      _builder.append("`");
      return _builder;
    } else {
      boolean _shouldRenderDefaults = this.shouldRenderDefaults(eAttribute);
      if (_shouldRenderDefaults) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("_Default:_ `-`");
        return _builder_1;
      } else {
        return null;
      }
    }
  }
  
  protected CharSequence _concatDefaultValue(final EReference eReference) {
    final EStructuralFeature defaultValueLiteral = EcorePackage.eINSTANCE.getEStructuralFeature_DefaultValueLiteral();
    final boolean defaultIsSet = eReference.eIsSet(defaultValueLiteral);
    if (defaultIsSet) {
      final Object defaultValue = eReference.getDefaultValue();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_Default:_ `");
      _builder.append(defaultValue);
      _builder.append("`");
      return _builder;
    } else {
      boolean _shouldRenderDefaults = this.shouldRenderDefaults(eReference);
      if (_shouldRenderDefaults) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("_Default:_ `-`");
        return _builder_1;
      } else {
        return null;
      }
    }
  }
  
  protected CharSequence defineUpperBound(final int upperBound) {
    CharSequence _xblockexpression = null;
    {
      final boolean upperBoundExists = (upperBound != (-1));
      CharSequence _xifexpression = null;
      if (upperBoundExists) {
        _xifexpression = Integer.valueOf(upperBound).toString();
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("*");
        _xifexpression = _builder;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected boolean shouldRenderDefaults(final EStructuralFeature eStructuralFeature) {
    IENamedElementConfig _findConfig = this.getConfig().findConfig(eStructuralFeature);
    return ((IEStructuralFeatureConfig) _findConfig).shouldRenderDefaults();
  }
  
  protected EcoreDocGeneratorConfig getConfig() {
    return this.config;
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
