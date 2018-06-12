package com.altran.general.emf.ecoredoc.maven;

import java.util.Objects;

import org.codehaus.plexus.component.configurator.ComponentConfigurationException;
import org.codehaus.plexus.component.configurator.ConfigurationListener;
import org.codehaus.plexus.component.configurator.converters.composite.ObjectWithFieldsConverter;
import org.codehaus.plexus.component.configurator.converters.lookup.ConverterLookup;
import org.codehaus.plexus.component.configurator.expression.ExpressionEvaluator;
import org.codehaus.plexus.configuration.PlexusConfiguration;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.sisu.plexus.CompositeBeanHelper;

public class EcoreDocGeneratorConfigConverter extends ObjectWithFieldsConverter {
	@Override
	public boolean canConvert(final Class<?> type) {
		return EObject.class.isAssignableFrom(type);
	}
	
	@Override
	public Object fromConfiguration(final ConverterLookup lookup, final PlexusConfiguration configuration, final Class<?> type,
			final Class<?> enclosingType, final ClassLoader loader, final ExpressionEvaluator evaluator, final ConfigurationListener listener)
					throws ComponentConfigurationException {
		final Object value = fromExpression(configuration, evaluator);
		if (type.isInstance(value)) {
			return value;
		}
		try {
			final Class<?> implType = getClassForImplementationHint(type, configuration, loader);
			final Object bean = instantiateObjectEx(implType);
			if (null == value) {
				processConfiguration(lookup, bean, loader, configuration, evaluator, listener);
			} else {
				new CompositeBeanHelper(lookup, loader, evaluator, listener).setDefault(bean, value, configuration);
			}
			return bean;
		} catch (final ComponentConfigurationException e) {
			if (null == e.getFailedConfiguration()) {
				e.setFailedConfiguration(configuration);
			}
			throw e;
		}
	}

	protected Object instantiateObjectEx(final Class<?> type) throws ComponentConfigurationException {
		if (EObject.class.isAssignableFrom(type)) {
			return EPackage.Registry.INSTANCE.keySet().stream()
					.filter(Objects::nonNull)
					.map(nsUri -> EPackage.Registry.INSTANCE.getEPackage(nsUri))
					.map(ePackage -> ePackage.getEClassifier(type.getSimpleName()))
					.filter(EClass.class::isInstance)
					.map(EClass.class::cast)
					.map(eClass -> (Object) eClass.getEPackage().getEFactoryInstance().create(eClass))
					.findAny()
					.get();
		}

		return instantiateObject(type);

	}

}
