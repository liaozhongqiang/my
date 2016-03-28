package com.my.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.core.spring.DBContextHolder;
import com.my.core.spring.SpringApplicationUtil;
import com.my.entity.User;
import com.my.service.IUserService;

@Component
@RequestMapping("user")
public class UserAction {
	
	private static final Logger logger=LoggerFactory.getLogger(UserAction.class);
	
	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping("find/{id}")
	@ResponseBody
	public User find(@PathVariable String id){
		logger.info("xxxx");
		return userServiceImpl.findById(id);
	}
	
	@RequestMapping("testRouteDataSource")
	@ResponseBody
	public String testRouteDataSource() throws Exception{
		TestAction t=(TestAction) SpringApplicationUtil.getApplicationContext().getBean("testAction");
		//DBContextHolder.clearDBSource();
		userServiceImpl.testRouteDataSource();
		return "success";
	}
}
