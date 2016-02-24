package spring.lookup;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookUpTest {
	
	@Test
	public void test(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("lookup.xml");
		Hello hello=(Hello) applicationContext.getBean("hello");
		hello.sayHello().printRandom();
		hello.createPrinter().printRandom();
	}

}
