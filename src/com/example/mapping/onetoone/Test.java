package com.example.mapping.onetoone;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		try{
		session.beginTransaction();
		
		//Address1 user to database
		Address address = new Address();
		address.setCity("jamshedpur");
		address.setCountry("India");
		address.setStreet("Ashiana");
		session.save(address);
		
		Users user = new Users();
		user.setFirstName("syed");
		user.setLastName("saifi");
		user.setAddress(address);
	    
	    session.save(user);
		
		//Fetching user form database
		/*Employee employee = new Employee();
		employee = (Employee) session.get(Employee.class, 1);
		
        System.out.println("The use is :: "+employee.getFirstName());*/
        
        
	    session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
	    session.close();
		}
	}

}
