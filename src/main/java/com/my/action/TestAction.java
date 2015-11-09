package com.my.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestAction {
	
	@RequestMapping("sayHello")
	@ResponseBody
	public String sayHello(){
		return "ฤ๚บรฃก mvc";
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
