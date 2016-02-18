package com.my.action;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.my.core.spring.SpringApplicationUtil;





@Controller
@RequestMapping("test")
public class TestAction {

	private static Logger logger=LoggerFactory.getLogger(TestAction.class);

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
		SpringApplicationUtil.getBeanById("userDaoImpl");
		return "xxxx";
	}
	
	@RequestMapping("/testHttp")
	@ResponseBody
	public String testHttp(HttpServletRequest req,String id,String name) throws Exception{
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("name"));
		return id+name;
	}
	
}
