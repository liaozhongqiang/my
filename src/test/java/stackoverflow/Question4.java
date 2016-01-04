package stackoverflow;

import org.apache.commons.lang3.ArrayUtils;
/**
 * 快速合并数组
 * @author liaozq
 * @DATE 2015年12月30日
 */
public class Question4 {
	
	public static void main(String[] args) {
		int[] a={1,23,4,567,8};
		int[] b={1,1,1};
		int[] xx=ArrayUtils.addAll(a, b);
		System.out.println(xx);
	}

}
