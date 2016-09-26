package guava;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class MapToString {
	
	
	@Test
	public void test1(){
		
		String str="userid=12345678911&yybqd=9999&channelid=5442015678680578000&devicetype=ios";
		
		Map<String,String> res=	Splitter.on("&").omitEmptyStrings().trimResults().withKeyValueSeparator("=").split(str);
		
		System.out.println(res);
		
	}
	
	@Test
	public void test2(){
		Map<String,String> map = new LinkedHashMap<>();
		map.put("userid", "12345678911");
		map.put("yybqd", "9999");
		map.put("channelid", "5442015678680578000");
		map.put("devicetype", "ios");
		String str = Joiner.on("&").withKeyValueSeparator("=").join(map);
		System.out.println(str);
	}

}
