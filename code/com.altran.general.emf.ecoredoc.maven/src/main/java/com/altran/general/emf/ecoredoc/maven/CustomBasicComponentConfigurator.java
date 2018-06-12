package com.altran.general.emf.ecoredoc.maven;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.configurator.BasicComponentConfigurator;
import org.codehaus.plexus.component.configurator.ComponentConfigurator;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;

import com.altran.general.emf.ecoredoc.util.EcoreDocUtils;

@Component(role = ComponentConfigurator.class, hint = "basic")
public class CustomBasicComponentConfigurator extends BasicComponentConfigurator implements Initializable {
	@Override
	public void initialize() throws InitializationException {
		EcoreDocUtils.getInstance().setupEcoreStandalone();
		
		this.converterLookup.registerConverter(new EcoreDocGeneratorConfigConverter());
	}
	
}
