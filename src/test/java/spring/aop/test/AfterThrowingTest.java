package spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.advice.AfterThrowing;
import spring.aop.advice.AfterTurnTest;

public class AfterThrowingTest {
	
	@Test
	public void afterThrowing(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:aop/afterthrowing.xml");
		AfterThrowing test=(AfterThrowing) applicationContext.getBean("afterThrowing");
		test.afterThrowing();
	}

}
