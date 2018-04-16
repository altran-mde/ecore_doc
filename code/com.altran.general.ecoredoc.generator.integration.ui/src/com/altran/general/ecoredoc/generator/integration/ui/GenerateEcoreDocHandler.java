package com.altran.general.ecoredoc.generator.integration.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class GenerateEcoreDocHandler extends AbstractHandler {
	private static final String EXTENSIONS = "ecore, xcore";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
			
		if (selection instanceof IStructuredSelection) {
		} 
			
		return null;
	}

}
