package com.ekart.dao;

import com.ekart.model.Login;
import com.ekart.model.User;

public interface UserDao {
	
	void register(User user);
	
	User validateUser(Login login);

}
