package com.jk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jk.dao.UserDAO;
import com.jk.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
		
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public User checkEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.queryUserByEmail(email);
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public User login(String email,String password) {
		// TODO Auto-generated method stub
		return userDAO.queryUserByEmailPassword(email, password);
	}

	@Override
	public void register(User user) {
		userDAO.insertUser(user);

	}

}
