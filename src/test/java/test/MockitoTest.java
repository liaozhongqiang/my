package test;

import org.junit.Assert;
import org.junit.Test;


import static org.mockito.Mockito.*;

import java.util.List;

public class MockitoTest {
	
	@Test
	public void test(){
		List<Integer> list=mock(List.class);
		when(list.get(0)).thenReturn(1);
		Assert.assertSame(1, list.get(0));
		
	}

}
