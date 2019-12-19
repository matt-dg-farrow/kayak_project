package com.bae.restTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Customer;
import com.bae.rest.CustomerController;
import com.bae.service.CustomerService;

@RunWith(SpringRunner.class)
public class CustControllerTest {

	@InjectMocks
	private CustomerController controller;

	@Mock
	private CustomerService service;

	private Customer cust1 = new Customer("Bill", "Billy", "Bob", "Bobby", "07779111222", "Brother");
	private Customer cust2 = new Customer("Sue", "Bills", "Steve", "Billington", "07742333444", "Father");
	private List<Customer> customers;

	@Before
	public void before() {
		this.customers = new ArrayList<>();
		this.customers.add(cust1);
		this.customers.add(cust2);
	}

	@Test
	public void createCustTest() {
		Mockito.when(service.createCust(cust1)).thenReturn(cust1);
		assertEquals(cust1, this.service.createCust(cust1));

		verify(this.service, times(1)).createCust(this.cust1);
	}

	@Test
	public void updateCustTest() {
		Mockito.when(service.updateCustomer(cust2, 1L)).thenReturn(cust2);
		assertEquals("Sue", controller.updateCustomer(1L, cust2).getCustFirstName());
		verify(this.service, times(1)).updateCustomer(cust2, 1L);

	}
	
	@Test
	public void getCustomersTest() {
		Mockito.when(service.readCustomers()).thenReturn(this.customers);
		
		assertEquals(this.customers, service.readCustomers());
		verify(this.service, times(1)).readCustomers();

	}
	
	@Test
	public void deleteCustomer() {
		this.controller.deleteCustomer(1L);
		
		verify(this.service, times(1)).deleteCustomer(1L);
	}
	
	@Test
	public void deleteAllTest() {
		this.controller.deleteAll();
		
		verify(this.service, times(1)).deleteAll();
	}

}
