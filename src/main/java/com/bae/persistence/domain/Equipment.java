package com.bae.persistence.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipId")
	private Long id;
	private String equipType;
	private int price;

	@OneToMany(mappedBy = "customer")
	private Set<Booking> bookings;

	public Equipment() {
		super();
	}

	public Equipment(String equipType, int price) {
		super();
		this.equipType = equipType;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", equipType=" + equipType + ", price=" + price + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

}
