package core;

import org.junit.Test;

public class BinarySearch {
	
	public static int binarySearchRecursion(int[] array,int from,int to,int key){
		if(from<0 || to <0){
			System.out.println("xxxxxxx错误");
		}
		if(from <=to){
			int mid = (from+to)>>>1;
			int temp = array[mid];
			if(temp>key){
				to=mid-1;
			}else if(temp<key){
				from = mid+1;
			}else{
				return mid;
			}
		}else{
			return -1;
		}
		return binarySearchRecursion(array, from, to, key);
	}
	
	@Test
	public void testRecursion(){
		int[] array ={1,2,3,4,6};
		int from=0,to=array.length-1;
		int key = 1;
		System.out.println(BinarySearch.binarySearchRecursion(array, from, to, key));
	}
	
	public static int binarySearchNotRecursion(int[] array,int from,int to,int key){
		while(from<=to){
			int mid = (from+to)>>>1;
			int temp=array[mid];
			if(temp>key){
				to = mid-1;
			}else if(temp<key){
				from = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	@Test
	public void testNotRecursion(){
		int[] array = {1,2,100};
		System.out.println(BinarySearch.binarySearchNotRecursion(array,0,array.length-1,100));
		
	}
}
