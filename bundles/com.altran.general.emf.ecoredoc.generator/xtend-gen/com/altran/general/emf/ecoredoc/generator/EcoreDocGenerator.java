package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.config.EPackageConfig;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IENamedElementConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.EcoreDocConfigBuilder;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorEClassifierPart;
import com.altran.general.emf.ecoredoc.generator.impl.EDataTypeGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.EEnumGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.diagram.PlantUMLEcoreDiagramGenerator;
import com.altran.general.emf.ecoredoc.generator.impl.eclass.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import com.google.inject.Injector;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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

/**
 * Naming conventions:
 *  - Ecore names are written in full, i.e. including the leading "E".
 *  - "writeX()" returns void and writes directly to the output.
 *  - "defineX()" produces the output text for a property, or null if no output is required.
 */
@SuppressWarnings("all")
public class EcoreDocGenerator {
  @Extension
  private EcoreDocExtension ecoreDocExtension = new EcoreDocExtension();
  
  private final Collection<? extends EClassifier> input;
  
  private final StringBuilder output = new StringBuilder();
  
  private Injector xcoreInjector;
  
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
  
  /**
   * Generates the AsciiDoctor contents.
   */
  public CharSequence generate() {
    this.writeIntro();
    EcoreDocGeneratorConfig _config = this.getConfig();
    Multimap<EPackage, EClassifier> _ePackages = this.getEPackages();
    Injector _xcoreInjector = this.getXcoreInjector();
    EDataTypeGeneratorPart _eDataTypeGeneratorPart = new EDataTypeGeneratorPart(_config, _ePackages, _xcoreInjector);
    EcoreDocGeneratorConfig _config_1 = this.getConfig();
    Multimap<EPackage, EClassifier> _ePackages_1 = this.getEPackages();
    Injector _xcoreInjector_1 = this.getXcoreInjector();
    EEnumGeneratorPart _eEnumGeneratorPart = new EEnumGeneratorPart(_config_1, _ePackages_1, _xcoreInjector_1);
    EcoreDocGeneratorConfig _config_2 = this.getConfig();
    Multimap<EPackage, EClassifier> _ePackages_2 = this.getEPackages();
    Injector _xcoreInjector_2 = this.getXcoreInjector();
    EClassGeneratorPart _eClassGeneratorPart = new EClassGeneratorPart(_config_2, _ePackages_2, _xcoreInjector_2);
    final List<? extends AEcoreDocGeneratorEClassifierPart> parts = Collections.<AEcoreDocGeneratorEClassifierPart>unmodifiableList(CollectionLiterals.<AEcoreDocGeneratorEClassifierPart>newArrayList(_eDataTypeGeneratorPart, _eEnumGeneratorPart, _eClassGeneratorPart));
    Set<EPackage> _keySet = this.getEPackages().keySet();
    for (final EPackage ePackage : _keySet) {
      {
        IENamedElementConfig _findConfig = this.getConfig().findConfig(ePackage);
        final EPackageConfig config = ((EPackageConfig) _findConfig);
        boolean _shouldRender = config.shouldRender();
        if (_shouldRender) {
          this.writeEPackageIntro(ePackage);
          boolean _shouldRenderDiagrams = config.shouldRenderDiagrams();
          if (_shouldRenderDiagrams) {
            this.writeEPackageDiagram(ePackage);
          }
          final Function1<AEcoreDocGeneratorEClassifierPart, Integer> _function = (AEcoreDocGeneratorEClassifierPart it) -> {
            int _switchResult = (int) 0;
            boolean _matched = false;
            if (it instanceof EDataTypeGeneratorPart) {
              _matched=true;
              _switchResult = config.getEDataTypesPosition();
            }
            if (!_matched) {
              if (it instanceof EEnumGeneratorPart) {
                _matched=true;
                _switchResult = config.getEEnumsPosition();
              }
            }
            if (!_matched) {
              if (it instanceof EClassGeneratorPart) {
                _matched=true;
                _switchResult = config.getEClassesPosition();
              }
            }
            return ((Integer) Integer.valueOf(_switchResult));
          };
          final Consumer<AEcoreDocGeneratorEClassifierPart> _function_1 = (AEcoreDocGeneratorEClassifierPart it) -> {
            this.output.append(it.write(ePackage));
          };
          IterableExtensions.sortBy(parts, _function).forEach(_function_1);
        }
      }
    }
    return this.output.toString();
  }
  
