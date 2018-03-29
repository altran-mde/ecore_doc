package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import java.util.Collection;
import java.util.Comparator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class EcoreDocGenerator {
  @Extension
  private EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  private final Collection<? extends EClassifier> input;
  
  private final StringBuilder output = new StringBuilder();
  
  private final Multimap<EPackage, EClassifier> ePackages = TreeMultimap.<EPackage, EClassifier>create(
    ((Comparator<EPackage>) (EPackage o1, EPackage o2) -> {
      return o1.getName().compareTo(o2.getName());
    }), 
    ((Comparator<EClassifier>) (EClassifier o1, EClassifier o2) -> {
      return o1.getName().compareTo(o2.getName());
    }));
  
  private /* EcoreDocGeneratorConfig */Object config;
  
  public EcoreDocGenerator(final Collection<? extends EClassifier> input) {
    this.input = input;
  }
  
  public CharSequence generate() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe constructor EDataTypeGeneratorPart(Object, Multimap<EPackage, EClassifier>) refers to the missing type Object"
      + "\nThe method getConfig() from the type EcoreDocGenerator refers to the missing type EcoreDocGeneratorConfig"
      + "\nThe constructor EEnumGeneratorPart(Object, Multimap<EPackage, EClassifier>) refers to the missing type Object"
      + "\nThe method getConfig() from the type EcoreDocGenerator refers to the missing type EcoreDocGeneratorConfig"
      + "\nThe constructor EClassGeneratorPart(Object, Multimap<EPackage, EClassifier>) refers to the missing type Object"
      + "\nThe method getConfig() from the type EcoreDocGenerator refers to the missing type EcoreDocGeneratorConfig"
      + "\nEDataType cannot be resolved"
      + "\nEEnum cannot be resolved"
      + "\nEClass cannot be resolved");
  }
  
  public EcoreDocGeneratorConfig getConfig() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field EcoreDocGenerator.config refers to the missing type EcoreDocGeneratorConfig");
  }
  
  protected StringBuilder writeIntro() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// White Up-Pointing Triangle");
    _builder.newLine();
    _builder.append(":wupt: &#9651;");
    _builder.newLine();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(":inherited: {wupt}{nbsp}");
    _builder.newLine();
    String _newline_1 = EcoreDocExtension.newline();
    _builder.append(_newline_1);
    _builder.newLineIfNotEmpty();
    _builder.append(":table-caption!:");
    _builder.newLine();
    String _newline_2 = EcoreDocExtension.newline();
    _builder.append(_newline_2);
    _builder.newLineIfNotEmpty();
    _builder.append("= Ecore Documentation");
    _builder.newLine();
    _builder.append(":toc:");
    _builder.newLine();
    _builder.append(":toclevels: 4");
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  protected StringBuilder writeEPackageIntro(final EPackage ePackage) {
    StringBuilder _xblockexpression = null;
    {
      final String ePackageName = ePackage.getName();
      StringConcatenation _builder = new StringConcatenation();
      String _newline = EcoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      String _newline_1 = EcoreDocExtension.newline();
      _builder.append(_newline_1);
      _builder.newLineIfNotEmpty();
      _builder.append("[[");
      _builder.append(ePackageName);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("== Contents of ");
      _builder.append(ePackageName);
      _builder.newLineIfNotEmpty();
      String _newline_2 = EcoreDocExtension.newline();
      _builder.append(_newline_2);
      _builder.newLineIfNotEmpty();
      CharSequence _documentation = this._ecoreDocExtension.getDocumentation(ePackage);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      String _newline_3 = EcoreDocExtension.newline();
      _builder.append(_newline_3);
      _builder.newLineIfNotEmpty();
      CharSequence _concatEPackageProperties = this.concatEPackageProperties(ePackage);
      _builder.append(_concatEPackageProperties);
      _builder.newLineIfNotEmpty();
      _xblockexpression = this.output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatEPackageProperties(final EPackage ePackage) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Ns Prefix:: ");
    String _nsPrefix = ePackage.getNsPrefix();
    _builder.append(_nsPrefix);
    _builder.newLineIfNotEmpty();
    _builder.append("Ns URI:: ");
    String _nsURI = ePackage.getNsURI();
    _builder.append(_nsURI);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected void collectEPackages() {
    for (final EClassifier eclassifier : this.input) {
      EObject _eContainer = eclassifier.eContainer();
      this.ePackages.put(((EPackage) _eContainer), eclassifier);
    }
  }
  
  protected void assureConfigExists() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field ConfigFactory is undefined"
      + "\nThe field EcoreDocGenerator.config refers to the missing type EcoreDocGeneratorConfig"
      + "\nThe field EcoreDocGenerator.config refers to the missing type EcoreDocGeneratorConfig"
      + "\n=== cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateEcoreDocGeneratorConfig cannot be resolved");
  }
}
