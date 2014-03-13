package de.gravitex.bpmtest.processref.delegate.anothersimpleprocess;

import javax.inject.Inject;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import de.gravitex.bpmtest.ejb.BpmTest;

public class AnotherDelegate implements JavaDelegate {
	
	@Inject
	BpmTest bpmTest;
	
	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println("Here is another delegate, i got injected : ["+bpmTest+"].");
	}
}
