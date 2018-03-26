package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EEnumGeneratorPart extends AEcoreDocGeneratorPart {
  public EEnumGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    super(ePackages);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    final List<EEnum> eEnums = this.collectEEnums(ePackage);
    this.writeEEnums(eEnums);
    return this.getOutput();
  }
  
  protected List<EEnum> collectEEnums(final EPackage ePackage) {
    final Function1<EEnum, String> _function = (EEnum it) -> {
      return it.getName();
    };
    return IterableExtensions.<EEnum, String>sortBy(Iterables.<EEnum>filter(this.getEPackages().get(ePackage), EEnum.class), _function);
  }
  
  protected void writeEEnums(final List<EEnum> eEnums) {
    boolean _isEmpty = eEnums.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEEnumsHeader();
      for (final EEnum eEnum : eEnums) {
        {
          this.writeEEnumHeader(eEnum);
          this.writeEEnumLiterals(eEnum);
          this.concatUseCases(eEnum);
        }
      }
    }
  }
  
  protected StringBuilder writeEEnumsHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Enumerations");
    _builder.newLine();
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeEEnumLiterals(final EEnum eEnum) {
    StringBuilder _xblockexpression = null;
    {
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
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
      _builder.newLine();
      _output.append(_builder);
      EList<EEnumLiteral> _eLiterals = eEnum.getELiterals();
      for (final EEnumLiteral eLiteral : _eLiterals) {
        this.writeELiteral(eLiteral);
      }
      _xblockexpression = this.getOutput().append(this.tableFooter());
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeELiteral(final EEnumLiteral eLiteral) {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|");
    String _name = eLiteral.getName();
    _builder.append(_name);
    _builder.append("[[");
    CharSequence _concatAnchor = this.concatAnchor(eLiteral);
    _builder.append(_concatAnchor);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    int _value = eLiteral.getValue();
    _builder.append(_value);
    _builder.newLineIfNotEmpty();
    _builder.append("|");
    String _documentation = EcoreUtil.getDocumentation(eLiteral);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected CharSequence writeEEnumHeader(final EEnum eEnum) {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[[");
    CharSequence _concatAnchor = this.concatAnchor(eEnum);
    _builder.append(_concatAnchor);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("==== ");
    String _name = eEnum.getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _documentation = this.getDocumentation(eEnum);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    return _output.append(_builder);
  }
}
