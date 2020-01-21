package com.bae.unit.entitiesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bae.persistence.domain.Equipment;

class EquipmentTest {

	@Test
	void equipTest() {
		Equipment equip1 = new Equipment("Kayak", 60);
		
		assertEquals("Kayak", equip1.getEquipType());
		assertEquals(60, equip1.getPrice());
		
		equip1.setEquipType("Helmet");
		equip1.setPrice(30);
		
		assertEquals("Helmet", equip1.getEquipType());
		assertEquals(30, equip1.getPrice());
			
		assertEquals("Equipment [id=null, equipType=Helmet, price=30]", equip1.toString());
		
		
	}

}
