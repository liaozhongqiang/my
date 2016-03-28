package com.my.service;

import com.my.entity.User;

public interface IUserService {
	
	public User findById(String id);
	
	public void testRouteDataSource() throws Exception;

}
