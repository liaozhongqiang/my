package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyRole implements InvocationHandler{
	
	private Object RealRole;
	
	public ProxyRole(Object RealRole) {
		super();
		this.RealRole = RealRole;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理类操作！！！！！");
		Object obj=method.invoke(RealRole, args);
		return obj;
	}
	
}
