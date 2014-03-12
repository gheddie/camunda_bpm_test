package de.gravitex.bpmtest.processref.delegate.anothersimpleprocess;

import javax.inject.Inject;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import de.gravitex.bpmtest.ejb.BusinessLogicAdapter;

public class AnotherDelegate implements JavaDelegate {
	
	@Inject
	BusinessLogicAdapter businessLogicAdapter;
	
	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println("...AnotherDelegate...["+businessLogicAdapter+"]");
	}
}
