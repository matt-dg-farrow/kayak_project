package com.bae.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.persistence.domain.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

}