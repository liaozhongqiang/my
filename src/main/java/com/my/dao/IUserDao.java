package com.my.dao;


import com.my.entity.User;

public interface IUserDao {
	
	public User findById(String id);
	
	public User saveUser(User user);

}
