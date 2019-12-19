package com.bae.serviceTest;

import static org.junit.Assert.assertTrue;
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

import com.bae.persistence.domain.Booking;
import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Equipment;
import com.bae.persistence.repo.BookingRepo;
import com.bae.service.BookingService;

@RunWith(SpringRunner.class)
public class BookingServiceTest {
	
	
	@InjectMocks
	private BookingService service;

	@Mock
	private BookingRepo repo;
	
	
	
	private Equipment equip1 = new Equipment("Kayak", 60);
	private Equipment equip2 = new Equipment("Helmet", 30);
	
	private Customer cust1 = new Customer("Bill", "Billy", "Bob", "Bobby", "07779111222", "Brother");
	private Customer cust2 = new Customer("Sue", "Bills", "Steve", "Billington", "07742333444", "Father");

	
	private Booking booking1 = new Booking(cust1, equip1);
	private Booking booking2 = new Booking(cust2, equip2);
	
	@Before
	public void init() {
		this.cust1.setId(1L);
		this.cust2.setId(2L);
		this.equip1.setId(1L);
		this.equip2.setId(2L);

	}

	@Test
	public void createBookingTest() {
		Mockito.when(repo.save(booking1)).thenReturn(booking1);
		assertEquals(booking1, this.service.createBooking(booking1));
		
	}
	
	@Test
	public void updateBookingTest() {
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking1);
		Mockito.when(repo.getOne(1L)).thenReturn(booking1);
		service.updateBooking(booking2, 1L);
		Mockito.when(repo.save(booking1)).thenReturn(booking1);

		assertEquals(cust2, bookings.get(0).getCustomer());
		
		
		verify(this.repo, times(1)).getOne(1L);
	}
	
	@Test
	public void readBookingTest() {
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking1);
		Mockito.when(repo.findAll()).thenReturn(bookings);
		assertTrue(this.service.readBookings().size() > 0);
		
		verify(this.repo, times(1)).findAll();
		
	}
	
	@Test
	public void deleteBookingTest() {
		
		this.service.deleteBooking(1L);
		
		verify(this.repo, times(1)).deleteById(1L);
		
	}
	
	@Test
	public void deleteAllTest() {
		this.service.deleteAll();
		
		verify(this.repo, times(1)).deleteAll();
	}


}
