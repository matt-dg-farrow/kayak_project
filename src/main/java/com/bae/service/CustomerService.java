package com.bae.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.repo.CustomerRepo;
import com.bae.persistence.repo.EquipmentRepo;

@Service
public class CustomerService {

	private CustomerRepo custRepo;

	private EquipmentRepo equipRepo;

	public CustomerService(CustomerRepo custRepo, EquipmentRepo repo) {
		super();
		this.custRepo = custRepo;
		this.equipRepo = repo;
	}

	public void customerSetEquip(Customer customer) {
		if (customer.getEquipment() != null) {
			customer.setEquipment(customer.getEquipment().stream()
					.map(equip -> equipRepo.findById(equip.getId()).orElseThrow(EntityNotFoundException::new))
					.collect(Collectors.toList()));
		} else {
			customer.setEquipment(null);
		}
	}

	public Customer createCust(Customer customer) throws CapacityReachedException {
		if (capacity() < 300) {
			customerSetEquip(customer);
			return this.custRepo.save(customer);
		} else {
			throw new CapacityReachedException();
		}
	}

	public int custEquipCost(Long id) {
		Customer cust = this.custRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		if (cust.getEquipment() != null) {
			return cust.getEquipment().stream().map(equip -> equip.getPrice()).reduce((acc, next) -> (acc + next))
					.orElse(0);
		}
		else {
			return 0;
		}

	}

	public List<Customer> getAllCustomers() {
		return this.custRepo.findAll();
	}
	
	public Customer getOneCustomer(Long id) {
		return this.custRepo.getOne(id);
	}

	public Customer updateCustomer(Customer cust, Long id) {
		Customer custToBeUpdated = this.custRepo.getOne(id);
		custToBeUpdated.setCustFirstName(cust.getCustFirstName());
		custToBeUpdated.setCustSurname(cust.getCustSurname());
		custToBeUpdated.setEmergFirstName(cust.getEmergFirstName());
		custToBeUpdated.setEmergSurname(cust.getEmergSurname());
		custToBeUpdated.setEmergContactNumber(cust.getEmergContactNumber());
		custToBeUpdated.setEmergRelation(cust.getEmergRelation());
		customerSetEquip(cust);

		custToBeUpdated.setEquipment(cust.getEquipment());

		return this.custRepo.save(custToBeUpdated);
	}

	public void deleteCustomer(Long id) {
		this.custRepo.deleteById(id);
	}

	public void deleteAll() {
		this.custRepo.deleteAll();
	}

	public Long capacity() {
		return this.custRepo.count();
	}
}
