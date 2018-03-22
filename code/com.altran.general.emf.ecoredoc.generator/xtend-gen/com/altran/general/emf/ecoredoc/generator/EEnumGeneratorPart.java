package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
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
    this.writeEEnumerations(eEnums);
    return this.getOutput();
  }
  
  protected List<EEnum> collectEEnums(final EPackage ePackage) {
    final Function1<EEnum, String> _function = (EEnum it) -> {
      return it.getName();
    };
    return IterableExtensions.<EEnum, String>sortBy(Iterables.<EEnum>filter(this.getEPackages().get(ePackage), EEnum.class), _function);
  }
  
  protected void writeEEnumerations(final List<EEnum> eEnums) {
    boolean _isEmpty = eEnums.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEEnumerationsHeader();
      final EPackage ePackage = this.getEPackage(eEnums.get(0));
      for (final EEnum eEnum : eEnums) {
        {
          StringBuilder _output = this.getOutput();
          StringConcatenation _builder = new StringConcatenation();
          CharSequence _writeEClassifierHeader = this.writeEClassifierHeader(eEnum);
          _builder.append(_writeEClassifierHeader);
          _output.append(_builder);
          StringBuilder _output_1 = this.getOutput();
          StringConcatenation _builder_1 = new StringConcatenation();
          CharSequence _documentation = this.getDocumentation(eEnum);
          _builder_1.append(_documentation);
          _output_1.append(_builder_1);
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
  
  protected StringBuilder writeEEnumLiterals(final EEnum eEnum, final EPackage ePackage) {
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
      StringBuilder _output_1 = this.getOutput();
      StringConcatenation _builder_1 = new StringConcatenation();
      CharSequence _writeFooter = this.writeFooter();
      _builder_1.append(_writeFooter);
      _builder_1.newLineIfNotEmpty();
      _xblockexpression = _output_1.append(_builder_1);
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeELiteral(final EEnumLiteral eLiteral) {
    StringBuilder _xblockexpression = null;
    {
      EObject _eContainer = eLiteral.eContainer();
      final EEnum eEnum = ((EEnum) _eContainer);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|");
      String _name = eLiteral.getName();
      _builder.append(_name);
      _builder.append("[[");
      CharSequence _writeAnchor = this.writeAnchor(eLiteral);
      _builder.append(_writeAnchor);
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
