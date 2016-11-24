package com.example.Inheritance;

import javax.persistence.Entity;

@Entity
public class FourWheelerVehicle extends GenericVehicle{
	private String strearingWheel;

	public String getStrearingWheel() {
		return strearingWheel;
	}

	public void setStrearingWheel(String strearingWheel) {
		this.strearingWheel = strearingWheel;
	}
	
	

}
