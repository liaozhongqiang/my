package concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
	
	
	public static void main(String[] args) {
		List<String> list=new CopyOnWriteArrayList<String>();
		list.add("");
		
		
		Collections.synchronizedList(list);
	}

}
