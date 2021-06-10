package com.altran.general.emf.ecoredoc.generator.impl.eclass;

import com.altran.general.emf.ecoredoc.generator.config.EAttributeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EClassConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EAttributeConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.AEStructuralFeatureGeneratorFragment;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EAttributeGeneratorFragment extends AEStructuralFeatureGeneratorFragment<EAttribute, EAttributeConfigPair> {
  public EAttributeGeneratorFragment(final EClassGeneratorPart eClassGeneratorPart) {
    super(eClassGeneratorPart);
  }
  
  public void writeEAttributes(final EClassConfigPair pair) {
    final EClass eClass = pair.getElement();
    final List<EAttributeConfigPair> eAttributes = this.combineConfigPairs(eClass.getEAttributes(), pair.getConfig());
    final List<EAttributeConfigPair> inheritedEAttributes = this.combineConfigPairs(this.collectInheritedEAttributes(pair), pair.getConfig());
    boolean _hasRenderedEntries = this.hasRenderedEntries(pair.getConfig(), eAttributes, inheritedEAttributes);
    if (_hasRenderedEntries) {
      this.writeEAttributesHeader();
      this.writeEStructuralFeatures(eAttributes, eClass, inheritedEAttributes);
    }
  }
  
  protected void writeEAttributesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Attributes");
    _builder.newLine();
    CharSequence _tableHeader = this._ecoreDocExtension.tableHeader();
    _builder.append(_tableHeader);
    _builder.newLineIfNotEmpty();
    _builder.append("|===");
    _builder.newLine();
    _builder.append("|Name");
    _builder.newLine();
    _builder.append("|Type");
    _builder.newLine();
    _builder.append("|Properties");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected Set<EAttribute> collectInheritedEAttributes(final EClassConfigPair pair) {
    Set<EAttribute> _xifexpression = null;
    boolean _shouldRepeatInherited = pair.getConfig().shouldRepeatInherited();
    if (_shouldRepeatInherited) {
      Set<EAttribute> _xblockexpression = null;
      {
        final EClass eClass = pair.getElement();
        final Function1<EAttribute, Boolean> _function = (EAttribute it) -> {
          return Boolean.valueOf(eClass.getEAttributes().contains(it));
        };
        final Function1<EAttribute, Boolean> _function_1 = (EAttribute eAttribute) -> {
          final Function1<EOperation, Boolean> _function_2 = (EOperation it) -> {
            return Boolean.valueOf(this._eOperationEStructuralFeatureInteractionExtension.overridesFeature(it, eAttribute));
          };
          return Boolean.valueOf(IterableExtensions.<EOperation>exists(eClass.getEOperations(), _function_2));
        };
        _xblockexpression = IterableExtensions.<EAttribute>toSet(IterableExtensions.<EAttribute>reject(IterableExtensions.<EAttribute>reject(eClass.getEAllAttributes(), _function), _function_1));
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = CollectionLiterals.<EAttribute>emptySet();
    }
    return _xifexpression;
  }
  
  @Override
  protected List<CharSequence> enumerateFeatureProperties(final EAttributeConfigPair pair) {
    CharSequence _defineId = this._eStructuralFeaturePropertyExtension.defineId(pair);
    return Collections.<CharSequence>unmodifiableList(CollectionLiterals.<CharSequence>newArrayList(_defineId));
  }
  
  @Override
  protected EAttributeConfigPair combineConfigPair(final EAttribute eAttribute, final EClassConfig classConfig) {
    final Function1<EAttributeConfig, Boolean> _function = (EAttributeConfig it) -> {
      String _id = it.getId();
      String _name = eAttribute.getName();
      return Boolean.valueOf(Objects.equal(_id, _name));
    };
    EAttributeConfig _findFirst = IterableExtensions.<EAttributeConfig>findFirst(classConfig.getEAttributes(), _function);
    return new EAttributeConfigPair(eAttribute, _findFirst);
  }
  
  @Override
  protected CharSequence concatFeatureType(final EAttribute eAttribute) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _concatLinkTo = this.eClassGeneratorPart.concatLinkTo(eAttribute.getEType());
    _builder.append(_concatLinkTo);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
