package com.my.core.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.SystemUtils;

/**
 * 执行命令行工具
 * 
 * @author liaozq
 * @DATE 2015年11月18日
 */
public class CMDUtil {
	public static String callCmd(String cmd) throws Exception {

		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		Process process = null;
		try {
			if (SystemUtils.IS_OS_LINUX) {
				process = Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", cmd });
			} else if (SystemUtils.IS_OS_WINDOWS) {
				process = Runtime.getRuntime().exec(cmd);
			}
			// 获取输入流
			is = process.getInputStream();
			// 用一个读输出流类去读
			isr = new InputStreamReader(is);
			// 用缓冲器读行
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				is.close();
			}
			if (null != isr) {
				isr.close();
			}

			if (null != br) {
				br.close();
			}
		}
		return sb.toString();
	}
}
