package de.gravitex.bpmtest.ejb.remoting;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "EngineProvider")
@Local(EngineProvider.class)
@Remote(EngineProviderRemote.class)
public class EngineProviderBean implements EngineProvider {
	
	public void startProcessInstance(String processDefinitionKey) {
		System.out.println("starting process instance by key : '"+processDefinitionKey+"'.");
	}

	public void testDBConnection() {
		// TODO Auto-generated method stub
	}
}
