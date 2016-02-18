package com.my.dao;


import com.my.entity.User;

public interface IUserDao {
	
	public User findById(String id);
	
	public void saveUser(User user);

}
