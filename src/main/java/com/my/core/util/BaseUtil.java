package com.my.core.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * 基础工具类
 * @author liaozq
 * @DATE 2015年11月18日
 */
public class BaseUtil {
	public static Resource getResource(String path) {
		return ((ResourcePatternResolver) new PathMatchingResourcePatternResolver()).getResource(path);
	}
}
