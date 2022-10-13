package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.generator.config.IEClassifierConfig;
import com.altran.general.emf.ecoredoc.generator.configbuilder.AEcoreDocConfigPair;
import com.altran.general.emf.ecoredoc.generator.impl.AEcoreDocGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.diagram.PlantUMLEcoreDiagramGenerator;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public abstract class AEcoreDocGeneratorEClassifierPart extends AEcoreDocGeneratorPart {
  public AEcoreDocGeneratorEClassifierPart(final EcoreDocGeneratorConfig config, final Multimap<EPackage, EClassifier> ePackages, final Injector xcoreInjector) {
    super(config, ePackages, xcoreInjector);
  }
  
  protected void writeDiagram(final AEcoreDocConfigPair<? extends EClassifier, ? extends IEClassifierConfig> pair) {
    boolean _shouldRenderDiagrams = pair.getConfig().shouldRenderDiagrams();
    boolean _not = (!_shouldRenderDiagrams);
    if (_not) {
      return;
    }
    final EClassifier eClassifier = pair.getElement();
    UnmodifiableIterator<EClassifier> _singletonIterator = Iterators.<EClassifier>singletonIterator(eClassifier);
    EcoreDocGeneratorConfig _config = this.getConfig();
    final PlantUMLEcoreDiagramGenerator diagramGenerator = new PlantUMLEcoreDiagramGenerator(_singletonIterator, true, false, _config);
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    String _newline = EcoreDocExtension.newline();
    _builder.append(_newline);
    _builder.newLineIfNotEmpty();
    _builder.append(".Class diagram of ");
    String _name = eClassifier.getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    _builder.append("[plantuml, ");
    String _diagramsOutputPath = this.getConfig().getDiagramsOutputPath();
    _builder.append(_diagramsOutputPath);
    _builder.append("/");
    String _name_1 = eClassifier.getEPackage().getName();
    _builder.append(_name_1);
    _builder.append("_");
    String _name_2 = eClassifier.getName();
    _builder.append(_name_2);
    _builder.append(", ");
    String _diagramsOutputFormat = this.getConfig().getDiagramsOutputFormat();
    _builder.append(_diagramsOutputFormat);
    _builder.append("]");
    _builder.newLineIfNotEmpty();
    _builder.append("----");
    _builder.newLine();
    _output.append(_builder);
    this.getOutput().append(diagramGenerator.generateDiagram());
    StringBuilder _output_1 = this.getOutput();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("----");
    _builder_1.newLine();
    String _newline_1 = EcoreDocExtension.newline();
    _builder_1.append(_newline_1);
    _builder_1.newLineIfNotEmpty();
    _output_1.append(_builder_1);
  }
}
