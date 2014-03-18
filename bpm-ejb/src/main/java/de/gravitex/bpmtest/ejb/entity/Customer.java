package de.gravitex.bpmtest.ejb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@NamedQueries({
		@NamedQuery(name = Customer.FIND_ALL, query = "SELECT object(o) FROM Customer AS o")
		})

@Entity
@Table(name = "CustomerBean")
@TableGenerator(name = "UniqueIdGenerator", table = "ID_GEN", pkColumnName = "ID_NAME", valueColumnName = "ID_VAL", pkColumnValue = "globalkey", allocationSize = 10)
public class Customer {
	
	public static final String FIND_ALL = "Customer.findAllCustomers";
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "UniqueIdGenerator")
	protected Long id;

	private String externalAddressNumber;
	
	private String customerVatNumber;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getExternalAddressNumber() {
		return externalAddressNumber;
	}
	
	public void setExternalAddressNumber(String externalAddressNumber) {
		this.externalAddressNumber = externalAddressNumber;
	}
	
	public String getCustomerVatNumber() {
		return customerVatNumber;
	}
	
	public void setCustomerVatNumber(String customerVatNumber) {
		this.customerVatNumber = customerVatNumber;
	}
}
