package cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	@Override
	public Object intercept(Object obj1, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object result=null;
		System.out.println("proxy doSomething");
		result=proxy.invokeSuper(obj1, args);
		System.out.println("proxy doSomething");
		return result;
	}

}
