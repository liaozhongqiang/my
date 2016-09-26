package concurrent;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicTest2 {
	
	private volatile int i=0;
	
	public static void main(String[] args) {
		AtomicIntegerFieldUpdater<AtomicTest2> update = AtomicIntegerFieldUpdater.newUpdater(AtomicTest2.class, "i");
		AtomicTest2 t = new AtomicTest2();
		
		new Thread(()->{
			while(true){
				System.out.println(t.i);
			}
		}).start();
		
		new Thread(()->{
			while(true){
				System.out.println(update.getAndIncrement(t));
			}
		}).start();
	}

}
