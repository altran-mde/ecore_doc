package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.impl.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EDataTypeGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EEnumGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
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
  
  public EcoreDocGenerator(final Collection<? extends EClassifier> input) {
    this.input = input;
  }
  
  public CharSequence generate() {
    this.writeIntro();
    this.collectEPackages();
    final EDataTypeGeneratorPart eDataTypeGeneratorPart = new EDataTypeGeneratorPart(this.ePackages);
    final EEnumGeneratorPart eEnumGeneratorPart = new EEnumGeneratorPart(this.ePackages);
    final EClassGeneratorPart eClassGeneratorPart = new EClassGeneratorPart(this.ePackages);
    Set<EPackage> _keySet = this.ePackages.keySet();
    for (final EPackage ePackage : _keySet) {
      {
        this.writeEPackageIntro(ePackage);
        this.output.append(eDataTypeGeneratorPart.write(ePackage));
        this.output.append(eEnumGeneratorPart.write(ePackage));
        this.output.append(eClassGeneratorPart.write(ePackage));
      }
    }
    return this.output.toString();
  }
  
  protected void writeIntro() {
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
    this.output.append(_builder);
  }
  
  protected void writeEPackageIntro(final EPackage ePackage) {
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
    this.output.append(_builder);
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
}
