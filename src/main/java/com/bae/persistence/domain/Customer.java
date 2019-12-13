package com.bae.persistence.domain;

import java.text.DecimalFormat;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custId")
	private Long id;

	private String custFirstName;
	private String custSurname;
	private String emergFirstName;
	private String emergSurname;
	private String emergContactNumber;
	private String emergRelation;

	@OneToMany(mappedBy = "customer")
	private Set<Booking> bookings;

	public Customer() {
		super();
	}

	public Customer(String custFirstName, String custSurname, String emergFirstName, String emergSurname,
			String contactNumber, String emergRelation, Booking... bookings) {
		super();
		this.custFirstName = custFirstName;
		this.custSurname = custSurname;
		this.emergFirstName = emergFirstName;
		this.emergSurname = emergSurname;
		this.emergContactNumber = contactNumber;
		this.emergRelation = emergRelation;
		this.bookings = Stream.of(bookings).collect(Collectors.toSet());
		this.bookings.forEach(x -> x.setCustomer(this));
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custFirstName=" + custFirstName + ", custSurname=" + custSurname
				+ ", emergFirstName=" + emergFirstName + ", emergSurname=" + emergSurname + ", contactNumber="
				+ emergContactNumber + ", emergRelation=" + emergRelation + ", bookings=" + bookings + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustSurname() {
		return custSurname;
	}

	public void setCustSurname(String custSurname) {
		this.custSurname = custSurname;
	}

	public String getEmergFirstName() {
		return emergFirstName;
	}

	public void setEmergFirstName(String emergFirstName) {
		this.emergFirstName = emergFirstName;
	}

	public String getEmergSurname() {
		return emergSurname;
	}

	public void setEmergSurname(String emergSurname) {
		this.emergSurname = emergSurname;
	}

	public String getEmergContactNumber() {
		return emergContactNumber;
	}

	public void setEmergContactNumber(String i) {
		this.emergContactNumber = i;
	}

	public String getEmergRelation() {
		return emergRelation;
	}

	public void setEmergRelation(String emergRelation) {
		this.emergRelation = emergRelation;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

}
