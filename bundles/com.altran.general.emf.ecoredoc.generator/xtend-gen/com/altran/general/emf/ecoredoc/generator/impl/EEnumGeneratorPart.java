package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.config.EEnumConfig;
import com.altran.general.emf.ecoredoc.generator.config.EEnumLiteralConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EEnumConfigPair;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EEnumLiteralConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorEDataTypePart;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.collect.Multimap;
import com.google.inject.Injector;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;

@SuppressWarnings("all")
public class EEnumGeneratorPart extends AEcoreDocGeneratorEDataTypePart {
  public EEnumGeneratorPart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages, final Injector xcoreInjector) {
    super(config, ePackages, xcoreInjector);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    this.clearOutput();
    final List<EEnum> eEnums = this._ecoreDocExtension.collectEEnums(this.getEPackages().get(ePackage));
    final Function1<EEnum, EEnumConfig> _function = (EEnum it) -> {
      IENamedElementConfig _findConfig = this.getConfig().findConfig(it);
      return ((EEnumConfig) _findConfig);
    };
    final Function2<EEnum, EEnumConfig, Boolean> _function_1 = (EEnum eEnum, EEnumConfig config) -> {
      return Boolean.valueOf(config.shouldRender());
    };
    final Map<EEnum, EEnumConfig> eEnumMap = MapExtensions.<EEnum, EEnumConfig>filter(IterableExtensions.<EEnum, EEnumConfig>toInvertedMap(eEnums, _function), _function_1);
    this.writeEEnums(eEnumMap);
    return this.getOutput();
  }
  
  protected void writeEEnums(final Map<EEnum, EEnumConfig> eEnumMap) {
    boolean _isEmpty = eEnumMap.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEEnumsHeader();
      Set<Map.Entry<EEnum, EEnumConfig>> _entrySet = eEnumMap.entrySet();
      for (final Map.Entry<EEnum, EEnumConfig> entry : _entrySet) {
        {
          final EEnumConfigPair pair = new EEnumConfigPair(entry);
          this.writeEEnumHeader(pair);
          this.writeProperties(pair);
          this.writeEEnumLiterals(pair);
          this.writeUseCases(pair);
        }
      }
    }
  }
  
  protected void writeEEnumsHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("=== Enumerations");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected void writeEEnumLiterals(final EEnumConfigPair pair) {
    final EEnum eEnum = pair.getElement();
    final EList<EEnumLiteral> eLiterals = eEnum.getELiterals();
    final Function1<EEnumLiteral, EEnumLiteralConfig> _function = (EEnumLiteral it) -> {
      IENamedElementConfig _findConfig = this.getConfig().findConfig(it);
      return ((EEnumLiteralConfig) _findConfig);
    };
    final Function2<EEnumLiteral, EEnumLiteralConfig, Boolean> _function_1 = (EEnumLiteral eLiteral, EEnumLiteralConfig config) -> {
      return Boolean.valueOf(config.shouldRender());
    };
    final Map<EEnumLiteral, EEnumLiteralConfig> eLiteralsMap = MapExtensions.<EEnumLiteral, EEnumLiteralConfig>filter(IterableExtensions.<EEnumLiteral, EEnumLiteralConfig>toInvertedMap(eLiterals, _function), _function_1);
    boolean _isEmpty = eLiteralsMap.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      String _newline = EcoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _builder.append(".Literals");
      _builder.newLine();
      _builder.append("[cols=\"<20m,>10m,<70a\",options=\"header\"]");
      _builder.newLine();
      _builder.append("|===");
      _builder.newLine();
      _builder.append("|Symbol");
      _builder.newLine();
      _builder.append("|Value");
      _builder.newLine();
      _builder.append("|Description");
      _builder.newLine();
      _output.append(_builder);
      Set<Map.Entry<EEnumLiteral, EEnumLiteralConfig>> _entrySet = eLiteralsMap.entrySet();
      for (final Map.Entry<EEnumLiteral, EEnumLiteralConfig> entry : _entrySet) {
        EEnumLiteralConfigPair _eEnumLiteralConfigPair = new EEnumLiteralConfigPair(entry);
        this.writeELiteral(_eEnumLiteralConfigPair);
      }
      this.getOutput().append(this._ecoreDocExtension.tableFooter());
    }
  }
  
  protected void writeELiteral(final EEnumLiteralConfigPair pair) {
    final EEnumLiteral eLiteral = pair.getElement();
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    String _name = eLiteral.getName();
    _builder.append(_name);
    _builder.append("[[");
    CharSequence _concatAnchor = this._anchorExtension.concatAnchor(eLiteral);
    _builder.append(_concatAnchor);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    int _value = eLiteral.getValue();
    _builder.append(_value);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eLiteral);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    _output.append(_builder);
  }
  
  protected void writeEEnumHeader(final EEnumConfigPair pair) {
    final EEnum eEnum = pair.getElement();
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("[[");
    CharSequence _concatAnchor = this._anchorExtension.concatAnchor(eEnum);
    _builder.append(_concatAnchor);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("==== ");
    String _name = eEnum.getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    String _newline_1 = EcoreDocExtension.newline();
    _builder.append(_newline_1);
    _builder.newLineIfNotEmpty();
    CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eEnum);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    String _newline_2 = EcoreDocExtension.newline();
    _builder.append(_newline_2);
    _builder.newLineIfNotEmpty();
    _output.append(_builder);
  }
}
