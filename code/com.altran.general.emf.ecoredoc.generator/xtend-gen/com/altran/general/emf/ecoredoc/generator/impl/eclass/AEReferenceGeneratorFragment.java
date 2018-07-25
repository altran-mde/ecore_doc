package com.altran.general.emf.ecoredoc.generator.impl.eclass;

import com.altran.general.emf.ecoredoc.generator.config.AEReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.config.EContainmentConfig;
import com.altran.general.emf.ecoredoc.generator.config.EReferenceConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EReferenceConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.AEStructuralFeatureGeneratorFragment;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.extension.AnchorExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class AEReferenceGeneratorFragment extends AEStructuralFeatureGeneratorFragment<EReference, EReferenceConfigPair> {
  public AEReferenceGeneratorFragment(final EClassGeneratorPart eClassGeneratorPart) {
    super(eClassGeneratorPart);
  }
  
  @Override
  protected List<CharSequence> enumerateFeatureProperties(final EReferenceConfigPair pair) {
    CharSequence _defineEKeys = this._eStructuralFeaturePropertyExtension.defineEKeys(pair);
    CharSequence _defineResolveProxies = this._eStructuralFeaturePropertyExtension.defineResolveProxies(pair);
    CharSequence _defineContainer = this._eStructuralFeaturePropertyExtension.defineContainer(pair);
    return Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineEKeys, _defineResolveProxies, _defineContainer));
  }
  
  @Override
  protected EReferenceConfigPair combineConfigPair(final EReference eReference, final EClassConfig classConfig) {
    EList<EContainmentConfig> _eContainments = classConfig.getEContainments();
    EList<EReferenceConfig> _eReferences = classConfig.getEReferences();
    final Function1<AEReferenceConfig, Boolean> _function = (AEReferenceConfig it) -> {
      String _id = it.getId();
      String _name = eReference.getName();
      return Boolean.valueOf(Objects.equal(_id, _name));
    };
    AEReferenceConfig _findFirst = IterableExtensions.<AEReferenceConfig>findFirst(Iterables.<AEReferenceConfig>concat(_eContainments, _eReferences), _function);
    return new EReferenceConfigPair(eReference, _findFirst);
  }
  
  @Override
  protected CharSequence concatFeatureType(final EReference eReference) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _concatLinkTo = this.eClassGeneratorPart.concatLinkTo(eReference.getEType());
    _builder.append(_concatLinkTo);
    _builder.newLineIfNotEmpty();
    CharSequence _opposite = this.getOpposite(eReference);
    _builder.append(_opposite);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence getOpposite(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final EReference eOpposite = eReference.getEOpposite();
      CharSequence _xifexpression = null;
      if ((eOpposite != null)) {
        CharSequence _xblockexpression_1 = null;
        {
          final String eOppositeName = eOpposite.getName();
          final EClass eReferenceType = eReference.getEReferenceType();
          StringConcatenation _builder = new StringConcatenation();
          String _newline = EcoreDocExtension.newline();
          _builder.append(_newline);
          _builder.newLineIfNotEmpty();
          _builder.append("_EOpposite:_ `<<");
          CharSequence _concatAnchor = this._anchorExtension.concatAnchor(eReferenceType);
          _builder.append(_concatAnchor);
          _builder.append(AnchorExtension.ANCHOR_SEPARATOR);
          _builder.append(eOppositeName);
          _builder.append(", ");
          _builder.append(eOppositeName);
          _builder.append(">>`");
          _builder.newLineIfNotEmpty();
          _xblockexpression_1 = _builder;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
