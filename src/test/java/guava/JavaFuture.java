package guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * JDK 1.8 之前异步处理
 * @author lzq
 * @date 2016年8月25日
 *
 */
public class JavaFuture {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<String> future = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("task start");
				Thread.sleep(3000);
				System.out.println("task end");
				return "hello";
			}
		});
		es.shutdown();
		System.out.println(future.get());
		System.out.println("main thread is blocking");
	}

}
