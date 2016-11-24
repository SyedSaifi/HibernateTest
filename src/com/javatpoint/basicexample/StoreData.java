package com.javatpoint.basicexample;  
  
import org.hibernate.HibernateException;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;  
  
public class StoreData {  
public static void main(String[] args) {  
      
    /*Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml"); 
      
    SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();*/  
	Session session=new AnnotationConfiguration()  
	         .configure().buildSessionFactory().openSession();  
      
    
    try{
    Transaction t=session.beginTransaction();  
          
    Employee e1=new Employee();  
    e1.setId(1);  
    e1.setFirstName("yasra");  
    e1.setLastName("shakil");  
      
    session.persist(e1);//persisting the object  
      
    t.commit();
    System.out.println("successfully saved");  
    }catch(HibernateException e){
		e.printStackTrace();
	}finally{
    session.close();
	}
}  
} 