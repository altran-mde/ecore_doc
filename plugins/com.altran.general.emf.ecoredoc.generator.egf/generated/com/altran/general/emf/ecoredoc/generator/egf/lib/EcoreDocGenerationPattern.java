//Generated with EGF 1.6.2.201911290829
package com.altran.general.emf.ecoredoc.generator.egf.lib;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import com.altran.general.emf.ecoredoc.generator.egf.EcoreDocGeneratorHelper;

public class EcoreDocGenerationPattern {

	public EcoreDocGenerationPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).

	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration((PatternContext) argument);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_body(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		Map<?, ?> fcs = (Map<?, ?>) ctx.getValue(FcoreBuilderConstants.CURRENT_FCORE);
		FactoryComponent fc = (FactoryComponent) fcs.get(parameter.eContainer());
		EcoreDocGeneratorHelper.addEcoreDocInvocation(fc, parameter);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration parameter;

	public void set_parameter(
			com.altran.general.emf.ecoredoc.generator.egf.ecoredocExtension.EcoreDocGeneration parameter) {
		this.parameter = parameter;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
