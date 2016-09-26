package redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class BitTest {
	
	@Test
	public void test1(){
		Jedis jedis = new Jedis("localhost");
		//System.out.println(jedis.get("name"));
		System.out.println(jedis.setbit("bitss", 10, "1"));
		System.out.println(jedis.bitcount("bitss"));
	}

}
