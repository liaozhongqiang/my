package concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) {
		
		
		Map<String,String> map=new ConcurrentHashMap<String, String>();
		
		map.put("111", "222");
		
		map.put("112", "333");
		
		
	}

}
