package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
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
  
  /**
   * Writes the dataTypes of the EPackage and where they are used in.
   */
  protected void writeEDataTypes(final List<EDataType> eDataTypes) {
    boolean _isEmpty = eDataTypes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEDataTypesHeader();
      for (final EDataType eDataType : eDataTypes) {
        {
          StringBuilder _output = this.getOutput();
          StringConcatenation _builder = new StringConcatenation();
          CharSequence _writeEClassifierHeader = this.writeEClassifierHeader(eDataType);
          _builder.append(_writeEClassifierHeader);
          _output.append(_builder);
          this.writeUseCases(eDataType);
        }
      }
    }
  }
  
  protected StringBuilder writeEDataTypesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Data Types");
    _builder.newLine();
    _builder.newLine();
    _builder.append("TODO: Create template for EDataType");
    _builder.newLine();
    _builder.newLine();
    return _output.append(_builder);
  }
}
