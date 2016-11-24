package com.example.NamedQuery;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class TestNamedQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		try{
		session.beginTransaction();
		
		//Query query = session.getNamedQuery("EmployeeDetails.byId");
		//query.setInteger(0, 5);
		
		Query query = session.getNamedQuery("EmployeeDetails.byname");
		query.setString(0, "User5");
		
		
		
		List<EmpDetails> employee = (List<EmpDetails>) query.list();
        
	    session.getTransaction().commit();
	    for(EmpDetails emp: employee){
	    System.out.println(emp.getUserName());
	    System.out.println(emp.getUserId());
	    }
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
	    session.close();
		}
	}

}
