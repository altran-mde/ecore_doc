package com.altran.general.emf.ecoredoc.plantuml.ecore;

import com.altran.general.emf.ecoredoc.generator.impl.diagram.PlantUMLEcoreDiagramGenerator;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import net.sourceforge.plantuml.eclipse.utils.WorkbenchPartDiagramIntentProviderContext;
import net.sourceforge.plantuml.util.DiagramIntent;
import net.sourceforge.plantuml.util.DiagramIntentContext;
import net.sourceforge.plantuml.util.DiagramIntentProvider;
import net.sourceforge.plantuml.util.SimpleDiagramIntent;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class EcoreDiagramIntentProvider implements DiagramIntentProvider {
  @Override
  public Collection<? extends DiagramIntent> getDiagramInfos(final DiagramIntentContext context) {
    String _xifexpression = null;
    if ((context instanceof WorkbenchPartDiagramIntentProviderContext)) {
      String _xifexpression_1 = null;
      if (((((WorkbenchPartDiagramIntentProviderContext)context).getWorkbenchPart() instanceof IEditingDomainProvider) && (((WorkbenchPartDiagramIntentProviderContext)context).getSelection() instanceof IStructuredSelection))) {
        IWorkbenchPart _workbenchPart = ((WorkbenchPartDiagramIntentProviderContext)context).getWorkbenchPart();
        ISelection _selection = ((WorkbenchPartDiagramIntentProviderContext)context).getSelection();
        _xifexpression_1 = this.getDiagramText(((IEditingDomainProvider) _workbenchPart), ((IStructuredSelection) _selection));
      }
      _xifexpression = _xifexpression_1;
    }
    final String diagramText = _xifexpression;
    if (((diagramText != null) && (!diagramText.isEmpty()))) {
      SimpleDiagramIntent _simpleDiagramIntent = new SimpleDiagramIntent(diagramText);
      return Collections.<SimpleDiagramIntent>singleton(_simpleDiagramIntent);
    }
    return null;
  }
  
  private String getDiagramText(final IEditingDomainProvider editingDomainProvider, final IStructuredSelection selection) {
    PlantUMLEcoreDiagramGenerator _switchResult = null;
    final IStructuredSelection it = selection;
    boolean _matched = false;
    if (((it.size() == 1) && (IterableExtensions.<Object>head(it) instanceof EPackage))) {
      _matched=true;
      Object _head = IterableExtensions.<Object>head(selection);
      Iterator<EClassifier> _iterator = ((EPackage) _head).getEClassifiers().iterator();
      _switchResult = new PlantUMLEcoreDiagramGenerator(_iterator, false, true);
    }
    if (!_matched) {
      if (((it.size() == 1) && (IterableExtensions.<Object>head(it) instanceof Resource))) {
        _matched=true;
        PlantUMLEcoreDiagramGenerator _xblockexpression = null;
        {
          Object _head_1 = IterableExtensions.<Object>head(it);
          final Iterator<EClassifier> eClassifiers = Iterators.<EClassifier>filter(((Resource) _head_1).getAllContents(), EClassifier.class);
          _xblockexpression = new PlantUMLEcoreDiagramGenerator(eClassifiers, false, true);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (((!it.isEmpty()) && IterableExtensions.<Object>forall(it, ((Function1<Object, Boolean>) (Object it_1) -> {
        return Boolean.valueOf((it_1 instanceof EClassifier));
      })))) {
        _matched=true;
        Iterator<EClassifier> _iterator_1 = Iterables.<EClassifier>filter(it, EClassifier.class).iterator();
        _switchResult = new PlantUMLEcoreDiagramGenerator(_iterator_1, true, true);
      }
    }
    if (!_matched) {
      Iterator<EClassifier> _filter = Iterators.<EClassifier>filter(editingDomainProvider.getEditingDomain().getResourceSet().getAllContents(), EClassifier.class);
      if (Objects.equal(it, _filter)) {
        _matched=true;
        PlantUMLEcoreDiagramGenerator _xblockexpression_1 = null;
        {
          final Iterator<EClassifier> eClassifiers = Iterators.<EClassifier>filter(editingDomainProvider.getEditingDomain().getResourceSet().getAllContents(), EClassifier.class);
          _xblockexpression_1 = new PlantUMLEcoreDiagramGenerator(eClassifiers, false, true);
        }
        _switchResult = _xblockexpression_1;
      }
    }
    PlantUMLEcoreDiagramGenerator generator = _switchResult;
    CharSequence _generateDiagram = null;
    if (generator!=null) {
      _generateDiagram=generator.generateDiagram();
    }
    String _string = null;
    if (_generateDiagram!=null) {
      _string=_generateDiagram.toString();
    }
    return _string;
  }
}
