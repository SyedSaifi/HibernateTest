package com.example.mapping.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Users 
{ 
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	
	@Column(name="First_Name")
	private String firstName; 
	
	@Column(name="Last_Name")
	private String lastName; 
	
	@OneToOne
	@PrimaryKeyJoinColumn
	//@JoinColumn(unique= true)
	private Address address;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
