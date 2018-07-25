package com.altran.general.emf.ecoredoc.generator.impl.eclass;

import com.altran.general.emf.ecoredoc.generator.impl.eclass.EClassGeneratorPart;
import com.altran.general.emf.ecoredoc.generator.impl.extension.AnchorExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EOperationEStructuralFeatureInteractionExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.altran.general.emf.ecoredoc.generator.impl.extension.InheritedEClassMemberSegmentsCollector;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class AEClassMemberGeneratorFragment {
  protected final static String PROPERTY_SEPARATOR = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      _builder.append("+");
      String _newline = EcoreDocExtension.newline();
      _builder.append(_newline, " ");
      return _builder.toString();
    }
  }.apply();
  
  @Extension
  protected AnchorExtension _anchorExtension = new AnchorExtension();
  
  @Extension
  protected EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  @Extension
  protected InheritedEClassMemberSegmentsCollector _inheritedEClassMemberSegmentsCollector = new InheritedEClassMemberSegmentsCollector();
  
  @Extension
  protected EOperationEStructuralFeatureInteractionExtension _eOperationEStructuralFeatureInteractionExtension = new EOperationEStructuralFeatureInteractionExtension();
  
  protected final EClassGeneratorPart eClassGeneratorPart;
  
  public AEClassMemberGeneratorFragment(final EClassGeneratorPart eClassGeneratorPart) {
    this.eClassGeneratorPart = eClassGeneratorPart;
  }
  
  protected StringBuilder getOutput() {
    return this.eClassGeneratorPart.getOutput();
  }
  
  protected CharSequence concatLinkTo(final ENamedElement eNamedElement) {
    return this.eClassGeneratorPart.concatLinkTo(eNamedElement);
  }
  
  protected CharSequence concatLinkTo(final ENamedElement eNamedElement, final String prefix) {
    return this.eClassGeneratorPart.concatLinkTo(eNamedElement, prefix);
  }
  
  protected Set<EClass> collectAllSubTypes(final EClass parent) {
    return this.eClassGeneratorPart.collectAllSubTypes(parent);
  }
  
  protected String joinInheritance(final Iterable<?> objects) {
    String _newline = EcoreDocExtension.newline();
    String _newline_1 = EcoreDocExtension.newline();
    String _newline_2 = EcoreDocExtension.newline();
    String _plus = (_newline_1 + _newline_2);
    final Function1<Object, CharSequence> _function = (Object it) -> {
      return it.toString();
    };
    return IterableExtensions.join(objects, _newline, _plus, "", _function);
  }
}
