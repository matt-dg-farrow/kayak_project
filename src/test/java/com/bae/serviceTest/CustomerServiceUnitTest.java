package com.bae.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Customer;
import com.bae.persistence.domain.Equipment;
import com.bae.persistence.repo.CustomerRepo;
import com.bae.persistence.repo.EquipmentRepo;
import com.bae.service.CustomerService;
import com.bae.utilities.CapacityReachedException;

@RunWith(SpringRunner.class)
public class CustomerServiceUnitTest {

	@InjectMocks
	private CustomerService service;

	@Mock
	private CustomerRepo custRepo;
	@Mock
	private EquipmentRepo equipRepo;

	private Customer cust1;
	private Customer cust2;
	private Equipment equip1;
	private List<Equipment> equipList;
	private List<Customer> customers;

	@Before
	public void init() {
		this.equipList = new ArrayList<>();
		this.customers = new ArrayList<>();
		this.cust1 = new Customer("Bill", "Billy", "Bob", "Bobby", "07779111222", "Brother");
		this.cust2 = new Customer("Sue", "Bills", "Steve", "Billington", "07742333444", "Father");
		this.cust2.setId(2L);
		this.equip1 = new Equipment("kayak", 60);
		this.equip1.setId(1L);
		this.equipList.add(equip1);
		this.cust2.setEquipment(equipList);
		customers.add(cust1);
	
		
	}

	@Test
	public void createCustomerTest() {
		Mockito.when(custRepo.save(cust1)).thenReturn(cust1);
		try {
			assertEquals(cust1, this.service.createCust(cust1));
		} catch (CapacityReachedException e) {
			e.printStackTrace();
		}

		verify(this.custRepo, times(1)).save(this.cust1);

	}

	@Test(expected = CapacityReachedException.class)
	public void createTestAtMaxCap() throws CapacityReachedException {
		Mockito.when(service.capacity()).thenReturn(301L);
		this.service.createCust(cust1);
	}

	@Test
	public void updateCustomerTest() {
		Mockito.when(custRepo.getOne(1L)).thenReturn(cust1);
		Mockito.when(equipRepo.findById(equip1.getId())).thenReturn(Optional.of(equip1));
		service.updateCustomer(cust2, 1L);
		assertEquals("Sue", customers.get(0).getCustFirstName());
		Mockito.when(custRepo.save(cust1)).thenReturn(cust1);

		verify(this.custRepo, times(1)).getOne(1L);
	}

	@Test
	public void getAllCustomersTest() {
		Mockito.when(custRepo.findAll()).thenReturn(customers);
		assertEquals(customers, service.getAllCustomers());

		verify(this.custRepo, times(1)).findAll();
	}
	
	@Test
	public void getOneCustomerTest() {
		Mockito.when(custRepo.getOne(1L)).thenReturn(cust1);
		assertEquals(customers.get(0), service.getOneCustomer(1L));

		verify(this.custRepo, times(1)).getOne(1L);
	}

	@Test
	public void deleteCustomerTest() {
		Mockito.when(custRepo.getOne(1L)).thenReturn(cust1);
		this.service.deleteCustomer(1L);

		verify(this.custRepo, times(1)).deleteById(1L);
	}

	@Test
	public void deleteAllTest() {
		Mockito.when(custRepo.findAll()).thenReturn(customers);
		this.service.deleteAll();

		verify(this.custRepo, times(1)).deleteAll();
	}

	@Test
	public void capacityTest() {
		Mockito.when(custRepo.count()).thenReturn(Long.valueOf(customers.size()));
		
		
		assertEquals(1, (long) this.service.capacity());
	}
	
	@Test
	public void custNoEquipCostTest() {
		Mockito.when(custRepo.findById(1L)).thenReturn(Optional.of(cust1));
		assertEquals(0, this.service.custEquipCost(1L));
	}
	
	@Test
	public void custEquipCostTest() {
		customers.add(cust2);
		Mockito.when(custRepo.findById(2L)).thenReturn(Optional.of(cust2));
		assertEquals(60, this.service.custEquipCost(2L));
	}
	
	@Test
	public void rentEquipTest() {
		List<String> equipTypesTest = new ArrayList<>();
		equipTypesTest.add("kayak");
		
		System.out.println(equipList.get(0).getEquipType());
		Mockito.when(custRepo.findById(1L)).thenReturn(Optional.of(cust1));
		Mockito.when(equipRepo.findAll()).thenReturn(equipList);
		Mockito.when(custRepo.save(cust1)).thenReturn(cust1);
				
		assertEquals(cust1, service.rentEquip(1L, equipTypesTest));
		
	}
	
	@Test
	public void getStockTest() {
		List<Integer> testListOfInts = new ArrayList<>();
		testListOfInts.add(1);
		testListOfInts.add(1);
		testListOfInts.add(1);
		testListOfInts.add(1);
		Equipment equip2 = new Equipment("helmet", 15);
		Equipment equip3 = new Equipment("BA", 30);
		Equipment equip4 = new Equipment("paddle", 20);
		equipList.add(equip2);
		equipList.add(equip3);
		equipList.add(equip4);
		
		Mockito.when(equipRepo.findAll()).thenReturn(equipList);
		
		assertEquals(testListOfInts, service.getStock());
	}

}
