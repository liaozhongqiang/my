package spring.depends;

public class CircleB {
	
	private CircleC c;
	
	public CircleB(CircleC c){
		this.c=c;
	}
	
	public void say(){
		System.out.println("b--"+c);
	}
}
