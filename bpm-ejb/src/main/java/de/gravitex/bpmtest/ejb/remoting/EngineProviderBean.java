package de.gravitex.bpmtest.ejb.remoting;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.task.Task;

import de.gravitex.bpmtest.ejb.entity.Customer;

@Stateless(name = "EngineProvider")
@Local(EngineProvider.class)
@Remote(EngineProviderRemote.class)
public class EngineProviderBean implements EngineProvider {
	
	@PersistenceContext
	EntityManager em;
	
	@Resource(mappedName = "java:global/camunda-bpm-platform/process-engine/default")
	private ProcessEngine processEngine;	
	
	public void startProcessInstance(String processDefinitionKey) {
		System.out.println("starting process instance by key : '"+processDefinitionKey+"' [process engine='"+processEngine+"'].");
		processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey);
	}

	public void testReadDatabase() {
		System.out.println(em.createNamedQuery(Customer.FIND_ALL).getResultList().size() + " customers found.");		
	}

	public void testWriteDatabase(Long customerId, String newCustomerVatNumber) {
		Customer customer = (Customer) em.find(Customer.class, customerId);
		customer.setCustomerVatNumber(newCustomerVatNumber);
		em.persist(customer);
	}

	public List<Task> queryTasks() {
		List<Task> tasks = processEngine.getTaskService().createTaskQuery().list();
		System.out.println("i have "+tasks.size()+" tasks at the moment");
		return tasks;
	}
}
