package guava;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

public class Test1 {
	
	@Test
	public  void test1() {
		List<Integer> nums=Lists.newArrayList(1,null,3,4,null,6);
		
		Assert.assertEquals(6, nums.size());
		
		List<Integer> newNums=Lists.newArrayList(Collections2.filter(nums, Predicates.notNull()));
		
		Assert.assertEquals(4, newNums.size());
		
		Assert.assertThat(newNums, Matchers.containsInAnyOrder(1,3,4,6));
		Assert.assertThat(newNums, Matchers.contains(1,3,6,4));
		
		Assert.assertThat(newNums, new Matcher<List<Integer>>() {

			@Override
			public void describeTo(Description description) {
				
			}

			@Override
			public boolean matches(Object item) {
				return false;
			}

			@Override
			public void describeMismatch(Object item, Description mismatchDescription) {
				
			}

			@Override
			public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {
				
			}

			
		});
	}
	
	@Test
	public void test2(){
		List<Integer> nums=Lists.newArrayList(1,null,3,4,null,6);
		List<Integer> newNums=Lists.newArrayList(Collections2.filter(nums, new Predicate<Integer>() {
			@Override
			public boolean apply(Integer input) {
				if(input==null){
					return false;
				}
				return input>4;
			}
		}));
		Assert.assertThat(newNums, Matchers.containsInAnyOrder(6));
		List<Integer> newNums2=Lists.newArrayList(Collections2.filter(nums, input -> input!=null&&input>4));
		Assert.assertThat(newNums2, Matchers.containsInAnyOrder(6));
	}
	
	/**
	 * Predicates.and()
	 */
	@Test
	public void test3(){
		List<Person> people=Lists.newArrayList(new Person("Jack", 18),new Person("Lucy",19),new Person("Lilei",20));
		List<Person> newPeople=Lists.newArrayList(Collections2.filter(people,Predicates.and(new Predicate<Person>(){

			@Override
			public boolean apply(Person input) {
				return input.getAge()>19;
			}
			
		},new Predicate<Person>() {

			@Override
			public boolean apply(Person input) {
				return input.getName().contains("L");
			}
			
		})));
		
		Assert.assertEquals(1, newPeople.size());
	}
	
	
	/**
	 * Predicates.or()
	 */
	
	@Test
	public void test4(){
		List<Person> people=Lists.newArrayList(new Person("Jack", 18),new Person("Lucy",19),new Person("Lilei",20));
		List<Person> newPeople=Lists.newArrayList(Collections2.filter(people,Predicates.or(new Predicate<Person>(){

			@Override
			public boolean apply(Person input) {
				return input.getAge()>19;
			}
			
		},new Predicate<Person>() {

			@Override
			public boolean apply(Person input) {
				return input.getName().contains("L");
			}
			
		})));
		
		Assert.assertEquals(2, newPeople.size());
	}
	
	
	
	/**
	 * map
	 */
	
	@Test
	public void test5(){
		List<String> names=Lists.newArrayList("JACK","TOM");
		List<String> lowerCaseNames=Lists.newArrayList(Collections2.transform(names, new Function<String, String>() {
			@Override
			public String apply(String input) {
				if(input==null){
					return null;
				}
				return input.toLowerCase();
			}
		}));
		
		Assert.assertThat(lowerCaseNames, Matchers.containsInAnyOrder("jack","tom"));
	}
	
	
	/**
	 * 文艺青年API  fluent
	 */
	@Test
	public void test6(){
		List<String> names=Lists.newArrayList("JACK","TOM");
		List<String> lowerCaseNames=FluentIterable.from(names).filter(Predicates.containsPattern("O")).transform(new Function<String, String>() {
			@Override
			public String apply(String input) {
				if(input==null){
					return null;
				}
				return input.toLowerCase();
			}
		}).toList();
		
		Assert.assertThat(lowerCaseNames, Matchers.containsInAnyOrder("tom"));
	}
	
}

class Person{
	private String name;
	
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
}
