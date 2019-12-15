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

import com.bae.persistence.domain.Equipment;
import com.bae.service.EquipmentService;

@RestController
public class EquipmentController {

	private EquipmentService service;

	@Autowired
	public EquipmentController(EquipmentService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createEquipment")
	public Equipment createEquipment(@RequestBody Equipment equip) {
		return this.service.createEquipment(equip);
	}

	@GetMapping("/getEquipment")
	public List<Equipment> getEquipment(@PathVariable Long id) {
		return this.service.readEquipments();
	}

	@PutMapping("/updateEquipment")
	public Equipment updateEquipment(@PathParam("id") Long id, @RequestBody Equipment equip) {
		return this.service.updateEquipment(equip, id);
	}

	@DeleteMapping("/deleteEquipment/{id}")
	public void deleteEquipment(@PathVariable Long id) {
		this.service.deleteEquipment(id);
	}

}
