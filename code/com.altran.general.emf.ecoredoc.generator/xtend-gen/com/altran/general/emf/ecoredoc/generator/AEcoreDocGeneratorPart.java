package com.altran.general.emf.ecoredoc.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EAttribute;
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
  
  /**
   * Writes in which classes the given EClassifier is used.
   * Goes through every class and then every attribute and it compare the dataType.name with the attribute type name.
   */
  protected CharSequence writeAnchor(final ENamedElement eNamedElement) {
    return this.writeType(eNamedElement, Character.valueOf('-'));
  }
  
  protected CharSequence writeReferenceName(final ENamedElement eNamedElement) {
    return this.writeType(eNamedElement, Character.valueOf('.'));
  }
  
  protected CharSequence _writeType(final EClass eClass, final Character S) {
    CharSequence _xblockexpression = null;
    {
      final String eClassName = eClass.getName();
      final String ePackageName = this.getEPackage(eClass).getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(ePackageName);
      _builder.append(S);
      _builder.append(eClassName);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _writeType(final EReference eReference, final Character S) {
    CharSequence _xblockexpression = null;
    {
      final EClass eClass = eReference.getEReferenceType();
      final String ePackageName = this.getEPackage(eClass).getName();
      final String eClassName = eClass.getName();
      final String eReferenceName = eReference.getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(ePackageName);
      _builder.append(S);
      _builder.append(eClassName);
      _builder.append(S);
      _builder.append(eReferenceName);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _writeType(final EAttribute eAttribute, final Character S) {
    CharSequence _xblockexpression = null;
    {
      final EDataType eClass = eAttribute.getEAttributeType();
      final String ePackageName = this.getEPackage(eClass).getName();
      final String eClassName = eClass.getName();
      final String eAttributeName = eAttribute.getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(ePackageName);
      _builder.append(S);
      _builder.append(eClassName);
      _builder.append(S);
      _builder.append(eAttributeName);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence _writeType(final EDataType eDataType, final Character S) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    EDataType _eInt = EcorePackage.eINSTANCE.getEInt();
    if (Objects.equal(eDataType, _eInt)) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("EInt");
      _switchResult = _builder;
    }
    if (!_matched) {
      EDataType _eString = EcorePackage.eINSTANCE.getEString();
      if (Objects.equal(eDataType, _eString)) {
        _matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("EString");
        _switchResult = _builder_1;
      }
    }
    if (!_matched) {
      EDataType _eDouble = EcorePackage.eINSTANCE.getEDouble();
      if (Objects.equal(eDataType, _eDouble)) {
        _matched=true;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("EDouble");
        _switchResult = _builder_2;
      }
    }
    if (!_matched) {
      EDataType _eChar = EcorePackage.eINSTANCE.getEChar();
      if (Objects.equal(eDataType, _eChar)) {
        _matched=true;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("EChar");
        _switchResult = _builder_3;
      }
    }
    if (!_matched) {
      EDataType _eFloat = EcorePackage.eINSTANCE.getEFloat();
      if (Objects.equal(eDataType, _eFloat)) {
        _matched=true;
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("EFloat");
        _switchResult = _builder_4;
      }
    }
    if (!_matched) {
      EDataType _eLong = EcorePackage.eINSTANCE.getELong();
      if (Objects.equal(eDataType, _eLong)) {
        _matched=true;
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("ELong");
        _switchResult = _builder_5;
      }
    }
    if (!_matched) {
      EDataType _eShort = EcorePackage.eINSTANCE.getEShort();
      if (Objects.equal(eDataType, _eShort)) {
        _matched=true;
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("EShort");
        _switchResult = _builder_6;
      }
    }
    if (!_matched) {
      EDataType _eBoolean = EcorePackage.eINSTANCE.getEBoolean();
      if (Objects.equal(eDataType, _eBoolean)) {
        _matched=true;
        StringConcatenation _builder_7 = new StringConcatenation();
        _builder_7.append("EBoolean");
        _switchResult = _builder_7;
      }
    }
    if (!_matched) {
      EDataType _eByte = EcorePackage.eINSTANCE.getEByte();
      if (Objects.equal(eDataType, _eByte)) {
        _matched=true;
        StringConcatenation _builder_8 = new StringConcatenation();
        _builder_8.append("EByte");
        _switchResult = _builder_8;
      }
    }
    if (!_matched) {
      EDataType _eDate = EcorePackage.eINSTANCE.getEDate();
      if (Objects.equal(eDataType, _eDate)) {
        _matched=true;
        StringConcatenation _builder_9 = new StringConcatenation();
        _builder_9.append("EDate");
        _switchResult = _builder_9;
      }
    }
    if (!_matched) {
      StringConcatenation _builder_10 = new StringConcatenation();
      String _name = this.getEPackage(eDataType).getName();
      _builder_10.append(_name);
      _builder_10.append(S);
      EObject _eContainer = eDataType.eContainer();
      String _name_1 = ((ENamedElement) _eContainer).getName();
      _builder_10.append(_name_1);
      _builder_10.append(S);
      String _name_2 = eDataType.getName();
      _builder_10.append(_name_2);
      _switchResult = _builder_10;
    }
    return _switchResult;
  }
  
  protected CharSequence _writeType(final EEnumLiteral eEnumLiteral, final Character S) {
    CharSequence _xblockexpression = null;
    {
      EObject _eContainer = eEnumLiteral.eContainer();
      final EEnum eEnum = ((EEnum) _eContainer);
      final String ePackageName = this.getEPackage(eEnum).getName();
      final String eClassName = eEnum.eClass().getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(ePackageName);
      _builder.append(S);
      String _name = eEnum.getName();
      _builder.append(_name);
      _builder.append(S);
      String _name_1 = eEnumLiteral.getName();
      _builder.append(_name_1);
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected CharSequence writeAnchorAndReference(final ENamedElement eNamedElement) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeAnchor = this.writeAnchor(eNamedElement);
    _builder.append(_writeAnchor);
    _builder.append(", ");
    CharSequence _writeReferenceName = this.writeReferenceName(eNamedElement);
    _builder.append(_writeReferenceName);
    return _builder;
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
          CharSequence _writeAnchorAndReference = this.writeAnchorAndReference(feature);
          _builder.append(_writeAnchorAndReference);
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
  
  protected CharSequence _writeEClassifierHeader(final EDataType eDataType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[[");
    CharSequence _writeAnchor = this.writeAnchor(eDataType);
    _builder.append(_writeAnchor);
    _builder.append("]]");
    _builder.newLineIfNotEmpty();
    _builder.append("==== ");
    String _name = eDataType.getName();
    _builder.append(_name);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _writeEClassifierHeader(final EClass eClass) {
    CharSequence _xblockexpression = null;
    {
      final String eClassName = eClass.getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[[");
      CharSequence _writeAnchor = this.writeAnchor(eClass);
      _builder.append(_writeAnchor);
      _builder.append("]]");
      _builder.newLineIfNotEmpty();
      _builder.append("==== ");
      {
        if ((eClass.isAbstract() && (!eClass.isInterface()))) {
          _builder.append("Abstract ");
        }
      }
      {
        boolean _isInterface = eClass.isInterface();
        if (_isInterface) {
          _builder.append("Interface");
        } else {
          _builder.append("Class");
        }
      }
      _builder.append(" ");
      _builder.append(eClassName);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence writeFooter() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("|===");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getDocumentation(final EModelElement modelElement) {
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
  
  protected CharSequence writeType(final ENamedElement eAttribute, final Character S) {
    if (eAttribute instanceof EAttribute) {
      return _writeType((EAttribute)eAttribute, S);
    } else if (eAttribute instanceof EReference) {
      return _writeType((EReference)eAttribute, S);
    } else if (eAttribute instanceof EClass) {
      return _writeType((EClass)eAttribute, S);
    } else if (eAttribute instanceof EDataType) {
      return _writeType((EDataType)eAttribute, S);
    } else if (eAttribute instanceof EEnumLiteral) {
      return _writeType((EEnumLiteral)eAttribute, S);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eAttribute, S).toString());
    }
  }
  
  public CharSequence writeEClassifierHeader(final EClassifier eClass) {
    if (eClass instanceof EClass) {
      return _writeEClassifierHeader((EClass)eClass);
    } else if (eClass instanceof EDataType) {
      return _writeEClassifierHeader((EDataType)eClass);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(eClass).toString());
    }
  }
}
