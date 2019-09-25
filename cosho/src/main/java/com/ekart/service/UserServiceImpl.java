package com.ekart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ekart.dao.UserDao;
import com.ekart.model.Login;
import com.ekart.model.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	public User validateUser(Login login) 
	{
	   return userDao.validateUser(login);
	}
	
	
	public void register(User user) 
	{
		userDao.register(user);
	    System.out.println("Data Entered Successfuly");
	}

}
