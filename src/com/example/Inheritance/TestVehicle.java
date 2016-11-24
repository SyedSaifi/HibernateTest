package com.example.Inheritance;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class TestVehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		try{
		Transaction tx = session.beginTransaction();
		
		GenericVehicle vehicle = new GenericVehicle();
		//vehicle.setVehicleId(1);
		vehicle.setVehicleName("car1");
		
		TwoWheelerVehicle twoWheelerVehicle = new TwoWheelerVehicle();
		//twoWheelerVehicle.setVehicleId(2);
		twoWheelerVehicle.setVehicleName("plusar");
		twoWheelerVehicle.setStrearingHandle("plusar strearing Handle");
		
		FourWheelerVehicle fourWheelerVehicle = new FourWheelerVehicle();
		//fourWheelerVehicle.setVehicleId(3);
		fourWheelerVehicle.setVehicleName("porsche");
		fourWheelerVehicle.setStrearingWheel("porsche strearing Wheel");
		
		
	    
	    session.save(vehicle);
	    session.save(twoWheelerVehicle);
	    session.save(fourWheelerVehicle);
		
	    tx.commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
	    session.close();
		}
	}

}
