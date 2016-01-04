package stackoverflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组转List
 * @author liaozq
 * @DATE 2015年12月30日
 */
public class Question2 {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a={1,2,34,5};
		List<Integer> list=Arrays.asList(1,2,34);
		List<Integer> list2=Arrays.asList(a);
		System.out.println(list);
		System.out.println(list2);
		List<Integer> list3=new ArrayList<Integer>();
		Collections.addAll(list3, a);
		a[0]=233;//这个改变了 list2也会改变,但是list3不会改变
		System.out.println(list2);
		System.out.println(list3);
		list2.remove(2);//不能改变list2,会抛出UnsupportedOperationException
	}

}
