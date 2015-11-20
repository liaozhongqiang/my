package com.my.core.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.SystemUtils;

/**
 * 
 * @author liaozq
 * @DATE 2015年11月19日
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
			// ��ȡ������
			is = process.getInputStream();
			// ��һ�����������ȥ��
			isr = new InputStreamReader(is);
			// �û���������
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
