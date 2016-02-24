package spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.advice.IHello;

public class HelloTest {
	
	
	@Test
	public void helloWorldTest(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:aop/hello.xml");
		IHello hws=	(IHello) applicationContext.getBean("hello");
		hws.sayHello("sb");
		
	}
	
}
