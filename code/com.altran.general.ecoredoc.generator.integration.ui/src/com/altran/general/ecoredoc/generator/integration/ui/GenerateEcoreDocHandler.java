package com.altran.general.ecoredoc.generator.integration.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class GenerateEcoreDocHandler extends AbstractHandler {
	private static enum Extension{
		ecore,
		xcore,
		something
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		boolean isStructuredSelection = selection instanceof IStructuredSelection;
			
		if (isStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					
			boolean isIFile = structuredSelection instanceof IFile;
			
			if(isIFile) {
				IFile file = (IFile) structuredSelection;
				
				String fileExtension = file.getFileExtension();
				
				Extension ext = Extension.valueOf(fileExtension);
				
				switch(ext) {
					case ecore:
						break;
						
					case xcore:
						break;
				}
				boolean isEcore = fileExtension.equals(Extension.ecore);
				boolean isXcore = fileExtension.equals(Extension.xcore);
					
				if (isEcore || isXcore) {
					
				}
			}
		} 
			
		return null;
	}

}
