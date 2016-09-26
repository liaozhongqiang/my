package gof.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceImplProxy implements InvocationHandler{
	
	private IUserService target;
	
	public UserServiceImplProxy(IUserService target) {
		this.target=target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("save user before");
		Object result = method.invoke(target, args);
		System.out.println("save user after");
		return result;
	}
}
