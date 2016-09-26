package core.jvm;

import org.junit.Test;

/**
 * 字符串常量测试
 * 
 * @author lzq
 * @date 2016年8月24日
 *
 */
public class StringTest {

	@Test
	public void test1() {
		String a = "1111";
		System.out.println(a == "1111");
	}

	@Test
	public void test2() {
		String a = new String("1")+new String("1");
		a.intern();
		String b = "11";
		System.out.println(a == b);
	}

	@Test
	public void test3() {
	/*	String s = new String("1");
		s.intern();
		String s2 = "1";
		System.out.println(s == s2);
*/
		String s3 = new String("1") + new String("2");
		s3.intern();
		String s4 = "12";
		System.out.println(s3 == s4);
	}
	
	public static void main(String[] args) {
		String s = new String("1")+new String("23");
		String	s5=	s.intern();
		String s2 = "1";
		System.out.println(s == s5);

		String s3 = new String("1") + new String("1");
		s3.intern();
		String s4 = "11";
		System.out.println(s3 == s4);
	}

}
