package com.ani.eshopbackend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ani.eshopbackend.model.Cart;

public class CartTest {

	ApplicationContext context=new ClassPathXmlApplicationContext("dbconfig.xml");
	SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
	
	public void testSaveCart()
	{
		Cart cart=new Cart();
		cart.setCartdId(12345);
		cart.setProductId(11);
		cart.setProductName("abc");
		cart.setProductprice(1122);
		cart.setProductQuantity(2);
		cart.setProductSupplier("ssa");
		cart.setTotalprice(112);
System.out.println( "Hello World!"+sessionFactory);
        
        Session session=sessionFactory.openSession();
        
        session.save(cart);
        Transaction  transaction=session.beginTransaction();
        transaction.commit();
	
	}
}
