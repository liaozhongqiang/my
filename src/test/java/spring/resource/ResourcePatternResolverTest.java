package spring.resource;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class ResourcePatternResolverTest {
	
	
	@Test
	public void testClassPathPrefix() throws IOException{
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		Resource[] resources=resolver.getResources("classpath:lookup.xml");
		Assert.assertEquals(1, resources.length);
		resources=resolver.getResources("classpath:*.xml");
		Assert.assertTrue(resources.length==2);
	}

}
