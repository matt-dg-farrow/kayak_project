package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistence.domain.Booking;
import com.bae.service.BookingService;

@RestController
public class BookingController {

	private BookingService service;

	@Autowired
	public BookingController(BookingService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createBooking")
	public Booking createBooking(@RequestBody Booking booking) {
		return this.service.createBooking(booking);
	}

	@GetMapping("/getBooking")
	public List<Booking> getBooking(@PathVariable Long id) {
		return this.service.readBookings();
	}

	@PutMapping("/updateBooking")
	public Booking updateBooking(@PathParam("id") Long id, @RequestBody Booking booking) {
		return this.service.updateBooking(booking, id);
	}

	@DeleteMapping("/deleteBooking/{id}")
	public void deleteBooking(@PathVariable Long id) {
		this.service.deleteBooking(id);
	}

	@DeleteMapping("/deleteAllBookings")
	public void deleteAll() {
		this.service.deleteAll();
	}

}
