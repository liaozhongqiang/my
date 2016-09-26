package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import sun.misc.BASE64Encoder;


public class Test13 {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		InputStream is=new FileInputStream("C:\\Users\\myzhong2012\\Desktop\\audio.amr");
		byte[] b=new byte[is.available()];
		is.read(b);
		String line=Base64.encodeBase64String(b);
		OutputStream os=new FileOutputStream("C:\\Users\\myzhong2012\\Desktop\\111.txt");
		os.write(line.getBytes());
		BASE64Encoder base=new BASE64Encoder();
		
		String	line2=new String(java.util.Base64.getEncoder().encode(b),"UTF-8");
		OutputStream os1=new FileOutputStream("C:\\Users\\myzhong2012\\Desktop\\1112.txt");
		os1.write(line2.getBytes());
		
		System.out.println(line.equals(line2));
	}

}
