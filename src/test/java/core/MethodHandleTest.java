package core;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
	
	static class ClassA{
		public void println(String s){
			System.out.println(s);
		}
	}
	
	
	private static MethodHandle getPrintlnMH(Object reveiver) throws NoSuchMethodException, IllegalAccessException{
		MethodType methodType = MethodType.methodType(void.class, String.class);
		return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", methodType).bindTo(reveiver);
	}
	
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, Throwable {
		Object obj = System.currentTimeMillis()%2==0?System.out:new ClassA();
		System.out.println(obj.getClass());
		getPrintlnMH(obj).invokeExact("hello MethodHandle");
	}
}
