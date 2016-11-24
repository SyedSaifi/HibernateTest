package com.example.Inheritance;

import javax.persistence.Entity;

@Entity
public class TwoWheelerVehicle extends GenericVehicle{
	private String strearingHandle;

	public String getStrearingHandle() {
		return strearingHandle;
	}

	public void setStrearingHandle(String strearingHandle) {
		this.strearingHandle = strearingHandle;
	}

	
}
