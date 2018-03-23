package com.altran.general.emf.ecoredoc.generator;

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
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class AEcoreDocGeneratorPart {
  private final Multimap<EPackage, EClassifier> ePackages;
  
  private final StringBuilder output = new StringBuilder();
  
  public AEcoreDocGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    this.ePackages = ePackages;
  }
  
  public abstract StringBuilder write(final EPackage ePackage);
  
  protected Multimap<EPackage, EClassifier> getEPackages() {
    return this.ePackages;
  }
  
  protected StringBuilder getOutput() {
    return this.output;
  }
  
  protected EPackage getEPackage(final EClassifier eClassifier) {
    EObject _eContainer = eClassifier.eContainer();
    return ((EPackage) _eContainer);
  }
  
  protected CharSequence _concatAnchor(final ENamedElement eNamedElement) {
    return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectTypeSegments(eNamedElement))), "-");
  }
  
  protected CharSequence _concatAnchor(final EDataType eDataType) {
    String _xifexpression = null;
    boolean _isDefaultEDataType = this.isDefaultEDataType(eDataType);
    boolean _not = (!_isDefaultEDataType);
    if (_not) {
      _xifexpression = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectTypeSegments(eDataType))), "-");
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  protected CharSequence concatReferenceName(final ENamedElement eNamedElement) {
    return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectTypeSegments(eNamedElement))), ".");
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
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<<");
    String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectInheritedFeatureSegments(eStructuralFeature, eClassThatInherits))), "-");
    _builder.append(_join);
    _builder.append(", ");
    String _join_1 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectInheritedFeatureSegments(eStructuralFeature, eClassThatInherits))), ".");
    _builder.append(_join_1);
    _builder.append(">>");
    return _builder;
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
    String[] _xifexpression = null;
    boolean _isDefaultEDataType = this.isDefaultEDataType(eDataType);
    boolean _not = (!_isDefaultEDataType);
    if (_not) {
      EObject _eContainer = eDataType.eContainer();
      String _name = ((EPackage) _eContainer).getName();
      String _name_1 = eDataType.getName();
      _xifexpression = new String[] { _name, _name_1 };
    } else {
      String _name_2 = eDataType.getName();
      _xifexpression = new String[] { _name_2 };
    }
    return _xifexpression;
  }
  
  protected void concatUseCases(final EClassifier target) {
    boolean anyMatch = false;
    final Function1<EClass, Boolean> _function = (EClass it) -> {
      return Boolean.valueOf(Objects.equal(it, target));
    };
    final Iterable<EClass> eClasses = IterableExtensions.<EClass>reject(this.collectAllEClasses(), _function);
    final ArrayList<String> useCaseStrings = CollectionLiterals.<String>newArrayList();
    for (final EClass eClass : eClasses) {
      final Function1<EStructuralFeature, String> _function_1 = (EStructuralFeature it) -> {
        return it.getName();
      };
      List<EStructuralFeature> _sortBy = IterableExtensions.<EStructuralFeature, String>sortBy(eClass.getEAllStructuralFeatures(), _function_1);
      for (final EStructuralFeature feature : _sortBy) {
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
      _builder_1.append(".Used at");
      _builder_1.newLine();
      this.output.append(_builder_1);
      List<String> _sort = IterableExtensions.<String>sort(useCaseStrings);
      for (final String useCaseString : _sort) {
        this.output.append(useCaseString);
      }
      this.output.append(this.newline());
    }
  }
  
  protected CharSequence tableFooter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|===");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence getDocumentation(final EModelElement modelElement) {
    return EcoreUtil.getDocumentation(modelElement);
  }
  
  protected boolean isDefaultEDataType(final EDataType eDataType) {
    String _nsURI = EcorePackage.eINSTANCE.getNsURI();
    String _nsURI_1 = this.getEPackage(eDataType).getNsURI();
    return Objects.equal(_nsURI, _nsURI_1);
  }
  
  protected String newline() {
    return System.getProperty("line.separator");
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
