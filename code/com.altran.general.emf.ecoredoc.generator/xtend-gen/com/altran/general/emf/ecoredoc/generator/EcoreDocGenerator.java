package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigBuilder;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EDataTypeGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EEnumGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
  
  private EcoreDocGeneratorConfig config;
  
  public EcoreDocGenerator(final Collection<? extends EClassifier> input) {
    this.input = input;
  }
  
  public CharSequence generate() {
    this.writeIntro();
    EcoreDocGeneratorConfig _config = this.getConfig();
    Multimap<EPackage, EClassifier> _ePackages = this.getEPackages();
    EDataTypeGeneratorPart _eDataTypeGeneratorPart = new EDataTypeGeneratorPart(_config, _ePackages);
    EcoreDocGeneratorConfig _config_1 = this.getConfig();
    Multimap<EPackage, EClassifier> _ePackages_1 = this.getEPackages();
    EEnumGeneratorPart _eEnumGeneratorPart = new EEnumGeneratorPart(_config_1, _ePackages_1);
    EcoreDocGeneratorConfig _config_2 = this.getConfig();
    Multimap<EPackage, EClassifier> _ePackages_2 = this.getEPackages();
    EClassGeneratorPart _eClassGeneratorPart = new EClassGeneratorPart(_config_2, _ePackages_2);
    final List<? extends AEcoreDocGeneratorPart> parts = Collections.<AEcoreDocGeneratorPart>unmodifiableList(CollectionLiterals.<AEcoreDocGeneratorPart>newArrayList(_eDataTypeGeneratorPart, _eEnumGeneratorPart, _eClassGeneratorPart));
    Set<EPackage> _keySet = this.getEPackages().keySet();
    for (final EPackage ePackage : _keySet) {
      {
        IENamedElementConfig _findConfig = this.getConfig().findConfig(ePackage);
        final EPackageConfig config = ((EPackageConfig) _findConfig);
        boolean _shouldRender = config.shouldRender();
        if (_shouldRender) {
          this.writeEPackageIntro(ePackage);
          final Function1<AEcoreDocGeneratorPart, Integer> _function = (AEcoreDocGeneratorPart it) -> {
            int _switchResult = (int) 0;
            boolean _matched = false;
            if (it instanceof EDataTypeGeneratorPart) {
              _matched=true;
              _switchResult = config.getPositionEDataTypes();
            }
            if (!_matched) {
              if (it instanceof EEnumGeneratorPart) {
                _matched=true;
                _switchResult = config.getPositionEEnums();
              }
            }
            if (!_matched) {
              if (it instanceof EClassGeneratorPart) {
                _matched=true;
                _switchResult = config.getPositionEClasses();
              }
            }
            return ((Integer) Integer.valueOf(_switchResult));
          };
          final Consumer<AEcoreDocGeneratorPart> _function_1 = (AEcoreDocGeneratorPart it) -> {
            this.output.append(it.write(ePackage));
          };
          IterableExtensions.sortBy(parts, _function).forEach(_function_1);
        }
      }
    }
    return this.output.toString();
  }
  
  public EcoreDocGeneratorConfig getConfig() {
    this.assureConfigExists();
    return this.config;
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
  
  protected Multimap<EPackage, EClassifier> getEPackages() {
    boolean _isEmpty = this.ePackages.isEmpty();
    if (_isEmpty) {
      this.collectEPackages();
    }
    return this.ePackages;
  }
  
  protected void collectEPackages() {
    for (final EClassifier eclassifier : this.input) {
      EObject _eContainer = eclassifier.eContainer();
      this.ePackages.put(((EPackage) _eContainer), eclassifier);
    }
  }
  
  protected void assureConfigExists() {
    if ((this.config == null)) {
      Set<EPackage> _keySet = this.getEPackages().keySet();
      this.config = new EcoreDocConfigBuilder(_keySet).build();
    }
  }
}
