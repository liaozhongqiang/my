package spring.aop.aspect;

public class AfterReturnAspect {
	
	public void beforeAdvice(){
		System.out.println("before advice");
	}
	
	public void afterLReturn(String params,String result){
		System.out.println(params+"----"+result);
	}

}
