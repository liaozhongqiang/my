package com.my.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.mysql.jdbc.Buffer;

/**
 * https 
 * @author liaozq
 * @DATE 2015年11月20日
 */
@SuppressWarnings("deprecation")
@Deprecated
public class HttpsUtil {
	
	 public static CloseableHttpClient createSSLClientDefault() {
	        try {
	            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
	                // 信任所有
	                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	                    return true;
	                }
	            }).build();
	            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
	            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	        } catch (KeyManagementException e) {
	            e.printStackTrace();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } catch (KeyStoreException e) {
	            e.printStackTrace();
	        }
	        return HttpClients.createDefault();
	 }
	 
	 /**
	  * GET
	  * @param url
	  * @return
	  * @throws Exception
	  */
	 public static Map<String,String> sendGetRequesst(String url) throws Exception{
		 Map<String,String> resultmap=new HashMap<String,String>();
		 String result=null;
		 CloseableHttpClient closeableHttpClient=HttpsUtil.createSSLClientDefault();
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
		 CloseableHttpClient closeableHttpClient=HttpsUtil.createSSLClientDefault();
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
		System.out.println(sendGetRequesst("https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2015-11-21&leftTicketDTO.from_station=SZQ&leftTicketDTO.to_station=GZG&purpose_codes=ADULT"));
	}

}
