package gof.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		IUserService proxy = (IUserService) Proxy.newProxyInstance(UserServiceImpl.class.getClassLoader(),
				UserServiceImpl.class.getInterfaces(), new UserServiceImplProxy(new UserServiceImpl()));
		proxy.save("11");
	}

}
