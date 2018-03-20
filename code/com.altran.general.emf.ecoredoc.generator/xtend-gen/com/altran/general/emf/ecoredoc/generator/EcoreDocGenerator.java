package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.ClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.DataTypeGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.EnumGeneratorPart;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class EcoreDocGenerator {
  private final Collection<? extends EClassifier> input;
  
  private final StringBuilder output = new StringBuilder();
  
  private final Multimap<EPackage, EClassifier> packages = TreeMultimap.<EPackage, EClassifier>create(
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
    this.collectPackages();
    final DataTypeGeneratorPart dataTypeGeneratorPart = new DataTypeGeneratorPart(this.packages);
    final EnumGeneratorPart enumGeneratorPart = new EnumGeneratorPart(this.packages);
    final ClassGeneratorPart classGeneratorPart = new ClassGeneratorPart(this.packages);
    Set<EPackage> _keySet = this.packages.keySet();
    for (final EPackage pack : _keySet) {
      {
        this.writePackageIntro(pack.getName());
        this.output.append(dataTypeGeneratorPart.write(pack));
        this.output.append(enumGeneratorPart.write(pack));
        this.output.append(classGeneratorPart.write(pack));
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
  
  protected StringBuilder writePackageIntro(final String packageName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[[");
    _builder.append(packageName);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("== Contents of ");
    _builder.append(packageName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return this.output.append(_builder);
  }
  
  protected void collectPackages() {
    for (final EClassifier eclassifier : this.input) {
      EObject _eContainer = eclassifier.eContainer();
      this.packages.put(((EPackage) _eContainer), eclassifier);
    }
  }
  
  protected CharSequence _writeEClassifierType(final EClass clazz) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Class");
    return _builder;
  }
  
  protected CharSequence _writeEClassifierType(final EEnum eenum) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Enum");
    return _builder;
  }
  
  protected CharSequence _writeEClassifierType(final EDataType dataType) {
    return null;
  }
  
  protected CharSequence writeEClassifierType(final EClassifier eenum) {
    if (eenum instanceof EEnum) {
      return _writeEClassifierType((EEnum)eenum);
    } else if (eenum instanceof EClass) {
      return _writeEClassifierType((EClass)eenum);
    } else if (eenum instanceof EDataType) {
      return _writeEClassifierType((EDataType)eenum);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eenum).toString());
    }
  }
}
