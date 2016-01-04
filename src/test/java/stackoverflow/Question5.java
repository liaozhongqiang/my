package stackoverflow;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

/**
 * 快速生产随机数，或者随机字符串
 * @author liaozq
 * @DATE 2015年12月30日
 */
public class Question5 {
	
	public static void main(String[] args) {
		
		System.out.println(RandomUtils.nextInt(1, 10));
		
		System.out.println(RandomStringUtils.randomNumeric(5));
		
		System.out.println(RandomStringUtils.randomAlphabetic(5));
		
		System.out.println(RandomStringUtils.randomAlphanumeric(5));
		
	}

}
