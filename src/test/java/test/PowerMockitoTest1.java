package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.my.core.util.HttpUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticTestUtil.class)
public class PowerMockitoTest1 {
	
	@Test
	public void test(){
		PowerMockito.mockStatic(StaticTestUtil.class);
		PowerMockito.when(StaticTestUtil.staticTest("SB")).thenReturn("SB");
		
		Assert.assertEquals(StaticTestUtil.staticTest("SB"), "SB");
	}
	

}
