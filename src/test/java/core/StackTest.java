package core;

import java.util.Arrays;

public class StackTest<E> {
	
	private Object[] elementData=null;
	
	private int elementCount=0;
	
	public StackTest(int initSize) {
		this.elementData=new Object[initSize];
	}
	
	@SuppressWarnings("unchecked")
	public E pop(){
		if(elementCount==0){
			throw new RuntimeException("stack is empty");
		}
		E obj= (E) elementData[elementCount];
		elementData[elementCount]=null;//help GC
		elementCount--;
		return obj;
	}
	
	public void push(E e){
		
		if(elementCount>=elementData.length){
			//Arrays.copyOf(original, newLength)
		}
		
		
	}
	
	
	public static void main(String[] args) {
	}

}
