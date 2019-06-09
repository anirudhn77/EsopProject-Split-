package com.ani.eshopbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ani.eshopbackend.daoimpl.SupplierDaoImpl;
import com.ani.eshopbackend.model.Supplier;



public class SupplierTest1 {
	static AnnotationConfigApplicationContext configApplicationContext;
	static SupplierDaoImpl supplierDaoImpl;
	@BeforeClass
	public static void test1()
	{
		
		configApplicationContext=new AnnotationConfigApplicationContext();
		   configApplicationContext.scan("com.ani.eshopbackend");
		   configApplicationContext.refresh();
		   
		   supplierDaoImpl=(SupplierDaoImpl) configApplicationContext.getBean("suppDaoImpl");
		   System.out.println(supplierDaoImpl);
	}

	@Test
   public void saveSupplier_Positivetest()
   {
	   
	   
	   
	   
		Supplier supplier=new Supplier();
		supplier.setSupplierId(321111);
		supplier.setSupplierName("bbc");
		supplier.setSupplierDescription("abc");
		supplier.setSupplierAddress("def");
	   assertEquals("success",true,supplierDaoImpl.saveSupplier(supplier));
	   
	   
	   
   }
	@Test
	   public void saveSupplier_Negativetest()
	   {
		   
		   
		   
		   

		Supplier supplier=new Supplier();
		supplier.setSupplierId(321111);
		supplier.setSupplierName("bbc");
		supplier.setSupplierDescription("abc");
		supplier.setSupplierAddress("def");
	   assertEquals("failure",false,supplierDaoImpl.saveSupplier(supplier));
		   
		   
		   
	   }
	
	
	
}
