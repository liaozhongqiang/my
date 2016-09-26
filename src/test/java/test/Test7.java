package test;

public class Test7 {
	
	{
		System.out.println("B");
	}
	
	static{
		System.out.println("A");
	}
	
	public Test7() {
		System.out.println("C");
	}
	
	
	public static void main(String[] args) {
		new Test7();
		new Test7();
	}

}
