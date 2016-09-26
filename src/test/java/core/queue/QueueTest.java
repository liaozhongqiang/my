package core.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

public class QueueTest {
	
	@Test
	public void test1() throws InterruptedException{
		
		Queue<String> queue = new LinkedList<>();
		
		ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
		
		LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(10);
		
		PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<String>();
		
		SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
		
		blockingQueue.put("11");
		
	}

}
