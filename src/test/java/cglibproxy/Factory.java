package cglibproxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class Factory {
	
	public static HelloCglib getInstance(Callback... args){
		Enhancer enhancer=new Enhancer();
		//设置父类
		enhancer.setSuperclass(HelloCglib.class);
		//设置拦截
		enhancer.setCallbacks(args);
		//设置过滤器
		enhancer.setCallbackFilter(new CallBackFilter());
		return (HelloCglib) enhancer.create();
	}

}
