package spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroudAspect {
	
	public Object aroudAdvice(ProceedingJoinPoint point) throws Throwable{
		System.out.println("----aroud before advice--");
		//System.out.println("----aroud replace params"+param);
		Object obj=point.proceed(new String[]{"replace"});
		System.out.println("----aroud after advice");
		return obj;
	}

}
