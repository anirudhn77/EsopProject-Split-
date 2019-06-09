package com.ani.eshopbackend.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ani.eshopbackend.dao.UserDao;
import com.ani.eshopbackend.model.User;


@Component(value="usDaoImpl")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		
		Session session=sessionFactory.openSession();
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        session.save(user);
        Transaction transaction=session.beginTransaction();
        
        try {
        transaction.commit();
        return true;
        }
        catch(Exception e)
        {
        	return false;
        }
        finally
        {
        	session.close();
        }
    
	}
	
	
	//------------------------------------------------------------
	//   Login Check

	@Override
	public boolean checkLogin(User user) {
		
		Session session=sessionFactory.openSession();
		   Query query=session.createQuery("from User where email=:em and password=:pw");
		   query.setParameter("em",user.getEmail());
		   query.setParameter("pw",user.getPassword());
		   User user2=(User)query.uniqueResult();
		   
		   if(user2==null) 
		   {
			   return false;
		   }
		   else
		   {
			   return true;
		   }
	
	
	}

}
