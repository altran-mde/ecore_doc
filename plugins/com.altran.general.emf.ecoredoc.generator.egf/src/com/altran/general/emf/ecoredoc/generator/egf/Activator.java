package com.altran.general.emf.ecoredoc.generator.egf;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	private static BundleContext context;

    static BundleContext getContext() {
        return context;
    }
    
    static String getPluginID() {
    	return context.getBundle().getSymbolicName();
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        context = bundleContext;
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        context = null;
    }
}
