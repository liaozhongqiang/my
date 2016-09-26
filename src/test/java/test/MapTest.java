package test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

import org.apache.commons.collections.map.LRUMap;
import org.junit.Test;

public class MapTest {
	
	public static void main(String[] args) {
		Map<String,String> hashMap = new HashMap<>();
		
		Map<String,String> treeMap = new TreeMap<>();
		treeMap.put("", "");
		
		Map<String,String> weakHashMap = new WeakHashMap<>();
		
		Map<String,String> hashTable = new Hashtable<>();
		
		Map<String,String> linkedHashMap = new LinkedHashMap<>();
		
		Collections.synchronizedMap(hashMap);
		
	}
	
	/**
	 * 测试WeakHashMap
	 */
	@Test
	public void test1(){
		
		Map<String,byte[]> weakHashMap = new WeakHashMap<>();
		
		for(int i=0;i<100;i++){
			weakHashMap.put("test"+i, new byte[1024*1024*5]);
			//System.gc();
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	*/	}
		System.out.println(weakHashMap.get("test1"));
	}
	
	
	/**
	 * LRUMap
	 * @author lzq
	 * @date 2016年8月10日
	 *
	 */
	class LRUMap<K,V> extends LinkedHashMap<K, V>{
		
		private int MAX_SIZE;

		/**
		 * 
		 */
		private static final long serialVersionUID = -9195917322094691842L;
		
		/**
		 * 设置LRU的大小
		 * @param maxSize
		 */
		public LRUMap(int maxSize) {
			super(16, 0.75f, true);
			this.MAX_SIZE=maxSize;
		}
		
		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
			return size()>MAX_SIZE;
		}
	}
}
