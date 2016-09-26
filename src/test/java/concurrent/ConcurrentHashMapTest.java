package concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class ConcurrentHashMapTest {
	
	public static void main(String[] args) {
		
		Map<String,String> map=new ConcurrentHashMap<String, String>();
		//Map<String,String> map=new HashMap<String, String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map.put("6", "6");
		map.put("7", "7");
		Set<Map.Entry<String, String>> set=map.entrySet();
		for(Map.Entry<String, String> entry:set){
			if("3".equals(entry.getKey())){
				map.put(entry.getKey()+"new",entry.getValue()+ "new");
			}
			System.out.println(set.size());
		}
		
		for(Map.Entry<String, String> entry:set){
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		System.out.println(map);
	}
	
	@Test
	public void test1(){
		Map<String,String> map = new HashMap<String,String>();
		Collections.synchronizedMap(map);
		
	}
}
