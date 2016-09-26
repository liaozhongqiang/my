package concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreSynchronousQueue<E> {
	
	E item=null;
	Semaphore sync=new Semaphore(0);
	Semaphore send=new Semaphore(1);
	Semaphore revc=new Semaphore(0);
	
	public E take() throws InterruptedException{
		revc.acquire();
		E x=item;
		sync.release();
		send.release();
		return x;
	}
	
	public void put(E e) throws InterruptedException{
		send.acquire();
		item=e;
		revc.release();
		sync.acquire();
	}
}
