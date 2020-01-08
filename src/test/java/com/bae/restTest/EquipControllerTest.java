package com.bae.restTest;

//import static org.junit.Assert.assertEquals;
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

import com.bae.persistence.domain.Equipment;
import com.bae.rest.EquipmentController;
import com.bae.service.EquipmentService;

@RunWith(SpringRunner.class)
public class EquipControllerTest {

	@InjectMocks
	private EquipmentController controller;
	
	@Mock
	private EquipmentService service;
	
	private Equipment equip1 = new Equipment("Kayak", 60);
	private Equipment equip2 = new Equipment("Helmet", 30);
	private List<Equipment> equipment;
	
	@Before
	public void before() {
		this.equipment = new ArrayList<>();
		this.equipment.add(equip1);
		this.equipment.add(equip2);
	}
	
	@Test
	public void createEquipTest() {
		Mockito.when(service.createEquipment(equip1)).thenReturn(equip1);
		assertEquals(equip1, this.controller.createEquipment(equip1));
		verify(this.service, times(1)).createEquipment(this.equip1);
	}
	
	@Test
	public void updateEquipTest() {
		Mockito.when(service.updateEquipment(equip2, 1L)).thenReturn(equip2);
		assertEquals("Helmet", controller.updateEquipment(1L, equip2).getEquipType());
		verify(this.service, times(1)).updateEquipment(equip2, 1L);

	}

	@Test
	public void getEquipmentTest() {
		Mockito.when(service.readEquipments()).thenReturn(this.equipment);
		assertEquals(this.equipment, controller.getEquipment());
		verify(this.service, times(1)).readEquipments();

	}

	@Test
	public void deleteEquipment() {
		this.controller.deleteEquipment(1L);
		verify(this.service, times(1)).deleteEquipment(1L);
	}

	@Test
	public void deleteAllTest() {
		this.controller.deleteAll();
		verify(this.service, times(1)).deleteAll();
	}

}
