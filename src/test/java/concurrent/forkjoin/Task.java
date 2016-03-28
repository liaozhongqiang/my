package concurrent.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Product> products;
	
	private int first;
	
	private int last;
	
	private double increment;
	
	

	public Task(List<Product> products, int first, int last, double increment) {
		super();
		this.products = products;
		this.first = first;
		this.last = last;
		this.increment = increment;
	}
	
	public Task() {
		super();
	}

	@Override
	protected void compute() {
		if(last-first<10){
			updateprice();
		}else{
			int middle=(last+first)/2;
			System.out.println("Task:Pending tasks:"+getQueuedTaskCount());
			Task task1=new Task(products, first, middle+1, increment);
			Task task2=new Task(products, middle+1, last, increment);
			invokeAll(task1,task2);
		}
	}
	
	private void updateprice(){
		Product product=null;
		for(int i=first;i<last;i++){
			product=products.get(i);
			product.setPrice(product.getPrice()*increment);
		}
	}

}
