package com.ani.eshopbackend;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ani.eshopbackend.model.Supplier;



public class SupplierTest {
	
		ApplicationContext context=new ClassPathXmlApplicationContext("DbConfig.xml");
		SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
		
	 
		void testSaveSupplier()
		{
			
	    	
			Supplier supplier=new Supplier();
	        supplier.setSupplierId(332);
	        supplier.setSupplierName("abc");
	        supplier.setSupplierDescription("bbc");
	        supplier.setSupplierAddress("xyz");
	        System.out.println( "Hello World!"+sessionFactory);
	        
	        Session session=sessionFactory.openSession();
	        
	        session.save(supplier);
	        Transaction  transaction=session.beginTransaction();
	        transaction.commit();
	        
	        
	     
		}
		
	}


