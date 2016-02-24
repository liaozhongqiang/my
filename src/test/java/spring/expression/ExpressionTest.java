package spring.expression;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionTest {
	
	@Test
	public void TestExpression(){
		
		ExpressionParser ep=new SpelExpressionParser();
		
		//字符串
		String str1=ep.parseExpression("'hello world!'").getValue(String.class);
		Assert.assertTrue("hello world!".equals(str1));
		
		//基础类型
		int int1=ep.parseExpression("1").getValue(Integer.class);
		Assert.assertEquals(1, int1);
		
		boolean true1=ep.parseExpression("true").getValue(Boolean.class);
		Assert.assertTrue(true1);
		
		//基本运算 + - * /(MOD) %(DIV) ^
		int int2=ep.parseExpression("(1+2*2/2%2)^2").getValue(Integer.class);
		Assert.assertEquals(1, int2);
		
		
		//逻辑运算符 and or not
		boolean true2=ep.parseExpression("1<2 and true").getValue(Boolean.class);
		Assert.assertTrue(true2);
		
		
	}
	
	
	@Test
	public void SplBeanTest(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:expression.xml");
		SplTestBean stb=(SplTestBean) applicationContext.getBean("splTestBean1");
		Assert.assertEquals("hello world !", stb.getValue());	
		
		
		
	}

}
