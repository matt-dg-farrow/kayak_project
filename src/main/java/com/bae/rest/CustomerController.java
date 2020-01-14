package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.CapacityReachedException;
import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Equipment;
import com.bae.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createCustomer")
	public Customer createCustomer(@RequestBody Customer cust) throws CapacityReachedException {
		return this.service.createCust(cust);
	}
	
	@PatchMapping("/rentEquip/{id}")
	public void rentEquip(@PathVariable Long id, @RequestBody List<String> equipTypes) {
		this.service.rentEquip(id, equipTypes);
	}

	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		return this.service.getAllCustomers();
	}

	@GetMapping("/getCustomer/{id}")
	public Customer getOneCustomer(@PathVariable Long id) {
		return this.service.getOneCustomer(id);
	}

	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@PathParam("id") Long id, @RequestBody Customer cust) {
		return this.service.updateCustomer(cust, id);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		this.service.deleteCustomer(id);
	}

	@DeleteMapping("/deleteAllCustomers")
	public void deleteAll() {
		this.service.deleteAll();
	}

	@GetMapping("/getCapacity")
	public Long getCapacity() {
		return this.service.capacity();
	}
}
