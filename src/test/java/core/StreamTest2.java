package core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import org.junit.Test;

public class StreamTest2 {
	
	@Test
	public void test1(){
		
		ConcurrentLinkedQueue<Node> input=new ConcurrentLinkedQueue<>();
		input.offer(new Node("1","a"));
		input.offer(new Node("2","b"));
		input.offer(new Node("3","c"));
		input.offer(new Node("4","d"));
		input.offer(new Node("5","f"));
		
		ConcurrentHashMap<String, Node> map=new ConcurrentHashMap<>();
		
		Map<String,Node> map1=input.stream().collect(Collectors.toConcurrentMap(node -> node.getId(), node -> node));
		
		System.out.println(input);
		
		System.out.println(map1);
	}
	
	class Node{
		
		private String id;
		
		private String name;

		public String getId() {
			return id;
		}

		public String getName() {
			return name;
		}
		public Node(String id, String name) {
			this.id = id;
			this.name = name;
		}
	}

}
