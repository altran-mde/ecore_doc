package com.altran.general.emf.ecoredoc.plantuml.xcore;

import com.altran.general.emf.ecoredoc.generator.impl.diagram.PlantUMLEcoreDiagramGenerator;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import net.sourceforge.plantuml.eclipse.utils.WorkbenchPartDiagramIntentProviderContext;
import net.sourceforge.plantuml.util.DiagramIntent;
import net.sourceforge.plantuml.util.DiagramIntentContext;
import net.sourceforge.plantuml.util.DiagramIntentProvider;
import net.sourceforge.plantuml.util.SimpleDiagramIntent;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xcore.XClassifier;
import org.eclipse.emf.ecore.xcore.mappings.XcoreMapper;
import org.eclipse.emf.ecore.xcore.ui.editor.XcoreEditor;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class XcoreDiagramIntentProvider implements DiagramIntentProvider {
  @Extension
  private static final EObjectAtOffsetHelper EOBJECT_AT_OFFSET_HELPER = new EObjectAtOffsetHelper();
  
  @Extension
  private static final XcoreMapper XCORE_MAPPER = new XcoreMapper();
  
  @Override
  public Collection<? extends DiagramIntent> getDiagramInfos(final DiagramIntentContext context) {
    CharSequence _xifexpression = null;
    if ((context instanceof WorkbenchPartDiagramIntentProviderContext)) {
      CharSequence _xifexpression_1 = null;
      if (((((WorkbenchPartDiagramIntentProviderContext)context).getWorkbenchPart() instanceof XcoreEditor) && (((WorkbenchPartDiagramIntentProviderContext)context).getSelection() instanceof ITextSelection))) {
        IWorkbenchPart _workbenchPart = ((WorkbenchPartDiagramIntentProviderContext)context).getWorkbenchPart();
        ISelection _selection = ((WorkbenchPartDiagramIntentProviderContext)context).getSelection();
        _xifexpression_1 = this.getDiagramText(((XcoreEditor) _workbenchPart), ((ITextSelection) _selection));
      }
      _xifexpression = _xifexpression_1;
    }
    final CharSequence diagramText = _xifexpression;
    if (((diagramText != null) && (diagramText.length() > 0))) {
      String _string = diagramText.toString();
      SimpleDiagramIntent _simpleDiagramIntent = new SimpleDiagramIntent(_string);
      return Collections.<SimpleDiagramIntent>singleton(_simpleDiagramIntent);
    }
    return null;
  }
  
  private CharSequence getDiagramText(final XcoreEditor xcoreEditor, final ITextSelection selection) {
    final IUnitOfWork<CharSequence, XtextResource> _function = (XtextResource it) -> {
      EObject _resolveContainedElementAt = XcoreDiagramIntentProvider.EOBJECT_AT_OFFSET_HELPER.resolveContainedElementAt(it, selection.getOffset());
      XClassifier _containerOfType = null;
      if (_resolveContainedElementAt!=null) {
        _containerOfType=EcoreUtil2.<XClassifier>getContainerOfType(_resolveContainedElementAt, XClassifier.class);
      }
      ENamedElement _ecore = null;
      if (_containerOfType!=null) {
        _ecore=XcoreDiagramIntentProvider.XCORE_MAPPER.getEcore(_containerOfType);
      }
      final EClassifier eClassifier = ((EClassifier) _ecore);
      if ((eClassifier != null)) {
        UnmodifiableIterator<EClassifier> _singletonIterator = Iterators.<EClassifier>singletonIterator(eClassifier);
        return new PlantUMLEcoreDiagramGenerator(_singletonIterator, true, true).generateDiagram();
      }
      final Iterator<EClassifier> eClassifiers = Iterators.<EClassifier>filter(it.getAllContents(), EClassifier.class);
      boolean _hasNext = eClassifiers.hasNext();
      if (_hasNext) {
        return new PlantUMLEcoreDiagramGenerator(eClassifiers, false, true).generateDiagram();
      }
      return null;
    };
    return xcoreEditor.getDocument().<CharSequence>readOnly(_function);
  }
}
