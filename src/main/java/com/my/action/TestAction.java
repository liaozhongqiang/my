package com.my.action;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.core.spring.Decryption;
import com.my.core.spring.MyException;
import com.my.core.spring.SpringApplicationUtil;
import com.my.entity.PhoneNumber;
import com.my.entity.User;
import com.my.service.IUserService;





@Controller
@RequestMapping("test")
public class TestAction {

	private static Logger logger=LoggerFactory.getLogger(TestAction.class);
	
	@Autowired
	private IUserService userServiceImpl;

	@RequestMapping("sayHello")
	@ResponseBody
	public String sayHello() {
		logger.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		return "日哦";
	}

	@RequestMapping("testdo.do")
	public @ResponseBody String testdo() {
		return "test .do";
	}

	@RequestMapping("rest1/{id}")
	@ResponseBody
	public String rest1(@PathVariable String id) {
		return id + "";
	}

	@RequestMapping("rest2/{val1}/{val2}")
	@ResponseBody
	public String rest2(@PathVariable("val1") String val1, @PathVariable("val2") String val2) {
		return val1 + val2;
	}

	@RequestMapping("view.do")
	public ModelAndView view() {
		return new ModelAndView("/page/index");
	}
	
	@RequestMapping("testResource")
	@ResponseBody
	public String testResource(){
		System.out.println(SpringApplicationUtil.getApplicationContext().getBean("userServiceImpl"));
		return "xxxx";
	}
	
	@RequestMapping("/testHttp")
	@ResponseBody
	public String testHttp(String id,String name){
		System.out.println(id+"----"+name);
		return id+name;
	}
	
	@RequestMapping("/testConversion")
	@ResponseBody
	public String testConversion(@RequestParam(name="phone") PhoneNumber phone){
		return phone.toString();
	}
	
	@RequestMapping("/testValidator")
	@ResponseBody
	public PhoneNumber testValidator(@Valid PhoneNumber phone){
		return phone;
	}
	
	@RequestMapping("/testMessageResolver")
	@ResponseBody
	public PhoneNumber testMessageResolver(){
		PhoneNumber phone=new PhoneNumber();
		phone.setAreaCode("010");
		phone.setPhoneNumber("1234567");
		return phone;
	}
	
	@RequestMapping("/testForward")
	public String testForward(){
		return "forward:/test/testMessageResolver";
	}
	
	@RequestMapping("/testMyException")
	@ResponseBody
	public String testMyException(){
		throw new MyException("");
	}
	
	
	@RequestMapping("/testDecrypt")
	@ResponseBody
	public User testDecrypt(@RequestBody User user){
		return user;
	}
	
}