  /**
   * Returns a fully populated configuration.
   */
  public EcoreDocGeneratorConfig getConfig() {
    this.ensureConfigExists();
    return this.config;
  }
  
  public Injector getXcoreInjector() {
    return this.xcoreInjector;
  }
  
  public Injector setXcoreInjector(final Injector xcoreInjector) {
    return this.xcoreInjector = xcoreInjector;
  }
  
  protected void writeIntro() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// White Up-Pointing Triangle");
    _builder.newLine();
    _builder.append(":wupt: &#9651;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(":inherited: {wupt}{nbsp}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// Black Up-Pointing Triangle");
    _builder.newLine();
    _builder.append(":bupt: &#9650;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(":override: {bupt}{nbsp}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// White Down-Pointing Triangle");
    _builder.newLine();
    _builder.append(":wdpt: &#9661;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(":inheritedBy: {wdpt}{nbsp}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// Black Down-Pointing Triangle");
    _builder.newLine();
    _builder.append(":bdpt: &#9660;");
    _builder.newLine();
    _builder.newLine();
    _builder.append(":overriddenBy: {bdpt}{nbsp}");
    _builder.newLine();
    _builder.newLine();
    _builder.append(":toc:");
    _builder.newLine();
    _builder.append(":toclevels: 4");
    _builder.newLine();
    _builder.append(":miscellaneous.tabsize: 2");
    _builder.newLine();
    _builder.append(":tabsize: 2");
    _builder.newLine();
    _builder.append(":icons: font");
    _builder.newLine();
    _builder.append(":experimental:");
    _builder.newLine();
    _builder.append(":source-highlighter: pygments");
    _builder.newLine();
    _builder.append(":prewrap!:");
    _builder.newLine();
    _builder.append(":table-caption!:");
    _builder.newLine();
    _builder.newLine();
    _builder.append("= ");
    String _documentTitle = this.getConfig().getDocumentTitle();
    _builder.append(_documentTitle);
    _builder.newLineIfNotEmpty();
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
    CharSequence _documentation = this.ecoreDocExtension.getDocumentation(ePackage);
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
  
  protected void writeEPackageDiagram(final EPackage ePackage) {
    Iterator<EClassifier> _iterator = ePackage.getEClassifiers().iterator();
    final PlantUMLEcoreDiagramGenerator diagramGenerator = new PlantUMLEcoreDiagramGenerator(_iterator, false, true, this.config);
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Class diagram of ");
    String _name = ePackage.getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    _builder.append("[plantuml, ");
    String _diagramsOutputPath = this.getConfig().getDiagramsOutputPath();
    _builder.append(_diagramsOutputPath);
    _builder.append("/");
    String _name_1 = ePackage.getName();
    _builder.append(_name_1);
    _builder.append(", ");
    String _diagramsOutputFormat = this.getConfig().getDiagramsOutputFormat();
    _builder.append(_diagramsOutputFormat);
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.append("----");
    _builder.newLine();
    this.output.append(_builder);
    this.output.append(diagramGenerator.generateDiagram());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----");
    _builder_1.newLine();
    String _newline_1 = EcoreDocExtension.newline();
    _builder_1.append(_newline_1);
    _builder_1.newLineIfNotEmpty();
    this.output.append(_builder_1);
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
  
  protected void ensureConfigExists() {
    if ((this.config == null)) {
      Set<EPackage> _keySet = this.getEPackages().keySet();
      this.config = new EcoreDocConfigBuilder(_keySet).build();
    }
  }
}
