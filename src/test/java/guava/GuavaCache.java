package guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;

public class GuavaCache {
	
	@Test
	public void testLoadingCache() throws ExecutionException{
		
		LoadingCache<String, String> loadingCache=CacheBuilder.newBuilder().maximumSize(1000).refreshAfterWrite(5, TimeUnit.SECONDS)
				.build(new CacheLoader<String, String>(){
			@Override
			public String load(String key) throws Exception {
				return "hello-"+key;
			}
			
			@Override
			public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
				return super.reload(key, oldValue);
			}
			
		});
		System.out.println(loadingCache.get("guava"));
	}
	
	@Test
	public void testCallabeCache() throws ExecutionException{
		Cache<String,String> cache=CacheBuilder.newBuilder().maximumSize(1000).build();
		String res=cache.get("guava", new Callable<String>() {
			@Override
			public String call() throws Exception {
				return "hello-"+"guava";
			}
		});
		System.out.println(res);
	}
	
}
