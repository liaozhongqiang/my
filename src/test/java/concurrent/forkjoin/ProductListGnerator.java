package concurrent.forkjoin;

import java.util.ArrayList;
import java.util.List;

public class ProductListGnerator {
	
	public static List<Product> genrate(int size){
		List<Product> list=new ArrayList<Product>();
		Product product=null;
		for(int i=0;i<size;i++){
			product=new Product();
			product.setName("product-"+i);
			product.setPrice(10);
			list.add(product);
		}
		return list;
	}
}
