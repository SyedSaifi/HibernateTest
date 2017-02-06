package com.example.Inheritance.TablePerConcreteClass;

import javax.persistence.*;  

@Entity  
public class Regular_EmployeeZ extends EmployeeZ{  
      
@Column(name="salary")    
private float salary;  
  
@Column(name="bonus")     
private int bonus;

public float getSalary() {
	return salary;
}

public void setSalary(float salary) {
	this.salary = salary;
}

public int getBonus() {
	return bonus;
}

public void setBonus(int bonus) {
	this.bonus = bonus;
}  

}  