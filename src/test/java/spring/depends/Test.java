package spring.depends;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	@org.junit.Test
	public void dependsTest(){
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("depend.xml");
		applicationContext.registerShutdownHook();
	}
	
	
	@org.junit.Test
	public void circle(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("circle.xml");
		
	}
	
	@org.junit.Test
	public void circleSet(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("circleset.xml");
		CircleSetA ca=(CircleSetA) applicationContext.getBean("a");
		System.out.println(ca.getB());
	}

}
