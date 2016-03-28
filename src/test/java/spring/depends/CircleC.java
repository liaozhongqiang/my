package spring.depends;

public class CircleC {
	
	private CircleA a;
	
	public CircleC(CircleA a){
		this.a=a;
	}
	
	public void say(){
		System.out.println("c--"+a);
	}
}
