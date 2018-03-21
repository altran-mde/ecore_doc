package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.EDataTypeGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.EEnumGeneratorPart;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class EcoreDocGenerator {
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
        this.writeEPackageIntro(ePackage.getName());
        this.output.append(eDataTypeGeneratorPart.write(ePackage));
        this.output.append(eEnumGeneratorPart.write(ePackage));
        this.output.append(eClassGeneratorPart.write(ePackage));
      }
    }
    return this.output.toString();
  }
  
  protected StringBuilder writeIntro() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// White Up-Pointing Triangle");
    _builder.newLine();
    _builder.append(":wupt: &#9651;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(":inherited: {wupt}{nbsp}");
    _builder.newLine();
    _builder.newLine();
    _builder.append(":table-caption!:");
    _builder.newLine();
    _builder.newLine();
    _builder.append("= Ecore Documentation");
    _builder.newLine();
    _builder.append(":toc:");
    _builder.newLine();
    _builder.append(":toclevels: 4");
    _builder.newLine();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  protected StringBuilder writeEPackageIntro(final String ePackageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[[");
    _builder.append(ePackageName);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("== Contents of ");
    _builder.append(ePackageName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  protected void collectEPackages() {
    for (final EClassifier eclassifier : this.input) {
      EObject _eContainer = eclassifier.eContainer();
      this.ePackages.put(((EPackage) _eContainer), eclassifier);
    }
  }
}
