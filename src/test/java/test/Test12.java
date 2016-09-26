package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import com.alibaba.fastjson.JSON;


public class Test12 {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		InputStream is=new FileInputStream("C:\\Users\\myzhong2012\\Desktop\\111.png");
		byte[] t=new byte[is.available()];
		is.read(t);
		final String str=Base64.encodeBase64String(t);
		Map<String,String> map=new HashMap<String,String>();
		map.put("service_id", "upload_service");
		map.put("base64Img", str);
		String s=JSON.toJSONString(map);
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100;i++){
					try {
						Request.Post("http://172.16.41.33:8080/robot/chat.do").bodyString(s, ContentType.DEFAULT_TEXT).execute().returnContent().asString();
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		Map<String,String> map2=new HashMap<String,String>();
		map2.put("service_id", "robot_chatService");
		map2.put("question", "傻逼怎么是你啊，卧槽");
		String s2=JSON.toJSONString(map2);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<1000;i++){
					try {
						Request.Post("http://172.16.41.33:8080/robot/chat.do").bodyString(s2, ContentType.DEFAULT_TEXT).execute().returnContent().asString();
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		
		System.out.println("OK");
	}

}
