package de.gravitex.bpmtest.processref.delegate.anothersimpleprocess;

import de.gravitex.bpmtest.ejb.BpmTest;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AnotherDelegate implements JavaDelegate {
	
	@Inject
	BpmTest bpmTest;
	
	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println("Here is another delegate, i got injected : ["+bpmTest+"].");
	}
}
