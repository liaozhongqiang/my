package concurrent.jointest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainRun {
	
	private static Logger logger=LoggerFactory.getLogger(MainRun.class);
	
	public static void main(String[] args) throws InterruptedException {
		ThreadB b =new ThreadB();
		ThreadA a =new ThreadA(b);
		a.start();
		b.start();
		//System.out.println("Main join");
		b.join(2000);
		logger.info("Main end");
	}

}
