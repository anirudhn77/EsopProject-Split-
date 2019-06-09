package com.ani.eshopbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.eshopbackend.dao.CartDao;
import com.ani.eshopbackend.model.Cart;
import com.ani.eshopbackend.model.Product;

@Component
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean saveCart(Cart cart) {
		Session session=sessionFactory.openSession();
		
	    session.save(cart);
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
	
	
	public Cart setCart(Product product,int q,String UserName)
	{
		Cart cart=new Cart();
		   
		   cart.setUserName(UserName);
		   cart.setCartdId((int)(Math.random()*10000));
		   cart.setProductId(product.getProductID());
		   cart.setProductName(product.getProductName());
	   
		   cart.setProductprice(product.getProductPrice());;
		   cart.setProductSupplier(product.getProductSupplier());
		   cart.setProductQuantity(q);
		   cart.setTotalprice(cart.getProductprice()*q);
		  
			
		   return cart;
		   
		}

	@Override
	public boolean deleteCart(Cart cart) {
		System.out.println("Cart Id="+cart);
		  
		Session session=sessionFactory.openSession();
		//Cart cart=getCart(cartId);
		session.delete(cart);
		Transaction transaction=session.beginTransaction();
	    transaction.commit();
	    session.close();
		return false;
	}

	@Override
	public Cart getCart(int cartId) {
		Session session=sessionFactory.openSession();
		Cart cart=session.get(Cart.class,cartId);
		session.close();
		return cart;
	}
		

	@Override
	public List<Cart> getCartList(String UserName) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where username=:em");
		query.setParameter("em",UserName);
		
		
		List<Cart> cartlist=query.list();

		for (Cart cart : cartlist) {
			
			System.out.println(cart.getProductId());
		}
		
		session.close();
		return cartlist;
		
	}

}
