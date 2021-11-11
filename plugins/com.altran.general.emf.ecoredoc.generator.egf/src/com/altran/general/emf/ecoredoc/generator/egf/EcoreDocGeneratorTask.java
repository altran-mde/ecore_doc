package com.altran.general.emf.ecoredoc.generator.egf;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.input.CharSequenceInputStream;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xcore.ui.internal.XcoreActivator;

import com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator;
import com.google.common.base.Charsets;
import com.google.common.collect.Iterables;

public class EcoreDocGeneratorTask implements ITaskProduction {
	static final String IN_DOMAIN = "domain";
	static final String IN_PROJECT_NAME = "projectName";
	static final String IN_OUTPUT_FOLDER = "outputFolder";
	static final String IN_RESOLVE = "resolve";

	@Override
	public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor)
			throws InvocationException {
		// Empty
	}

	@Override
	public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor)
			throws InvocationException {
		final SubMonitor subMonitor = SubMonitor.convert(monitor, 100);

		final EMFDomain domain = context.getInputValue(IN_DOMAIN, EMFDomain.class);
		final String projectName = context.getInputValue(IN_PROJECT_NAME, String.class);
		final String outputFolder = context.getInputValue(IN_OUTPUT_FOLDER, String.class);
		final Boolean resolve = context.getInputValue(IN_RESOLVE, Boolean.class);

		try {
			// Prepare output project structure
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			final IFolder outputIFolder = project.getFolder(outputFolder);
			if (!outputIFolder.exists()) {
				outputIFolder.create(true, true, subMonitor.split(1));
			}
			final IFile outputFile = outputIFolder.getFile(domain.getUri().trimFileExtension().lastSegment() + ".adoc");

			// Optional: resolve
			final Iterable<EObject> eContents = Iterables.filter(domain.getContent(), EObject.class);
			if (resolve) {
				eContents.forEach(EcoreUtil::resolveAll);
			}
			
			// Generate ecore doc
			final Set<EClassifier> eClassifiers = EcoreDocGeneratorHelper.collectInput(eContents);
			final EcoreDocGenerator ecoreDocGenerator = new EcoreDocGenerator(eClassifiers);
			ecoreDocGenerator.setXcoreInjector(
					XcoreActivator.getInstance().getInjector(XcoreActivator.ORG_ECLIPSE_EMF_ECORE_XCORE_XCORE));
			final CharSequence ecoreDoc = ecoreDocGenerator.generate();
			
			// Persist ecore doc
			try (final CharSequenceInputStream content = new CharSequenceInputStream(ecoreDoc, Charsets.UTF_8)) {
				if (outputFile.exists()) {
					outputFile.setContents(content, true, true, subMonitor.split(98));
				} else {
					outputFile.create(content, true, subMonitor.split(98));
				}
			}
			outputFile.setCharset(Charsets.UTF_8.name(), subMonitor.split(1));
		} catch (CoreException | IOException e) {
			throw new InvocationException(e.getMessage(), e);
		}
	}

	@Override
	public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor)
			throws InvocationException {
		// Empty
	}
}
