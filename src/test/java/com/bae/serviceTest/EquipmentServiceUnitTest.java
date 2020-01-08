package com.bae.serviceTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistence.domain.Equipment;
import com.bae.persistence.repo.EquipmentRepo;
import com.bae.service.EquipmentService;

@RunWith(SpringRunner.class)
public class EquipmentServiceUnitTest {
	
	@InjectMocks
	private EquipmentService service;

	@Mock
	private EquipmentRepo repo;
	
	private Equipment equip1 = new Equipment("Kayak", 60);
	private Equipment equip2 = new Equipment("Helmet", 30);

	
	@Test
	public void createEquipTest() {
		Mockito.when(repo.save(equip1)).thenReturn(equip1);
		assertEquals(equip1, this.service.createEquipment(equip1));
	}
	
	@Test
	public void updateEquipTest() {
		List<Equipment> equipment = new ArrayList<>();
		equipment.add(equip1);
		Mockito.when(repo.getOne(1L)).thenReturn(equip1);
		service.updateEquipment(equip2, 1L);
		Mockito.when(repo.save(equip1)).thenReturn(equip1);

		assertEquals("Helmet", equipment.get(0).getEquipType());
		
		verify(this.repo, times(1)).getOne(1L);
	}
	
	@Test
	public void readEquipTest() {
		List<Equipment> equipment = new ArrayList<>();
		equipment.add(equip1);
		Mockito.when(repo.findAll()).thenReturn(equipment);
		assertTrue(this.service.readEquipments().size() > 0);
		
		verify(this.repo, times(1)).findAll();
		
	}
	
	@Test
	public void deleteEquipTest() {
		
		this.service.deleteEquipment(1L);
		
		verify(this.repo, times(1)).deleteById(1L);
		
	}
	
	@Test
	public void deleteAllTest() {
		this.service.deleteAll();
		
		verify(this.repo, times(1)).deleteAll();
	}
	
	


}
