package com.test;

import java.io.InputStream;

public class Test1 {
	
	public static void main(String[] args) {
		InputStream is=	ClassLoader.getSystemResourceAsStream("uploadconfig.xml");
		System.out.println(is);
	}
}
