package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ConcurrentQueueTest {
	
	public static void main(String[] args) {
		
		ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<String>();
		queue.offer("1111");
		
		queue.offer("1113");
		
		queue.offer("1112");
		
		LinkedBlockingQueue<String> linkedQueue=new LinkedBlockingQueue<String>();
		
		linkedQueue.add("111");
		
		ArrayBlockingQueue<String> arrayQueue=new ArrayBlockingQueue<String>(100);
		
		PriorityBlockingQueue<String> priorityQueue=new PriorityBlockingQueue<String>();
		
		
		priorityQueue.offer("111");
		
		SynchronousQueue<String> synQueue=new SynchronousQueue<String>();
		
		synQueue.offer("1111");
		
		try {
			synQueue.put("111222");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
