package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorPart;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.List;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EDataTypeGeneratorPart extends AEcoreDocGeneratorPart {
  public EDataTypeGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    super(ePackages);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    this.clearOutput();
    final List<EDataType> eDataTypes = this.collectEDataTypes(ePackage);
    this.writeEDataTypes(eDataTypes);
    return this.getOutput();
  }
  
  protected List<EDataType> collectEDataTypes(final EPackage ePackage) {
    final Function1<EDataType, Boolean> _function = (EDataType it) -> {
      return Boolean.valueOf((!(it instanceof EEnum)));
    };
    final Function1<EDataType, String> _function_1 = (EDataType it) -> {
      return it.getName();
    };
    return IterableExtensions.<EDataType, String>sortBy(IterableExtensions.<EDataType>filter(Iterables.<EDataType>filter(this.getEPackages().get(ePackage), EDataType.class), _function), _function_1);
  }
  
  protected void writeEDataTypes(final List<EDataType> eDataTypes) {
    boolean _isEmpty = eDataTypes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEDataTypesHeader();
      for (final EDataType eDataType : eDataTypes) {
        {
          this.writeEDataTypeHeader(eDataType);
          this.writeUseCases(eDataType);
        }
      }
    }
  }
  
  protected void writeEDataTypesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append("=== Data Types");
    _builder.newLine();
    _output.append(_builder);
  }
  
  protected CharSequence writeEDataTypeHeader(final EDataType eDataType) {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = this._ecoreDocExtension.newline();
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
    String _newline_1 = this._ecoreDocExtension.newline();
    _builder.append(_newline_1);
    _builder.newLineIfNotEmpty();
    CharSequence _documentation = this._ecoreDocExtension.getDocumentation(eDataType);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    return _output.append(_builder);
  }
}
