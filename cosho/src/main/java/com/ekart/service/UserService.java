package com.ekart.service;

import com.ekart.model.Login;
import com.ekart.model.User;

public interface UserService {
	
	User validateUser(Login login);
	void register(User user);

}
