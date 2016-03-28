package test;

import org.junit.Test;

public class Test4 {
	
	@Test
	public void test1(){
		int[] a={1,2};
		System.out.println(a.getClass().getSuperclass());
		System.out.println(a.getClass().getName());
		foo(a);
		System.out.println(a[1]);
	}

	public static void foo(int[] a){
		a[1]=10;
	}
}
