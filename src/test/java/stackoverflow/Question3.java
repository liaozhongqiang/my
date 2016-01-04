package stackoverflow;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 判断数组里面是否包含某个值
 * @author liaozq
 * @DATE 2015年12月30日
 */
public class Question3 {
	
	public static void main(String[] args) {
		int[] a={1,2,3,4,5};
		System.out.println(ArrayUtils.contains(a, 1));
	}

}
