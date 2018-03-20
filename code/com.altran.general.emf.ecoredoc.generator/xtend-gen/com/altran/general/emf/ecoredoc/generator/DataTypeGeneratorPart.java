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
public class DataTypeGeneratorPart extends AEcoreDocGeneratorPart {
  public DataTypeGeneratorPart(final Multimap<EPackage, EClassifier> packages) {
    super(packages);
  }
  
  @Override
  public StringBuilder write(final EPackage pack) {
    final Collection<EDataType> dataTypes = this.collectDataTypes(pack);
    this.writeDataTypes(dataTypes);
    return this.getOutput();
  }
  
  protected Collection<EDataType> collectDataTypes(final EPackage pack) {
    final Function1<EDataType, Boolean> _function = (EDataType it) -> {
      return Boolean.valueOf((!(it instanceof EEnum)));
    };
    return IterableExtensions.<EDataType>toSet(IterableExtensions.<EDataType>filter(Iterables.<EDataType>filter(this.getPackages().get(pack), EDataType.class), _function));
  }
  
  /**
   * Writes the dataTypes of the EPackage and where they are used in.
   */
  protected void writeDataTypes(final Collection<EDataType> dataTypes) {
    boolean _isEmpty = dataTypes.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeDataTypesHeader();
      final EPackage pack = this.getPackage(((EClassifier[])Conversions.unwrapArray(dataTypes, EClassifier.class))[0]);
      for (final EDataType dataType : dataTypes) {
        {
          this.writeDataType(pack.getName(), dataType.getName());
          this.writeUseCases(dataType);
        }
      }
    }
  }
  
  protected StringBuilder writeDataTypesHeader() {
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
  
  protected StringBuilder writeDataType(final String packageName, final String dataTypeName) {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[[");
    _builder.append(packageName);
    _builder.append("-");
    _builder.append(dataTypeName);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("==== ");
    _builder.append(dataTypeName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _output.append(_builder);
  }
}
