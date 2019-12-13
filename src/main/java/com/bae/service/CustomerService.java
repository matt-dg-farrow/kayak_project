package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.repo.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo custRepo;

	public CustomerService(CustomerRepo custRepo) {
		super();
		this.custRepo = custRepo;
	}

	public Customer createCust(Customer customer) {
		return this.custRepo.save(customer);

	}

	public List<Customer> readCustomers() {
		List<Customer> customers = this.custRepo.findAll();
		return customers;
	}

	public Customer updateCustomer(Customer cust, Long id) {
		Customer custToBeUpdated = this.custRepo.getOne(id);
		custToBeUpdated.setCustFirstName(cust.getCustFirstName());
		custToBeUpdated.setCustSurname(cust.getCustSurname());
		custToBeUpdated.setEmergFirstName(cust.getEmergFirstName());
		custToBeUpdated.setEmergSurname(cust.getEmergSurname());
		custToBeUpdated.setEmergContactNumber(cust.getEmergContactNumber());
		custToBeUpdated.setEmergRelation(cust.getEmergRelation());
		return this.custRepo.save(custToBeUpdated);
	}

	public void deleteCustomer(Long id) {
		this.custRepo.deleteById(id);
	}
	
	public void deleteAll() {
		this.custRepo.deleteAll();
	}
}
