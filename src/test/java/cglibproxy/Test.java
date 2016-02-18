package cglibproxy;

import net.sf.cglib.proxy.NoOp;

public class Test {
	
	public static void main(String[] args) {
		CglibProxy cglibProxy=new CglibProxy();
		HelloCglib proxyRole=Factory.getInstance(cglibProxy,NoOp.INSTANCE);
		proxyRole.doSomething();
	}

}
