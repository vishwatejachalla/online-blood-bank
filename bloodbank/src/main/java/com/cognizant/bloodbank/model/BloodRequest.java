package com.cognizant.bloodbank.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "blood_request")
public class BloodRequest {
	public BloodRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BloodRequest(int id, String bloodgroup, String name, String contactnumber, String state, String area,
			int pincode) {
		super();
		this.id = id;
		this.bloodgroup = bloodgroup;
		this.name = name;
		this.contactnumber = contactnumber;
		this.state = state;
		this.area = area;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "BloodRequest [id=" + id + ", bloodgroup=" + bloodgroup + ", name=" + name + ", contactnumber="
				+ contactnumber + ", state=" + state + ", area=" + area + ", pincode=" + pincode + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
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
	@Column(name = "req_id")
	private int id;
	
	@Column(name = "req_bloodgroup")
	private String bloodgroup;
	
	@Column(name = "req_name")
	private String name;
	
	@Column(name = "req_contactnumber")
	private String contactnumber;
	
	@Column(name = "req_state")
	private String state;
	
	@Column(name = "req_area")
	private String area;
	
	@Column(name = "req_pincode")
	private int pincode;
	
	
	

	
	

}
