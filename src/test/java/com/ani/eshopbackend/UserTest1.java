package com.ani.eshopbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.ani.eshopbackend.daoimpl.UserDaoImpl;

import com.ani.eshopbackend.model.User;

public class UserTest1 {
	static AnnotationConfigApplicationContext configApplicationContext;
	static UserDaoImpl userDaoImpl;
	
	@BeforeClass
	public static void test1()
	{
		
		configApplicationContext=new AnnotationConfigApplicationContext();
		   configApplicationContext.scan("com.ani.eshopbackend");
		   configApplicationContext.refresh();
		   
		   userDaoImpl=(UserDaoImpl) configApplicationContext.getBean("usDaoImpl");
		   System.out.println(userDaoImpl);
	}
	@Test
	   public void saveUser_Positivetest()
	   {
		   
		   
		   
		User user=new User();
		 user.setEmail("ane@");
		 user.setPassword("abc");
		 user.setUsername("ane");
		 user.setMobileno("1122");
		 user.setAddress("hyd");
		 user.setRole("ROLE_USER");
		 user.setEnabled(true);
		   assertEquals("success",true,userDaoImpl.addUser(user));
		   
		   
		   
	   }
		@Test
		   public void saveUser_Negativetest()
		   {
			   
			User user=new User();
			 user.setEmail("ane@");
			 user.setPassword("abc");
			 user.setUsername("ane");
			 user.setMobileno("1122");
			 user.setAddress("hyd");
			 user.setRole("ROLE_USER");
			 user.setEnabled(true);
			   
			   
		   assertEquals("failure",false,userDaoImpl.addUser(user));
			   
			   
			   
		   }

}
