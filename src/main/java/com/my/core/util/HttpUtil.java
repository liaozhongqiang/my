package com.my.core.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * http
 * @author liaozq
 * @DATE 2015年11月20日
 */
public class HttpUtil {
	
	/**
	 * GET
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static Map<String,String> sendGetRequest(String url) throws Exception{
		 Map<String,String> resultmap=new HashMap<String,String>();
		 String result=null;
		 CloseableHttpClient closeableHttpClient=HttpClients.createDefault();
		 HttpGet httpGet=new HttpGet(url);
		 HttpResponse httpResponse=closeableHttpClient.execute(httpGet);
		 int statusCode=httpResponse.getStatusLine().getStatusCode();
		 resultmap.put("statusCode", statusCode+"");
		 if(HttpStatus.SC_OK==statusCode){
			 HttpEntity httpEntity=httpResponse.getEntity();
			 result=EntityUtils.toString(httpEntity,Charset.forName("UTF-8"));
		 }
		 resultmap.put("result", result);
		 return resultmap;
	}
	
	/**
	 * POST
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static Map<String,String> sendPostRequest(String url,Map<String,String> params) throws Exception{
		 Map<String,String> resultmap=new HashMap<String,String>();
		 String result=null;
		 CloseableHttpClient closeableHttpClient=HttpClients.createDefault();
		 HttpPost httpPost=new HttpPost(url);
		 List<NameValuePair> nvps=new ArrayList<NameValuePair>();
		 if(!params.isEmpty()){
			 for(Map.Entry<String, String> set:params.entrySet()){
				 nvps.add(new BasicNameValuePair(set.getKey(), set.getValue()));
			 }
			 httpPost.setEntity(new UrlEncodedFormEntity(nvps,Charset.forName("UTF-8")));
		 }
		 HttpResponse httpResponse=closeableHttpClient.execute(httpPost);
		 int statusCode=httpResponse.getStatusLine().getStatusCode();
		 resultmap.put("statusCode", statusCode+"");
		 if(HttpStatus.SC_OK==statusCode){
			 HttpEntity httpEntity=httpResponse.getEntity();
			 result=EntityUtils.toString(httpEntity,Charset.forName("UTF-8"));
		 }
		 resultmap.put("result", result);
		 return resultmap;
	 }
	
	public static void main(String[] args) throws Exception {
		Map<String,String> params=new HashMap<String,String>();
		params.put("id", "12344");
		params.put("name", "李四");
		System.out.println(sendPostRequest("http://localhost:8080/myweb/test/testHttp", params));
	}
}
