package com.cognizant.bloodbank.model;

import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ro_id")
	private int id;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String name, Set<User> userlist) {
		super();
		this.id = id;
		this.name = name;
		this.userlist = userlist;
	}

	public Role(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", userlist=" + userlist + "]";
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

	public Set<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(Set<User> userlist) {
		this.userlist = userlist;
	}

	@Column(name = "ro_name")
	private String name;
	
	@ManyToMany(mappedBy="userroleList")
	private Set<User> userlist;
}
