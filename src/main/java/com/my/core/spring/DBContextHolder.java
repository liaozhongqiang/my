package com.my.core.spring;

/**
 * 为当前线程绑定数据源
 * @author liaozq
 * @DATE 2015年11月17日
 */
public class DBContextHolder {
	
	private static final ThreadLocal<String> contextHolder=new ThreadLocal<String>();
	
	public static void setDBSource(String dbSource){
		contextHolder.set(dbSource);
	}
	
	public static String getDBSource(){
		return	contextHolder.get();
	}
	
	public static void clearDBSource(){
		contextHolder.remove();
	}
}
