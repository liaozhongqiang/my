package guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * Guava 异步处理
 * @author lzq
 * @date 2016年8月25日
 *
 */
public class GuavaFuture {
	
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(es);
		ListenableFuture<String> listenableFuture = listeningExecutorService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("task start");
				Thread.sleep(3000);
				System.out.println("task end");
				return "hello";
			}
		});
		Futures.addCallback(listenableFuture, new FutureCallback<String>() {
			@Override
			public void onSuccess(String result) {
				System.out.println(result);
			}
			@Override
			public void onFailure(Throwable t) {
				t.printStackTrace();
			}
		});
		System.out.println("main thread is running");
		es.shutdown();
	}

}
