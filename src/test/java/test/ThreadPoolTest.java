package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;


public class ThreadPoolTest {
	
	private static int A;

	public static void main(String[] args) {
		ExecutorService es = new ThreadPoolExecutor(1, 10, 15, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		
		Executors.newCachedThreadPool();
		
		Executors.newSingleThreadExecutor();
		
		Executors.newFixedThreadPool(100);
		
		Executors.newScheduledThreadPool(100);

		// ExecutorService es=Executors.newCachedThreadPool();
		

		es.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("test1");
			}
		});
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		es.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println("22222");
			}
		});
	}
	
	class TestA{
		public TestA(){
			System.out.println(A);
		}
	}
	
	@Test
	public void test1(){
		int num = -1;
		System.out.println(Integer.toBinaryString(num));
	}

}
