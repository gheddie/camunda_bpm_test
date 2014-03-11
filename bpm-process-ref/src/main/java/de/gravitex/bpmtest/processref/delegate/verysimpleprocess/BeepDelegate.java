package de.gravitex.bpmtest.processref.delegate.verysimpleprocess;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import de.gravitex.bpmtest.ejb.BusinessLogicAdapter;

public class BeepDelegate implements JavaDelegate {
	
//	@Inject
	BusinessLogicAdapter businessLogicAdapter;
	
	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println(" #### MACHINE BEEPS (BusinessLogicAdapter:"+businessLogicAdapter+") #### ");
	}
}
