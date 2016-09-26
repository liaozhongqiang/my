package core;

import org.junit.Test;

/**
 * 各种排序算法
 * @author lzq
 * @date 2016年7月5日
 *
 */
public class PaiXuUtil {
	
	/**
	 * 冒泡排序
	 * @param src
	 * @return
	 */
	public static int[] maoPaoSort(int[] src){
		for(int i=0;i<src.length-1;i++){
			for(int j=0;j<src.length-1-i;j++){
				int temp;
				if(src[j]>src[j+1]){
					temp=src[j];
					src[j]=src[j+1];
					src[j+1]=temp;
				}
			}
		}
		return src;
	}
	
	/**
	 *  快速排序
	 *  快速排序是从数组中选取一个基准，而后将数组大于等于基准的分一边，小于基准分一边，再对两边的集进行如上操作。
	 * @param src
	 * @return
	 * 
	 */
	public static int[] kuaiSuSort(int[] src){
		quickSort(src, 0, src.length-1);
		return src;
	}
	
	private static void quickSort(int[] src,int start,int end){
		if(start<end){
			int left=start,right=end;
			int mid=src[left];
			while(left<right){
				//从右边向左小于mid的数来填src[left]
				while(left<right&&src[right]>=mid){
					right--;
				}
				if(left<right){
					src[left]=src[right];
					left++;
				}
				// 从左边找大于等于src[right]的数来填 right
				while(left<right&&src[left]<mid){
					left++;
				}
				if(left<right){
					src[right]=src[left];
					right--;
				}
			}
			src[left]=mid;
			quickSort(src,start,left-1);
			quickSort(src,left+1,end);
		}
	}
	
	/**
	 *  选择排序 选择排序基本思想是  选择第一个作为默认最小，然后将其与后面的元素作比较遍历若比其还小则将最小值的位置记录为此元素的位置。比较完其他元素。将最小元素
	 *  换到第一个位置。后对剩下元素。重复以上操作。
	 * @param arr
	 * @return
	 */
	public static int[] selectionSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int min=i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[min]){
					min=j;
				}
			}
			if(min!=i){
				int temp=arr[i];
				arr[i]=arr[min];
				arr[min]=temp;
			}
		}
		return arr;
	}
	
	
	/**
	 * 插入排序
	 * 插入排序分为已排序部分和未排序部分。遍历未排序部分，将其插入到已排序部分。
	 * @param arr
	 * @return
	 */
	
	public static int[] insertionSort(int[] arr){
		int len=arr.length,i,j,value;
		for(i=0;i<len;i++){
			value=arr[i];
			for(j=i-1;j>-1&&arr[j]>value;j--){
				arr[j+1]=arr[j];
			}
			arr[j+1]=value;
		}
		return arr;
	}
	
	
	@Test
	public void testMaoPaoSort(){
		int[] a={0,9,1,3,1,31,2};
		int[] b=PaiXuUtil.maoPaoSort(a);
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
	}
	
	@Test
	public void testQuitSort(){
		int[] a={0,9,1,3,1,31,2};
		a=kuaiSuSort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
