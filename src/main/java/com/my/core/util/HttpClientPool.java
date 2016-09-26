package com.my.core.util;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.http.HttpEntity;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author lzq
 *
 */
public class HttpClientPool {

	private static PoolingHttpClientConnectionManager cm;

	private static HttpRequestRetryHandler httpRequestRetryHandler;

	private static RequestConfig requestConfig;

	private static final int MAX_TOTAL = 200;

	private static final int DEFAULT_MAX_PERROUTE = 100;

	private static final int CONNECTION_REQUEST_TIMEOUT = 5000;// 从连接池获取连接超时时间

	private static final int CONNECT_TIMEOUT = 5000;// 获取主机连接连接超时时间

	private static final int SOCKET_TIMEOUT = 10000;// 获取数据连接超时时间

	// 初始化Manager
	static {
		cm = new PoolingHttpClientConnectionManager();
		// 设置最大连接数
		cm.setMaxTotal(MAX_TOTAL);
		// 每个路由的最大连接
		cm.setDefaultMaxPerRoute(DEFAULT_MAX_PERROUTE);

		// 请求重试
		httpRequestRetryHandler = new HttpRequestRetryHandler() {

			@Override
			public boolean retryRequest(IOException ex, int executionCount, HttpContext arg2) {
				if (executionCount > 3) {
					return false;
				}
				// 服务器丢了连接，重试
				if (ex instanceof NoHttpResponseException) {
					return true;
				}
				return false;
			}
		};

		requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
				.setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
	}

	/**
	 * 
	 * @param connectionTimeOut
	 *            获取连接超时时间
	 * @param soTimeOut
	 *            等待数据超时时间
	 * @param connManagerTimeOut
	 *            从Manager获取httpclient的等待时间
	 * @return
	 */
	public static CloseableHttpClient getHttpClient() {
		return HttpClients.custom().setConnectionManager(cm).setRetryHandler(httpRequestRetryHandler)
				.setDefaultRequestConfig(requestConfig).build();
	}

	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {

		SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(new TrustSelfSignedStrategy()).build();
		// Allow TLSv1 protocol only
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,SSLConnectionSocketFactory.getDefaultHostnameVerifier());
		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		try {
			HttpGet httpget = new HttpGet("https://www.baidu.com/");

			//HttpPost post = new HttpPost("https://www.baidu.com/");
			

			System.out.println("Executing request " + httpget.getRequestLine());

			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				HttpEntity entity = response.getEntity();

				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

}
