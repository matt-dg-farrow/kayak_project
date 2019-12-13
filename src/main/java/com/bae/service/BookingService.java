package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Booking;
import com.bae.persistence.domain.Equipment;
import com.bae.persistence.repo.BookingRepo;

@Service
public class BookingService {

	private BookingRepo bookingRepo;

	public BookingService(BookingRepo bookingRepo) {
		super();
		this.bookingRepo = bookingRepo;
	}

	public Booking createBooking(Booking booking) {
		return this.bookingRepo.save(booking);

	}

	public List<Booking> readBookings() {
		List<Booking> bookings = this.bookingRepo.findAll();
		return bookings;
	}

	public Booking updateBooking(Booking booking, Long id) {
		Booking bookingToBeUpdated = this.bookingRepo.getOne(id);
		bookingToBeUpdated.setCustomer(booking.getCustomer());
		bookingToBeUpdated.setEquipment(booking.getEquipment());
		return this.bookingRepo.save(bookingToBeUpdated);
	}

	public void deleteBooking(Long id) {
		this.bookingRepo.deleteById(id);
	}
	
	public void deleteAll() {
		this.bookingRepo.deleteAll();
	}

}
