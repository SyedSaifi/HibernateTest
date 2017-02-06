package com.example.Inheritance.TablePerSubclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle_TwoWheeler")
public class TwoWheelerVehicle extends GenericVehicle{
	private String strearingHandle;

	public String getStrearingHandle() {
		return strearingHandle;
	}

	public void setStrearingHandle(String strearingHandle) {
		this.strearingHandle = strearingHandle;
	}

}
