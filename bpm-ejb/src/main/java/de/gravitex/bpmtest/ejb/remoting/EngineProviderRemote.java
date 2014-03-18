package de.gravitex.bpmtest.ejb.remoting;

import javax.ejb.Remote;

@Remote
public interface EngineProviderRemote {

	public void startProcessInstance(String processDefinitionKey);

	public void testDBConnection();
}
