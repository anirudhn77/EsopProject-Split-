package com.ani.eshopbackend.dao;

import java.util.List;

import com.ani.eshopbackend.model.Product;

public interface ProductDao {
	
boolean saveProduct(Product product);
    
    boolean deleteProduct(Product product);
    
    Product getProduct(int productId);
    
   List<Product>    getProductList();

}
