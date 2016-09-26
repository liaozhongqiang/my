package com.my.service.impl;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my.dao.IUserDao;
import com.my.entity.User;
import com.my.service.IUserService;

@Component
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDaoImpl;

	public User findById(String id) {
		return userDaoImpl.findById(id);
	}
	
	@Transactional
	public void testRouteDataSource() throws Exception {
		//DBContextHolder.setDBSource("dataSourceone");
		// System.out.println(userDaoImpl.findById("1"));
		User user = new User("30", "我擦洗擦洗");
		userDaoImpl.saveUser(user);
		//OutputStream os=new FileOutputStream("E:\\jd-gui\\jd-gui-windows-1.4.0.111.34.5.6\\jd-gui.xls");
		//os.write("xx".getBytes());
		//os.close();
		//DBContextHolder.setDBSource("dataSourcetwo");
		// System.out.println(userDaoImpl.findById("2"));
		//User user2 = new User("17", "偶日哦");
		//userDaoImpl.saveUser(user2);
	}
	
	@Transactional
	public User saveUser(User user){
		return	userDaoImpl.saveUser(user);
	}
}
