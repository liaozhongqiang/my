package concurrent;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import concurrent.forkjoin.Product;
import concurrent.forkjoin.ProductListGnerator;
import concurrent.forkjoin.Task;

public class ForkJoinTest {

	public static void main(String[] args) {
		ForkJoinPool fjp = new ForkJoinPool();
		List<Product> list = ProductListGnerator.genrate(10000);
		Task task = new Task(list, 0, list.size(), 0.5);
		fjp.execute(task);
		do {
			System.out.printf("Main: Thread Count: %d\n", fjp.getActiveThreadCount());
			System.out.printf("Main: Thread Steal: %d\n", fjp.getStealCount());
			System.out.printf("Main: Parallelism: %d\n", fjp.getParallelism());
			try {
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!task.isDone());
	}

}
