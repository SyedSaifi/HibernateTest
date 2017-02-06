package com.example.mapping.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class HibernateOneToManyAnnotationMain {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try{
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();

		//start transaction
		tx = session.beginTransaction();
		
		Cart cart = new Cart();
		cart.setName("MyCart1");
		cart.setTotal(10*1 + 20*2);
		
		Items item1 = new Items(10, 1, cart);
		Items item2 = new Items(20, 2, cart);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1); 
		itemsSet.add(item2);
		
		cart.setItems1(itemsSet);

		session.save(cart);

		tx.commit();
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

}