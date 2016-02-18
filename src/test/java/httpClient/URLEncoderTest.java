package httpClient;

import java.io.IOException;
import java.net.URLEncoder;

public class URLEncoderTest {
	
	
	public static void main(String[] args) throws IOException {
		//System.out.println(URLEncoder.encode("+ +", "UTF-8"));
		String str="南方的艳阳天，+大雪   123Ab";
		System.out.println(URLEncoder.encode(str, "UTF-8"));
		
	}

}
