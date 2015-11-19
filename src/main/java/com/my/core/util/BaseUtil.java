package com.my.core.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * ����������
 * @author liaozq
 * @DATE 2015��11��18��
 */
public class BaseUtil {
	public static Resource getResource(String path) {
		return ((ResourcePatternResolver) new PathMatchingResourcePatternResolver()).getResource(path);
	}
}
