package core;

public class Depot {

	private int capacity; // 容量

	private int size; // 实际大小
	
	

	public Depot(int capacity) {
		super();
		this.capacity = capacity;
	}

	public synchronized void produce(int val) {
		int prod = val;
		try {
			while (prod > 0) {
				int i = prod;
				while (size >= capacity) {
					wait();
				}
				int syrl = capacity - size;
				int _prod = prod > syrl ? syrl : prod;
				size += _prod;
				prod -= _prod;
				System.out.printf("%s线程初始要生产%3d,此次要生产%3d,此次生产了%3d,后容量为%3d\n",Thread.currentThread().getName(),val,i,_prod,size);
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void consume(int val) {
		int sume = val;
		try {
			while (sume > 0) {
				int i = sume;
				while (size <= 0) {
					wait();
				}
				int dec = sume<size?sume:size;
				size-=dec;
				sume-=dec;
				System.out.printf("%s线程初始要消费%3d,此次要消费%3d,此次消费了%3d,后容量为%3d\n",Thread.currentThread().getName(),val,i,dec,size);
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Depot depot = new Depot(100);
		new Thread(()->{depot.produce(60);}).start();
		new Thread(()->{depot.produce(120);}).start();
		new Thread(()->{depot.consume(90);}).start();
		new Thread(()->{depot.consume(150);}).start();
		new Thread(()->{depot.produce(110);}).start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(depot.size);
	}

}
