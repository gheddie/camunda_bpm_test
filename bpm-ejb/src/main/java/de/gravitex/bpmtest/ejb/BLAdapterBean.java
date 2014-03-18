package de.gravitex.bpmtest.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.gravitex.bpmtest.ejb.entity.Customer;

@Stateless(name = "BLAdapter")
@Local(BLAdapter.class)
public class BLAdapterBean implements BLAdapter {
	
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	public void invokeSomeBusinessLogic(String command) {
//		System.out.println("bl command received : '" + command + "'.");
		System.out.println("bl command received : " + command + ", my em is : "+em+".");
		List<Customer> customers = em.createNamedQuery(Customer.FIND_ALL).getResultList();
		System.out.println(customers.size() + " customers found.");
	}
}
