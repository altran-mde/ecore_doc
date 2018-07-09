package com.altran.general.emf.ecoredoc.maven;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.altran.general.emf.ecoredoc.generator.EcoreDocGenerator;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocConfigFactory;
import com.altran.general.emf.ecoredoc.generator.config.EcoreDocGeneratorConfig;
import com.altran.general.emf.ecoredoc.util.EcoreDocUtils;
import com.altran.general.emf.ecoredoc.util.EcoreMerger;

/**
 * Creates JavaDoc-like documents for Ecore metamodels in AsciiDoctor format.
 *
 * @see <a href=
 *      "http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html">JavaDoc
 *      Homepage</a>
 * @see <a href="https://wiki.eclipse.org/Ecore">Ecore Wiki entry</a>
 * @see <a href="https://asciidoctor.org/">AsciiDoctor Homepage</a>
 *
 */
@Mojo(name = "ecoredoc", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class EcoredocMavenPlugin extends AbstractMojo {
	/**
	 * All ecore metamodel files we want to generate documentation for.
	 */
	@Parameter(property = "inputFiles", required = true)
	private Set<File> inputFiles;

	/**
	 * The output file to write the documentation to.
	 *
	 * <p>
	 * By convention, the file extension is <tt>.adoc</tt>.
	 * </p>
	 *
	 * <p>
	 * <b>Caution:</b> If the file exists, it will be overwritten and a warning
	 * is emitted.
	 * </p>
	 */
	@Parameter(property = "outputFile", required = true)
	private File outputFile;

	/**
	 * Whether we should explicitly resolve all EMF proxies.
	 */
	@Parameter
	private boolean resolve = false;

	/**
	 * Detailed configuration of the generated documentation.
	 */
	@Parameter(property = "config")
	private EcoreDocGeneratorConfig config = EcoreDocConfigFactory.eINSTANCE.createEcoreDocGeneratorConfig();

	@Override
	public void execute() throws MojoExecutionException {
		if (!checkParameters()) {
			return;
		}

		EcoreDocUtils.getInstance().setupEcoreStandalone();
		EcoreDocUtils.getInstance().setupXcoreStandalone();

		final ResourceSetImpl resourceSet = EcoreDocUtils.getInstance().createResourceSet();

		try {
			EcoreDocUtils.getInstance().loadInputModels(resourceSet, this.inputFiles);
		} catch (final IOException e) {
			throw new MojoExecutionException("Exception while loading input models", e);
		}

		EcoreDocUtils.getInstance().resolve(resourceSet, this.resolve);

		final Set<EClassifier> classifiers = EcoreDocUtils.getInstance().collectInput(resourceSet, this.inputFiles);

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

		new EcoreMerger<EcoreDocGeneratorConfig>(generator.getConfig())
		.merge(resolveConfig(classifiers.stream().map(c -> c.getEPackage()).collect(Collectors.toSet())));

		final CharSequence result = generator.generate();
		return result;
	}

	private EcoreDocGeneratorConfig resolveConfig(final Collection<EPackage> ePackages) {

		final EcoreLookupHelper lookupHelper = EcoreLookupHelper.createDefault().addPackages(ePackages);
		final EcoreLazyResolver lazyResolver = new EcoreLazyResolver(lookupHelper);
		lazyResolver.resolveAll(this.config);

		return this.config;
	}

}
