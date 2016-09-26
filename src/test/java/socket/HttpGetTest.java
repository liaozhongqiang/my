package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class HttpGetTest {
	
	@Test
	public void sendGetTest() throws UnknownHostException, IOException{
		Socket socket=new Socket("news.baidu.com", 80);
		OutputStream os=socket.getOutputStream();
		String get="GET / HTTP/1.1\r\nHost:news.baidu.com\r\nConnection:close\r\n\r\n";
		os.write(get.getBytes());
		os.flush();
		InputStream is=socket.getInputStream();
		StringBuilder sb = new StringBuilder();
		while(true){
			byte[] b = new byte[1024];
			int i=is.read(b);
			System.out.println(i);
			if(i==-1){
				socket.close();
				break;
			}
			//System.out.println(new String(b,"GBK"));
		}
	}
}
