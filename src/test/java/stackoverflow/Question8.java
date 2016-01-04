package stackoverflow;

import java.util.concurrent.Semaphore;

public class Question8 {
	
	public static void main(String[] args) {
		Semaphore semaphore=new Semaphore(1);
		new Thread(new SemaphoreRunnable(semaphore)).start();
		new Thread(new SemaphoreRunnable(semaphore)).start();
	}
}

class SemaphoreRunnable implements Runnable{
	
	private Semaphore semaphore;
	
	public SemaphoreRunnable(Semaphore semaphore) {
		super();
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		while(true){
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
			semaphore.release();
		}
	}
	
}