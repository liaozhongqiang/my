package core;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

public class StreamTest {
	
	private List<Tag> values;
	
	@Before
	public void setUp(){
		values=Lists.newArrayList(new Tag("1","a",100),new Tag("2","b",200),new Tag("3","c",300),new Tag("4","c",400),new Tag("5","b",500),new Tag("6","b",600));
	}
	
	/**
	 * Grouping by
	 */
	
	@Test
	public void test1(){
		Map<String,List<Tag>> tags=values.stream().collect(Collectors.groupingBy(Tag::getTag,Collectors.toList()));
		System.out.println(tags);
	}
	
	
	/**
	 * tag to list
	 */
	
	@Test
	public void test2(){
		System.out.println(values.stream().map(Tag::getTag).collect(Collectors.toList()));
	}
	
	/**
	 * tag to TreeSet
	 */
	
	@Test
	public void test3(){
		Set<String>  vals=values.stream().map(Tag::getTag).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(vals);
	}
	
	/**
	 * collection join 
	 */
	
	@Test
	public void test4(){
		String str=values.stream().map(Object::toString).collect(Collectors.joining(","));
		System.out.println(str);
	}
	
	/**
	 *  sum salary
	 */
	
	@Test
	public void test5(){
		int sum=values.stream().collect(Collectors.summingInt(Tag::getSalary));
		System.out.println(sum);
	}
	
	/**
	 *  sum salary group by tag
	 */
	@Test
	public void test6(){
		Map<String,Integer> map=values.stream().collect(Collectors.groupingBy(Tag::getTag,Collectors.summingInt(Tag::getSalary)));
		System.out.println(map);
	}
	
	
	/**
	 * 区分大于300的tag
	 */
	
	@Test
	public void test7(){
		Map<Boolean,List<Tag>> map=values.stream().collect(Collectors.partitioningBy(s -> s.getSalary() >= 300));
		System.out.println(map);
	}
	
	
	/**
	 *  List<Tag> mapping to List<String>
	 */
	
	@Test
	public void test8(){
		List<String> valus=values.stream().collect(Collectors.mapping(Tag::getValue, Collectors.toList()));
		System.out.println(valus);
	}
	
	
	
	class Tag{
		private String value;
		
		private String tag;
		
		private int salary;

		public Tag(String value, String tag,int salary) {
			super();
			this.value = value;
			this.tag = tag;
			this.salary=salary;
		}

		public String getValue() {
			return value;
		}

		public String getTag() {
			return tag;
		}
		
		
		
		public int getSalary() {
			return salary;
		}

		@Override
		public String toString() {
			return JSON.toJSONString(this);
		}
	}

}
