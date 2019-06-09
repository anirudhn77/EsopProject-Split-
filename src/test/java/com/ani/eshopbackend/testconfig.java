package com.ani.eshopbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ani.eshopbackend.daoimpl.CategoryDaoImpl;
import com.ani.eshopbackend.model.Category;

public class testconfig {
	static AnnotationConfigApplicationContext configApplicationContext;
	static CategoryDaoImpl  categoryDaoImpl;
	@BeforeClass
	public static void test1()
	{
		
		configApplicationContext=new AnnotationConfigApplicationContext();
		   configApplicationContext.scan("com.ani.eshopbackend");
		   configApplicationContext.refresh();
		   
		   categoryDaoImpl=(CategoryDaoImpl)configApplicationContext.getBean("cateDaoImpl");
		   System.out.println(categoryDaoImpl);
	}

	@Test
   public void saveCategory_Positivetest()
   {
	   
	   
	   
	   
	   Category category=new Category();
	   category.setCategoryId(1221);
	   category.setCategoryName("abcd");
	   category.setCategoryDescription("bbcd");
	   assertEquals("success",true,categoryDaoImpl.saveCategory(category));
	   
	   
	   
   }
	@Test
	   public void saveCategory_Negativetest()
	   {
		   
		   
		   
		   
		   Category category=new Category();
		   category.setCategoryId(1221);
		   category.setCategoryName("abcd");
		   category.setCategoryDescription("bbcd");
		   assertEquals("failure",false,categoryDaoImpl.saveCategory(category));
		   
		   
		   
	   }
	
	
	
}
