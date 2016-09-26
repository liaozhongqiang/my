package core.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class ThreadPoolTest {
	
	
	/**
	 * Future.get()方法会抛出ExecutionExcpetion
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void test1() throws InterruptedException, ExecutionException{
		ExecutorService es = Executors.newSingleThreadExecutor();
		List<Future<?>> fs = new ArrayList<>();
		for(int i=1;i<10;i++){
			final int j=i;
			Future<?> f=es.submit(()->{
				System.out.println("执行到任务:"+j);
				if(j%2==0){
					System.out.println(j/0);
				}
			});
			fs.add(f);
		}
		es.shutdown();
		System.out.println("线程池Terminated状态:"+es.isTerminated());
		for(Future<?> f: fs){
			System.out.println(f.get());
		}
	}
	
	@Test
	public void test2(){
		
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "11111";
			}
		};
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("11111");
			}
		};
		
		FutureTask<String> futureTask = new FutureTask<>(callable);
	}

	
	
	public static void main(String[] args) throws SQLException {
		Connection conn= null;
		conn.commit();
	}
}
