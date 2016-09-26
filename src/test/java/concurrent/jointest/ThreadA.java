package concurrent.jointest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadA extends Thread{
	
	private static Logger logger=LoggerFactory.getLogger(ThreadA.class);
	
	private ThreadB b;
	
	public ThreadA(ThreadB b) {
		this.b=b;
	}
	
	@Override
	public void run() {
		synchronized (b) {
			logger.info("ThreadA start");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("ThreadA end");
		}
	}
}
