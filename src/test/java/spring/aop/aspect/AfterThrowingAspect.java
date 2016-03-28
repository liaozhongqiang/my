package spring.aop.aspect;

public class AfterThrowingAspect {
	
	public void afterThrowing(Exception exception){
		System.out.println("抛出的异常"+exception.getMessage());
	}

}
