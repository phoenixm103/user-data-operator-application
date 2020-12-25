package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Parent {
	@Id
	String civilId;
	String firstname;
	String lastname;
	Address address;

	public Parent() {
		super();
	}

	public Parent(String civilId, String firstname, String lastname, Address address) {
		super();
		this.civilId = civilId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}

	public String getCivilId() {
		return civilId;
	}

	public void setCivilId(String id) {
		this.civilId = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
