package test;

public class Test3 {
	
	private volatile int i;
	
	
	public static void main(String[] args) {
		Test3 t1=new Test3();
		t1.i=1;
		Test3 t2=new Test3();
		System.out.println(t2.i);
		
	}

}
