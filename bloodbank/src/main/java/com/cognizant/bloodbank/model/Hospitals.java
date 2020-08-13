package com.cognizant.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "hospital")
public class Hospitals {





	public Hospitals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospitals(int id, String name, String state, String area, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.area = area;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Hospitals [id=" + id + ", name=" + name + ", state=" + state + ", area=" + area + ", pincode=" + pincode
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hp_id")
	private int id;
	
	@Column(name = "hp_name")
	private String name;
	
	@Column(name = "hp_state")
	private String state;
	
	@Column(name = "hp_area")
	private String area;
	
	@Column(name = "hp_pincode")
	private int pincode;
	


}
