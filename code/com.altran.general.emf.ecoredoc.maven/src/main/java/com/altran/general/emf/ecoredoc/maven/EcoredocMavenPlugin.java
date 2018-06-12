package com.altran.general.emf.ecoredoc.maven;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator;
import com.altran.general.emf.ecoredoc.util.EcoreDocUtils;

@Mojo(name = "ecoredoc", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class EcoredocMavenPlugin extends AbstractMojo {
	@Parameter(property = "inputFiles", required = true)
	private Set<File> inputFiles;
	
	@Parameter(property = "outputFile", required = true)
	private File outputFile;
	
	@Parameter
	private final boolean resolve = true;
	
	@Override
	public void execute() throws MojoExecutionException {
		if (!checkParameters()) {
			return;
		}
		
		EcoreDocUtils.getInstance().setupEcoreStandalone();
		
		final ResourceSetImpl resourceSet = EcoreDocUtils.getInstance().createResourceSet();
		
		try {
			EcoreDocUtils.getInstance().loadInputModels(resourceSet, this.inputFiles);
		} catch (final IOException e) {
			throw new MojoExecutionException("Exception while loading input models", e);
		}

		EcoreDocUtils.getInstance().resolve(resourceSet, this.resolve);
		
		final Set<EClassifier> classifiers = EcoreDocUtils.getInstance().collectInput(resourceSet);
		
		final CharSequence result = generate(classifiers);
		
		writeOutput(result);
	}

	private boolean checkParameters() throws MojoExecutionException {
		if (this.outputFile == null) {
			throw new MojoExecutionException("outputFile not set.");
		} else {
			if (this.outputFile.exists()) {
				getLog().debug("outputFile '" + this.outputFile + "' already exists and will be overridden.");
			} else {
				final File parent = this.outputFile.getParentFile();
				if (!parent.exists()) {
					getLog().debug("creating parent directory for outputFile: '" + parent + "'");
					parent.mkdirs();
				}
			}
		}
		
		if (this.inputFiles == null || this.inputFiles.isEmpty()) {
			getLog().warn("inputFiles is empty, will not create any output.");
			return false;
		} else {
			final Iterator<File> iter = this.inputFiles.iterator();
			while (iter.hasNext()) {
				final File inputFile = iter.next();
				if (!inputFile.exists()) {
					getLog().warn("inputFile '" + inputFile + "' does not exist and will be ignored.");
					iter.remove();
				}
				if (!inputFile.isFile()) {
					getLog().warn("inputFile '" + inputFile + "' is not a file and will be ignored.");
					iter.remove();
				}
				if (!inputFile.canRead()) {
					getLog().warn("inputFile '" + inputFile + "' cannot be read and will be ignored.");
					iter.remove();
				}
			}
		}
		
		return true;
	}

	private void writeOutput(final CharSequence result) throws MojoExecutionException {
		try (final FileWriter outputWriter = new FileWriter(this.outputFile)) {
			outputWriter.append(result);
		} catch (final IOException e) {
			throw new MojoExecutionException("Error creating output file '" + this.outputFile + "'", e);
		}
	}
	
	private CharSequence generate(final Set<EClassifier> classifiers) {
		final EcoreDocGenerator generator = new EcoreDocGenerator(classifiers);

		final CharSequence result = generator.generate();
		return result;
	}
}
