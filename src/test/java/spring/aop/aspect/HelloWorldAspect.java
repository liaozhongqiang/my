package spring.aop.aspect;

public class HelloWorldAspect {
	
	public void beforeAdvice(){
		System.out.println("############before advice");
		
	}
	
	
	public void afterAdvice(){
		System.out.println("############after advice");
	}
}
