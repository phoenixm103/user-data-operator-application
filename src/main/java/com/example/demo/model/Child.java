package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Child {
	@Id
	String civilId;
	String firstname;
	String lastname;
	Parent parent;

	public String getCivilId() {
		return civilId;
	}

	public void setCivilId(String civilId) {
		this.civilId = civilId;
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

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Child(String civilId, String firstname, String lastname, Parent parent) {
		super();
		this.civilId = civilId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.parent = parent;
	}

	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}

}
