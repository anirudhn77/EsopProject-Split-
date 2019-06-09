package com.ani.eshopbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ani.eshopbackend.daoimpl.ProductDaoImpl;

import com.ani.eshopbackend.model.Product;



public class ProductTest1 {
	static AnnotationConfigApplicationContext configApplicationContext;
	static ProductDaoImpl productDaoImpl;
	@BeforeClass
	public static void test1()
	{
		
		configApplicationContext=new AnnotationConfigApplicationContext();
		   configApplicationContext.scan("com.ani.eshopbackend");
		   configApplicationContext.refresh();
		   
		   productDaoImpl=(ProductDaoImpl) configApplicationContext.getBean("proDaoImpl");
		   System.out.println(productDaoImpl);
	}

	@Test
   public void saveProduct_Positivetest()
   {
	   
	   
	   

		Product product=new Product();
		product.setProductID(212111);
		product.setProductName("s2");
		product.setProductDescription("bbc");
		product.setProductPrice(1123);
		product.setProductCategory("mobiles");
		product.setProductSupplier("baj");
	   assertEquals("success",true,productDaoImpl.saveProduct(product));
	   
	   
	   
   }
	@Test
	   public void saveProduct_Negativetest()
	   {
		   
		   
		   
		   

		Product product=new Product();
		product.setProductID(212111);
		product.setProductName("s2");
		product.setProductDescription("bbc");
		product.setProductPrice(1123);
		product.setProductCategory("mobiles");
		product.setProductSupplier("baj");
	   assertEquals("failure",false,productDaoImpl.saveProduct(product));
		   
		   
		   
	   }
	
	
	
}



