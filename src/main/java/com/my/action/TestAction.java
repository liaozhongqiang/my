package com.my.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.entity.TestEntity;

@Controller
@RequestMapping("test")
public class TestAction {

	private final Logger logger = LoggerFactory.getLogger(TestAction.class);

	@RequestMapping("sayHello")
	@ResponseBody
	public TestEntity sayHello() {
		logger.info("≤‚ ‘INFO»’÷æ£°£°£°");
		TestEntity test = new TestEntity("111", "222");
		return test;
	}

	@RequestMapping("testdo.do")
	public @ResponseBody String testdo() {
		return "test .do";
	}

	@RequestMapping("rest1/{id}")
	@ResponseBody
	public String rest1(@PathVariable String id) {
		return id + "∂∫ƒ„ÕÊ£°";
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
}
