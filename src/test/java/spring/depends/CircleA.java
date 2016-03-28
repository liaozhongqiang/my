package spring.depends;

public class CircleA {
	
	private CircleB b;
	
	public CircleA(CircleB b){
		this.b=b;
	}
	
	public void say(){
		System.out.println("a--"+b);
	}

}
