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
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
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
  
  protected final static String ANCHOR_SEPARATOR = "-";
  
  protected final static String REFERENCE_SEPARATOR = ".";
  
  private final Multimap<EPackage, EClassifier> ePackages;
  
  private StringBuilder output;
  
  public AEcoreDocGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    this.ePackages = ePackages;
  }
  
  public abstract StringBuilder write(final EPackage ePackage);
  
  protected StringBuilder clearOutput() {
    StringBuilder _stringBuilder = new StringBuilder();
    return this.output = _stringBuilder;
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
  
  protected EPackage getEPackage(final EClassifier eClassifier) {
    EObject _eContainer = eClassifier.eContainer();
    return ((EPackage) _eContainer);
  }
  
  protected CharSequence _concatAnchor(final ENamedElement eNamedElement) {
    return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectTypeSegments(eNamedElement))), AEcoreDocGeneratorPart.ANCHOR_SEPARATOR);
  }
  
  protected CharSequence _concatAnchor(final EDataType eDataType) {
    String _xifexpression = null;
    boolean _isDefaultEDataType = this.isDefaultEDataType(eDataType);
    boolean _not = (!_isDefaultEDataType);
    if (_not) {
      _xifexpression = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectTypeSegments(eDataType))), AEcoreDocGeneratorPart.ANCHOR_SEPARATOR);
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  protected CharSequence concatReferenceName(final ENamedElement eNamedElement) {
    return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectTypeSegments(eNamedElement))), AEcoreDocGeneratorPart.REFERENCE_SEPARATOR);
  }
  
  protected CharSequence _concatLinkTo(final ENamedElement eNamedElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<<");
    CharSequence _concatAnchor = this.concatAnchor(eNamedElement);
    _builder.append(_concatAnchor);
    _builder.append(", ");
    CharSequence _concatReferenceName = this.concatReferenceName(eNamedElement);
    _builder.append(_concatReferenceName);
    _builder.append(">>");
    return _builder;
  }
  
  protected CharSequence _concatLinkTo(final EDataType eDataType) {
    CharSequence _xifexpression = null;
    boolean _isDefaultEDataType = this.isDefaultEDataType(eDataType);
    boolean _not = (!_isDefaultEDataType);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<<");
      CharSequence _concatAnchor = this.concatAnchor(eDataType);
      _builder.append(_concatAnchor);
      _builder.append(", ");
      CharSequence _concatReferenceName = this.concatReferenceName(eDataType);
      _builder.append(_concatReferenceName);
      _builder.append(">>");
      _xifexpression = _builder;
    } else {
      _xifexpression = eDataType.getName();
    }
    return _xifexpression;
  }
  
  protected CharSequence concatUsedLink(final EStructuralFeature eStructuralFeature, final EClass eClassThatInherits) {
    CharSequence _xblockexpression = null;
    {
      final String[] inheritedFeatureSegments = this.collectInheritedFeatureSegments(eStructuralFeature, eClassThatInherits);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<<");
      String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(inheritedFeatureSegments)), AEcoreDocGeneratorPart.ANCHOR_SEPARATOR);
      _builder.append(_join);
      _builder.append(", ");
      String _join_1 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(inheritedFeatureSegments)), AEcoreDocGeneratorPart.REFERENCE_SEPARATOR);
      _builder.append(_join_1);
      _builder.append(">>");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected String[] collectInheritedFeatureSegments(final EStructuralFeature eStructuralFeature, final EClass eClassThatInherits) {
    String[] _xblockexpression = null;
    {
      final String ePackageName = this.getEPackage(eClassThatInherits).getName();
      final String eClassName = eClassThatInherits.getName();
      final String eStructuralFeatureName = eStructuralFeature.getName();
      _xblockexpression = new String[] { ePackageName, eClassName, eStructuralFeatureName };
    }
    return _xblockexpression;
  }
  
  protected String[] _collectTypeSegments(final EClass eClass) {
    String[] _xblockexpression = null;
    {
      final String eClassName = eClass.getName();
      final String ePackageName = this.getEPackage(eClass).getName();
      _xblockexpression = new String[] { ePackageName, eClassName };
    }
    return _xblockexpression;
  }
  
  protected String[] _collectTypeSegments(final EStructuralFeature eStructuralFeature) {
    String[] _xblockexpression = null;
    {
      EObject _eContainer = eStructuralFeature.eContainer();
      final EClass eClass = ((EClass) _eContainer);
      final String ePackageName = this.getEPackage(eClass).getName();
      final String eClassName = eClass.getName();
      final String eStructuralFeatureName = eStructuralFeature.getName();
      _xblockexpression = new String[] { ePackageName, eClassName, eStructuralFeatureName };
    }
    return _xblockexpression;
  }
  
  protected String[] _collectTypeSegments(final EEnumLiteral eEnumLiteral) {
    String[] _xblockexpression = null;
    {
      EObject _eContainer = eEnumLiteral.eContainer();
      final EEnum eEnum = ((EEnum) _eContainer);
      final String ePackageName = this.getEPackage(eEnum).getName();
      String _name = eEnum.getName();
      String _name_1 = eEnumLiteral.getName();
      _xblockexpression = new String[] { ePackageName, _name, _name_1 };
    }
    return _xblockexpression;
  }
  
  protected String[] _collectTypeSegments(final EDataType eDataType) {
    String[] _xblockexpression = null;
    {
      final String eDataTypeName = eDataType.getName();
      String[] _xifexpression = null;
      boolean _isDefaultEDataType = this.isDefaultEDataType(eDataType);
      boolean _not = (!_isDefaultEDataType);
      if (_not) {
        String[] _xblockexpression_1 = null;
        {
          final String eDataTypePackageName = this.getEPackage(eDataType).getName();
          _xblockexpression_1 = new String[] { eDataTypePackageName, eDataTypeName };
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = new String[] { eDataTypeName };
      }
      _xblockexpression = _xifexpression;
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
    List<EClass> _sortBy = IterableExtensions.<EClass, String>sortBy(eClasses, _function);
    for (final EClass eClass : _sortBy) {
      final Function1<EStructuralFeature, String> _function_1 = (EStructuralFeature it) -> {
        return it.getName();
      };
      List<EStructuralFeature> _sortBy_1 = IterableExtensions.<EStructuralFeature, String>sortBy(eClass.getEAllStructuralFeatures(), _function_1);
      for (final EStructuralFeature feature : _sortBy_1) {
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
    if (anyMatch) {
      StringConcatenation _builder_1 = new StringConcatenation();
      String _newline = this._ecoreDocExtension.newline();
      _builder_1.append(_newline);
      _builder_1.newLineIfNotEmpty();
      _builder_1.append(".Used at");
      _builder_1.newLine();
      this.output.append(_builder_1);
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
  
  protected boolean isDefaultEDataType(final EDataType eDataType) {
    String _nsURI = EcorePackage.eINSTANCE.getNsURI();
    String _nsURI_1 = this.getEPackage(eDataType).getNsURI();
    return Objects.equal(_nsURI, _nsURI_1);
  }
  
  protected Collection<EClass> collectAllEClasses() {
    return IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(this.ePackages.values(), EClass.class));
  }
  
  protected CharSequence concatAnchor(final ENamedElement eDataType) {
    if (eDataType instanceof EDataType) {
      return _concatAnchor((EDataType)eDataType);
    } else if (eDataType != null) {
      return _concatAnchor(eDataType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eDataType).toString());
    }
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
  
  protected String[] collectTypeSegments(final ENamedElement eClass) {
    if (eClass instanceof EClass) {
      return _collectTypeSegments((EClass)eClass);
    } else if (eClass instanceof EDataType) {
      return _collectTypeSegments((EDataType)eClass);
    } else if (eClass instanceof EStructuralFeature) {
      return _collectTypeSegments((EStructuralFeature)eClass);
    } else if (eClass instanceof EEnumLiteral) {
      return _collectTypeSegments((EEnumLiteral)eClass);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eClass).toString());
    }
  }
}
