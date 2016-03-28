package com.my.core.util;

import java.io.IOException;

import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

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

	private static final int CONNECTION_REQUEST_TIMEOUT = 5000;//从连接池获取连接超时时间

	private static final int CONNECT_TIMEOUT = 5000;//获取主机连接连接超时时间

	private static final int SOCKET_TIMEOUT = 10000;//获取数据连接超时时间

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
				.setConnectTimeout(CONNECT_TIMEOUT).setConnectTimeout(SOCKET_TIMEOUT)
				.build();
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

}
