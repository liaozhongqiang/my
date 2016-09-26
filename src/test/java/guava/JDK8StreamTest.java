package guava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class JDK8StreamTest {
	
	@Test
	public void test1(){
		List<Integer> nums=Lists.newArrayList(1,null,3,4,null,6);
		long count=nums.stream().filter(num -> num!=null).count();
		new Thread(() -> {System.out.println("111");}).start();
		Assert.assertEquals(count, 4);
	}
	/**
	 * 生成stream
	 */
	@Test
	public void test2(){
		Stream<Integer> integerStream=Stream.of(1,2,3,4);
		Stream<String> stringStream=Stream.of("1213");
		Stream<Double> doubleStream=Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
		Stream<Double> doubleStream2=Stream.generate(() -> Math.random());
		Stream<Double> doubleStream3=Stream.generate(Math::random);
		Stream.iterate(2, item -> item+1).limit(10).forEach(System.out::println);
	}
	
	/**
	 * 
	 */
	@Test
	public void test3(){
		//去重
		Stream.of(1,2,3,3,3,4).distinct().forEach(System.out::print);
		
		System.out.println();
		
		//过滤
		Stream.of(1,2,3,4,5,6,7).filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t>5;
			}
		}).forEach(System.out::print);
		
		System.out.println();
		
		//Map
		Stream.of(1,2,3,4,5).map(t->t*t).forEach(System.out::print);
		
		//flatmap
		Stream.of(1,2,3,4,5).flatMap(new Function<Integer, Stream<? extends Integer>>() {
			@Override
			public Stream<? extends Integer> apply(Integer t) {
				return null;
			}
		});
		
		System.out.println();
		
		//返回一个全新的stream 并且在每个元素被消费的时候会执行consumer函数
		Stream.of(1,22,3,4,5).peek(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.print("haha");
			}
		}).forEach(System.out::println);
		System.out.println();
		//返回前3个元素的
		Stream.of(1,2,3,4,5).limit(3).forEach(System.out::print);
		System.out.println();
		
		//返回除去前3个后剩下的元素
		Stream.of(1,2,3,4,5).skip(3).forEach(System.out::print);
		
		//综合
		List<Integer> nums=Lists.newArrayList(1,1,null,null,2,3,4,5,6,7,8,9,null,10);
		long sum=nums.stream().filter(num->num!=null).distinct().mapToInt(num -> num*2).peek(System.out::println).skip(2).limit(4).sum();
		System.out.println("sum:"+sum);
	}
	
	
	@Test
	public void test4(){
		Map<String,String> map=new HashMap<>();
		Maps.filterValues(map, value->Objects.nonNull(value));
	}
}
