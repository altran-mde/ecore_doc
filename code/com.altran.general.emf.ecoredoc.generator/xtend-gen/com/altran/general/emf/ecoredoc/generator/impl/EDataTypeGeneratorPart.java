package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.config.EDataTypeConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EDataTypeConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorEDataTypePart;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;

@SuppressWarnings("all")
public class EDataTypeGeneratorPart extends AEcoreDocGeneratorEDataTypePart {
  public EDataTypeGeneratorPart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages) {
    super(config, ePackages);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    this.clearOutput();
    final List<EDataType> eDataTypes = this._ecoreDocExtension.collectEDataTypes(this.getEPackages().get(ePackage));
    final Function1<EDataType, EDataTypeConfig> _function = (EDataType it) -> {
      IENamedElementConfig _findConfig = this.getConfig().findConfig(it);
      return ((EDataTypeConfig) _findConfig);
    };
    final Function2<EDataType, EDataTypeConfig, Boolean> _function_1 = (EDataType eDataType, EDataTypeConfig config) -> {
      return Boolean.valueOf(config.shouldRender());
    };
    final Map<EDataType, EDataTypeConfig> eDataTypeMap = MapExtensions.<EDataType, EDataTypeConfig>filter(IterableExtensions.<EDataType, EDataTypeConfig>toInvertedMap(eDataTypes, _function), _function_1);
    this.writeEDataTypes(eDataTypeMap);
    return this.getOutput();
  }
  
  protected void writeEDataTypes(final Map<EDataType, EDataTypeConfig> eDataTypeMap) {
    boolean _isEmpty = eDataTypeMap.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEDataTypesHeader();
      Set<Map.Entry<EDataType, EDataTypeConfig>> _entrySet = eDataTypeMap.entrySet();
      for (final Map.Entry<EDataType, EDataTypeConfig> entry : _entrySet) {
        {
          final EDataTypeConfigPair pair = new EDataTypeConfigPair(entry);
          this.writeEDataTypeHeader(pair);
          this.writeProperties(pair);
          this.writeUseCases(pair);
        }
      }
    }
  }
  
  protected void writeEDataTypesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("=== Data Types");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected void writeEDataTypeHeader(final EDataTypeConfigPair pair) {
    final EDataType eDataType = pair.getElement();
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("[[");
    CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eDataType);
    _builder.append(_concatAnchor);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("==== ");
    String _name = eDataType.getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    String _newline_1 = EcoreDocExtension.newline();
    _builder.append(_newline_1);
    _builder.newLineIfNotEmpty();
    CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eDataType);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    String _newline_2 = EcoreDocExtension.newline();
    _builder.append(_newline_2);
    _builder.newLineIfNotEmpty();
    _output.append(_builder);
  }
}
