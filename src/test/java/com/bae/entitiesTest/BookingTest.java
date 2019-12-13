package com.bae.entitiesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;

import com.bae.persistence.domain.Booking;
import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Equipment;

class BookingTest {

	@Test
	void test() {
		Equipment equip1 = new Equipment();
		Customer cust1 = new Customer();
		
		equip1.setId(1L);
		cust1.setId(1L);

		
		Booking bookings = new Booking(cust1, equip1);
				
		assertEquals(1, bookings.getCustomer().getId());
		assertEquals(1, bookings.getEquipment().getId());
		
		Equipment equip2 = new Equipment();
		Customer cust2 = new Customer();
		
		equip2.setId(2L);
		cust2.setId(2L);
		
		bookings.setCustomer(cust2);
		bookings.setEquipment(equip2);
		
		assertEquals(2, bookings.getCustomer().getId());
		assertEquals(2, bookings.getEquipment().getId());

	}
}
