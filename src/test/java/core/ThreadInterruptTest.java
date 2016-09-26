package core;

import org.junit.Assert;
import org.junit.Test;

public class ThreadInterruptTest {
	
	
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(int i=0;i<1000;i++){
				System.out.println(i);
			}
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		t.start();
		t.interrupt();
	}
	
	@Test
	public void test1(){
		Thread t = new Thread(()->{while(true){System.out.println('a');}});
		t.start();
		t.interrupt();
		Assert.assertTrue(t.isInterrupted());
		t.interrupt();
		Assert.assertTrue(t.isInterrupted());
	}
}

