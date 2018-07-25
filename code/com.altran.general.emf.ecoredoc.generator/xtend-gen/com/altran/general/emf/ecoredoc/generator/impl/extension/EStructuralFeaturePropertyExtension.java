package com.altran.general.emf.ecoredoc.generator.impl.extension;

import com.altran.general.emf.ecoredoc.generator.configbuilder.EAttributeConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EReferenceConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEStructuralFeatureConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.extension.AnchorExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.ETypedElementPropertyExtension;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EStructuralFeaturePropertyExtension extends ETypedElementPropertyExtension {
  public CharSequence defineChangeable(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return this.definePropertyString(pair, "changeable", "unchangeable", true, pair.getElement().isChangeable());
  }
  
  public CharSequence defineDerived(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return this.definePropertyString(pair, "derived", "underived", false, pair.getElement().isDerived());
  }
  
  public CharSequence defineTransient(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return this.definePropertyString(pair, "transient", "non-transient", false, pair.getElement().isTransient());
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
        CharSequence _concatAnchor = this._anchorExtension.concatAnchor(eAttribute.getEAttributeType());
        _builder.append(_concatAnchor);
        _builder.append(AnchorExtension.ANCHOR_SEPARATOR);
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
  
  protected boolean shouldRenderDefaults(final IEStructuralFeatureConfigPair<?, ?> pair) {
    return pair.getConfig().shouldRenderDefaults();
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
