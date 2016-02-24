package spring.aop.advice;

public class HelloWorldService implements IHelloWorldService{

	@Override
	public void sayHello() {
		System.out.println("############hello world!");
	}

}
