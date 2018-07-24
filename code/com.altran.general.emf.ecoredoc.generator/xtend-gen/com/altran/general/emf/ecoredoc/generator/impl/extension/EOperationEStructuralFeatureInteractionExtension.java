package com.altran.general.emf.ecoredoc.generator.impl.extension;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class EOperationEStructuralFeatureInteractionExtension {
  public boolean overridesFeature(final EOperation eOperation, final EStructuralFeature eStructuralFeature) {
    boolean getter = true;
    String _xifexpression = null;
    if ((((eOperation.getEParameters().size() == 1) && (eOperation.getEParameters().get(0).getUpperBound() == 1)) && (eOperation.getEType() == null))) {
      String _xblockexpression = null;
      {
        getter = false;
        _xblockexpression = StringExtensions.toFirstLower(eOperation.getName().replaceFirst("^set", ""));
      }
      _xifexpression = _xblockexpression;
    } else {
      String _xifexpression_1 = null;
      if (((eOperation.getEParameters().size() == 0) && (eOperation.getEType() != null))) {
        String _xblockexpression_1 = null;
        {
          getter = true;
          _xblockexpression_1 = StringExtensions.toFirstLower(eOperation.getName().replaceFirst("^get", ""));
        }
        _xifexpression_1 = _xblockexpression_1;
      } else {
        return false;
      }
      _xifexpression = _xifexpression_1;
    }
    final String simpleName = _xifexpression;
    String _name = eStructuralFeature.getName();
    boolean _notEquals = (!Objects.equal(_name, simpleName));
    if (_notEquals) {
      return false;
    }
    ETypedElement _xifexpression_2 = null;
    if (getter) {
      _xifexpression_2 = eOperation;
    } else {
      _xifexpression_2 = IterableExtensions.<EParameter>head(eOperation.getEParameters());
    }
    final ETypedElement compare = _xifexpression_2;
    boolean _isMany = eStructuralFeature.isMany();
    boolean _isMany_1 = compare.isMany();
    boolean _notEquals_1 = (_isMany != _isMany_1);
    if (_notEquals_1) {
      return false;
    }
    EClassifier _eType = eStructuralFeature.getEType();
    Class<?> _instanceClass = null;
    if (_eType!=null) {
      _instanceClass=_eType.getInstanceClass();
    }
    final Class<?> featureInstanceClass = _instanceClass;
    EClassifier _eType_1 = compare.getEType();
    Class<?> _instanceClass_1 = null;
    if (_eType_1!=null) {
      _instanceClass_1=_eType_1.getInstanceClass();
    }
    final Class<?> opInstanceClass = _instanceClass_1;
    if (((featureInstanceClass != null) && (opInstanceClass != null))) {
      return featureInstanceClass.isAssignableFrom(opInstanceClass);
    }
    if (((eStructuralFeature.getEType() instanceof EClass) && (compare.getEType() instanceof EClass))) {
      EClassifier _eType_2 = eStructuralFeature.getEType();
      EClassifier _eType_3 = compare.getEType();
      return EcoreUtil2.isAssignableFrom(((EClass) _eType_2), ((EClass) _eType_3));
    }
    return false;
  }
  
  public boolean implementsOperation(final EStructuralFeature eStructuralFeature, final EOperation eOperation) {
    String _firstUpper = StringExtensions.toFirstUpper(eStructuralFeature.getName());
    final String getterName = ("get" + _firstUpper);
    String _xifexpression = null;
    boolean _isMany = eStructuralFeature.isMany();
    if (_isMany) {
      _xifexpression = null;
    } else {
      String _firstUpper_1 = StringExtensions.toFirstUpper(eStructuralFeature.getName());
      _xifexpression = ("set" + _firstUpper_1);
    }
    final String setterName = _xifexpression;
    ETypedElement _xifexpression_1 = null;
    String _name = eOperation.getName();
    boolean _equals = Objects.equal(_name, getterName);
    if (_equals) {
      EOperation _xblockexpression = null;
      {
        boolean _isEmpty = eOperation.getEParameters().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          return false;
        }
        _xblockexpression = eOperation;
      }
      _xifexpression_1 = _xblockexpression;
    } else {
      EParameter _xifexpression_2 = null;
      String _name_1 = eOperation.getName();
      boolean _equals_1 = Objects.equal(_name_1, setterName);
      if (_equals_1) {
        EParameter _xblockexpression_1 = null;
        {
          EClassifier _eType = eOperation.getEType();
          boolean _tripleNotEquals = (_eType != null);
          if (_tripleNotEquals) {
            return false;
          }
          int _size = eOperation.getEParameters().size();
          boolean _notEquals = (_size != 1);
          if (_notEquals) {
            return false;
          }
          _xblockexpression_1 = IterableExtensions.<EParameter>head(eOperation.getEParameters());
        }
        _xifexpression_2 = _xblockexpression_1;
      } else {
        return false;
      }
      _xifexpression_1 = _xifexpression_2;
    }
    final ETypedElement compare = _xifexpression_1;
    boolean _isMany_1 = eStructuralFeature.isMany();
    boolean _isMany_2 = compare.isMany();
    boolean _notEquals = (_isMany_1 != _isMany_2);
    if (_notEquals) {
      return false;
    }
    EClassifier _eType = eStructuralFeature.getEType();
    Class<?> _instanceClass = null;
    if (_eType!=null) {
      _instanceClass=_eType.getInstanceClass();
    }
    final Class<?> featureInstanceClass = _instanceClass;
    EClassifier _eType_1 = compare.getEType();
    Class<?> _instanceClass_1 = null;
    if (_eType_1!=null) {
      _instanceClass_1=_eType_1.getInstanceClass();
    }
    final Class<?> opInstanceClass = _instanceClass_1;
    if (((featureInstanceClass != null) && (opInstanceClass != null))) {
      return opInstanceClass.isAssignableFrom(featureInstanceClass);
    }
    if (((eStructuralFeature.getEType() instanceof EClass) && (compare.getEType() instanceof EClass))) {
      EClassifier _eType_2 = compare.getEType();
      EClassifier _eType_3 = eStructuralFeature.getEType();
      return EcoreUtil2.isAssignableFrom(((EClass) _eType_2), ((EClass) _eType_3));
    }
    return false;
  }
}
