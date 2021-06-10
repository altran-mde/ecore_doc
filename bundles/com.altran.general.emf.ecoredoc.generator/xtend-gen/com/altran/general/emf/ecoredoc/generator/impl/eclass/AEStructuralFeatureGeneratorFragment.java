package com.altran.general.emf.ecoredoc.generator.impl.eclass;

import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.IEStructuralFeatureConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.AEClassMemberGeneratorFragment;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EStructuralFeaturePropertyExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class AEStructuralFeatureGeneratorFragment<F extends EStructuralFeature, P extends IEStructuralFeatureConfigPair<F, ?>> extends AEClassMemberGeneratorFragment {
  @Extension
  protected EStructuralFeaturePropertyExtension _eStructuralFeaturePropertyExtension = new EStructuralFeaturePropertyExtension();
  
  public AEStructuralFeatureGeneratorFragment(final EClassGeneratorPart eClassGeneratorPart) {
    super(eClassGeneratorPart);
  }
  
  protected boolean hasRenderedEntries(final EClassConfig classConfig, final Collection<P> eStructuralFeatures, final Collection<P> inheritedEStructuralFeatures) {
    return (IterableExtensions.<P>exists(eStructuralFeatures, ((Function1<P, Boolean>) (P it) -> {
      return Boolean.valueOf(it.getConfig().shouldRender());
    })) || 
      (classConfig.shouldRepeatInherited() && 
        IterableExtensions.<P>exists(inheritedEStructuralFeatures, ((Function1<P, Boolean>) (P it) -> {
          return Boolean.valueOf(it.getConfig().shouldRender());
        }))));
  }
  
  protected List<P> combineConfigPairs(final Collection<F> eStructuralFeatures, final EClassConfig classConfig) {
    final Function1<F, P> _function = (F it) -> {
      P _combineConfigPair = this.combineConfigPair(it, classConfig);
      return ((P) _combineConfigPair);
    };
    return IterableExtensions.<P>toList(IterableExtensions.<F, P>map(eStructuralFeatures, _function));
  }
  
  protected void writeEStructuralFeatures(final Collection<P> ownEStructuralFeatures, final EClass eClass, final Collection<P> inheritedEStructuralFeatures) {
    final Function1<P, String> _function = (P it) -> {
      return EcoreDocExtension.eStructuralFeatureSorter.apply(it.getElement());
    };
    List<P> _sortBy = IterableExtensions.<P, String>sortBy(ownEStructuralFeatures, _function);
    for (final P entry : _sortBy) {
      this.writeRow(entry, eClass, false);
    }
    final Function1<P, String> _function_1 = (P it) -> {
      return EcoreDocExtension.eStructuralFeatureSorter.apply(it.getElement());
    };
    List<P> _sortBy_1 = IterableExtensions.<P, String>sortBy(inheritedEStructuralFeatures, _function_1);
    for (final P entry_1 : _sortBy_1) {
      this.writeRow(entry_1, eClass, true);
    }
    this.getOutput().append(this._ecoreDocExtension.tableFooter());
  }
  
  protected void writeRow(final P pair, final EClass eClass, final boolean inherited) {
    boolean _shouldRender = pair.getConfig().shouldRender();
    boolean _not = (!_shouldRender);
    if (_not) {
      return;
    }
    final F eStructuralFeature = pair.getElement();
    final String eStructuralFeatureName = eStructuralFeature.getName();
    final String[] inheritedFeatureSegments = this._inheritedEClassMemberSegmentsCollector.collectInheritedEClassMemberSegments(eStructuralFeature, eClass);
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("|`");
    _builder.append(eStructuralFeatureName);
    _builder.append("`[[");
    CharSequence _joinAnchor = this._anchorExtension.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(inheritedFeatureSegments)));
    _builder.append(_joinAnchor);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    {
      if (inherited) {
        _builder.newLine();
        CharSequence _concatInheritedElement = this.concatInheritedElement(eStructuralFeature);
        _builder.append(_concatInheritedElement);
        _builder.newLineIfNotEmpty();
      }
    }
    String _concatOverridesOperations = this.concatOverridesOperations(eStructuralFeature, eClass);
    _builder.append(_concatOverridesOperations);
    _builder.newLineIfNotEmpty();
    String _concatOverridenByOperations = this.concatOverridenByOperations(eStructuralFeature, eClass);
    _builder.append(_concatOverridenByOperations);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    CharSequence _concatFeatureType = this.concatFeatureType(eStructuralFeature);
    _builder.append(_concatFeatureType);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    CharSequence _concatFeatureProperties = this.concatFeatureProperties(pair);
    _builder.append(_concatFeatureProperties);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eStructuralFeature);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    _output.append(_builder);
  }
  
  protected String concatOverridesOperations(final F eStructuralFeature, final EClass eClass) {
    String _xblockexpression = null;
    {
      final Function1<EClass, EList<EOperation>> _function = (EClass it) -> {
        return it.getEOperations();
      };
      final Function1<EOperation, Boolean> _function_1 = (EOperation it) -> {
        return Boolean.valueOf(this._eOperationEStructuralFeatureInteractionExtension.implementsOperation(eStructuralFeature, it));
      };
      final Set<EOperation> overridesOperations = IterableExtensions.<EOperation>toSet(IterableExtensions.<EOperation>filter(Iterables.<EOperation>concat(ListExtensions.<EClass, EList<EOperation>>map(eClass.getEAllSuperTypes(), _function)), _function_1));
      final Function1<EOperation, CharSequence> _function_2 = (EOperation it) -> {
        return this.concatLinkTo(it, "{override}");
      };
      _xblockexpression = this.joinInheritance(IterableExtensions.<EOperation, CharSequence>map(overridesOperations, _function_2));
    }
    return _xblockexpression;
  }
  
  protected String concatOverridenByOperations(final F eStructuralFeature, final EClass eClass) {
    String _xblockexpression = null;
    {
      final Function1<EClass, EList<EOperation>> _function = (EClass it) -> {
        return it.getEOperations();
      };
      final Function1<EOperation, Boolean> _function_1 = (EOperation it) -> {
        return Boolean.valueOf(this._eOperationEStructuralFeatureInteractionExtension.overridesFeature(it, eStructuralFeature));
      };
      final Set<EOperation> overriddenByOperations = IterableExtensions.<EOperation>toSet(IterableExtensions.<EOperation>filter(Iterables.<EOperation>concat(IterableExtensions.<EClass, EList<EOperation>>map(this.collectAllSubTypes(eClass), _function)), _function_1));
      final Function1<EOperation, CharSequence> _function_2 = (EOperation it) -> {
        return this.concatLinkTo(it, "{overriddenBy}");
      };
      _xblockexpression = this.joinInheritance(IterableExtensions.<EOperation, CharSequence>map(overriddenByOperations, _function_2));
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatFeatureProperties(final P pair) {
    final List<CharSequence> featureProperties = this.enumerateFeatureProperties(pair);
    final List<CharSequence> genericProperties = this.enumerateGenericProperties(pair);
    return IterableExtensions.join(IterableExtensions.<CharSequence>filterNull(Iterables.<CharSequence>concat(featureProperties, genericProperties)), AEClassMemberGeneratorFragment.PROPERTY_SEPARATOR);
  }
  
  protected CharSequence concatInheritedElement(final ENamedElement eNamedElement) {
    return this.concatLinkTo(eNamedElement, "{inherited}");
  }
  
  protected List<CharSequence> enumerateGenericProperties(final P pair) {
    CharSequence _concatBounds = this._eStructuralFeaturePropertyExtension.concatBounds(pair);
    CharSequence _concatDefaultValue = this._eStructuralFeaturePropertyExtension.concatDefaultValue(pair);
    CharSequence _defineOrdered = this._eStructuralFeaturePropertyExtension.defineOrdered(pair);
    CharSequence _defineChangeable = this._eStructuralFeaturePropertyExtension.defineChangeable(pair);
    CharSequence _defineDerived = this._eStructuralFeaturePropertyExtension.defineDerived(pair);
    CharSequence _defineTransient = this._eStructuralFeaturePropertyExtension.defineTransient(pair);
    CharSequence _defineUnique = this._eStructuralFeaturePropertyExtension.defineUnique(pair);
    CharSequence _defineUnsettable = this._eStructuralFeaturePropertyExtension.defineUnsettable(pair);
    CharSequence _defineVolatile = this._eStructuralFeaturePropertyExtension.defineVolatile(pair);
    return Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_concatBounds, _concatDefaultValue, _defineOrdered, _defineChangeable, _defineDerived, _defineTransient, _defineUnique, _defineUnsettable, _defineVolatile));
  }
  
  protected abstract List<CharSequence> enumerateFeatureProperties(final P pair);
  
  protected abstract P combineConfigPair(final F eStructuralFeature, final EClassConfig classConfig);
  
  protected abstract CharSequence concatFeatureType(final F eStructuralFeature);
}
