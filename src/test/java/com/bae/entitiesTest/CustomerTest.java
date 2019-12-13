package com.bae.entitiesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bae.persistence.domain.Customer;

class CustomerTest {

	@Test
	void customerTest() {
		Customer cust1 = new Customer();
		
		cust1.setEmergContactNumber("07779123456");
		cust1.setCustFirstName("Bill");
		cust1.setCustSurname("Billy");
		cust1.setEmergFirstName("Bob");
		cust1.setEmergSurname("Bobby");
		cust1.setEmergRelation("Friend");
		
		assertEquals("07779123456", cust1.getEmergContactNumber());
		assertEquals("Bill", cust1.getCustFirstName());
		assertEquals("Billy", cust1.getCustSurname());
		assertEquals("Bob", cust1.getEmergFirstName());
		assertEquals("Bobby", cust1.getEmergSurname());
		assertEquals("Friend", cust1.getEmergRelation());
		
		
		System.out.println(cust1.toString());
		
		assertEquals("Customer [id=null, custFirstName=Bill, custSurname=Billy, emergFirstName=Bob, emergSurname=Bobby, contactNumber=07779123456, emergRelation=Friend, bookings=null]", cust1.toString());


	

		
	}

}
