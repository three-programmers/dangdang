package com.jk.dao;

import org.apache.ibatis.annotations.Param;

import com.jk.entity.User;

public interface UserDAO {
	User queryUserByEmail(@Param("email")String email);
	User queryUserByEmailPassword(@Param("email")String email,@Param("password")String password);
	void insertUser(@Param("user")User user);
}
