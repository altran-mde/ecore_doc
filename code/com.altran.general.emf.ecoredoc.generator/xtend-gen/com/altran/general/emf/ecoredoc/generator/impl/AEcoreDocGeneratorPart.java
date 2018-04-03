package com.altran.general.emf.ecoredoc.generator.impl;

import com.altran.general.emf.ecoredoc.generator.impl.EcoreDocExtension;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class AEcoreDocGeneratorPart {
  @Extension
  protected EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
  private final Multimap<EPackage, EClassifier> ePackages;
  
  private StringBuilder output;
  
  public AEcoreDocGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    this.ePackages = ePackages;
  }
  
  protected abstract StringBuilder write(final EPackage ePackage);
  
  protected void clearOutput() {
    StringBuilder _stringBuilder = new StringBuilder();
    this.output = _stringBuilder;
  }
  
  protected Multimap<EPackage, EClassifier> getEPackages() {
    return this.ePackages;
  }
  
  protected StringBuilder getOutput() {
    StringBuilder _xblockexpression = null;
    {
      if ((this.output == null)) {
        throw new IllegalStateException("Tried to write to output before clearing it");
      }
      _xblockexpression = this.output;
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatReferenceName(final ENamedElement eNamedElement) {
    return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this._ecoreDocExtension.collectTypeSegments(eNamedElement))), EcoreDocExtension.REFERENCE_SEPARATOR);
  }
  
  protected CharSequence _concatLinkTo(final ENamedElement eNamedElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<<");
    CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eNamedElement);
    _builder.append(_concatAnchor);
    _builder.append(", ");
    CharSequence _concatReferenceName = this.concatReferenceName(eNamedElement);
    _builder.append(_concatReferenceName);
    _builder.append(">>");
    return _builder;
  }
  
  protected CharSequence _concatLinkTo(final EDataType eDataType) {
    CharSequence _xblockexpression = null;
    {
      final boolean defaultDataType = this._ecoreDocExtension.isDefaultEDataType(eDataType);
      CharSequence _xifexpression = null;
      if (defaultDataType) {
        _xifexpression = eDataType.getName();
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<<");
        CharSequence _concatAnchor = this._ecoreDocExtension.concatAnchor(eDataType);
        _builder.append(_concatAnchor);
        _builder.append(", ");
        CharSequence _concatReferenceName = this.concatReferenceName(eDataType);
        _builder.append(_concatReferenceName);
        _builder.append(">>");
        _xifexpression = _builder;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatUsedLink(final EStructuralFeature eStructuralFeature, final EClass eClassThatInherits) {
    CharSequence _xblockexpression = null;
    {
      final String[] inheritedFeatureSegments = this.collectInheritedFeatureSegments(eStructuralFeature, eClassThatInherits);
      StringConcatenation _builder = new StringConcatenation();
      String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(inheritedFeatureSegments)), EcoreDocExtension.ANCHOR_SEPARATOR);
      _builder.append(_join);
      final CharSequence anchor = _builder;
      StringConcatenation _builder_1 = new StringConcatenation();
      String _join_1 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(inheritedFeatureSegments)), EcoreDocExtension.REFERENCE_SEPARATOR);
      _builder_1.append(_join_1);
      final CharSequence reference = _builder_1;
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("<<");
      _builder_2.append(anchor);
      _builder_2.append(", ");
      _builder_2.append(reference);
      _builder_2.append(">>");
      _xblockexpression = _builder_2;
    }
    return _xblockexpression;
  }
  
  protected String[] collectInheritedFeatureSegments(final EStructuralFeature eStructuralFeature, final EClass eClassThatInherits) {
    String[] _xblockexpression = null;
    {
      final String ePackageName = this._ecoreDocExtension.getEPackage(eClassThatInherits).getName();
      final String eClassName = eClassThatInherits.getName();
      final String eStructuralFeatureName = eStructuralFeature.getName();
      _xblockexpression = new String[] { ePackageName, eClassName, eStructuralFeatureName };
    }
    return _xblockexpression;
  }
  
  protected void writeUseCases(final EClassifier target) {
    boolean anyMatch = false;
    final Collection<EClass> eClasses = this.collectAllEClasses();
    final ArrayList<String> useCaseStrings = CollectionLiterals.<String>newArrayList();
    final Function1<EClass, String> _function = (EClass it) -> {
      return it.getName();
    };
    final List<EClass> sortedEClasses = IterableExtensions.<EClass, String>sortBy(eClasses, _function);
    for (final EClass eClass : sortedEClasses) {
      {
        final Function1<EStructuralFeature, String> _function_1 = (EStructuralFeature it) -> {
          return it.getName();
        };
        final List<EStructuralFeature> sortedEStructuralFeatures = IterableExtensions.<EStructuralFeature, String>sortBy(eClass.getEAllStructuralFeatures(), _function_1);
        for (final EStructuralFeature feature : sortedEStructuralFeatures) {
          EClassifier _eType = feature.getEType();
          boolean _equals = Objects.equal(_eType, target);
          if (_equals) {
            anyMatch = true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("* ");
            CharSequence _concatUsedLink = this.concatUsedLink(feature, eClass);
            _builder.append(_concatUsedLink);
            _builder.newLineIfNotEmpty();
            useCaseStrings.add(_builder.toString());
          }
        }
      }
    }
    if (anyMatch) {
      StringConcatenation _builder = new StringConcatenation();
      String _newline = this._ecoreDocExtension.newline();
      _builder.append(_newline);
      _builder.newLineIfNotEmpty();
      _builder.append(".Used at");
      _builder.newLine();
      this.output.append(_builder);
      List<String> _sort = IterableExtensions.<String>sort(useCaseStrings);
      for (final String useCaseString : _sort) {
        this.output.append(useCaseString);
      }
    }
  }
  
  protected CharSequence tableFooter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|===");
    _builder.newLine();
    return _builder;
  }
  
  protected Collection<EClass> collectAllEClasses() {
    return IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(this.ePackages.values(), EClass.class));
  }
  
  protected CharSequence concatLinkTo(final ENamedElement eDataType) {
    if (eDataType instanceof EDataType) {
      return _concatLinkTo((EDataType)eDataType);
    } else if (eDataType != null) {
      return _concatLinkTo(eDataType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eDataType).toString());
    }
  }
}
