package concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicTest1 {
	
	private volatile int a=100;
	
	public void test1(){
		AtomicInteger atomicInteger =new AtomicInteger(10);
		atomicInteger.get();
		atomicInteger.decrementAndGet();
		atomicInteger.getAndIncrement();
		AtomicIntegerFieldUpdater<AtomicTest1> update=AtomicIntegerFieldUpdater.newUpdater(AtomicTest1.class, "a");
	}
}
