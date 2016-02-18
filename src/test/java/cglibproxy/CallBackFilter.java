package cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

public class CallBackFilter implements CallbackFilter{

	@Override
	public int accept(Method method) {
		System.out.println("进行filter过滤");
		return 0;
	}

}
