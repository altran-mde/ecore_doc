package com.altran.general.emf.ecoredoc.generator.impl.extension;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EcoreDocExtension {
  public final static String ECLASSIFIER_PROPERTY_SEPARATOR = EcoreDocExtension.newline();
  
  public final static Function1<EClassifier, String> eClassifierSorter = ((Function1<EClassifier, String>) (EClassifier it) -> {
    String _elvis = null;
    String _name = it.getEPackage().getName();
    String _name_1 = it.getName();
    String _plus = (_name + _name_1);
    if (_plus != null) {
      _elvis = _plus;
    } else {
      _elvis = "";
    }
    return _elvis;
  });
  
  public final static Function1<EStructuralFeature, String> eStructuralFeatureSorter = ((Function1<EStructuralFeature, String>) (EStructuralFeature it) -> {
    String _elvis = null;
    String _name = it.getName();
    if (_name != null) {
      _elvis = _name;
    } else {
      _elvis = "";
    }
    return _elvis;
  });
  
  public final static Function1<EOperation, String> eOperationSorter = ((Function1<EOperation, String>) (EOperation it) -> {
    String _elvis = null;
    String _name = it.getName();
    if (_name != null) {
      _elvis = _name;
    } else {
      _elvis = "";
    }
    return _elvis;
  });
  
  public static String newline() {
    return System.getProperty("line.separator");
  }
  
  public CharSequence getDocumentation(final EModelElement modelElement) {
    CharSequence _xblockexpression = null;
    {
      final String documentation = EcoreUtil.getDocumentation(modelElement);
      CharSequence _xifexpression = null;
      if ((documentation != null)) {
        CharSequence _xblockexpression_1 = null;
        {
          final String stripped = documentation.replaceAll("(<[^>]+>)(<[^>]+>)", " ").replaceAll("<[^>]+>", "");
          CharSequence _xifexpression_1 = null;
          boolean _equals = Objects.equal(stripped, documentation);
          if (_equals) {
            String _newline = EcoreDocExtension.newline();
            _xifexpression_1 = (documentation + _newline);
          } else {
            StringConcatenation _builder = new StringConcatenation();
            String _newline_1 = EcoreDocExtension.newline();
            _builder.append(_newline_1);
            _builder.newLineIfNotEmpty();
            _builder.append("ifdef::backend-html5[]");
            _builder.newLine();
            _builder.append("++++");
            _builder.newLine();
            _builder.append(documentation);
            _builder.newLineIfNotEmpty();
            _builder.append("++++");
            _builder.newLine();
            _builder.append("endif::[]");
            _builder.newLine();
            _builder.append("ifndef::backend-html5[]");
            _builder.newLine();
            _builder.append(stripped);
            _builder.newLineIfNotEmpty();
            _builder.append("endif::[]");
            _builder.newLine();
            _xifexpression_1 = _builder;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = "";
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public CharSequence tableHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[cols=\"<20,<20,<20,<40a\",options=\"header\"]");
    return _builder;
  }
  
  public CharSequence tableFooter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|===");
    _builder.newLine();
    return _builder;
  }
  
  public EPackage getEPackage(final EClassifier eClassifier) {
    EObject _eContainer = eClassifier.eContainer();
    return ((EPackage) _eContainer);
  }
  
  public boolean isDefaultEDataType(final EDataType eDataType) {
    String _nsURI = EcorePackage.eINSTANCE.getNsURI();
    EPackage _ePackage = this.getEPackage(eDataType);
    String _nsURI_1 = null;
    if (_ePackage!=null) {
      _nsURI_1=_ePackage.getNsURI();
    }
    return Objects.equal(_nsURI, _nsURI_1);
  }
  
  public List<EDataType> collectEDataTypes(final Collection<EClassifier> classifiers) {
    final Function1<EDataType, Boolean> _function = (EDataType it) -> {
      return Boolean.valueOf((!(it instanceof EEnum)));
    };
    return IterableExtensions.<EDataType, String>sortBy(IterableExtensions.<EDataType>filter(Iterables.<EDataType>filter(classifiers, EDataType.class), _function), EcoreDocExtension.eClassifierSorter);
  }
  
  public List<EEnum> collectEEnums(final Collection<EClassifier> classifiers) {
    return IterableExtensions.<EEnum, String>sortBy(Iterables.<EEnum>filter(classifiers, EEnum.class), EcoreDocExtension.eClassifierSorter);
  }
  
  public List<EClass> collectEClasses(final Collection<EClassifier> classifiers) {
    return IterableExtensions.<EClass, String>sortBy(Iterables.<EClass>filter(classifiers, EClass.class), EcoreDocExtension.eClassifierSorter);
  }
}
