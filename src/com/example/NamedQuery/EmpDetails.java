package com.example.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
@NamedQuery(name="EmployeeDetails.byId", query="select userName from EmployeeDetails where userId= ?")
//@NamedQuery(name="EmployeeDetails.byName", query="delete from EmployeeDetails where userName= ?")
@NamedNativeQuery(name="EmployeeDetails.byname", query="select * from employeedetails where User_Name = ?", resultClass=EmpDetails.class)
public class EmpDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int userId; 
	@Column(name="User_Name")
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
