package com.altran.general.emf.ecoredoc.maven;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.testing.MojoRule;
import org.junit.Rule;
import org.junit.Test;

public class EcoreDocMavenTest {
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
		executeTest("target/test-classes/testBasic/", "target/test-classes/testBasic/expected.adoc");
	}
	
	@Test
	public void testNoRepeatInherited() throws Exception {
		executeTest("target/test-classes/testNoRepeatInherited/",
				"target/test-classes/testNoRepeatInherited/expected.adoc");
	}

	@Test
	public void testNoDefaults() throws Exception {
		executeTest("target/test-classes/testNoDefaults/", "target/test-classes/testNoDefaults/expected.adoc");
	}

	@Test
	public void testNoDefaultsButBounds() throws Exception {
		executeTest("target/test-classes/testNoDefaultsButBounds/",
				"target/test-classes/testNoDefaultsButBounds/expected.adoc");
	}

	@Test
	public void testReorderNoUseCases() throws Exception {
		executeTest("target/test-classes/testReorderNoUseCases/",
				"target/test-classes/testReorderNoUseCases/expected.adoc");
	}

	protected void executeTest(final String pomDir, final String expectedOutputPath) throws Exception {
		final File pom = new File(pomDir);
		assertNotNull(pom);
		assertTrue(pom.exists());

		final EcoredocMavenPlugin ecoredocMojo = (EcoredocMavenPlugin) this.rule.lookupConfiguredMojo(pom, "ecoredoc");
		assertNotNull(ecoredocMojo);
		ecoredocMojo.execute();

		final File outputFile = (File) this.rule.getVariableValueFromObject(ecoredocMojo, "outputFile");
		assertNotNull(outputFile);
		assertTrue(outputFile.exists());
		
		final String expected = FileUtils.readFileToString(new File(expectedOutputPath));
		final String actual = FileUtils.readFileToString(outputFile);
		
		assertEquals(expected, actual);
	}
}

