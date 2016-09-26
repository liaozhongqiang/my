package cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import com.my.entity.User;

public class Test1 {
	
	@Test
	public void test1(){
		JdkSerializationRedisSerializer jdk=new JdkSerializationRedisSerializer();
		User user=new User();
		user.setId("10000000");
		user.setName("长水水水水水水水水");
		long start=System.nanoTime();
		for(int i=0;i<10000000;i++){
			jdk.serialize(user);
		}
		long end=System.nanoTime();
		System.out.println(end-start);
	}
	
	
	@Test
	public void test2(){
		Jackson2JsonRedisSerializer<User> jack=new Jackson2JsonRedisSerializer<>(User.class);
		User user=new User();
		user.setId("10000000");
		user.setName("长水水水水水水水水");
		long start=System.nanoTime();
		for(int i=0;i<10000000;i++){
			jack.serialize(user);
		}
		long end=System.nanoTime();
		System.out.println(end-start);
	}
}
