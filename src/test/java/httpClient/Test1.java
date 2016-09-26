package httpClient;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

public class Test1 {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		Response rs=Request.Post("http://101.226.253.100:8000/robot/ask.action")
        .bodyForm(Form.form().add("platform", "web").add("userId", "123").add("question", "开户").build(),Charset.forName("utf-8"))
        .execute();
		System.out.println(rs.returnContent().asString(Charset.forName("utf-8")));
	}

}
