package com.my.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.tools.extcheck.Main;

/**
 * 日期工具
 * @author liaozq
 * @DATE 2015年11月18日
 */
public class DateUtil {
	
	public static String getNow(String pattern){
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}
	
	public static Date getDate(String date) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return	sdf.parse(date);
	}
	
	
	public static void main(String[] args) throws Exception {
		String time=	getNow("yyyy-MM-dd");
		System.out.println(time);
		System.out.println(getDate(time));
	}

}
