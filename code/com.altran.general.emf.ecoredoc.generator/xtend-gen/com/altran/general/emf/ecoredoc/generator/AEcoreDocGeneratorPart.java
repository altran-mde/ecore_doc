package com.altran.general.emf.ecoredoc.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
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
  
  protected CharSequence writeAnchor(final ENamedElement eNamedElement) {
    return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.writeType(eNamedElement))), "-");
  }
  
  protected CharSequence writeReferenceName(final ENamedElement eNamedElement) {
    return IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.writeType(eNamedElement))), ".");
  }
  
  protected CharSequence writeEClassType(final EClass eClass) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeAnchor = this.writeAnchor(eClass);
    _builder.append(_writeAnchor);
    _builder.append(", ");
    CharSequence _writeReferenceName = this.writeReferenceName(eClass);
    _builder.append(_writeReferenceName);
    return _builder;
  }
  
  protected CharSequence writeEStructuralFeatureAnchor(final EStructuralFeature eAttribute) {
    CharSequence _xblockexpression = null;
    {
      CharSequence result = null;
      EClassifier _eType = eAttribute.getEType();
      String _plus = ("eAttributeType.name " + _eType);
      String _plus_1 = (_plus + " ");
      String _name = eAttribute.getName();
      String _plus_2 = (_plus_1 + _name);
      InputOutput.<String>println(_plus_2);
      String _name_1 = eAttribute.getEType().getName();
      boolean _matched = false;
      String _name_2 = EcorePackage.eINSTANCE.getEInt().getName();
      if (Objects.equal(_name_1, _name_2)) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("EInt");
        result = _builder;
      }
      if (!_matched) {
        String _name_3 = EcorePackage.eINSTANCE.getEString().getName();
        if (Objects.equal(_name_1, _name_3)) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("EString");
          result = _builder_1;
        }
      }
      if (!_matched) {
        String _name_4 = EcorePackage.eINSTANCE.getEDouble().getName();
        if (Objects.equal(_name_1, _name_4)) {
          _matched=true;
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("EDouble");
          result = _builder_2;
        }
      }
      if (!_matched) {
        String _name_5 = EcorePackage.eINSTANCE.getEChar().getName();
        if (Objects.equal(_name_1, _name_5)) {
          _matched=true;
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("EChar");
          result = _builder_3;
        }
      }
      if (!_matched) {
        String _name_6 = EcorePackage.eINSTANCE.getEFloat().getName();
        if (Objects.equal(_name_1, _name_6)) {
          _matched=true;
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("EFloat");
          result = _builder_4;
        }
      }
      if (!_matched) {
        String _name_7 = EcorePackage.eINSTANCE.getELong().getName();
        if (Objects.equal(_name_1, _name_7)) {
          _matched=true;
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("ELong");
          result = _builder_5;
        }
      }
      if (!_matched) {
        String _name_8 = EcorePackage.eINSTANCE.getEShort().getName();
        if (Objects.equal(_name_1, _name_8)) {
          _matched=true;
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("EShort");
          result = _builder_6;
        }
      }
      if (!_matched) {
        String _name_9 = EcorePackage.eINSTANCE.getEBoolean().getName();
        if (Objects.equal(_name_1, _name_9)) {
          _matched=true;
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("EBoolean");
          result = _builder_7;
        }
      }
      if (!_matched) {
        String _name_10 = EcorePackage.eINSTANCE.getEByte().getName();
        if (Objects.equal(_name_1, _name_10)) {
          _matched=true;
          StringConcatenation _builder_8 = new StringConcatenation();
          _builder_8.append("EByte");
          result = _builder_8;
        }
      }
      if (!_matched) {
        String _name_11 = EcorePackage.eINSTANCE.getEDate().getName();
        if (Objects.equal(_name_1, _name_11)) {
          _matched=true;
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append("EDate");
          result = _builder_9;
        }
      }
      if (!_matched) {
        StringConcatenation _builder_10 = new StringConcatenation();
        _builder_10.append("<<");
        CharSequence _writeAnchor = this.writeAnchor(eAttribute.getEType());
        _builder_10.append(_writeAnchor);
        _builder_10.append(", ");
        CharSequence _writeReferenceName = this.writeReferenceName(eAttribute.getEType());
        _builder_10.append(_writeReferenceName);
        _builder_10.append(">>");
        result = _builder_10;
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected CharSequence writeEReferenceType(final EReference eReference) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeAnchor = this.writeAnchor(eReference);
    _builder.append(_writeAnchor);
    _builder.append(", ");
    CharSequence _writeReferenceName = this.writeReferenceName(eReference.eClass());
    _builder.append(_writeReferenceName);
    return _builder;
  }
  
  protected CharSequence writeWhereUsed(final EStructuralFeature eStructuralFeature, final EClass eClassThatInherits) {
    StringConcatenation _builder = new StringConcatenation();
    String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.writeEStructuralFeatureType(eStructuralFeature, eClassThatInherits))), "-");
    _builder.append(_join);
    _builder.append(", ");
    String _join_1 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.writeEStructuralFeatureType(eStructuralFeature, eClassThatInherits))), ".");
    _builder.append(_join_1);
    return _builder;
  }
  
  protected String[] writeEStructuralFeatureType(final EStructuralFeature eStructuralFeature, final EClass eClassThatInherits) {
    String[] _xblockexpression = null;
    {
      final String ePackageName = this.getEPackage(eClassThatInherits).getName();
      final String eClassName = eClassThatInherits.getName();
      final String eStructuralFeatureName = eStructuralFeature.getName();
      _xblockexpression = new String[] { ePackageName, eClassName, eStructuralFeatureName };
    }
    return _xblockexpression;
  }
  
  protected String[] _writeType(final EClass eClass) {
    String[] _xblockexpression = null;
    {
      final String eClassName = eClass.getName();
      final String ePackageName = this.getEPackage(eClass).getName();
      _xblockexpression = new String[] { ePackageName, eClassName };
    }
    return _xblockexpression;
  }
  
  protected String[] _writeType(final EStructuralFeature eStructuralFeature) {
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
  
  protected String[] _writeType(final EEnumLiteral eEnumLiteral) {
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
  
  protected String writeDataTypes(final EDataType eDataType) {
    String _xblockexpression = null;
    {
      EObject _eContainer = eDataType.eContainer();
      final String ePackageName = ((EPackage) _eContainer).getName();
      final String eDataTypeName = eDataType.getName();
      _xblockexpression = IterableExtensions.join(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(ePackageName, eDataTypeName)), "-");
    }
    return _xblockexpression;
  }
  
  protected String[] _writeType(final EDataType eDataType) {
    String[] _xblockexpression = null;
    {
      String[] result = null;
      boolean _matched = false;
      EDataType _eInt = EcorePackage.eINSTANCE.getEInt();
      if (Objects.equal(eDataType, _eInt)) {
        _matched=true;
        result = new String[] { "EInt" };
      }
      if (!_matched) {
        EDataType _eString = EcorePackage.eINSTANCE.getEString();
        if (Objects.equal(eDataType, _eString)) {
          _matched=true;
          result = new String[] { "EString" };
        }
      }
      if (!_matched) {
        EDataType _eDouble = EcorePackage.eINSTANCE.getEDouble();
        if (Objects.equal(eDataType, _eDouble)) {
          _matched=true;
          result = new String[] { "EDouble" };
        }
      }
      if (!_matched) {
        EDataType _eChar = EcorePackage.eINSTANCE.getEChar();
        if (Objects.equal(eDataType, _eChar)) {
          _matched=true;
          result = new String[] { "EChar" };
        }
      }
      if (!_matched) {
        EDataType _eFloat = EcorePackage.eINSTANCE.getEFloat();
        if (Objects.equal(eDataType, _eFloat)) {
          _matched=true;
          result = new String[] { "EFloat" };
        }
      }
      if (!_matched) {
        EDataType _eLong = EcorePackage.eINSTANCE.getELong();
        if (Objects.equal(eDataType, _eLong)) {
          _matched=true;
          result = new String[] { "ELong" };
        }
      }
      if (!_matched) {
        EDataType _eShort = EcorePackage.eINSTANCE.getEShort();
        if (Objects.equal(eDataType, _eShort)) {
          _matched=true;
          result = new String[] { "EShort" };
        }
      }
      if (!_matched) {
        EDataType _eBoolean = EcorePackage.eINSTANCE.getEBoolean();
        if (Objects.equal(eDataType, _eBoolean)) {
          _matched=true;
          result = new String[] { "EBoolean" };
        }
      }
      if (!_matched) {
        EDataType _eByte = EcorePackage.eINSTANCE.getEByte();
        if (Objects.equal(eDataType, _eByte)) {
          _matched=true;
          result = new String[] { "EByte" };
        }
      }
      if (!_matched) {
        EDataType _eDate = EcorePackage.eINSTANCE.getEDate();
        if (Objects.equal(eDataType, _eDate)) {
          _matched=true;
          result = new String[] { "EDate" };
        }
      }
      if (!_matched) {
        EObject _eContainer = eDataType.eContainer();
        String _name = ((EPackage) _eContainer).getName();
        String _name_1 = eDataType.getName();
        result = new String[] { _name, _name_1 };
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected void writeUseCases(final EClassifier target) {
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
          _builder.append("* <<");
          CharSequence _writeWhereUsed = this.writeWhereUsed(feature, eClass);
          _builder.append(_writeWhereUsed);
          _builder.append(">>");
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
  
  protected CharSequence writeTableFooter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|===");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence getDocumentation(final EModelElement modelElement) {
    StringConcatenation _builder = new StringConcatenation();
    String _documentation = EcoreUtil.getDocumentation(modelElement);
    _builder.append(_documentation);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected String newline() {
    return System.getProperty("line.separator");
  }
  
  protected Collection<EClass> collectAllEClasses() {
    return IterableExtensions.<EClass>toSet(Iterables.<EClass>filter(this.ePackages.values(), EClass.class));
  }
  
  protected String[] writeType(final ENamedElement eClass) {
    if (eClass instanceof EClass) {
      return _writeType((EClass)eClass);
    } else if (eClass instanceof EDataType) {
      return _writeType((EDataType)eClass);
    } else if (eClass instanceof EStructuralFeature) {
      return _writeType((EStructuralFeature)eClass);
    } else if (eClass instanceof EEnumLiteral) {
      return _writeType((EEnumLiteral)eClass);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eClass).toString());
    }
  }
}
