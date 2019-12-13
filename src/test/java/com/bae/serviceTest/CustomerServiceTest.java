package com.bae.serviceTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.repo.CustomerRepo;
import com.bae.service.CustomerService;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService service;

	@Mock
	private CustomerRepo repo;

	private Customer cust1 = new Customer("Bill", "Billy", "Bob", "Bobby", "07779111222", "Brother");
	private Customer cust2 = new Customer("Sue", "Bills", "Steve", "Billington", "07742333444", "Father");

	@Test
	public void createCustomerTest() {

		Mockito.when(repo.save(cust1)).thenReturn(cust1);
		assertEquals(cust1, this.service.createCust(cust1));
		
		verify(this.repo, times(1)).save(this.cust1);


	}

	@Test
	public void updateCustomerTest() {

		List<Customer> customers = new ArrayList<>();
		customers.add(cust1);
		Mockito.when(repo.getOne(1L)).thenReturn(cust1);
		service.updateCustomer(cust2, 1L);
		assertEquals("Sue", customers.get(0).getCustFirstName());
		Mockito.when(repo.save(cust1)).thenReturn(cust1);

		
		verify(this.repo, times(1)).getOne(1L);
	}

	@Test
	public void getCustomersTest() {

		List<Customer> customers = new ArrayList<>();
		customers.add(cust1);
		Mockito.when(repo.findAll()).thenReturn(customers);
		assertTrue(this.service.readCustomers().size() > 0);
		
		verify(this.repo, times(1)).findAll();
	}

	@Test
	public void deleteCustomerTest() {
		
		this.service.deleteCustomer(1L);
		
		verify(this.repo, times(1)).deleteById(1L);
	}
	
	@Test
	public void deleteAllTest() {
		this.service.deleteAll();
		
		verify(this.repo, times(1)).deleteAll();
	}

}
