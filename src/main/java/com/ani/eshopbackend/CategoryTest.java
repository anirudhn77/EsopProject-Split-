package com.ani.eshopbackend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.ani.eshopbackend.model.Category;

	

public class CategoryTest {
	ApplicationContext context=new ClassPathXmlApplicationContext("dbconfig.xml");
	SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
	
 
	void testSaveCategory()
	{
		
    	
		Category  category=new Category();
        category.setCategoryId(1234556);
        category.setCategoryName("abc");
        category.setCategoryDescription("bbc");

System.out.println( "Hello World!"+sessionFactory);
        
        Session session=sessionFactory.openSession();
        
        session.save(category);
        Transaction  transaction=session.beginTransaction();
        transaction.commit();
        
        
     
	}
	
}


