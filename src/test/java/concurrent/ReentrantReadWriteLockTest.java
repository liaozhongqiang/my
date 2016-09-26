package concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReentrantReadWriteLockTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		ReentrantReadWriteLock rwlock=new ReentrantReadWriteLock(true);
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("我来了");
				rwlock.readLock().lock();
				try {
					System.out.println("我读读");
					Thread.sleep(5000);
					System.out.println("我完了");
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					rwlock.readLock().unlock();
				}
			}
		}).start();
		
		Thread.sleep(1000);
		for(int i=0;i<100;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("我也来了");
					rwlock.readLock().lock();
					try {
						System.out.println("我也读读");
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						rwlock.readLock().unlock();
					}
				}
			}).start();
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("我要写了");
				rwlock.writeLock().lock();
				System.out.println("我在写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写写!");
				rwlock.writeLock().unlock();
			}
		}).start();
	}

}
