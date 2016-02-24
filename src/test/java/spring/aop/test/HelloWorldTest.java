package spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.advice.IHelloWorldService;

public class HelloWorldTest {
	
	@Test
	public void helloWorldTest(){
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:aop/helloworld.xml");
		IHelloWorldService hws=	(IHelloWorldService) applicationContext.getBean("helloworld");
		hws.sayHello();
		
	}

}
