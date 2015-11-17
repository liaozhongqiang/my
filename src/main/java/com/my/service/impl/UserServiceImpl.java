package com.my.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.core.spring.DBContextHolder;
import com.my.dao.IUserDao;
import com.my.entity.User;
import com.my.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDaoImpl;

	public User findById(String id) {
		return userDaoImpl.findById(id);
	}

	@Transactional
	public void testRouteDataSource() {
		DBContextHolder.setDBSource("dataSourceone");
		// System.out.println(userDaoImpl.findById("1"));
		User user = new User("12", "数据源测试1");
		userDaoImpl.saveUser(user);
		DBContextHolder.setDBSource("dataSourcetwo");
		// System.out.println(userDaoImpl.findById("2"));
		User user2 = new User("13", "数据源测试1");
		userDaoImpl.saveUser(user2);
	}
}
