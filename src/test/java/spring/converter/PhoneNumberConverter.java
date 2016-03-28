package spring.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.StringUtils;

public class PhoneNumberConverter implements Converter<String, PhoneNumberPojo>{
	
	private Pattern pattern=Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");

	@Override
	public PhoneNumberPojo convert(String source) {
		if(!StringUtils.hasLength(source)){
			return null;
		}
		Matcher matcher=pattern.matcher(source);
		if(matcher.matches()){
			PhoneNumberPojo pojo=new PhoneNumberPojo();
			pojo.setAreaCode(matcher.group(1));
			pojo.setPhoneNumber(matcher.group(2));
			return pojo;
		}else{
			throw new IllegalArgumentException(String.format("类型转换失败,需要格式[010-1234567],但格式是[%s]", source));
		}
	}
	
	@Test
	public void test(){
		DefaultConversionService dcs=new DefaultConversionService();
		dcs.addConverter(new PhoneNumberConverter());
		String phone="01012345678";
		PhoneNumberPojo pojo=dcs.convert(phone, PhoneNumberPojo.class);
		Assert.assertEquals("010", pojo.getAreaCode());
	}

}
