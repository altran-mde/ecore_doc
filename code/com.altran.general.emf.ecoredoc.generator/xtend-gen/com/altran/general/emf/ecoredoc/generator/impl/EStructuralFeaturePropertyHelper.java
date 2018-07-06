package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfigPair;
import com.altran.general.emf.ecoredoc.generator.config.EReferenceConfigPair;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEStructuralFeatureConfigPair;
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
  
  public CharSequence concatBounds(final IEStructuralFeatureConfigPair<?, ?> pair) {
    CharSequence _xblockexpression = null;
    {
      final EStructuralFeature eStructuralFeature = pair.getElement();
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
      if ((isSet || pair.getConfig().shouldRenderBounds())) {
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
  
  public CharSequence definePropertyString(final IEStructuralFeatureConfigPair<?, ?> pair, final String trueLiteral, final String falseLiteral, final boolean defaultValue, final boolean currentPropertyValue) {
    final boolean isSet = (defaultValue != currentPropertyValue);
    final boolean shouldRenderDefaults = pair.getConfig().shouldRenderDefaults();
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
  
  public CharSequence defineChangeable(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return this.definePropertyString(pair, "changeable", "unchangeable", true, pair.getElement().isChangeable());
  }
  
  public CharSequence defineDerived(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return this.definePropertyString(pair, "derived", "underived", false, pair.getElement().isDerived());
  }
  
  public CharSequence defineOrdered(final IEStructuralFeatureConfigPair<?, ?> pair) {
    CharSequence _xifexpression = null;
    int _upperBound = pair.getElement().getUpperBound();
    boolean _notEquals = (_upperBound != 1);
    if (_notEquals) {
      _xifexpression = this.definePropertyString(pair, "ordered", "unordered", true, pair.getElement().isOrdered());
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public CharSequence defineTransient(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return this.definePropertyString(pair, "transient", "non-transient", false, pair.getElement().isTransient());
  }
  
  public CharSequence defineUnique(final IEStructuralFeatureConfigPair<?, ?> pair) {
    EStructuralFeature _element = pair.getElement();
    return this.definePropertyString(pair, "unique", "non-unique", (_element instanceof EReference), pair.getElement().isUnique());
  }
  
  public CharSequence defineUnsettable(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return this.definePropertyString(pair, "unsettable", "settable", false, pair.getElement().isUnsettable());
  }
  
  public CharSequence defineVolatile(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return this.definePropertyString(pair, "volatile", "non-volatile", false, pair.getElement().isVolatile());
  }
  
  public CharSequence defineResolveProxies(final EReferenceConfigPair pair) {
    boolean _isContainment = pair.getElement().isContainment();
    boolean _not = (!_isContainment);
    return this.definePropertyString(pair, "resolveProxies", "non-resolveProxies", _not, pair.getElement().isResolveProxies());
  }
  
  public CharSequence defineContainer(final EReferenceConfigPair pair) {
    CharSequence _xifexpression = null;
    boolean _isContainer = pair.getElement().isContainer();
    if (_isContainer) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("*container*");
      _xifexpression = _builder;
    } else {
      CharSequence _xifexpression_1 = null;
      boolean _shouldRenderDefaults = pair.getConfig().shouldRenderDefaults();
      if (_shouldRenderDefaults) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("non-container");
        _xifexpression_1 = _builder_1;
      } else {
        _xifexpression_1 = null;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence defineId(final EAttributeConfigPair pair) {
    CharSequence _xblockexpression = null;
    {
      final boolean isID = pair.getElement().isID();
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
  
  public CharSequence defineEKeys(final EReferenceConfigPair pair) {
    CharSequence _xblockexpression = null;
    {
      final EList<EAttribute> eKeys = pair.getElement().getEKeys();
      boolean _isEmpty = eKeys.isEmpty();
      final boolean eKeysExist = (!_isEmpty);
      CharSequence _xifexpression = null;
      if ((eKeysExist || this.shouldRenderDefaults(pair))) {
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
  
  protected CharSequence _concatDefaultValue(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return null;
  }
  
  protected CharSequence _concatDefaultValue(final EAttributeConfigPair pair) {
    final EAttribute eAttribute = pair.getElement();
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
      boolean _shouldRenderDefaults = this.shouldRenderDefaults(pair);
      if (_shouldRenderDefaults) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("_Default:_ `-`");
        return _builder_1;
      } else {
        return null;
      }
    }
  }
  
  protected CharSequence _concatDefaultValue(final EReferenceConfigPair pair) {
    final EReference eReference = pair.getElement();
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
      boolean _shouldRenderDefaults = this.shouldRenderDefaults(pair);
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
  
  protected boolean shouldRenderDefaults(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return pair.getConfig().shouldRenderDefaults();
  }
  
  protected EcoreDocGeneratorConfig getConfig() {
    return this.config;
  }
  
  public CharSequence concatDefaultValue(final IEStructuralFeatureConfigPair<?, ?> pair) {
    if (pair instanceof EAttributeConfigPair) {
      return _concatDefaultValue((EAttributeConfigPair)pair);
    } else if (pair instanceof EReferenceConfigPair) {
      return _concatDefaultValue((EReferenceConfigPair)pair);
    } else if (pair != null) {
      return _concatDefaultValue(pair);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(pair).toString());
    }
  }
}
