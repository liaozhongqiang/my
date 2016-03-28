package com.my.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liaozq
 * @DATE 2015年11月19日
 */

@Component
public class SpringApplicationUtil implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
}
