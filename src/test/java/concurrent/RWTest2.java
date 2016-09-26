package concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author lzq
 * @date 2016年5月19日
 *
 */
public class RWTest2 {
	
	public static void main(String[] args) {
		ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();
		new Thread(new Runnable() {
			@Override
			public void run() {
				rwLock.writeLock().lock();
				rwLock.readLock().lock();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					rwLock.readLock().unlock();
					rwLock.writeLock().unlock();
				}
			}
		}).start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				rwLock.readLock().lock();
				try {
					System.out.println("读锁获取锁");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					rwLock.readLock().unlock();
				}
			}
		}).start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				rwLock.writeLock().lock();
				try {
					System.out.println("写获取锁");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					rwLock.writeLock().unlock();
				}
			}
		}).start();
	}
	
}
