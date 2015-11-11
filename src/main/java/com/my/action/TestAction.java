package com.my.action;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestAction {
	
	private final Logger logger=LoggerFactory.getLogger(TestAction.class);
	
	@RequestMapping("sayHello")
	@ResponseBody
	public String sayHello(){
		logger.info("测试INFO日志！！！");
		try{
			throw new NullPointerException();
		}catch(Exception e){
			logger.error("测试ERROR日志",e);
		}
		return "您好！ mvc";
	}
	
	@RequestMapping("rest1/{id}")
	@ResponseBody
	public String rest1(@PathVariable String id){
		return id;
	}
	
	@RequestMapping("rest2/{val1}/{val2}")
	@ResponseBody
	public String rest2(@PathVariable("val1") String val1,@PathVariable("val2") String val2){
		return val1+val2;
	}
}
