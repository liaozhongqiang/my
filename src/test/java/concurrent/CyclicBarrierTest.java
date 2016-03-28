package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		
		CyclicBarrier cyclicBarrier=new CyclicBarrier(4);
		for(int i=0;i<4;i++){
			new Thread(new Worker(cyclicBarrier, 5)).start();
		}
	}

	static class Worker implements Runnable {

		private CyclicBarrier cyclicBarrier;

		private int i;

		public Worker(CyclicBarrier cyclicBarrier, int i) {
			super();
			this.cyclicBarrier = cyclicBarrier;
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
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}

			System.out.println("所有线程都执行完毕了");
		}
	}

}
