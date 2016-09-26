package spring;


import java.util.Objects;

import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

import com.google.common.base.Strings;

public class SpringTest {
	
	public static void main(String[] args) {	
		Objects.equals("a", "b");
		Strings.isNullOrEmpty("");
	}
}
