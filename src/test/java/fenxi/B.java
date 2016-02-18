package fenxi;

public class B extends A{
	@Override
	void newNode() {
		System.out.println("B newNode");
	}
	
	public static void main(String[] args) {
		B b=new B();
		
		b.put();
	}
}



