package spring.aop.advice;

public class Hello implements IHello{

	@Override
	public void sayHello(String params) {
		System.out.println("hello "+params);
	}

}
