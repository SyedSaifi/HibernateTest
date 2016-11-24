package com.javatutorials.crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class TestUserDetailsCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		try{
		session.beginTransaction();
		
		//Create User in DB
		for(int i=0;i<10;i++){
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName("User"+i);
		session.save(userDetails);
		}
		
		//Fetching user form database
		UserDetails us = (UserDetails) session.get(UserDetails.class, 6);
        System.out.println("The use is :: "+us.getUserName());
        
        //Delete user from DB
        session.delete(us);
        
        //Update user in DB
        UserDetails us1 = (UserDetails) session.get(UserDetails.class, 5);
        us1.setUserName("Updated user");
        session.update(us1);
        
        
	    session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
	    session.close();
		}
	}

}
