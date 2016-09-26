package guava;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 *  guava collection multiset 
 *  此类跟set集合功能差不多，但是其的数据可以重复。
 * @author lzq
 * @date 2016年4月6日
 *
 */
public class MultisetTest {
	
	@Test
	public void test1(){
		Multiset<String> multiset=HashMultiset.create();
		multiset.add("sb");
		multiset.add("sb");
		System.out.println(multiset.count("sb"));
	}
}
