package concurrent.jointest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadB extends Thread{
	
	private static Logger logger=LoggerFactory.getLogger(ThreadB.class);
	
	
	@Override
	public synchronized void run() {
		logger.info("ThreadB start");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("ThreadB end");
	}
	
}
