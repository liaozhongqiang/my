package concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest1 {
	
	public void test1() throws Exception{
		
		/*	
		LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<Integer>();
		queue.take();
		
		ConcurrentLinkedQueue<Integer> q=new ConcurrentLinkedQueue<Integer>();
		
		q.poll();
		*/
		//AbstractQueuedSynchronizer
		
		Lock lock=new ReentrantLock();
		
		lock.lock();
		
		lock.unlock();
		
	}
}
