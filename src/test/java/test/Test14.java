package test;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Base64;



/**
 * Test try catch finnaly
 * @author lzq
 * @date 2016年8月24日
 *
 */
public class Test14 {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(test());
		
	}
	
	public static int test(){
		int i=0;
		try{
			return i;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("1111");
		}
		return i;
	}

}
