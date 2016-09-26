package test;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class Test6 {
	
	@Test
	public void test(){
		
		Set<int[]> set=new HashSet<int[]>();
		
		set.add(new int[]{1,1});
		set.add(new int[]{1,2,6,8,1});
		set.add(new int[]{1,3});
		set.add(new int[]{1,4,5});
		
		int[][] array= set.toArray(new int[set.size()][]);
		
		System.out.println(array[1][1]);
		
		System.out.println(RandomStringUtils.random(10,true,false));
	}

}
