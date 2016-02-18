package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test {
	
	
	public static void main(String[] args) throws Exception {
		InputStream is=new FileInputStream("C:\\Users\\myzhong2012\\Desktop\\新建文本文档 (2).txt");
		byte[] b=new byte[is.available()];
		is.read(b);
		OutputStream os=new FileOutputStream("C:\\Users\\myzhong2012\\Desktop\\222.txt");
		Map map=(Map) JSON.parse(new String(b));
		List<String> target= (List<String>) map.get("target");
		os.write(target.get(0).getBytes());
	}

}
