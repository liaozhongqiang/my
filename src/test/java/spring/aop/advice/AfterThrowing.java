package spring.aop.advice;

public class AfterThrowing {
	
	public void afterThrowing(){
		System.out.println("after throwing");
		throw new RuntimeException("after throwing exception test");
	}

}
