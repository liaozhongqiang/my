package concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ConditionTest {
	
	
	public static void main(String[] args) {
		
		ReentrantLock lock=new ReentrantLock();
		
		Condition condition=lock.newCondition();
		
		BlockingQueue<String> queue=new LinkedBlockingQueue<String>();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				lock.lock();
				try {
					queue.put("1111");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
