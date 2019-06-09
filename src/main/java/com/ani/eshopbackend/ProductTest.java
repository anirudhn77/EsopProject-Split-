package com.ani.eshopbackend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ani.eshopbackend.model.Product;

public class ProductTest {
	
	ApplicationContext context=new ClassPathXmlApplicationContext("dbconfig.xml");
	SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
	
	public void testSaveProduct()
	{
		Product product=new Product();
		product.setProductID(212);
		product.setProductName("s1");
		product.setProductDescription("abc");
		product.setProductPrice(112);
		product.setProductCategory("mobile");
		product.setProductSupplier("bajaj");

System.out.println( "Hello World!"+sessionFactory);
        
        Session session=sessionFactory.openSession();
        
        session.save(product);
        Transaction  transaction=session.beginTransaction();
        transaction.commit();
	}
	

}
