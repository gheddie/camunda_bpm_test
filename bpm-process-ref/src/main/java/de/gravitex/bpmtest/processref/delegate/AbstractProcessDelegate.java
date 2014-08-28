package de.gravitex.bpmtest.processref.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import de.gravitex.bpmtest.ejb.common.GenericBpmException;

public abstract class AbstractProcessDelegate implements JavaDelegate {

	protected void ensureVariablesSet(DelegateExecution execution, String... variableNames) throws GenericBpmException {
		for (String variableName : variableNames) {
			if (execution.getVariable(variableName) == null) {
				throw new GenericBpmException("variable "+variableName+" must be set!");
			}	
		}
	}
}
