package com.example.hql;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class TestEmployeeDetailsHql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		try{
		session.beginTransaction();
		
		//--------------------------------------------------------------------------------------------------------------
		//1. Create User in DB
		for(int i=1;i<=5;i++){
			EmployeeDetails employeeDetails = new EmployeeDetails();
			employeeDetails.setUserName("User"+i);
		session.persist(employeeDetails);
		}
		
		session.getTransaction().commit();
		
		//--------------------------------------------------------------------------------------------------------------
		//2. Select query
		/*Query query = session.createQuery("select userName from EmployeeDetails where userId=:userId and userName = :userName");
		query.setParameter("userId", 5);
		query.setParameter("userName", "User5");
		List<String> employee = (List<String>) query.list();*/
		
		//--------------------------------------------------------------------------------------------------------------
		//2. Update query
		/*Query query = session.createQuery("Update EmployeeDetails set userName = :userName where userId=:userId");
		query.setParameter("userId", 5);
		query.setParameter("userName", "talib");
		query.executeUpdate();*/
		
		//--------------------------------------------------------------------------------------------------------------
		//3. Aggregate function
		/*Query query = session.createQuery("select max(userId) from EmployeeDetails");
		System.out.println(query.uniqueResult());*/
		
		//--------------------------------------------------------------------------------------------------------------
		//4. Pagination
		Query query = session.createQuery("select userName from EmployeeDetails");
		query.setFirstResult(2);
		query.setMaxResults(3);
		List<String> employee = (List<String>) query.list();
		
        //------------------------------------------------------------------------------------------------------------
		
	    for(String emp: employee)
	    System.out.println(emp);
	    
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
	    session.close();
		}
	}

}
