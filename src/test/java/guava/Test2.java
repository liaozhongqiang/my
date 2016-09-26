package guava;

public class Test2 {
	
	public static void main(String[] args) {
		Runnable r=new Runnable() {
			@Override
			public void run() {
				System.out.println("111");
			}
		};
		r.run();
		Runnable r1=()->{System.out.println("1121");};
		r1.run();
	}

}
