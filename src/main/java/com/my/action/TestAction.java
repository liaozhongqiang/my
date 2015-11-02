package com.my.action;

import org.springframework.stereotype.Controller;
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
}
