package de.gravitex.bpmtest.ejb.remoting;

import java.util.List;

import javax.ejb.Remote;

import org.camunda.bpm.engine.task.Task;

@Remote
public interface EngineProviderRemote {

	public void startProcessInstance(String processDefinitionKey);

	public List<Task> queryTasks();
	
	public void completeTask(String taskId);
}
