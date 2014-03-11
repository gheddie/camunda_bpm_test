package de.gravitex.bpmtest.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "BpmTest")
@Remote(BpmTestRemote.class)
public class BpmTestBean implements BpmTest {

//	@Resource(mappedName = "java:global/camunda-bpm-platform/process-engine/default")
//	private ProcessEngine processEngine;

	public void startProcessInstance(String processDefinitionKey) {
		
		System.out.println("starting process instance by key : '"
				+ processDefinitionKey + "'.");
		
//		if (processEngine != null) {
//			processEngine.getTaskService().createTaskQuery().list();
//		}
	}

	public void sayMoo(String moo) {
		System.out.println("moo : " + moo);
	}
}
