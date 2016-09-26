package wrapperClass;

import java.util.Stack;

import org.junit.Assert;

import com.alibaba.fastjson.JSON;


public class FastJsonTest {

	public static void main(String[] args) {
		String json = "{\"a\":\"12344\",\"b\":\"3344\"}";
		ObjectA a = JSON.parseObject(json, ObjectA.class);
		Assert.assertNotNull(a.a);
	}
}

class ObjectA {
	public String a;
	
	public ObjectA() {
	}
	
}
