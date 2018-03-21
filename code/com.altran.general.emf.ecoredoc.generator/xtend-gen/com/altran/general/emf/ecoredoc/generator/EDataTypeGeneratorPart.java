package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.Collection;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EDataTypeGeneratorPart extends AEcoreDocGeneratorPart {
  public EDataTypeGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    super(ePackages);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    final Collection<EDataType> eDataTypes = this.collectEDataTypes(ePackage);
    this.writeEDataTypes(eDataTypes);
    return this.getOutput();
  }
  
  protected Collection<EDataType> collectEDataTypes(final EPackage ePackage) {
    final Function1<EDataType, Boolean> _function = (EDataType it) -> {
      return Boolean.valueOf((!(it instanceof EEnum)));
    };
    return IterableExtensions.<EDataType>toSet(IterableExtensions.<EDataType>filter(Iterables.<EDataType>filter(this.getEPackages().get(ePackage), EDataType.class), _function));
  }
  
  /**
   * Writes the dataTypes of the EPackage and where they are used in.
   */
  protected void writeEDataTypes(final Collection<EDataType> eDataTypes) {
    boolean _isEmpty = eDataTypes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEDataTypesHeader();
      final EPackage ePackage = this.getEPackage(((EClassifier[])Conversions.unwrapArray(eDataTypes, EClassifier.class))[0]);
      for (final EDataType eDataType : eDataTypes) {
        {
          this.writeEDataType(ePackage.getName(), eDataType.getName());
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
  
  protected StringBuilder writeEDataType(final String ePackageName, final String eDataTypeName) {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[[");
    _builder.append(ePackageName);
    _builder.append("-");
    _builder.append(eDataTypeName);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("==== ");
    _builder.append(eDataTypeName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _output.append(_builder);
  }
}
