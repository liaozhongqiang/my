package spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloWorldConfig {
	
	@Bean
	@Scope("prototype")
	public HelloWorldImpl getHelloWorld(){
		return new HelloWorldImpl();
	}
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		ctx.start();
		System.out.println(ctx.getBeanNamesForType(ApplicationListener.class).length);
		IHelloWorld obj=(IHelloWorld) ctx.getBean("getHelloWorld");
		
		obj.hello();
		ctx.stop();
	}
	
}
