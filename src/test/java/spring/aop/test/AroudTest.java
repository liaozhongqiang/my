package spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.advice.AroudAdvice;

public class AroudTest {
	
	@Test
	public void aroudTest(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:aop/around.xml");
		AroudAdvice test=(AroudAdvice) ac.getBean("aroudAdvice");
		test.aroud("xxxxx");
	}

}
