package com.altran.general.emf.ecoredoc.generator.impl.eclass;

import com.altran.general.emf.ecoredoc.generator.configbuilder.EClassConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EReferenceConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.AEReferenceGeneratorFragment;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ECrossReferenceReferenceGeneratorFragment extends AEReferenceGeneratorFragment {
  public ECrossReferenceReferenceGeneratorFragment(final EClassGeneratorPart eClassGeneratorPart) {
    super(eClassGeneratorPart);
  }
  
  public void writeECrossReferences(final EClassConfigPair pair) {
    final EClass eClass = pair.getElement();
    final List<EReferenceConfigPair> crossReferences = this.combineConfigPairs(this.collectECrossReferences(eClass), pair.getConfig());
    final List<EReferenceConfigPair> inheritedCrossReferences = this.combineConfigPairs(this.collectInheritedECrossReferences(pair), pair.getConfig());
    boolean _hasRenderedEntries = this.hasRenderedEntries(pair.getConfig(), crossReferences, inheritedCrossReferences);
    if (_hasRenderedEntries) {
      this.writeEReferencesHeader();
      this.writeEStructuralFeatures(crossReferences, eClass, inheritedCrossReferences);
    }
  }
  
  protected void writeEReferencesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".References");
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
  
  protected Set<EReference> collectECrossReferences(final EClass eClass) {
    final Function1<EReference, Boolean> _function = (EReference it) -> {
      boolean _isContainment = it.isContainment();
      return Boolean.valueOf((!_isContainment));
    };
    return IterableExtensions.<EReference>toSet(IterableExtensions.<EReference>filter(eClass.getEReferences(), _function));
  }
  
  protected Set<EReference> collectInheritedECrossReferences(final EClassConfigPair pair) {
    Set<EReference> _xifexpression = null;
    boolean _shouldRepeatInherited = pair.getConfig().shouldRepeatInherited();
    if (_shouldRepeatInherited) {
      Set<EReference> _xblockexpression = null;
      {
        final EClass eClass = pair.getElement();
        final Function1<EReference, Boolean> _function = (EReference it) -> {
          boolean _isContainment = it.isContainment();
          return Boolean.valueOf((!_isContainment));
        };
        final Function1<EReference, Boolean> _function_1 = (EReference it) -> {
          return Boolean.valueOf(eClass.getEReferences().contains(it));
        };
        final Function1<EReference, Boolean> _function_2 = (EReference eReference) -> {
          final Function1<EOperation, Boolean> _function_3 = (EOperation it) -> {
            return Boolean.valueOf(this._eOperationEStructuralFeatureInteractionExtension.overridesFeature(it, eReference));
          };
          return Boolean.valueOf(IterableExtensions.<EOperation>exists(eClass.getEOperations(), _function_3));
        };
        _xblockexpression = IterableExtensions.<EReference>toSet(IterableExtensions.<EReference>reject(IterableExtensions.<EReference>reject(IterableExtensions.<EReference>filter(eClass.getEAllReferences(), _function), _function_1), _function_2));
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = CollectionLiterals.<EReference>emptySet();
    }
    return _xifexpression;
  }
}
