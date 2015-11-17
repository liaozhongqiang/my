package com.my.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.core.spring.DBContextHolder;
import com.my.entity.User;
import com.my.service.IUserService;

@Controller
@RequestMapping("user")
public class UserAction {
	
	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping("find/{id}")
	@ResponseBody
	public User find(@PathVariable String id){
		return userServiceImpl.findById(id);
	}
	
	@RequestMapping("testRouteDataSource")
	@ResponseBody
	public String testRouteDataSource(){
		DBContextHolder.clearDBSource();
		userServiceImpl.testRouteDataSource();
		return "success";
	}
}
