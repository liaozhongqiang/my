package core;

import org.junit.Test;

public class ThreadTest {
	
	
	/**
	 * 测试多次调用Thread.start() 方法。 
	 */
	@Test
	public void testStartThreadTwice(){
		Thread t = new Thread(()->{System.out.println("test1111");});
		t.start();
		t.start();
	}
}
