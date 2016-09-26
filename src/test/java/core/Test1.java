package core;

import java.text.NumberFormat;

import javax.xml.parsers.DocumentBuilderFactory;

public class Test1 {
	
	public int[] bubbleSort(int[] array){
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
	
	public static void quickSort(int[] array,int start,int end){
		if(start<end){
			int left=start,right=end;
			int mid=array[left];
			while(left<right){
				while(left<right&&array[right]>=mid){
					right--;
				}
				if(left<right){
					array[left]=array[right];
					left++;
				}
				while(left<right&&array[left]<mid){
					left++;
				}
				if(left<right){
					array[right]=array[left];
					right--;
				}
			}
			array[left]=mid;
			quickSort(array, start, left-1);
			quickSort(array, left+1, end);
		}
	}
	
	public static void main(String[] args) {
		DocumentBuilderFactory.newInstance();
		NumberFormat.getInstance();
	}

}
