package com.example.collection;

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
		
		// Address1 user to database
		Address address1 = new Address();
		address1.setCity("ranchi");
		address1.setCountry("India");
		address1.setStreet("galaxy");
		
		EmployeeCollection employee = new EmployeeCollection();
		employee.setFirstName("syed");
		employee.setLastName("saifi");
		employee.setSalary(500300);
		employee.getAddress().add(address);
		employee.getAddress().add(address1);
	    
	    session.save(employee);
		
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
