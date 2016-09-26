package concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
	
	
	public static void main(String[] args) {
		StampedLock stampedLock=new StampedLock();
		
		long readLong=stampedLock.readLock();
		
		stampedLock.unlockRead(readLong);
		
		stampedLock.validate(readLong);
		
		//AbstractQueuedSynchronizer
		
		System.out.println(1<<16);
	}
}
