package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
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
      int _size = eClasses.size();
      String _plus = ("eClasses.size " + Integer.valueOf(_size));
      InputOutput.<String>println(_plus);
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
  
  public StringBuilder writeEClass(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      CharSequence _writeEClassifierHeader = this.writeEClassifierHeader(eClass);
      _builder.append(_writeEClassifierHeader);
      _output.append(_builder);
      StringBuilder _output_1 = this.getOutput();
      StringConcatenation _builder_1 = new StringConcatenation();
      CharSequence _documentation = this.getDocumentation(eClass);
      _builder_1.append(_documentation);
      _output_1.append(_builder_1);
      this.writeSuperTypes(eClass);
      this.writeEAttributes(eClass);
      _xblockexpression = this.writeReferences(eClass);
    }
    return _xblockexpression;
  }
  
  public StringBuilder writeSuperTypes(final EClass eClass) {
    StringBuilder _xifexpression = null;
    int _size = eClass.getEAllSuperTypes().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
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
          String superTypeEPackageName = this.getEPackage(supertype).getName();
          _builder.newLineIfNotEmpty();
          _builder.append("* <<");
          CharSequence _writeAnchorAndReference = this.writeAnchorAndReference(superTypeEPackageName, supertype.getName());
          _builder.append(_writeAnchorAndReference);
          _builder.append(">>");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _xifexpression = _output.append(_builder);
    } else {
      StringBuilder _output_1 = this.getOutput();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\t\t\t\t");
      _builder_1.newLine();
      _xifexpression = _output_1.append(_builder_1);
    }
    return _xifexpression;
  }
  
  protected StringBuilder writeEAttributesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(".Attributes");
    _builder.newLine();
    CharSequence _writeTableHeader = this.writeTableHeader();
    _builder.append(_writeTableHeader);
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
  
  protected CharSequence writeTableHeader() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[cols=\"<15m,<15,<15m,<15m,<40a\",options=\"header\"]");
    return _builder;
  }
  
  public StringBuilder writeEAttributes(final EClass eClass) {
    StringBuilder _xifexpression = null;
    int _size = eClass.getEAllAttributes().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      StringBuilder _xblockexpression = null;
      {
        this.writeEAttributesHeader();
        final String eClassName = eClass.getName();
        final String ePackageName = this.getEPackage(eClass).getName();
        Map<EAttribute, EClass> inheritedEAttributes = new HashMap<EAttribute, EClass>();
        EList<EClass> _eAllSuperTypes = eClass.getEAllSuperTypes();
        for (final EClass superclass : _eAllSuperTypes) {
          if ((superclass instanceof EClass)) {
            final Function1<EAttribute, String> _function = (EAttribute it) -> {
              return it.getName();
            };
            List<EAttribute> _sortBy = IterableExtensions.<EAttribute, String>sortBy(superclass.getEAllAttributes(), _function);
            for (final EAttribute eAttribute : _sortBy) {
              inheritedEAttributes.put(eAttribute, superclass);
            }
          }
        }
        int _size_1 = inheritedEAttributes.keySet().size();
        String _plus = ("inheritedEAttributes.keySet.size " + Integer.valueOf(_size_1));
        InputOutput.<String>println(_plus);
        final Function1<EAttribute, String> _function_1 = (EAttribute it) -> {
          return it.getName();
        };
        List<EAttribute> _sortBy_1 = IterableExtensions.<EAttribute, String>sortBy(eClass.getEAllAttributes(), _function_1);
        for (final EAttribute eAttribute_1 : _sortBy_1) {
          boolean _contains = inheritedEAttributes.keySet().contains(eAttribute_1);
          boolean _not = (!_contains);
          if (_not) {
            final String eAttributeTypeName = eAttribute_1.getEAttributeType().getName();
            final int lowerBound = eAttribute_1.getLowerBound();
            final int upperBound = eAttribute_1.getUpperBound();
            final String eAttributeName = eAttribute_1.getName();
            StringBuilder _output = this.getOutput();
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("|");
            _builder.append(eAttributeName);
            _builder.append("[[");
            CharSequence _writeAnchor = this.writeAnchor(ePackageName, eClassName, eAttributeName);
            _builder.append(_writeAnchor);
            _builder.append("]]");
            _builder.newLineIfNotEmpty();
            _builder.append("|<<");
            CharSequence _writeAnchorAndReference = this.writeAnchorAndReference(ePackageName, eAttributeTypeName);
            _builder.append(_writeAnchorAndReference);
            _builder.append(">>");
            _builder.newLineIfNotEmpty();
            _builder.append("|");
            CharSequence _writeBounds = this.writeBounds(lowerBound, upperBound);
            _builder.append(_writeBounds);
            _builder.newLineIfNotEmpty();
            _builder.append("|");
            _builder.newLine();
            _builder.append("|");
            CharSequence _documentation = this.getDocumentation(eAttribute_1);
            _builder.append(_documentation);
            _builder.newLineIfNotEmpty();
            _builder.newLine();
            _output.append(_builder);
          }
        }
        final Function1<EAttribute, String> _function_2 = (EAttribute it) -> {
          return it.getName();
        };
        List<EAttribute> _sortBy_2 = IterableExtensions.<EAttribute, String>sortBy(inheritedEAttributes.keySet(), _function_2);
        for (final EAttribute eAttribute_2 : _sortBy_2) {
          {
            final String packageNameOfInherited = this.getEPackage(inheritedEAttributes.get(eAttribute_2)).getName();
            final String superClassName = inheritedEAttributes.get(eAttribute_2).getName();
            final String eAttributeTypeName_1 = eAttribute_2.getEAttributeType().getName();
            final int lowerBound_1 = eAttribute_2.getLowerBound();
            final int upperBound_1 = eAttribute_2.getUpperBound();
            final String eAttributeName_1 = eAttribute_2.getName();
            StringBuilder _output_1 = this.getOutput();
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("|");
            _builder_1.append(eAttributeName_1);
            _builder_1.append("[[");
            CharSequence _writeAnchor_1 = this.writeAnchor(packageNameOfInherited, eClassName, eAttributeName_1);
            _builder_1.append(_writeAnchor_1);
            _builder_1.append("]] +");
            _builder_1.newLineIfNotEmpty();
            CharSequence _inheritedAnchorAndReference = this.inheritedAnchorAndReference(packageNameOfInherited, superClassName, eAttributeName_1);
            _builder_1.append(_inheritedAnchorAndReference);
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("|");
            _builder_1.append(eAttributeTypeName_1);
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("|");
            CharSequence _writeBounds_1 = this.writeBounds(lowerBound_1, upperBound_1);
            _builder_1.append(_writeBounds_1);
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("|");
            _builder_1.newLine();
            _builder_1.append("|");
            CharSequence _documentation_1 = this.getDocumentation(eAttribute_2);
            _builder_1.append(_documentation_1);
            _builder_1.newLineIfNotEmpty();
            _builder_1.newLine();
            _output_1.append(_builder_1);
          }
        }
        StringBuilder _output_1 = this.getOutput();
        StringConcatenation _builder_1 = new StringConcatenation();
        CharSequence _writeFooter = this.writeFooter();
        _builder_1.append(_writeFooter);
        _builder_1.newLineIfNotEmpty();
        _xblockexpression = _output_1.append(_builder_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public CharSequence inheritedAnchorAndReference(final String packageName, final String superClassName, final String eAttributeName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(<<");
    CharSequence _writeAnchor = this.writeAnchor(packageName, superClassName, eAttributeName);
    _builder.append(_writeAnchor);
    _builder.append(", {inherited}");
    CharSequence _writeReference = this.writeReference(packageName, superClassName);
    _builder.append(_writeReference);
    _builder.append(">>)");
    return _builder;
  }
  
  public CharSequence writeBounds(final int lowerBound, final int upperBound) {
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
  
  public StringBuilder writeReferences(final EClass eClass) {
    StringBuilder _xifexpression = null;
    int _size = eClass.getEReferences().size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      StringBuilder _xblockexpression = null;
      {
        this.writeEReferencesHeader();
        final String ePackageName = this.getEPackage(eClass).getName();
        final String eClassName = eClass.getName();
        Map<EReference, EClass> inheritedEReferences = new HashMap<EReference, EClass>();
        EList<EClass> _eAllSuperTypes = eClass.getEAllSuperTypes();
        for (final EClass superclass : _eAllSuperTypes) {
          if ((superclass instanceof EClass)) {
            final Function1<EReference, String> _function = (EReference it) -> {
              return it.getName();
            };
            List<EReference> _sortBy = IterableExtensions.<EReference, String>sortBy(superclass.getEReferences(), _function);
            for (final EReference eReference : _sortBy) {
              inheritedEReferences.put(eReference, superclass);
            }
          }
        }
        final Function1<EReference, String> _function_1 = (EReference it) -> {
          return it.getName();
        };
        List<EReference> _sortBy_1 = IterableExtensions.<EReference, String>sortBy(eClass.getEReferences(), _function_1);
        for (final EReference eReference_1 : _sortBy_1) {
          boolean _contains = inheritedEReferences.keySet().contains(eReference_1);
          boolean _not = (!_contains);
          if (_not) {
            this.writeReferenceTable(eReference_1, false, inheritedEReferences, ePackageName, eClassName);
          }
        }
        final Function1<EReference, String> _function_2 = (EReference it) -> {
          return it.getName();
        };
        List<EReference> _sortBy_2 = IterableExtensions.<EReference, String>sortBy(inheritedEReferences.keySet(), _function_2);
        for (final EReference eReference_2 : _sortBy_2) {
          this.writeReferenceTable(eReference_2, true, inheritedEReferences, ePackageName, eClassName);
        }
        StringBuilder _output = this.getOutput();
        StringConcatenation _builder = new StringConcatenation();
        CharSequence _writeFooter = this.writeFooter();
        _builder.append(_writeFooter);
        _builder.newLineIfNotEmpty();
        _xblockexpression = _output.append(_builder);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public StringBuilder writeReferenceTable(final EReference eReference, final boolean inherited, final Map<EReference, EClass> inheritedEReferences, final String ePackageName, final String eClassName) {
    StringBuilder _xblockexpression = null;
    {
      final String eReferenceTypeName = eReference.getEReferenceType().getName();
      String ePackageNameOfInherited = "";
      String superEClassName = "";
      if (inherited) {
        ePackageNameOfInherited = this.getEPackage(inheritedEReferences.get(eReference)).getName();
        superEClassName = inheritedEReferences.get(eReference).getName();
      }
      final int lowerBound = eReference.getLowerBound();
      final int upperBound = eReference.getUpperBound();
      final String eReferenceName = eReference.getName();
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("|");
      _builder.append(eReferenceName);
      _builder.append("[[");
      {
        if (inherited) {
          CharSequence _writeAnchor = this.writeAnchor(ePackageNameOfInherited, eClassName, eReferenceName);
          _builder.append(_writeAnchor);
          _builder.append("]] +");
        } else {
          CharSequence _writeAnchor_1 = this.writeAnchor(ePackageName, eClassName, eReferenceName);
          _builder.append(_writeAnchor_1);
          _builder.append("]]");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        if (inherited) {
          CharSequence _inheritedAnchorAndReference = this.inheritedAnchorAndReference(ePackageNameOfInherited, superEClassName, eReferenceName);
          _builder.append(_inheritedAnchorAndReference);
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("|<<");
      CharSequence _writeAnchorAndReference = this.writeAnchorAndReference(ePackageName, eReferenceTypeName);
      _builder.append(_writeAnchorAndReference);
      _builder.append(">>");
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      CharSequence _writeBounds = this.writeBounds(lowerBound, upperBound);
      _builder.append(_writeBounds);
      _builder.newLineIfNotEmpty();
      _builder.append("|");
      {
        EReference _eOpposite = eReference.getEOpposite();
        boolean _tripleNotEquals = (_eOpposite != null);
        if (_tripleNotEquals) {
          CharSequence _writeOpposite = this.writeOpposite(eReference, ePackageName, eReferenceTypeName, eReference.getEOpposite().getName());
          _builder.append(_writeOpposite);
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
  
  public CharSequence writeOpposite(final EReference eReference, final String ePackageName, final String eReferenceTypeName, final String oppositeName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<<");
    CharSequence _writeAnchor = this.writeAnchor(ePackageName, eReferenceTypeName, oppositeName);
    _builder.append(_writeAnchor);
    _builder.append(", ");
    _builder.append(oppositeName);
    _builder.append(">>");
    return _builder;
  }
  
  public StringBuilder writeEReferencesHeader() {
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
}
