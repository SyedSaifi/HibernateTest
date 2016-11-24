package com.example.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class TestCreteriaAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		try{
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(EmployeeDetails.class).setProjection(Projections.property("userName"));
		//criteria.add(Restrictions.eq("userName", "User5"));
		criteria.add(Restrictions.or(Restrictions.between("userId", 0, 3), Restrictions.between("userId", 1, 2)));
		
		
		List<String> employee = (List<String>) criteria.list();
        
	    session.getTransaction().commit();
	    for(String emp: employee){
	    System.out.println(emp);
	    //System.out.println(emp.getUserId());
	    }
		}catch(HibernateException e){
			e.printStackTrace();
		}finally{
	    session.close();
		}
	}

}
