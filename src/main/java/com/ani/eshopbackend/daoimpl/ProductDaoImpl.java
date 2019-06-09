package com.ani.eshopbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.eshopbackend.dao.ProductDao;
import com.ani.eshopbackend.model.Product;


@Component(value="proDaoImpl")
public class ProductDaoImpl implements ProductDao {


	@Autowired
	SessionFactory sessionFactory;
    
	
	@Override
	public boolean saveProduct(Product product) {
		System.out.println("--------------------------"+sessionFactory);
	
	/*		if(product.getProductID()==0)
			{
		    int id=(int)(Math.random()*10000);
		    product.setProductID(id);
			}   */
		 Session session=sessionFactory.openSession();
		 session.saveOrUpdate(product);
		    Transaction transaction=session.beginTransaction();
		    
		    try
		    {
		    transaction.commit();
			return true;
		}
		    catch(Exception e)
		    {
			return false;
			}
		    finally {
		    	
		    	session.close();
		    }	
		
	}

	@Override
	public boolean deleteProduct(Product product) {
		System.out.println("Product Id="+product);
		  
		Session session=sessionFactory.openSession();
		//Products product=getProduct(product);
		session.delete(product);
		Transaction transaction=session.beginTransaction();
	    transaction.commit();
	    session.close();
		return false;
	}

	@Override
	public Product getProduct(int productId) {
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class,productId);
		session.close();
		return product;
	}

	@Override
	public List<Product> getProductList() {
		Session session=sessionFactory.openSession();
		 Query query=session.createQuery("from  com.ani.eshopbackend.model.Product");
		
		List<Product> listProduct=query.list();
		 for(Product prod:listProduct)
		 {
			 Product product=prod;
			System.out.println("id = "+ product.getProductID());
			System.out.println("Name = "+ product.getProductName());
			System.out.println("Description = "+ product.getProductDescription());
			System.out.println("Price = "+ product.getProductPrice());
			System.out.println("Category = "+ product.getProductCategory());
			System.out.println("supplier = "+ product.getProductSupplier());
			
		 }
		 session.close();
		 return listProduct;
		
	}

}
