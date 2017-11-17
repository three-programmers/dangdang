package com.jk.service;

import com.jk.entity.User;

public interface UserService {
	User checkEmail(String email);
	User login(String email,String password);
	void register(User user);
}
