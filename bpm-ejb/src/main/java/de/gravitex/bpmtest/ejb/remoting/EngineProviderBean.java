package de.gravitex.bpmtest.ejb.remoting;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.gravitex.bpmtest.ejb.entity.Customer;

@Stateless(name = "EngineProvider")
@Local(EngineProvider.class)
@Remote(EngineProviderRemote.class)
public class EngineProviderBean implements EngineProvider {
	
	@PersistenceContext
	EntityManager em;
	
	public void startProcessInstance(String processDefinitionKey) {
		System.out.println("starting process instance by key : '"+processDefinitionKey+"'.");
	}

	public void testReadDatabase() {
		System.out.println(em.createNamedQuery(Customer.FIND_ALL).getResultList().size() + " customers found.");		
	}

	public void testWriteDatabase(Long customerId, String newCustomerVatNumber) {
		Customer customer = (Customer) em.find(Customer.class, customerId);
		customer.setCustomerVatNumber(newCustomerVatNumber);
		em.persist(customer);
	}
}
