package com.altran.general.emf.ecoredoc.generator;

import com.altran.general.emf.ecoredoc.generator.AEcoreDocGeneratorPart;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.Collection;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EClassGeneratorPart extends AEcoreDocGeneratorPart {
  public EClassGeneratorPart(final Multimap<EPackage, EClassifier> ePackages) {
    super(ePackages);
  }
  
  @Override
  public StringBuilder write(final EPackage ePackage) {
    final List<EClass> eClasses = this.collectPackageEClasses(ePackage);
    this.writeEClasses(eClasses);
    return this.getOutput();
  }
  
  protected List<EClass> collectPackageEClasses(final EPackage ePackages) {
    final Function1<EClass, String> _function = (EClass it) -> {
      return it.getName();
    };
    return IterableExtensions.<EClass, String>sortBy(Iterables.<EClass>filter(this.getEPackages().get(ePackages), EClass.class), _function);
  }
  
  protected void writeEClasses(final Collection<EClass> eClasses) {
    boolean _isEmpty = eClasses.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.writeEClassesHeader();
      for (final EClass eClass : eClasses) {
        {
          this.writeEClassHeader(eClass);
          this.writeEClass(eClass);
        }
      }
    }
  }
  
  protected StringBuilder writeEClassesHeader() {
    StringBuilder _output = this.getOutput();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("=== Classes");
    _builder.newLine();
    _builder.newLine();
    return _output.append(_builder);
  }
  
  protected StringBuilder writeEClassHeader(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      final EPackage ePackage = this.getEPackage(eClass);
      StringBuilder _output = this.getOutput();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[[");
      String _name = ePackage.getName();
      _builder.append(_name);
      _builder.append("-");
      String _name_1 = eClass.getName();
      _builder.append(_name_1);
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
      String _name_2 = eClass.getName();
      _builder.append(_name_2);
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _xblockexpression = _output.append(_builder);
    }
    return _xblockexpression;
  }
  
  public StringBuilder writeEClass(final EClass eclass) {
    StringBuilder _xblockexpression = null;
    {
      this.getDocumentation(eclass);
      this.writeSuperTypes(eclass);
      this.writeEAttributes(eclass);
      _xblockexpression = this.writeReferences(eclass);
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
          _builder.append("* <<");
          String _name = this.getEPackage(supertype).getName();
          _builder.append(_name);
          _builder.append("-");
          String _name_1 = supertype.getName();
          _builder.append(_name_1);
          _builder.append(", ");
          String _name_2 = this.getEPackage(supertype).getName();
          _builder.append(_name_2);
          _builder.append(".");
          String _name_3 = supertype.getName();
          _builder.append(_name_3);
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
    _builder.append("\t");
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
        final Function1<EAttribute, String> _function_1 = (EAttribute it) -> {
          return it.getName();
        };
        List<EAttribute> _sortBy_1 = IterableExtensions.<EAttribute, String>sortBy(inheritedEAttributes.keySet(), _function_1);
        for (final EAttribute eAttribute_1 : _sortBy_1) {
          {
            final String packageNameOfInherited = this.getEPackage(inheritedEAttributes.get(eAttribute_1)).getName();
            final EClass superclass_1 = inheritedEAttributes.get(eAttribute_1);
            final String eAttributeTypeName = eAttribute_1.getEAttributeType().getName();
            final int lowerBound = eAttribute_1.getLowerBound();
            final int upperBound = eAttribute_1.getUpperBound();
            StringBuilder _output = this.getOutput();
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("|");
            String _name = eAttribute_1.getName();
            _builder.append(_name);
            _builder.append("[[");
            _builder.append(packageNameOfInherited);
            _builder.append("-");
            String _name_1 = eClass.getName();
            _builder.append(_name_1);
            _builder.append("-");
            String _name_2 = eAttribute_1.getName();
            _builder.append(_name_2);
            _builder.append("]] +");
            _builder.newLineIfNotEmpty();
            _builder.append("(<<");
            _builder.append(packageNameOfInherited);
            _builder.append("-");
            String _name_3 = superclass_1.getName();
            _builder.append(_name_3);
            _builder.append("-");
            String _name_4 = eAttribute_1.getName();
            _builder.append(_name_4);
            _builder.append(", {inherited}");
            _builder.append(packageNameOfInherited);
            _builder.append(".");
            String _name_5 = superclass_1.getName();
            _builder.append(_name_5);
            _builder.append(">>)");
            _builder.newLineIfNotEmpty();
            _builder.append("|");
            _builder.append(eAttributeTypeName);
            _builder.newLineIfNotEmpty();
            _builder.append("|");
            _builder.append(lowerBound);
            {
              if ((lowerBound != upperBound)) {
                _builder.append("..");
                _builder.append(upperBound);
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("|");
            _builder.newLine();
            _builder.append("|");
            StringBuilder _documentation = this.getDocumentation(eAttribute_1);
            _builder.append(_documentation);
            _builder.newLineIfNotEmpty();
            _builder.newLine();
            _output.append(_builder);
          }
        }
        final Function1<EAttribute, String> _function_2 = (EAttribute it) -> {
          return it.getName();
        };
        List<EAttribute> _sortBy_2 = IterableExtensions.<EAttribute, String>sortBy(eClass.getEAllAttributes(), _function_2);
        for (final EAttribute eAttribute_2 : _sortBy_2) {
          boolean _contains = inheritedEAttributes.keySet().contains(eAttribute_2);
          boolean _not = (!_contains);
          if (_not) {
            final String eAttributeTypeName = eAttribute_2.getEAttributeType().getName();
            final int lowerBound = eAttribute_2.getLowerBound();
            final int upperBound = eAttribute_2.getUpperBound();
            StringBuilder _output = this.getOutput();
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("|");
            String _name = eAttribute_2.getName();
            _builder.append(_name);
            _builder.append("[[");
            _builder.append(ePackageName);
            _builder.append("-");
            String _name_1 = eClass.getName();
            _builder.append(_name_1);
            _builder.append("-");
            String _name_2 = eAttribute_2.getName();
            _builder.append(_name_2);
            _builder.append("]]");
            _builder.newLineIfNotEmpty();
            _builder.append("|<<");
            _builder.append(ePackageName);
            _builder.append("-");
            _builder.append(eAttributeTypeName);
            _builder.append(", ");
            _builder.append(ePackageName);
            _builder.append(".");
            _builder.append(eAttributeTypeName);
            _builder.append(">>");
            _builder.newLineIfNotEmpty();
            _builder.append("|");
            _builder.append(lowerBound);
            {
              if ((lowerBound != upperBound)) {
                _builder.append("..");
                _builder.append(upperBound);
              }
            }
            _builder.newLineIfNotEmpty();
            _builder.append("|");
            _builder.newLine();
            _builder.append("|");
            StringBuilder _documentation = this.getDocumentation(eAttribute_2);
            _builder.append(_documentation);
            _builder.newLineIfNotEmpty();
            _builder.newLine();
            _output.append(_builder);
          }
        }
        _xblockexpression = this.writeFooter();
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public StringBuilder writeReferences(final EClass eClass) {
    StringBuilder _xblockexpression = null;
    {
      int _size = eClass.getEReferences().size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        this.writeEReferencesHeader();
      }
      final String ePackageName = this.getEPackage(eClass).getName();
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
      List<EReference> _sortBy_1 = IterableExtensions.<EReference, String>sortBy(inheritedEReferences.keySet(), _function_1);
      for (final EReference eReference_1 : _sortBy_1) {
        {
          final String packageNameOfInherited = this.getEPackage(inheritedEReferences.get(eReference_1)).getName();
          final EClass superclass_1 = inheritedEReferences.get(eReference_1);
          final String eReferenceTypeName = eReference_1.getEReferenceType().getName();
          final int lowerBound = eReference_1.getLowerBound();
          final int upperBound = eReference_1.getUpperBound();
          StringBuilder _output = this.getOutput();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("|");
          String _name = eReference_1.getName();
          _builder.append(_name);
          _builder.append("[[");
          _builder.append(packageNameOfInherited);
          _builder.append("-");
          String _name_1 = eClass.getName();
          _builder.append(_name_1);
          _builder.append("-");
          String _name_2 = eReference_1.getName();
          _builder.append(_name_2);
          _builder.append("]] +");
          _builder.newLineIfNotEmpty();
          _builder.append("(<<");
          _builder.append(packageNameOfInherited);
          _builder.append("-");
          String _name_3 = superclass_1.getName();
          _builder.append(_name_3);
          _builder.append("-");
          String _name_4 = eReference_1.getName();
          _builder.append(_name_4);
          _builder.append(", {inherited}");
          _builder.append(packageNameOfInherited);
          _builder.append(".");
          String _name_5 = superclass_1.getName();
          _builder.append(_name_5);
          _builder.append(">>)");
          _builder.newLineIfNotEmpty();
          _builder.append("|<<");
          _builder.append(ePackageName);
          _builder.append("-");
          _builder.append(eReferenceTypeName);
          _builder.append(", ");
          _builder.append(ePackageName);
          _builder.append(".");
          _builder.append(eReferenceTypeName);
          _builder.append(">>");
          _builder.newLineIfNotEmpty();
          _builder.append("|");
          _builder.append(lowerBound);
          {
            if ((lowerBound != upperBound)) {
              _builder.append("..");
              _builder.append(upperBound);
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("|<<");
          _builder.append(ePackageName);
          _builder.append("-");
          _builder.append(eReferenceTypeName);
          _builder.append("-");
          String _name_6 = eReference_1.getEOpposite().getName();
          _builder.append(_name_6);
          _builder.append(", ");
          String _name_7 = eReference_1.getEOpposite().getName();
          _builder.append(_name_7);
          _builder.append(">>");
          _builder.newLineIfNotEmpty();
          _builder.append("|");
          StringBuilder _documentation = this.getDocumentation(eReference_1);
          _builder.append(_documentation);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _output.append(_builder);
        }
      }
      final Function1<EReference, String> _function_2 = (EReference it) -> {
        return it.getName();
      };
      List<EReference> _sortBy_2 = IterableExtensions.<EReference, String>sortBy(eClass.getEReferences(), _function_2);
      for (final EReference eReference_2 : _sortBy_2) {
        boolean _contains = inheritedEReferences.keySet().contains(eReference_2);
        boolean _not = (!_contains);
        if (_not) {
          StringBuilder _output = this.getOutput();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("|");
          String _name = eReference_2.getName();
          _builder.append(_name);
          _builder.append("[[");
          _builder.append(ePackageName);
          _builder.append("-");
          String _name_1 = eClass.getName();
          _builder.append(_name_1);
          _builder.append("-");
          String _name_2 = eReference_2.getName();
          _builder.append(_name_2);
          _builder.append("]]");
          _builder.newLineIfNotEmpty();
          _builder.append("|<<");
          _builder.append(ePackageName);
          _builder.append("-");
          String _name_3 = eReference_2.getEReferenceType().getName();
          _builder.append(_name_3);
          _builder.append(", ");
          _builder.append(ePackageName);
          _builder.append(".");
          String _name_4 = eReference_2.getEReferenceType().getName();
          _builder.append(_name_4);
          _builder.append(">>");
          _builder.newLineIfNotEmpty();
          _builder.append("|");
          int _lowerBound = eReference_2.getLowerBound();
          _builder.append(_lowerBound);
          {
            int _lowerBound_1 = eReference_2.getLowerBound();
            int _upperBound = eReference_2.getUpperBound();
            boolean _notEquals = (_lowerBound_1 != _upperBound);
            if (_notEquals) {
              _builder.append("..");
              int _upperBound_1 = eReference_2.getUpperBound();
              _builder.append(_upperBound_1);
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("|");
          _builder.newLine();
          _builder.append("|");
          StringBuilder _documentation = this.getDocumentation(eReference_2);
          _builder.append(_documentation);
          _builder.newLineIfNotEmpty();
          _builder.newLine();
          _output.append(_builder);
        }
      }
      _xblockexpression = this.writeFooter();
    }
    return _xblockexpression;
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
