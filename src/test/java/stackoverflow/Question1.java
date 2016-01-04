package stackoverflow;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class Question1 {
	
	/**
	 *  InputStream 转String
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		InputStream inpustream=null;
		IOUtils.toString(inpustream,"");
		
		//使用原生库
		Scanner scanner=new Scanner(inpustream).useDelimiter("\\A");
		String str=scanner.hasNext()?scanner.next():"";
	}

}
