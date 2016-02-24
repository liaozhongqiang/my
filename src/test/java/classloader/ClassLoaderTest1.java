package classloader;

import org.junit.Test;

public class ClassLoaderTest1 {
	
	
	@SuppressWarnings("static-access")
	@Test
	public void test1() throws Exception{
		ClassLoaderTree clt=(ClassLoaderTree) Class.forName("classloader.ClassLoaderTree").newInstance();
		clt.test1();
	}

}
