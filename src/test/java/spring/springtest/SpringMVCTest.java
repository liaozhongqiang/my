package spring.springtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.my.service.IUserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({ @ContextConfiguration(name = "parent", locations = {"classpath:spring-core.xml","classpath:spring-mybatis.xml"}),
		@ContextConfiguration(name = "child", locations = "classpath:mvc.xml") })
public class SpringMVCTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void init(){
		mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void test1() throws Exception{
		MvcResult result=mockMvc.perform(get("/test/rest1/{id}", "SB")).andDo(print()).andReturn();
		Assert.assertEquals(result.getResponse().getContentAsString(), "SB");
	}
	
	@Test
	@Rollback(false)
	@Transactional
	public void test2() throws Exception{
		IUserService ius=(IUserService) wac.getBean("userServiceImpl");
		ius.testRouteDataSource();
		throw new Exception("11");
	}

}
