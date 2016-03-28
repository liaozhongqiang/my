package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CountLatchDownTest {
	
	
	public static void main(String[] args) {
		
		CountDownLatch countDownLatch=new CountDownLatch(3);
		new Thread(new Worker(countDownLatch, 1)).start();
		new Thread(new Worker(countDownLatch, 10)).start();
		new Thread(new Worker(countDownLatch, 5)).start();
		try {
			//countDownLatch.await();
			countDownLatch.await(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("所有都执行完了");
	}
	
	
	static class Worker implements Runnable {

		private CountDownLatch countDownLatch;

		private int i;

		public Worker(CountDownLatch countDownLatch, int i) {
			super();
			this.countDownLatch = countDownLatch;
			this.i = i;
		}

		@Override
		public void run() {
			System.out.println("线程" + Thread.currentThread().getId() + "正在执行任务，需要执行" + i + "秒");
			try {
				Thread.sleep(i * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();
		}
	}

}
