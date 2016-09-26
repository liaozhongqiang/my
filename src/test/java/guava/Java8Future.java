package guava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * jdk 8 异步调用
 * @author lzq
 * @date 2016年8月25日
 *
 */
public class Java8Future {
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {

			@Override
			public String get() {
				System.out.println("task start");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("task end");
				return "hello";
			}
		},es);
		future.thenAccept(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("result:"+t);
			}
		});
		es.shutdown();
		System.out.println("main thread is running");
	}

}
