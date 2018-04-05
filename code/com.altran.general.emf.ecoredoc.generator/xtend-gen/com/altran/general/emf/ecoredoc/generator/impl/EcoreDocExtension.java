package com.altran.general.emf.ecoredoc.generator.impl;

import com.google.common.base.Objects;
import java.util.Arrays;
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
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

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
  
  protected CharSequence _concatAnchor(final ENamedElement eNamedElement) {
    return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectTypeSegments(eNamedElement))), EcoreDocExtension.ANCHOR_SEPARATOR);
  }
  
  protected CharSequence _concatAnchor(final EDataType eDataType) {
    String _xifexpression = null;
    boolean _isDefaultEDataType = this.isDefaultEDataType(eDataType);
    boolean _not = (!_isDefaultEDataType);
    if (_not) {
      _xifexpression = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectTypeSegments(eDataType))), EcoreDocExtension.ANCHOR_SEPARATOR);
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
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
      final boolean defaultEDataType = this.isDefaultEDataType(eDataType);
      String[] _xifexpression = null;
      if (defaultEDataType) {
        _xifexpression = new String[] { eDataTypeName };
      } else {
        String[] _xblockexpression_1 = null;
        {
          final String eDataTypePackageName = this.getEPackage(eDataType).getName();
          _xblockexpression_1 = new String[] { eDataTypePackageName, eDataTypeName };
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
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
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eClass).toString());
    }
  }
}
