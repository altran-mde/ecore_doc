package com.altran.general.emf.ecoredoc.generator.impl.extension;

import com.altran.general.emf.ecoredoc.generator.configbuilder.IETypedElementConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.extension.AnchorExtension;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class ETypedElementPropertyExtension {
  private final static String BOLD = "**";
  
  @Extension
  protected AnchorExtension _anchorExtension = new AnchorExtension();
  
  public CharSequence concatBounds(final IETypedElementConfigPair<?, ?> pair) {
    CharSequence _xblockexpression = null;
    {
      final ETypedElement eTypedElement = pair.getElement();
      final int lowerBound = eTypedElement.getLowerBound();
      final int upperBound = eTypedElement.getUpperBound();
      final boolean lowerNotEqualUpperBound = (lowerBound != upperBound);
      boolean _xifexpression = false;
      boolean _isMany = eTypedElement.isMany();
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
  
  public CharSequence defineOrdered(final IETypedElementConfigPair<?, ?> pair) {
    CharSequence _xifexpression = null;
    boolean _isMany = pair.getElement().isMany();
    if (_isMany) {
      _xifexpression = this.definePropertyString(pair, "ordered", "unordered", true, pair.getElement().isOrdered());
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public CharSequence defineUnique(final IETypedElementConfigPair<?, ?> pair) {
    CharSequence _xifexpression = null;
    boolean _isMany = pair.getElement().isMany();
    if (_isMany) {
      ETypedElement _element = pair.getElement();
      _xifexpression = this.definePropertyString(pair, "unique", "non-unique", (_element instanceof EReference), pair.getElement().isUnique());
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public CharSequence definePropertyString(final IETypedElementConfigPair<?, ?> pair, final String trueLiteral, final String falseLiteral, final boolean defaultValue, final boolean currentPropertyValue) {
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
  
  public CharSequence boldifyString(final String string) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(ETypedElementPropertyExtension.BOLD);
    _builder.append(string);
    _builder.append(ETypedElementPropertyExtension.BOLD);
    return _builder;
  }
}
