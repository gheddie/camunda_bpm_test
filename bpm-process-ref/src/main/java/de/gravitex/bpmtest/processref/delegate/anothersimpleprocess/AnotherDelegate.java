package de.gravitex.bpmtest.processref.delegate.anothersimpleprocess;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class AnotherDelegate implements JavaDelegate {
	
	public void execute(DelegateExecution arg0) throws Exception {
//		System.out.println("Here is another delegate, i got injected : ["+blAdapter+"].");
//		blAdapter.invokeSomeBusinessLogic("here is some bl command from process delegate...");
	}
}
