package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistence.domain.Equipment;
import com.bae.persistence.repo.EquipmentRepo;

@Service
public class EquipmentService {

	private EquipmentRepo equipRepo;

	public EquipmentService(EquipmentRepo equipRepo) {
		super();
		this.equipRepo = equipRepo;
	}

	public Equipment createEquipment(Equipment equip) {
		return this.equipRepo.save(equip);

	}

	public List<Equipment> readEquipments() {
		return this.equipRepo.findAll();
	}

	public Equipment updateEquipment(Equipment equip, Long id) {
		Equipment equipToBeUpdated = this.equipRepo.getOne(id);
		equipToBeUpdated.setEquipType(equip.getEquipType());
		equipToBeUpdated.setPrice(equip.getPrice());
		return this.equipRepo.save(equipToBeUpdated);
	}

	public void deleteEquipment(Long id) {
		this.equipRepo.deleteById(id);
	}

}
