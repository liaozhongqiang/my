package jdkproxy;

import java.lang.reflect.Proxy;

public class Test {
	
	public static void main(String[] args) {
		IRole2 interFace=(IRole2) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{IRole2.class}, new ProxyRole(new RealRole()));
		interFace.doSomething2();
	}

}
