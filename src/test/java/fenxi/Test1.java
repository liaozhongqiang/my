package fenxi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.collections.list.TreeList;

public class Test1 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Map map=new HashMap();
		
		/*Map<String,String> tree=new TreeMap<String,String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});*/
		
		Map tree=new TreeMap();
		
		Test1 test1=new Test1();
		
		/*tree.put("1", "1");
		tree.put(test1, "");*/
		
		Map<String,String> linkedHashMap=new LinkedHashMap<String,String>();
		
		//((Comparable<? super Test1>)test1).compareTo((Test1)test1);
		
		Set<String> set=new HashSet<String>();
		
		Set<String> treeSet=new TreeSet<String>();
		
		Set<String> linked=new LinkedHashSet<String>();
		
		for(int i=20;i>0;i--){
			set.add(""+i);
		}
		
		
		set.remove(1);
		
		System.out.println(set.size());
		
		
		List<String> list=new ArrayList<String>();
		
		List<String> linkedList=new LinkedList<String>();
		
		List<String> list2=new TreeList();
		
		list2.remove(0);
		
		list2.remove("1");
		
	}
}
