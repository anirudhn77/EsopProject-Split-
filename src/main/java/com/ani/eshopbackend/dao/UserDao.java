package com.ani.eshopbackend.dao;

import com.ani.eshopbackend.model.User;

public interface UserDao {

	 public boolean addUser(User user);
	    public boolean checkLogin(User user);
}
