package de.gravitex.bpmtest.ejb.remoting;

import java.util.List;

import javax.ejb.Remote;

import org.camunda.bpm.engine.task.Task;

@Remote
public interface EngineProviderRemote {

	public void startProcessInstance(String processDefinitionKey);

	public void testReadDatabase();
	
	public void testWriteDatabase(Long customerId, String newCustomerVatNumber);

	public List<Task> queryTasks();
}
