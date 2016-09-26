package httpClient;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.impl.io.DefaultHttpRequestParser;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.impl.io.SessionInputBufferImpl;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

public class Test2HTTP {
	
	public static void main(String[] args) throws IOException, HttpException {
		 String str = "POST http://localhost:8080/foobar/1234567 HTTP/1.1\n" +
		            "Message-ID: <19815303.1075861029555.JavaMail.ss@kk>\n" +
		            "Date: Wed, 6 Mar 2010 12:32:20 -0800 (PST)\n" +
		            "From: someone@someotherplace.com\n" +
		            "To: someone@someplace.com\n" +
		            "Subject: some subject\n" +
		            "Mime-Version: 1.0\n" +
		            "Content-Type: text/plain; charset=UTF-16\n" +
		            "Content-Length: 28\n"+
		            "X-From: one, some <some.one@someotherplace.com>\n" +
		            "X-To: one\n" +
		            "X-cc: \n" +
		            "X-bcc: \n" +
		            "X-Origin: Bob-R\n" +
		            "X-FileName: rbob (Non-Privileged).pst\n" +
		            "\n" +
		            "somemessage\n";
		        ByteArrayInputStream fakeStream = new ByteArrayInputStream(
		                str.getBytes());
		        HttpTransportMetricsImpl metrics = new HttpTransportMetricsImpl();
		        SessionInputBufferImpl inbuffer = new SessionInputBufferImpl(metrics, 1024);

		        inbuffer.bind(fakeStream);
		        HttpMessageParser<HttpRequest> requestParser =
		                new DefaultHttpRequestParser(inbuffer);
		        BasicHttpEntityEnclosingRequest request = (BasicHttpEntityEnclosingRequest)requestParser.parse();

		        for (Header hdr : request.getAllHeaders()) {
		            System.out.println(String.format("%-30s = %s", hdr.getName(), hdr.getValue()));
		        }
		        System.out.println(String.format("Request Line: %s", request.getRequestLine()));
		        System.out.println(String.format("Body\n------------------\n%s",
		                request.getEntity()));
		    }

}
