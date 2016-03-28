package com.my.core.spring;


/**
 * 自定义异常
 * @author myzhong2012
 *
 */
public class MyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1852760465631856721L;
	
	public MyException(Throwable e) {
		super(e);
	}
	
	public MyException(String msg) {
		super(msg);
	}

}
