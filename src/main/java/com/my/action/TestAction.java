package com.my.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("test")
public class TestAction {

	private final Logger logger = LoggerFactory.getLogger(TestAction.class);

	@RequestMapping("sayHello")
	@ResponseBody
	public String sayHello() {
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
		return "xxxx";
	}
	
	@RequestMapping("/testHttp")
	@ResponseBody
	public String testHttp(String id,String name){
		return id+name;
	}
	
}
