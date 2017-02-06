package com.example.Inheritance.SingleTable;

import org.hibernate.*;  
import org.hibernate.cfg.*;  
  
public class StoreData {  
public static void main(String[] args) {  
    AnnotationConfiguration cfg=new AnnotationConfiguration();  
    Session session=cfg.configure("hibernate.cfg.xml").buildSessionFactory().openSession();  
    
    try{
    Transaction t=session.beginTransaction();  
      
    EmployeeX e1=new EmployeeX();  
    e1.setName("sonoo");  
      
    Regular_Employee e2=new Regular_Employee();  
    e2.setName("Vivek Kumar");  
    e2.setSalary(50000);  
    e2.setBonus(5);  
      
    Contract_Employee e3=new Contract_Employee();  
    e3.setName("Arjun Kumar");  
    e3.setPay_per_hour(1000);  
    e3.setContract_duration("15 hours");  
      
    session.persist(e1);  
    session.persist(e2);  
    session.persist(e3);  
      
    t.commit();  
    System.out.println("success"); 
    }catch(HibernateException e){
		e.printStackTrace();
	}finally{
    session.close();
	}
}  
}  
