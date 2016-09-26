package concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	
	public static void main(String[] args) {
		Semaphore semaphore=new Semaphore(5);
		for(int i=1;i<10;i++){
			new Thread(new Worker(semaphore, i)).start();
		}
	}
	
	static class Worker implements Runnable{
		
		private Semaphore semaphore;
		
		private int i;

		public Worker(Semaphore semaphore, int i) {
			super();
			this.semaphore = semaphore;
			this.i = i;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("工人"+i+"使用一个机器");
				Thread.sleep(5000);
				System.out.println("工人"+i+"释放一个机器");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaphore.release();
			}
		}
		
		
		
		
	}

}
