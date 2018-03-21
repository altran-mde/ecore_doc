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
public class EEnumGeneratorPart extends AEcoreDocGeneratorPart {
  public EEnumGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    super(ePackages);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    final Collection<EEnum> eEnums = this.collectEEnums(ePackage);
    this.writeEEnumerations(eEnums);
    return this.getOutput();
  }
  
  protected Collection<EEnum> collectEEnums(final EPackage ePackage) {
    return IterableExtensions.<EEnum>toSet(Iterables.<EEnum>filter(this.getEPackages().get(ePackage), EEnum.class));
  }
  
  protected void writeEEnumerations(final Collection<EEnum> eEnums) {
    boolean _isEmpty = eEnums.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEEnumerationsHeader();
      final EPackage ePackage = this.getEPackage(((EClassifier[])Conversions.unwrapArray(eEnums, EClassifier.class))[0]);
      for (final EEnum eEnum : eEnums) {
        {
          this.writeEEnumHeader(eEnum);
          this.writeEEnumLiterals(eEnum, ePackage);
          this.writeUseCases(eEnum);
        }
      }
    }
  }
  
  protected StringBuilder writeEEnumerationsHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Enumerations");
    _builder.newLine();
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeEEnumHeader(final EEnum eEnum) {
    StringBuilder _xblockexpression = null;
    {
      this.writeEClassifierHeader(eEnum);
      this.getDocumentation(eEnum);
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
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeEEnumLiterals(final EEnum eEnum, final EPackage ePackage) {
    StringBuilder _xblockexpression = null;
    {
      EList<EEnumLiteral> _eLiterals = eEnum.getELiterals();
      for (final EEnumLiteral eLiteral : _eLiterals) {
        this.writeELiteral(eLiteral);
      }
      _xblockexpression = this.writeFooter();
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeELiteral(final EEnumLiteral eLiteral) {
    StringBuilder _xblockexpression = null;
    {
      EObject _eContainer = eLiteral.eContainer();
      final EEnum eEnum = ((EEnum) _eContainer);
      EObject _eContainer_1 = eEnum.eContainer();
      final EPackage ePackage = ((EPackage) _eContainer_1);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|");
      String _name = eLiteral.getName();
      _builder.append(_name);
      _builder.append("[[");
      String _name_1 = ePackage.getName();
      _builder.append(_name_1);
      _builder.append("-");
      String _name_2 = eEnum.getName();
      _builder.append(_name_2);
      _builder.append("-");
      String _name_3 = eLiteral.getName();
      _builder.append(_name_3);
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
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
}
