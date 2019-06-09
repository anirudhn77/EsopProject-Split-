package com.ani.eshopbackend;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class test {
	
	@BeforeClass
	public static void  test1()
	{
		System.out.println("from before class");
		
	}
	@Test
	public void test3()
	{
		EvenTest e=new EvenTest();
		System.out.println("test3");
		assertEquals("success",true,e.even(5));
	}
	@AfterClass
 public static void test2()
 {
	 System.out.println("from after class");
 }
	
}
