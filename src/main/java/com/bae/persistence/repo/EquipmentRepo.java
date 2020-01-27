package com.bae.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Equipment;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, Long> {

}