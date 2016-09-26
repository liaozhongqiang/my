package guava;

import org.junit.Test;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {
	
	
	/**
	 * 限流  令牌桶法
	 */
	
	@Test
	public void test(){
		
		final RateLimiter rateLimiter = RateLimiter.create(1);
		
		
		
		for(int i=0;i<100;i++){
			
			System.out.println(rateLimiter.acquire(i+1));	
			
			System.out.println(i+"--"+System.currentTimeMillis());
			
		}
		
		
	}

}
