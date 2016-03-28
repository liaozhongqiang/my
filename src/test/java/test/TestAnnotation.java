package test;

import java.lang.annotation.Annotation;

import org.junit.Test;

import com.my.action.TestAction;
import com.my.core.util.HttpUtil;

public class TestAnnotation {
	
	@Test
	public void test1(){
		for(int i=0;i<5000;i++){
			try {
				HttpUtil.sendGetRequest("http://172.16.41.33:8080/test/NewDemo");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
