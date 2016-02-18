package httpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;



public class Test {
	
	public static void main(String[] args) throws Exception {
		
		String commString="id="+Base64.encodeBase64String("我就测试一下而已".getBytes("UTF-8"))+"&name=傻逼";
		
		connectURL(commString, "http://172.16.30.163:8080/myweb/test/testHttp");
		
		
	}
	
	
	public static String connectURL(String commString, String address) {
		String rec_string = "";
		URL url = null;
		HttpURLConnection urlConn = null;
		try {
			url = new URL(address);
			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setConnectTimeout(60000);
			urlConn.setReadTimeout(60000);
			urlConn.setRequestMethod("POST");
			urlConn.setDoOutput(true);
			urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			OutputStream out = urlConn.getOutputStream();
			out.write(commString.getBytes());
			out.flush();
			out.close();
			BufferedReader rd = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			int ch;
			while ((ch = rd.read()) > -1) {
				sb.append((char) ch);
			}
			rec_string = sb.toString().trim();
			rd.close();
			System.out.println("发送到" + address + "?" + commString + "成功，返回：" + rec_string);
		} catch (Exception e) {
			rec_string = "-107";
			System.out.println(e);
		} finally {
			if (urlConn != null) {
				urlConn.disconnect();
			}
		}
		return rec_string;
	}

}
