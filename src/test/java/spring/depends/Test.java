package spring.depends;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	@org.junit.Test
	public void dependsTest(){
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("depend.xml");
		applicationContext.registerShutdownHook();
	}

}
