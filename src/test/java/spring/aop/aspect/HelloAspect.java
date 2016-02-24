package spring.aop.aspect;

public class HelloAspect {
	
	public void beforeAdvice(String params){
		System.out.println("before advice "+params);
		
	}
	
	
	public void afterAdvice(String params){
		System.out.println("after advice "+params);
	} 

}
