package spring.test;

import org.mybatis.spring.config.NamespaceHandler;
import org.springframework.util.ReflectionUtils;

public class NameSpaceHandlerTest {
	
	public static void main(String[] args) throws Exception {
		Class<NamespaceHandler> clazz=(Class<NamespaceHandler>) Class.forName("org.mybatis.spring.config.NamespaceHandler");
		//org.springframework.beans.factory.xml.NamespaceHandler ns=cs.newInstance();
		ReflectionUtils.makeAccessible(clazz.getDeclaredConstructor());
		org.springframework.beans.factory.xml.NamespaceHandlerSupport ns=clazz.newInstance();
		System.out.println(ns);
	}

}
