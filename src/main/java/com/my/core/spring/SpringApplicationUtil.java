package com.my.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * @author liaozq
 * @DATE 2015年11月19日
 */
public class SpringApplicationUtil implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	public static Object getBeanById(String beanId){
		return	applicationContext.getBean(beanId);
	}

}
