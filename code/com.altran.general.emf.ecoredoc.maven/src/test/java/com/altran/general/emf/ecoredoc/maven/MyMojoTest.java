package com.altran.general.emf.ecoredoc.maven;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.maven.plugin.testing.MojoRule;
import org.apache.maven.plugin.testing.WithoutMojo;
import org.junit.Rule;

public class MyMojoTest
{
	@Rule
	public MojoRule rule = new MojoRule()
	{
		@Override
		protected void before() throws Throwable
		{
		}
		
		@Override
		protected void after()
		{
		}
	};
	
	/**
	 * @throws Exception if any
	 */
	// @Test
	public void testSomething()
			throws Exception
	{
		final File pom = new File( "target/test-classes/project-to-test/" );
		assertNotNull( pom );
		assertTrue( pom.exists() );
		
		final EcoredocMavenPlugin myMojo = ( EcoredocMavenPlugin ) this.rule.lookupConfiguredMojo( pom, "touch" );
		assertNotNull( myMojo );
		myMojo.execute();
		
		final File outputDirectory = ( File ) this.rule.getVariableValueFromObject( myMojo, "outputDirectory" );
		assertNotNull( outputDirectory );
		assertTrue( outputDirectory.exists() );
		
		final File touch = new File( outputDirectory, "touch.txt" );
		assertTrue( touch.exists() );
		
	}
	
	/** Do not need the MojoRule. */
	@WithoutMojo
	// @Test
	public void testSomethingWhichDoesNotNeedTheMojoAndProbablyShouldBeExtractedIntoANewClassOfItsOwn()
	{
		assertTrue( true );
	}
	
}

