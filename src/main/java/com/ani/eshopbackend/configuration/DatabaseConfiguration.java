package com.ani.eshopbackend.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
public class DatabaseConfiguration {
	
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setDriverClassName("org.h2.Driver" );
		basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/testeshop");
		basicDataSource.setUsername("ani");
		basicDataSource.setPassword("ani");
		return basicDataSource;
	}
	
	@Bean
	public Properties getproperties()
	{
		Properties properties=new Properties();
		properties.getProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.getProperty("hibernate.show_sql","true");
		properties.getProperty("hibernate.hbm2ddl.auto","update");
		return properties;
		
	}
	
	@Bean(name="sessionFactory")
 public SessionFactory getSessionFactory()
 {
	 LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
	 localSessionFactoryBuilder.addProperties(getproperties());
	 localSessionFactoryBuilder.scanPackages("com.ani.eshopbackend");
	 return localSessionFactoryBuilder.buildSessionFactory();
	 
 }
	@Bean
	 public HibernateTransactionManager getHibernateTransactionManager()
	    {
	        HibernateTransactionManager transactionManager=new HibernateTransactionManager(getSessionFactory());
	    
	        System.out.println(transactionManager);
	        return transactionManager;
	    }
}
