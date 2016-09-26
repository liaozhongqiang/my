package test;

public interface JDK8InterfaceTest {
	
	default void sayHello(){
		System.out.println("hello jdk8 interface defalut");
	}
	
	public static void main(String[] args) {
		JDK8InterfaceTest test=new JDK8InterfaceTest(){};
		test.sayHello();
	}

}
