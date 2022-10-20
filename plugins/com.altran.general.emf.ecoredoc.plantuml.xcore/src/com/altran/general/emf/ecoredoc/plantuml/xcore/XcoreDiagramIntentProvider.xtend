package com.altran.general.emf.ecoredoc.plantuml.xcore

import com.altran.general.emf.ecoredoc.generator.impl.diagram.PlantUMLEcoreDiagramGenerator
import java.util.Collection
import java.util.Collections
import net.sourceforge.plantuml.eclipse.utils.WorkbenchPartDiagramIntentProviderContext
import net.sourceforge.plantuml.util.DiagramIntent
import net.sourceforge.plantuml.util.DiagramIntentContext
import net.sourceforge.plantuml.util.DiagramIntentProvider
import net.sourceforge.plantuml.util.SimpleDiagramIntent
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.xcore.XClassifier
import org.eclipse.emf.ecore.xcore.mappings.XcoreMapper
import org.eclipse.emf.ecore.xcore.ui.editor.XcoreEditor
import org.eclipse.jface.text.ITextSelection
import org.eclipse.xtext.resource.EObjectAtOffsetHelper

import static com.google.common.collect.Iterators.singletonIterator

import static extension org.eclipse.xtext.EcoreUtil2.*

class XcoreDiagramIntentProvider implements DiagramIntentProvider {
    static extension val EObjectAtOffsetHelper EOBJECT_AT_OFFSET_HELPER = new EObjectAtOffsetHelper();
    static extension val XcoreMapper XCORE_MAPPER = new XcoreMapper();

    override Collection<? extends DiagramIntent> getDiagramInfos(DiagramIntentContext context) {
         val diagramText = if (context instanceof WorkbenchPartDiagramIntentProviderContext) {
            if (context.workbenchPart instanceof XcoreEditor && context.selection instanceof ITextSelection) {
                getDiagramText(context.workbenchPart as XcoreEditor, context.selection as ITextSelection)
            }
        }
        if (diagramText !== null && diagramText.length > 0) {
            return Collections::singleton(new SimpleDiagramIntent(diagramText.toString))
        }
    }
    
    def private getDiagramText(XcoreEditor xcoreEditor, ITextSelection selection) {
        xcoreEditor.document.readOnly[
            val eClassifier = resolveContainedElementAt(selection.offset)?.getContainerOfType(XClassifier)?.ecore as EClassifier
            if (eClassifier !== null) {
                return new PlantUMLEcoreDiagramGenerator(singletonIterator(eClassifier), true, true).generateDiagram
            }
            val eClassifiers = allContents.filter(EClassifier)
            if (eClassifiers.hasNext) {
                return new PlantUMLEcoreDiagramGenerator(eClassifiers, false, true).generateDiagram
            }
        ]
    }
}
