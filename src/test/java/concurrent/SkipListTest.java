package concurrent;

import java.util.concurrent.ConcurrentSkipListMap;

import org.junit.Test;

/**
 * 跳表
 * @author lzq
 * @date 2016年8月16日
 *
 */
public class SkipListTest {
	
	@Test
	public void test1(){
		
		ConcurrentSkipListMap<String, String> map = new ConcurrentSkipListMap<>();
		
		map.put("a", "b");
		
		
	}

}
