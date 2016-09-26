package fenxi;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test2 {
	
	public static void main(String[] args) {
		//List<Integer> list=new ArrayList<Integer>();
		//list.add(1);
		//System.out.println(24>>1);
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0;i<100;i++){
			if(i==99){
				map.put(i+"", i+"00000");
			}else{
				map.put(i+"", i+"00000");
			}
		}
		
		map.entrySet();
		
	}

}
