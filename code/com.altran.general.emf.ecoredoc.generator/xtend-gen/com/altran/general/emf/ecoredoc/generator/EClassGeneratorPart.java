package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EClassGeneratorPart extends AEcoreDocGeneratorPart {
  public EClassGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    super(ePackages);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    final List<EClass> eClasses = this.collectEPackageEClasses(ePackage);
    this.writeEClasses(eClasses);
    return this.getOutput();
  }
  
  protected List<EClass> collectEPackageEClasses(final EPackage ePackages) {
    final Function1<EClass, String> _function = (EClass it) -> {
      return it.getName();
    };
    return IterableExtensions.<EClass, String>sortBy(Iterables.<EClass>filter(this.getEPackages().get(ePackages), EClass.class), _function);
  }
  
  protected void writeEClasses(final List<EClass> eClasses) {
    boolean _isEmpty = eClasses.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEClassesHeader();
      for (final EClass eClass : eClasses) {
        this.writeEClass(eClass);
      }
    }
  }
  
  protected StringBuilder writeEClassesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Types");
    _builder.newLine();
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeEClass(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      this.writeEClassHeader(eClass);
      this.writeSuperTypes(eClass);
      this.writeEAttributes(eClass);
      _xblockexpression = this.writeEReferences(eClass);
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeSuperTypes(final EClass eClass) {
    StringBuilder _xifexpression = null;
    boolean _isEmpty = eClass.getEAllSuperTypes().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      _builder.append(".Supertypes");
      _builder.newLine();
      {
        final Function1<EClass, String> _function = (EClass it) -> {
          return it.getName();
        };
        List<EClass> _sortBy = IterableExtensions.<EClass, String>sortBy(eClass.getEAllSuperTypes(), _function);
        for(final EClass supertype : _sortBy) {
          _builder.append("* ");
          CharSequence _concatLinkTo = this.concatLinkTo(supertype);
          _builder.append(_concatLinkTo);
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _xifexpression = _output.append(_builder);
    } else {
      _xifexpression = this.getOutput().append(this.newline());
    }
    return _xifexpression;
  }
  
  protected StringBuilder writeEAttributesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".Attributes");
    _builder.newLine();
    CharSequence _tableHeader = this.tableHeader();
    _builder.append(_tableHeader);
    _builder.newLineIfNotEmpty();
    _builder.append("|===");
    _builder.newLine();
    _builder.append("|Name");
    _builder.newLine();
    _builder.append("|Type");
    _builder.newLine();
    _builder.append("|Multiplicity{nbsp}/ Order");
    _builder.newLine();
    _builder.append("|Default Value");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected CharSequence tableHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[cols=\"<15m,<15,<15m,<15m,<40a\",options=\"header\"]");
    return _builder;
  }
  
  protected StringBuilder writeEAttributes(final EClass eClass) {
    StringBuilder _xifexpression = null;
    boolean _isEmpty = eClass.getEAllAttributes().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringBuilder _xblockexpression = null;
      {
        this.writeEAttributesHeader();
        final List<EAttribute> inheritedEAttributes = new ArrayList<EAttribute>();
        EList<EClass> _eAllSuperTypes = eClass.getEAllSuperTypes();
        for (final EClass superclass : _eAllSuperTypes) {
          if ((superclass instanceof EClass)) {
            final Function1<EAttribute, String> _function = (EAttribute it) -> {
              return it.getName();
            };
            List<EAttribute> _sortBy = IterableExtensions.<EAttribute, String>sortBy(superclass.getEAllAttributes(), _function);
            for (final EAttribute eAttribute : _sortBy) {
              inheritedEAttributes.add(eAttribute);
            }
          }
        }
        final Function1<EAttribute, String> _function_1 = (EAttribute it) -> {
          return it.getName();
        };
        List<EAttribute> _sortBy_1 = IterableExtensions.<EAttribute, String>sortBy(eClass.getEAllAttributes(), _function_1);
        for (final EAttribute eAttribute_1 : _sortBy_1) {
          boolean _contains = inheritedEAttributes.contains(eAttribute_1);
          boolean _not_1 = (!_contains);
          if (_not_1) {
            this.writeEAttributeRow(eAttribute_1, eClass);
          }
        }
        final Function1<EAttribute, String> _function_2 = (EAttribute it) -> {
          return it.getName();
        };
        List<EAttribute> _sortBy_2 = IterableExtensions.<EAttribute, String>sortBy(inheritedEAttributes, _function_2);
        for (final EAttribute eAttribute_2 : _sortBy_2) {
          this.writeEAttributeRow(eAttribute_2, eClass);
        }
        StringBuilder _output = this.getOutput();
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _tableFooter = this.tableFooter();
        _builder.append(_tableFooter);
        _xblockexpression = _output.append(_builder);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected StringBuilder writeEAttributeRow(final EAttribute eAttribute, final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      String _name = eAttribute.getName();
      String _plus = (_name + " ");
      String _name_1 = eClass.getName();
      String _plus_1 = (_plus + _name_1);
      String _plus_2 = (_plus_1 + " ");
      EObject _eContainer = eAttribute.eContainer();
      String _name_2 = ((EClass) _eContainer).getName();
      String _plus_3 = (_plus_2 + _name_2);
      InputOutput.<String>println(_plus_3);
      EObject _eContainer_1 = eAttribute.eContainer();
      boolean _equals = Objects.equal(eClass, ((EClass) _eContainer_1));
      final boolean inherited = (!_equals);
      final int lowerBound = eAttribute.getLowerBound();
      final int upperBound = eAttribute.getUpperBound();
      final String eAttributeName = eAttribute.getName();
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|");
      _builder.append(eAttributeName);
      _builder.append("[[");
      String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectInheritedFeatureSegments(eAttribute, eClass))), "-");
      _builder.append(_join);
      _builder.append("]]");
      {
        if (inherited) {
          _builder.append(" +");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        if (inherited) {
          CharSequence _concatInheritedEStructuralElementType = this.concatInheritedEStructuralElementType(eAttribute);
          _builder.append(_concatInheritedEStructuralElementType);
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _concatLinkTo = this.concatLinkTo(eAttribute.getEType());
      _builder.append(_concatLinkTo);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _concatBounds = this.concatBounds(lowerBound, upperBound);
      _builder.append(_concatBounds);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      _builder.newLine();
      _builder.append("|");
      CharSequence _documentation = this.getDocumentation(eAttribute);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatInheritedEStructuralElementType(final ENamedElement eNamedElement) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(<<");
    CharSequence _concatAnchor = this.concatAnchor(eNamedElement);
    _builder.append(_concatAnchor);
    _builder.append(", {inherited}");
    EObject _eContainer = eNamedElement.eContainer();
    CharSequence _concatReferenceName = this.concatReferenceName(((EClass) _eContainer));
    _builder.append(_concatReferenceName);
    _builder.append(">>)");
    return _builder;
  }
  
  protected CharSequence concatBounds(final int lowerBound, final int upperBound) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(lowerBound);
    {
      if ((lowerBound != upperBound)) {
        _builder.append("..");
        _builder.append(upperBound);
      }
    }
    return _builder;
  }
  
  protected StringBuilder writeEReferences(final EClass eClass) {
    StringBuilder _xifexpression = null;
    int _size = eClass.getEReferences().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      StringBuilder _xblockexpression = null;
      {
        this.writeEReferencesHeader();
        final List<EReference> inheritedEReferences = new ArrayList<EReference>();
        EList<EClass> _eAllSuperTypes = eClass.getEAllSuperTypes();
        for (final EClass superclass : _eAllSuperTypes) {
          if ((superclass instanceof EClass)) {
            final Function1<EReference, String> _function = (EReference it) -> {
              return it.getName();
            };
            List<EReference> _sortBy = IterableExtensions.<EReference, String>sortBy(superclass.getEReferences(), _function);
            for (final EReference eReference : _sortBy) {
              inheritedEReferences.add(eReference);
            }
          }
        }
        final Function1<EReference, String> _function_1 = (EReference it) -> {
          return it.getName();
        };
        List<EReference> _sortBy_1 = IterableExtensions.<EReference, String>sortBy(eClass.getEReferences(), _function_1);
        for (final EReference eReference_1 : _sortBy_1) {
          boolean _contains = inheritedEReferences.contains(eReference_1);
          boolean _not = (!_contains);
          if (_not) {
            this.writeEReferenceRow(eReference_1, eClass);
          }
        }
        final Function1<EReference, String> _function_2 = (EReference it) -> {
          return it.getName();
        };
        List<EReference> _sortBy_2 = IterableExtensions.<EReference, String>sortBy(inheritedEReferences, _function_2);
        for (final EReference eReference_2 : _sortBy_2) {
          this.writeEReferenceRow(eReference_2, eClass);
        }
        StringBuilder _output = this.getOutput();
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _tableFooter = this.tableFooter();
        _builder.append(_tableFooter);
        _xblockexpression = _output.append(_builder);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected StringBuilder writeEReferenceRow(final EReference eReference, final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      EObject _eContainer = eReference.eContainer();
      boolean _equals = Objects.equal(eClass, ((EClass) _eContainer));
      final boolean inherited = (!_equals);
      final int lowerBound = eReference.getLowerBound();
      final int upperBound = eReference.getUpperBound();
      final String eReferenceName = eReference.getName();
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|");
      _builder.append(eReferenceName);
      _builder.append("[[");
      String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(this.collectInheritedFeatureSegments(eReference, eClass))), "-");
      _builder.append(_join);
      _builder.append("]]");
      {
        if (inherited) {
          _builder.append(" +");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        if (inherited) {
          CharSequence _concatInheritedEStructuralElementType = this.concatInheritedEStructuralElementType(eReference);
          _builder.append(_concatInheritedEStructuralElementType);
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _concatLinkTo = this.concatLinkTo(eReference.getEType());
      _builder.append(_concatLinkTo);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _concatBounds = this.concatBounds(lowerBound, upperBound);
      _builder.append(_concatBounds);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      {
        EReference _eOpposite = eReference.getEOpposite();
        boolean _tripleNotEquals = (_eOpposite != null);
        if (_tripleNotEquals) {
          CharSequence _concatOpposite = this.concatOpposite(eReference);
          _builder.append(_concatOpposite);
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _documentation = this.getDocumentation(eReference);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  protected CharSequence concatOpposite(final EReference eReference) {
    CharSequence _xblockexpression = null;
    {
      final String eOppositeName = eReference.getEOpposite().getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<<");
      CharSequence _concatAnchor = this.concatAnchor(eReference.getEReferenceType());
      _builder.append(_concatAnchor);
      _builder.append("-");
      _builder.append(eOppositeName);
      _builder.append(", ");
      _builder.append(eOppositeName);
      _builder.append(">>");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  protected StringBuilder writeEReferencesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".References");
    _builder.newLine();
    _builder.append("[cols=\"<15m,<15,<15m,<15m,<40a\",options=\"header\"]");
    _builder.newLine();
    _builder.append("|===");
    _builder.newLine();
    _builder.append("|Name");
    _builder.newLine();
    _builder.append("|Type");
    _builder.newLine();
    _builder.append("|Multiplicity{nbsp}/ Order");
    _builder.newLine();
    _builder.append("|Opposite");
    _builder.newLine();
    _builder.append("|Description");
    _builder.newLine();
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected CharSequence writeEClassHeader(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      final String eClassName = eClass.getName();
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[[");
      CharSequence _concatAnchor = this.concatAnchor(eClass);
      _builder.append(_concatAnchor);
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
      CharSequence _documentation = this.getDocumentation(eClass);
      _builder.append(_documentation);
      _builder.newLineIfNotEmpty();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
}
