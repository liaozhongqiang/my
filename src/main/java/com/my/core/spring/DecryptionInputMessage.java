package com.my.core.spring;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

import com.my.core.util.DesUtil;



public class DecryptionInputMessage implements HttpInputMessage{
	
	private  InputStream body;
	
	private  HttpHeaders header;
	
	public DecryptionInputMessage(InputStream body, HttpHeaders headers) throws IOException{
		try {
			this.body=IOUtils.toInputStream(DesUtil.decrypt(IOUtils.toString(body)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.header=headers;
	}

	@Override
	public HttpHeaders getHeaders() {
		return this.header;
	}

	@Override
	public InputStream getBody() throws IOException {
		return this.body;
	}

}
