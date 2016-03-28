package spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.advice.AfterTurnTest;

public class AfterReturnTest {
	
	@Test
	public void afterReturnTest(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:aop/afterreturn.xml");
		AfterTurnTest test=(AfterTurnTest) applicationContext.getBean("afterReturn");
		test.afterReturn("hello after return");
	}

}
