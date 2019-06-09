package com.ani.eshopbackend.dao;

import java.util.List;

import com.ani.eshopbackend.model.Cart;
import com.ani.eshopbackend.model.Product;

public interface CartDao {
	 boolean saveCart(Cart cart);
	 
	 Cart setCart(Product product,int q,String UserName);
	    
	    boolean deleteCart(Cart cart);
	    
	    Cart getCart(int cartId);
	    
	   List<Cart>    getCartList(String UserName);
}
