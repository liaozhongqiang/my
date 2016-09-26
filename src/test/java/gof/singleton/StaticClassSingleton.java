package gof.singleton;

import java.io.Serializable;

public class StaticClassSingleton implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static class SingletonHolder{
		private static StaticClassSingleton INSTANCE = new StaticClassSingleton();
	}
	
	public static StaticClassSingleton getInstance(){
		return	SingletonHolder.INSTANCE;
	}
	
	/**
	 * 反序列化
	 * @return
	 */
	private Object readResolve(){
		return getInstance();
	}

}
