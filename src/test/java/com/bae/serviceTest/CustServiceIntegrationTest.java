package com.bae.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.repo.CustomerRepo;
import com.bae.service.CapacityReachedException;
import com.bae.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustServiceIntegrationTest {

	@Autowired
	private CustomerService service;

	@Autowired
	private CustomerRepo repo;

	private Customer cust;

//	private Customer custWithId = this.repo.save(this.cust);

	@Before
	public void init() {
		this.cust = new Customer("Bill", "Billy", "Bob", "Bobby", "07779111222", "Brother");
		this.repo.deleteAll();
//		this.custWithId = this.repo.save(this.cust);
	}

	@Test
	public void createCustTest() throws CapacityReachedException {
		assertEquals(this.cust, this.service.createCust(cust));
	}

}
