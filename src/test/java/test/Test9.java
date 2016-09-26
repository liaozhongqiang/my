package test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AbstractQueuedSynchronizer
 * @author lzq
 * @date 2016年4月27日
 *
 */
public class Test9 {
	
	public  static void main(String[] args) {
		/*ReentrantLock lock=new ReentrantLock();
		
		lock.lock();
		try{
			System.out.println("do something");
		}finally{
			lock.unlock();
		}
		Condition condition=lock.newCondition();
		try {
			condition.await();
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		BoundBuffer bb=new BoundBuffer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					try {
						bb.take();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					try {
						bb.put(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
}

class BoundBuffer{
	
	final ReentrantLock lock=new ReentrantLock();
	final Condition notFull=lock.newCondition();
	final Condition notEmpty=lock.newCondition();
	
	final Object[] items=new Object[100];
	
	int count,putptr,takeptr;
	
	public void put(Object x) throws Exception{
		lock.lock();
		System.out.println("put get the lock");
		try{
			while(count==items.length){
				System.out.println("full,please wait");
				notFull.await();
			}
			items[putptr]=x;
			System.out.println("put a elements");
			if(++putptr==items.length){
				putptr=0;
			}
			++count;
			notEmpty.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public Object take() throws Exception{
		lock.lock();
		System.out.println("take get the lock");
		try{
			while(count==0){
				System.out.println("no elements,please wait");
				notEmpty.await();
			}
			Object x=items[takeptr];
			System.out.println("take a elements");
			if(++takeptr==items.length){
				takeptr=0;
			}
			count--;
			notFull.signal();
			return x;
		}finally{
			lock.unlock();
		}
	}
	
}


