package com.altran.general.emf.ecoredoc.generator.impl.extension;

import com.altran.general.emf.ecoredoc.generator.impl.extension.EcoreDocExtension;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.Collections;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TypeSegmentsCollector {
  @Extension
  private EcoreDocExtension _ecoreDocExtension = new EcoreDocExtension();
  
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
      String[] __collectTypeSegments = this._collectTypeSegments(this._ecoreDocExtension.getEPackage(eClass));
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
      final boolean defaultEDataType = this._ecoreDocExtension.isDefaultEDataType(eDataType);
      String[] _xifexpression = null;
      if (defaultEDataType) {
        _xifexpression = new String[] { eDataTypeName };
      } else {
        String[] __collectTypeSegments = this._collectTypeSegments(this._ecoreDocExtension.getEPackage(eDataType));
        _xifexpression = ((String[])Conversions.unwrapArray(Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(__collectTypeSegments)), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(eDataTypeName))), String.class));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected String[] _collectTypeSegments(final EOperation eOperation) {
    EObject _eContainer = eOperation.eContainer();
    String[] _collectTypeSegments = this.collectTypeSegments(((EClass) _eContainer));
    String _assuredName = this.getAssuredName(eOperation);
    return ((String[])Conversions.unwrapArray(Iterables.<String>concat(((Iterable<? extends String>)Conversions.doWrapArray(_collectTypeSegments)), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_assuredName))), String.class));
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
  
  public String[] collectTypeSegments(final ENamedElement eClass) {
    if (eClass instanceof EClass) {
      return _collectTypeSegments((EClass)eClass);
    } else if (eClass instanceof EDataType) {
      return _collectTypeSegments((EDataType)eClass);
    } else if (eClass instanceof EOperation) {
      return _collectTypeSegments((EOperation)eClass);
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
