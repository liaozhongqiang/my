package com.my.core.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 
 * @author liaozq
 * @DATE 2015年11月19日
 */
public class BaseUtil {
	public static Resource getResource(String path) {
		return ((ResourcePatternResolver) new PathMatchingResourcePatternResolver()).getResource(path);
	}
	
	
	public static InputStream decrypInputStream(InputStream is){
		try {
			IOUtils.toString(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String decrypString(String msg){
		return null;
	}
}
