package concurrent.waittest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {
	
	private static Logger logger=LoggerFactory.getLogger(MainTest.class);
	
	public static void main(String[] args) throws InterruptedException {
		
		RunTest test=new RunTest();
		
		Thread a=new Thread(()->{test.test1(2000);});
		a.start();
		
		new Thread(()->{test.test2();}).start();
		
		Thread.sleep(1010);
		
		a.join();
		
		logger.info("Main end");
		
	}

}


class RunTest{
	
	private static Logger logger=LoggerFactory.getLogger(RunTest.class);
	
	public synchronized void test1(int timeout){
		logger.info("RunTest1 start:{}",Thread.currentThread().getName());
		try {
			wait(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//logger.info("RunTest1 end:{}",Thread.currentThread().getName());
	}
	
	public synchronized void test2(){
		logger.info("RunTest2 start:{}",Thread.currentThread().getName());
		//notifyAll();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("RunTest2 end:{}",Thread.currentThread().getName());
	}
}
