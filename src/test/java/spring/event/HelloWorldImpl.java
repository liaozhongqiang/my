package spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class HelloWorldImpl implements IHelloWorld,ApplicationListener<ContextStartedEvent>{

	@Override
	public void onApplicationEvent(ContextStartedEvent event) {
		System.out.println("-------------------start----------------------");
	}

	@Override
	public void hello() {
		System.out.println("-------------------hello----------------------");		
	}

}
