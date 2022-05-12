package com.altran.general.emf.ecoredoc.plantuml.eclipse;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;

import com.altran.general.emf.ecoredoc.generator.impl.diagram.PlantUMLEcoreDiagramGenerator;

import net.sourceforge.plantuml.eclipse.utils.DiagramTextProvider;

public class EcoreDocDiagramTextProvider implements DiagramTextProvider {
	@Override
	public boolean supportsSelection(ISelection selection) {
		return getFirstElement(selection) instanceof EPackage || getFirstElement(selection) instanceof EClass;
	}
	
	@Override
	public String getDiagramText(IEditorPart editorPart, ISelection selection) {
		return getDiagramText(selection);
	}
	
	@Override
	public String getDiagramText(IViewPart viewPart, ISelection selection) {
		return getDiagramText(selection);
	}
	
	public String getDiagramText(ISelection selection) {
		Object element = getFirstElement(selection);
		if (element instanceof EPackage) {
			return new PlantUMLEcoreDiagramGenerator((EPackage) element, (e) -> true).generateDiagram().toString();
		} else if (element instanceof EClassifier) {
			return new PlantUMLEcoreDiagramGenerator((EClassifier) element, (e) -> true).generateDiagram().toString();
		}
		return null;
	}
	
	private Object getFirstElement(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			return ((IStructuredSelection) selection).getFirstElement();
		}
		return null;
	}
}
