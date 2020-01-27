package com.bae.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "custId")
	private Long id;

	private String custFirstName;
	private String custSurname;
	private String emergFirstName;
	private String emergSurname;
	private String emergContactNumber;
	private String emergRelation;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private List<Equipment> equipment;

	public Customer() {
		super();
	}

	public Customer(String custFirstName, String custSurname, String emergFirstName, String emergSurname,
			String contactNumber, String emergRelation) {
		super();
		this.custFirstName = custFirstName;
		this.custSurname = custSurname;
		this.emergFirstName = emergFirstName;
		this.emergSurname = emergSurname;
		this.emergContactNumber = contactNumber;
		this.emergRelation = emergRelation;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custFirstName=" + custFirstName + ", custSurname=" + custSurname
				+ ", emergFirstName=" + emergFirstName + ", emergSurname=" + emergSurname + ", contactNumber="
				+ emergContactNumber + ", emergRelation=" + emergRelation + ", equipment=" + equipment + "]";
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

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

}
