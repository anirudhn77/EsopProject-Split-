package com.ani.eshopbackend.dao;

import java.util.List;

import com.ani.eshopbackend.model.Category;

public interface CategoryDao {

	    boolean saveCategory(Category category);
	    
	    boolean deleteCategory(Category category);
	    
	    Category getCategory(int categoryId);
	    
	List<Category>    getCategoryList();
}
