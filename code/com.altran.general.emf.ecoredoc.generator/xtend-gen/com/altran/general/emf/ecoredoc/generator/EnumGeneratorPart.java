package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EnumGeneratorPart extends AEcoreDocGeneratorPart {
  public EnumGeneratorPart(final Multimap<EPackage, EClassifier> packages) {
    super(packages);
  }
  
  @Override
  public StringBuilder write(final EPackage pack) {
    final Collection<EEnum> eenums = this.collectEEnums(pack);
    this.writeEnumerations(eenums);
    return this.getOutput();
  }
  
  protected Collection<EEnum> collectEEnums(final EPackage pack) {
    return IterableExtensions.<EEnum>toSet(Iterables.<EEnum>filter(this.getPackages().get(pack), EEnum.class));
  }
  
  protected void writeEnumerations(final Collection<EEnum> eenums) {
    boolean _isEmpty = eenums.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEnumerationsHeader();
      final EPackage pack = this.getPackage(((EClassifier[])Conversions.unwrapArray(eenums, EClassifier.class))[0]);
      for (final EEnum eenum : eenums) {
        {
          this.writeEnumHeader(eenum);
          this.writeEnumLiterals(eenum, pack);
          this.writeUseCases(eenum);
        }
      }
    }
  }
  
  protected StringBuilder writeEnumerationsHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Enumerations");
    _builder.newLine();
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeEnumHeader(final EEnum eenum) {
    StringBuilder _xblockexpression = null;
    {
      this.writeEClassifierHeader(eenum);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      String _documentation = this.getDocumentation(eenum);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
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
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeEnumLiterals(final EEnum eenum, final EPackage pack) {
    StringBuilder _xblockexpression = null;
    {
      EList<EEnumLiteral> _eLiterals = eenum.getELiterals();
      for (final EEnumLiteral literal : _eLiterals) {
        this.writeLiteral(literal);
      }
      _xblockexpression = this.writeBlockClosure();
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeLiteral(final EEnumLiteral literal) {
    StringBuilder _xblockexpression = null;
    {
      EObject _eContainer = literal.eContainer();
      final EEnum eenum = ((EEnum) _eContainer);
      EObject _eContainer_1 = eenum.eContainer();
      final EPackage pack = ((EPackage) _eContainer_1);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|");
      String _name = literal.getName();
      _builder.append(_name);
      _builder.append("[[");
      String _name_1 = pack.getName();
      _builder.append(_name_1);
      _builder.append("-");
      String _name_2 = eenum.getName();
      _builder.append(_name_2);
      _builder.append("-");
      String _name_3 = literal.getName();
      _builder.append(_name_3);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      int _value = literal.getValue();
      _builder.append(_value);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      String _documentation = EcoreUtil.getDocumentation(literal);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeEClassifierHeader(final EClassifier eclassifier) {
    StringBuilder _xblockexpression = null;
    {
      final EPackage pack = this.getPackage(eclassifier);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[[");
      String _name = pack.getName();
      _builder.append(_name);
      _builder.append("-");
      String _name_1 = eclassifier.getName();
      _builder.append(_name_1);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("==== ");
      String _name_2 = eclassifier.getName();
      _builder.append(_name_2);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
}
