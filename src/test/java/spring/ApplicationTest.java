package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ApplicationTest {
	
	@Bean
	HelloSpring hello(){
		return new HelloSpring() {
			@Override
			public String helloSpring() {
				return "hello spring";
			}
		};
	}
	
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationTest.class);
		MessagePrinter mp=context.getBean(MessagePrinter.class);
		mp.printerMessage();
	}

}
