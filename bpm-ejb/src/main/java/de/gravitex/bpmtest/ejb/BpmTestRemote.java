package de.gravitex.bpmtest.ejb;

import javax.ejb.Remote;

@Remote
public interface BpmTestRemote {

	public void startProcessInstance(String processDefinitionKey);
	
	public void sayMoo(String moo);
}
