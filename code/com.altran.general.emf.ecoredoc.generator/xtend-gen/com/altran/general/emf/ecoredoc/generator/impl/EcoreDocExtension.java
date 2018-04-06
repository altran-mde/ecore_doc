package com.altran.general.emf.ecoredoc.generator.impl;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EcoreDocExtension {
  public final static String ANCHOR_SEPARATOR = "-";
  
  public final static String REFERENCE_SEPARATOR = ".{zwsp}";
  
  public final static String ECLASSIFIER_PROPERTY_SEPARATOR = EcoreDocExtension.newline();
  
  public static String newline() {
    return System.getProperty("line.separator");
  }
  
  public CharSequence getDocumentation(final EModelElement modelElement) {
    final CharSequence documentation = EcoreUtil.getDocumentation(modelElement);
    if ((documentation != null)) {
      String _newline = EcoreDocExtension.newline();
      return (documentation + _newline);
    } else {
      return "";
    }
  }
  
  public EPackage getEPackage(final EClassifier eClassifier) {
    EObject _eContainer = eClassifier.eContainer();
    return ((EPackage) _eContainer);
  }
  
  public CharSequence joinAnchor(final Collection<? extends CharSequence> segments) {
    final Function1<CharSequence, String> _function = (CharSequence it) -> {
      return it.toString();
    };
    final Function1<String, Boolean> _function_1 = (String it) -> {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
      return Boolean.valueOf((!_isNullOrEmpty));
    };
    final Function1<String, String> _function_2 = (String it) -> {
      return it.replaceAll("[^a-zA-Z0-9_-]", ":");
    };
    return IterableExtensions.join(IterableExtensions.<String, String>map(IterableExtensions.<String>filter(IterableExtensions.map(segments, _function), _function_1), _function_2), EcoreDocExtension.ANCHOR_SEPARATOR);
  }
  
  public CharSequence joinReference(final Collection<? extends CharSequence> segments) {
    final Function1<CharSequence, String> _function = (CharSequence it) -> {
      return it.toString();
    };
    final Function1<String, Boolean> _function_1 = (String it) -> {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
      return Boolean.valueOf((!_isNullOrEmpty));
    };
    return IterableExtensions.join(IterableExtensions.<String>filter(IterableExtensions.map(segments, _function), _function_1), EcoreDocExtension.REFERENCE_SEPARATOR);
  }
  
  protected CharSequence _concatAnchor(final ENamedElement eNamedElement) {
    return this.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(this.collectTypeSegments(eNamedElement))));
  }
  
  protected CharSequence _concatAnchor(final EDataType eDataType) {
    CharSequence _xifexpression = null;
    boolean _isDefaultEDataType = this.isDefaultEDataType(eDataType);
    boolean _not = (!_isDefaultEDataType);
    if (_not) {
      _xifexpression = this.joinAnchor(((Collection<? extends CharSequence>)Conversions.doWrapArray(this.collectTypeSegments(eDataType))));
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  protected String[] _collectTypeSegments(final Void voidType) {
    String _assuredName = this.getAssuredName(null);
    return new String[] { _assuredName };
  }
  
  protected String[] _collectTypeSegments(final EPackage ePackage) {
    String _assuredName = this.getAssuredName(ePackage);
    return new String[] { _assuredName };
  }
  
  protected String[] _collectTypeSegments(final EClass eClass) {
    Iterable<String> _xblockexpression = null;
    {
      final String eClassName = this.getAssuredName(eClass);
      String[] __collectTypeSegments = this._collectTypeSegments(this.getEPackage(eClass));
      _xblockexpression = Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(__collectTypeSegments)), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(eClassName)));
    }
    return ((String[])Conversions.unwrapArray(_xblockexpression, String.class));
  }
  
  protected String[] _collectTypeSegments(final EStructuralFeature eStructuralFeature) {
    Iterable<String> _xblockexpression = null;
    {
      EObject _eContainer = eStructuralFeature.eContainer();
      final EClass eClass = ((EClass) _eContainer);
      final String eStructuralFeatureName = this.getAssuredName(eStructuralFeature);
      String[] _collectTypeSegments = this.collectTypeSegments(eClass);
      _xblockexpression = Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(_collectTypeSegments)), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(eStructuralFeatureName)));
    }
    return ((String[])Conversions.unwrapArray(_xblockexpression, String.class));
  }
  
  protected String[] _collectTypeSegments(final EEnumLiteral eEnumLiteral) {
    Iterable<String> _xblockexpression = null;
    {
      EObject _eContainer = eEnumLiteral.eContainer();
      final EEnum eEnum = ((EEnum) _eContainer);
      String[] _collectTypeSegments = this.collectTypeSegments(eEnum);
      String _assuredName = this.getAssuredName(eEnumLiteral);
      _xblockexpression = Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(_collectTypeSegments)), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_assuredName)));
    }
    return ((String[])Conversions.unwrapArray(_xblockexpression, String.class));
  }
  
  protected String[] _collectTypeSegments(final EDataType eDataType) {
    String[] _xblockexpression = null;
    {
      final String eDataTypeName = this.getAssuredName(eDataType);
      final boolean defaultEDataType = this.isDefaultEDataType(eDataType);
      String[] _xifexpression = null;
      if (defaultEDataType) {
        _xifexpression = new String[] { eDataTypeName };
      } else {
        String[] __collectTypeSegments = this._collectTypeSegments(this.getEPackage(eDataType));
        _xifexpression = ((String[])Conversions.unwrapArray(Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(__collectTypeSegments)), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(eDataTypeName))), String.class));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String getAssuredName(final ENamedElement eNamedElement) {
    String _xifexpression = null;
    if ((eNamedElement == null)) {
      _xifexpression = "";
    } else {
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(eNamedElement.getName());
      if (_isNullOrEmpty) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("[");
        String _fragment = EcoreUtil.getURI(eNamedElement).fragment();
        _builder.append(_fragment);
        _builder.append("]");
        _xifexpression_1 = _builder.toString();
      } else {
        _xifexpression_1 = eNamedElement.getName();
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public boolean isDefaultEDataType(final EDataType eDataType) {
    String _nsURI = EcorePackage.eINSTANCE.getNsURI();
    String _nsURI_1 = this.getEPackage(eDataType).getNsURI();
    return Objects.equal(_nsURI, _nsURI_1);
  }
  
  public CharSequence concatAnchor(final ENamedElement eDataType) {
    if (eDataType instanceof EDataType) {
      return _concatAnchor((EDataType)eDataType);
    } else if (eDataType != null) {
      return _concatAnchor(eDataType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eDataType).toString());
    }
  }
  
  public String[] collectTypeSegments(final ENamedElement eClass) {
    if (eClass instanceof EClass) {
      return _collectTypeSegments((EClass)eClass);
    } else if (eClass instanceof EDataType) {
      return _collectTypeSegments((EDataType)eClass);
    } else if (eClass instanceof EStructuralFeature) {
      return _collectTypeSegments((EStructuralFeature)eClass);
    } else if (eClass instanceof EEnumLiteral) {
      return _collectTypeSegments((EEnumLiteral)eClass);
    } else if (eClass instanceof EPackage) {
      return _collectTypeSegments((EPackage)eClass);
    } else if (eClass == null) {
      return _collectTypeSegments((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eClass).toString());
    }
  }
}