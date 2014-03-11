package de.gravitex.bpmtest.processref.delegate.anothersimpleprocess;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AnotherDelegate implements JavaDelegate {
	
//	@Inject
//	BusinessLogicAdapter businessLogicAdapter;
	
	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println("...AnotherDelegate...");
	}
}
