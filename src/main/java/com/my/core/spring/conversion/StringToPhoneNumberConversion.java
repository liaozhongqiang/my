package com.my.core.spring.conversion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import com.my.entity.PhoneNumber;


public class StringToPhoneNumberConversion implements Converter<String, PhoneNumber>{
	
	private Pattern pattern=Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");

	@Override
	public PhoneNumber convert(String source) {
		if(!StringUtils.hasLength(source)){
			return null;
		}
		Matcher matcher=pattern.matcher(source);
		if(matcher.matches()){
			PhoneNumber pojo=new PhoneNumber();
			pojo.setAreaCode(matcher.group(1));
			pojo.setPhoneNumber(matcher.group(2));
			return pojo;
		}else{
			throw new IllegalArgumentException(String.format("类型转换失败,需要格式[010-1234567],但格式是[%s]", source));
		}
	}
	
}
