package com.example.Inheritance.TablePerSubclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle_FourWheeler")
public class FourWheelerVehicle extends GenericVehicle{
	private String strearingWheel;

	public String getStrearingWheel() {
		return strearingWheel;
	}

	public void setStrearingWheel(String strearingWheel) {
		this.strearingWheel = strearingWheel;
	}

}
