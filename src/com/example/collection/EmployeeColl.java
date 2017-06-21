package com.example.collection;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class EmployeeColl
{ 
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id; 
	@Column(name="First_Name")
	private String firstName; 
	@Column(name="Last_Name")
	private String lastName; 
	@Column(name="SALARY")
	private int salary; 
	@ElementCollection
	@JoinTable(name="EMPLOYEE_ADDRESS",
				joinColumns=@JoinColumn(name="ID"))
	@GenericGenerator(name = "hilo-exp", strategy = "hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-exp", type = @Type(type="long"))
	private Collection<Address> address = new ArrayList<Address>();
	
	public EmployeeColl() {
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Collection<Address> getAddress() {
		return address;
	}

	public void setAddress(Collection<Address> address) {
		this.address = address;
	}


	
	
}