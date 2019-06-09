package com.ani.eshopbackend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ani.eshopbackend.model.User;

public class UserTest {
	ApplicationContext context=new ClassPathXmlApplicationContext("dbconfig.xml");
	SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
	
 public void testSaveUser()
 {
	 User user=new User();
	 user.setEmail("ani@");
	 user.setPassword("abcd");
	 user.setUsername("ani");
	 user.setMobileno("112233");
	 user.setAddress("hy");
	 user.setRole("ROLE_USER");
	 user.setEnabled(true);
	 
	 System.out.println( "Hello World!"+sessionFactory);
     
     Session session=sessionFactory.openSession();
     
     session.save(user);
     Transaction  transaction=session.beginTransaction();
     transaction.commit();
 }
}
