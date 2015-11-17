package com.my.core.spring;

/**
 * Ϊ��ǰ�̰߳�����Դ
 * @author liaozq
 * @DATE 2015��11��17��
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
