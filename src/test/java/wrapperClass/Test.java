package wrapperClass;


public class Test {
	
	public static void main(String[] args) {
		
		String s1="hello";
		String s2="hello";
		String s3="h"+"ello";
		String s4="h";
		String s5="ello";
		String s6=s4+s5;
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s6);
		
	}

}
