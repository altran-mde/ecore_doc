package com.altran.general.emf.ecoredoc.generator.egf;

import com.altran.general.emf.ecoredoc.generator.egf.EcoreDocGeneratorHelper;
import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration;
import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionFactory;
import com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoredocExtensionPackage;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionHelper;
import org.eclipse.egf.portfolio.genchain.extension.ExtensionProperties;
import org.eclipse.egf.portfolio.genchain.generationChain.EcoreElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EcoreDocGeneratorExtension extends ExtensionHelper {
  @Extension
  private static final PatternFactory f_pattern = PatternFactory.eINSTANCE;
  
  @Extension
  private static final EcoredocExtensionFactory f_ecoredoc_ext = EcoredocExtensionFactory.eINSTANCE;
  
  @Extension
  private static final EcoredocExtensionPackage p_ecoredoc_ext = EcoredocExtensionPackage.eINSTANCE;
  
  @Override
  public String getLabel() {
    return "Emf EcoreDoc";
  }
  
  @Override
  protected void computeDefaultProperties(final Map<String, String> context) {
    final String project = context.get(ExtensionProperties.CONTEXT_PROJECT_NAME);
    EAttribute _ecoreDocGeneration_ProjectName = EcoreDocGeneratorExtension.p_ecoredoc_ext.getEcoreDocGeneration_ProjectName();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(project);
    _builder.append(".doc");
    this.properties.put(_ecoreDocGeneration_ProjectName, _builder.toString());
    this.properties.put(EcoreDocGeneratorExtension.p_ecoredoc_ext.getEcoreDocGeneration_OutputFolder(), "output");
    this.properties.put(EcoreDocGeneratorExtension.p_ecoredoc_ext.getEcoreDocGeneration_Resolve(), "false");
  }
  
  @Override
  public EcoreElement createEcoreElement(final Map<String, String> context) {
    EcoreDocGeneration _createEcoreDocGeneration = EcoreDocGeneratorExtension.f_ecoredoc_ext.createEcoreDocGeneration();
    final Procedure1<EcoreDocGeneration> _function = (EcoreDocGeneration it) -> {
      it.setModelPath(context.get(ExtensionProperties.MODEL_PATH));
      it.setOutputFolder(context.get(EcoreDocGeneratorExtension.p_ecoredoc_ext.getEcoreDocGeneration_OutputFolder().getName()));
      it.setProjectName(context.get(EcoreDocGeneratorExtension.p_ecoredoc_ext.getEcoreDocGeneration_ProjectName().getName()));
      it.setResolve(Boolean.parseBoolean(context.get(EcoreDocGeneratorExtension.p_ecoredoc_ext.getEcoreDocGeneration_Resolve().getName())));
    };
    return ObjectExtensions.<EcoreDocGeneration>operator_doubleArrow(_createEcoreDocGeneration, _function);
  }
  
  @Override
  public List<Substitution> getSubstitutions() {
    final TargetPlatformResourceSet resourceSet = new TargetPlatformResourceSet();
    Substitution _createSubstitution = EcoreDocGeneratorExtension.f_pattern.createSubstitution();
    final Procedure1<Substitution> _function = (Substitution it) -> {
      EList<Pattern> _replacement = it.getReplacement();
      EObject _eObject = resourceSet.getEObject(EcoreDocGeneratorHelper.getEcoreDocGenerationPatternURI(), true);
      _replacement.add(((Pattern) _eObject));
    };
    final Substitution substitution = ObjectExtensions.<Substitution>operator_doubleArrow(_createSubstitution, _function);
    return Collections.<Substitution>singletonList(substitution);
  }
}
