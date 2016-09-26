package redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class SentinalTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Set<String> hostSet = new HashSet<String>();
		hostSet.add(new HostAndPort("192.168.1.106", 26379).toString());
		hostSet.add(new HostAndPort("192.168.1.106", 26380).toString());
		hostSet.add(new HostAndPort("192.168.1.106", 26381).toString());
		JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster", hostSet);
		Jedis master = sentinelPool.getResource();
		master.set("hello", "world");
		master.close();
		Jedis master2 = sentinelPool.getResource();
		String value = master2.get("hello");
		System.out.println("hello: " + value);
		master2.close();
		sentinelPool.destroy();
	}

}
