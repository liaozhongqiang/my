package guava;

import java.util.concurrent.Callable;

import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;

/**
 * Netty 里面的异步处理
 * @author lzq
 * @date 2016年8月25日
 *
 */
public class NettyFuture {
	
	public static void main(String[] args) {
		EventExecutorGroup eeg = new DefaultEventExecutor();
		Future<String> future = eeg.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("task start");
				Thread.sleep(3000);
				System.out.println("task end");
				return "hello";
			}
		});
		future.addListener(new FutureListener<String>() {
			@Override
			public void operationComplete(Future<String> fu) throws Exception {
				System.out.println("listening");
				if(fu.isSuccess()){
					System.out.println(fu.get());
				}
			}
		});
		System.out.println("main thread is running");
		eeg.shutdownGracefully();
	}

}
