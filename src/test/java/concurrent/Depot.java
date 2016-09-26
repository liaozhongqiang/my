package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Depot {

	private int capacity; // 容量

	private int size; // 实际大小
	
	private Lock lock;
	
	private Condition fullCondition;
	
	private Condition emptyCondition;

	public Depot(int capacity) {
		super();
		this.capacity = capacity;
		this.lock=new ReentrantLock();
		this.fullCondition=lock.newCondition();
		this.emptyCondition=lock.newCondition();
	}

	public  void produce(int val) {
		lock.lock();
		try {
			int prod = val;
			while (prod > 0) {
				int i = prod;
				while (size >= capacity) {
					fullCondition.await();
				}
				int syrl = capacity - size;
				int _prod = prod > syrl ? syrl : prod;
				size += _prod;
				prod -= _prod;
				System.out.printf("%s线程初始要生产%3d,此次要生产%3d,此次生产了%3d,后容量为%3d\n",Thread.currentThread().getName(),val,i,_prod,size);
				emptyCondition.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public  void consume(int val) {
		int sume = val;
		lock.lock();
		try {
			while (sume > 0) {
				int i = sume;
				while (size <= 0) {
					emptyCondition.await();
				}
				int dec = sume<size?sume:size;
				size-=dec;
				sume-=dec;
				System.out.printf("%s线程初始要消费%3d,此次要消费%3d,此次消费了%3d,后容量为%3d\n",Thread.currentThread().getName(),val,i,dec,size);
				fullCondition.signal();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Depot depot = new Depot(100);
		new Thread(()->{depot.produce(60);}).start();
		new Thread(()->{depot.produce(120);}).start();
		new Thread(()->{depot.consume(90);}).start();
		new Thread(()->{depot.consume(150);}).start();
		new Thread(()->{depot.produce(110);}).start();
	}
}
