package com.altran.general.emf.ecoredoc.maven;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.maven.plugin.testing.MojoRule;
import org.apache.maven.plugin.testing.WithoutMojo;
import org.junit.Rule;
import org.junit.Test;

public class EcoreDocTest {
	@Rule
	public MojoRule rule = new MojoRule() {
		@Override
		protected void before() throws Throwable {
		}

		@Override
		protected void after() {
		}
	};

	@Test
	public void testBasic() throws Exception {
		final File pom = new File("target/test-classes/project-to-test/");
		assertNotNull(pom);
		assertTrue(pom.exists());

		System.out.println("pom: " + pom.getAbsolutePath());

		final EcoredocMavenPlugin ecoredocMojo = (EcoredocMavenPlugin) this.rule.lookupConfiguredMojo(pom, "ecoredoc");
		assertNotNull(ecoredocMojo);
		ecoredocMojo.execute();

		final File outputFile = (File) this.rule.getVariableValueFromObject(ecoredocMojo, "outputFile");
		assertNotNull(outputFile);
		assertTrue(outputFile.exists());

	}

	/** Do not need the MojoRule. */
	@WithoutMojo
	// @Test
	public void testSomethingWhichDoesNotNeedTheMojoAndProbablyShouldBeExtractedIntoANewClassOfItsOwn() {
		assertTrue(true);
	}

}

