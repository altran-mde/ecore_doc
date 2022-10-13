package com.altran.general.emf.ecoredoc.plantuml.ecore

import com.altran.general.emf.ecoredoc.generator.impl.diagram.PlantUMLEcoreDiagramGenerator
import java.util.Collection
import java.util.Collections
import net.sourceforge.plantuml.eclipse.utils.WorkbenchPartDiagramIntentProviderContext
import net.sourceforge.plantuml.util.DiagramIntent
import net.sourceforge.plantuml.util.DiagramIntentContext
import net.sourceforge.plantuml.util.DiagramIntentProvider
import net.sourceforge.plantuml.util.SimpleDiagramIntent
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.edit.domain.IEditingDomainProvider
import org.eclipse.jface.viewers.IStructuredSelection

class EcoreDiagramIntentProvider implements DiagramIntentProvider {
    override Collection<? extends DiagramIntent> getDiagramInfos(DiagramIntentContext context) {
         val diagramText = if (context instanceof WorkbenchPartDiagramIntentProviderContext) {
            if (context.workbenchPart instanceof IEditingDomainProvider && context.selection instanceof IStructuredSelection) {
                getDiagramText(context.workbenchPart as IEditingDomainProvider, context.selection as IStructuredSelection)
            }
        }
        if (diagramText !== null && !diagramText.isEmpty()) {
            return Collections::singleton(new SimpleDiagramIntent(diagramText))
        }
    }
    
    def private String getDiagramText(IEditingDomainProvider editingDomainProvider, IStructuredSelection selection) {
        var PlantUMLEcoreDiagramGenerator generator = switch it: selection {
        	case size == 1 && head instanceof EPackage: {
        	    new PlantUMLEcoreDiagramGenerator((selection.head as EPackage).EClassifiers.iterator, false, true)
    	    }
    	    case size == 1 && head instanceof Resource: {
    	        val eClassifiers = (head as Resource).allContents.filter(EClassifier)
    	        new PlantUMLEcoreDiagramGenerator(eClassifiers, false, true)
    	    }
    	    case !isEmpty && forall[it instanceof EClassifier]: {
    	        new PlantUMLEcoreDiagramGenerator(filter(EClassifier).iterator, true, true)
    	    }
    	    case editingDomainProvider.editingDomain.resourceSet.allContents.filter(EClassifier): {
                val eClassifiers = editingDomainProvider.editingDomain.resourceSet.allContents.filter(EClassifier)
                new PlantUMLEcoreDiagramGenerator(eClassifiers, false, true)
    	    }
        }
        return generator?.generateDiagram()?.toString()
    }
}
