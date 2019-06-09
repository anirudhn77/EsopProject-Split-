package com.ani.eshopbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.eshopbackend.dao.CategoryDao;
import com.ani.eshopbackend.model.Category;

@Component(value="cateDaoImpl")
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
    

	public boolean saveCategory(Category category) {
	System.out.println("--------------------------"+sessionFactory);
	Session session=sessionFactory.openSession();
	System.out.println("from saveCategory catId= "+category.getCategoryId());
	if(category.getCategoryId()==0)
	{
		System.out.println("from inner saveCategory catId= "+category.getCategoryId());
		
    int id=(int)(Math.random()*10000);
   	category.setCategoryId(id);
	}
	 
	 session.saveOrUpdate(category);
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
	
	public boolean deleteCategory(Category category) {
	    
		System.out.println("Category Id="+category);
		  
		Session session=sessionFactory.openSession();
		//Category category=getCategory(categoryid);
		session.delete(category);
		Transaction transaction=session.beginTransaction();
	    transaction.commit();
	    session.close();
		
		return false;
	}

	public Category getCategory(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=session.get(Category.class,categoryId);
		System.out.println("from getcategoryDaoimpl "+categoryId);
		session.close();
		return category;
		
	}

	public List<Category> getCategoryList() {
		Session session=sessionFactory.openSession();
		 Query query=session.createQuery("from  com.ani.eshopbackend.model.Category");
		 @SuppressWarnings("unchecked")
		List<Category> listCategory=query.list();
		 session.close();
		 return listCategory;
	}

	
}
