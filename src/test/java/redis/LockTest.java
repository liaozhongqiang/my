package redis;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.core.RLock;

public class LockTest {
	
	public static void main(String[] args) {
		Config config = new Config();
		config.useSingleServer().setAddress("").setConnectionPoolSize(10);
		RedissonClient redisson = Redisson.create(config);
		RLock rlock=redisson.getLock("");
		rlock.lock();
	}

}
