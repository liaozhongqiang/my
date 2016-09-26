package test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class Test5 {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str ="I am 君山";
		
		System.out.println(Arrays.toString(str.toCharArray()));
		
		byte [] biso=str.getBytes(StandardCharsets.ISO_8859_1);
		
		System.out.println(new String(biso));
		
		System.out.println(Arrays.toString(biso));
		
		byte[] butf8=str.getBytes(StandardCharsets.UTF_8);
		
		System.out.println(Arrays.toString(butf8));
		
		System.out.println(Arrays.toString(str.getBytes()));
		
		System.out.println(Arrays.toString(str.getBytes(StandardCharsets.UTF_16)));
		
		
		
		//Collection<E>
		
	}
}
