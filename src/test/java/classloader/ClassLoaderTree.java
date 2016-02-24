package classloader;

public class ClassLoaderTree {
	
	public static void main(String[] args) {
		ClassLoader classLoader=ClassLoaderTree.class.getClassLoader();
		while(classLoader!=null){
			System.out.println(classLoader.toString());
			classLoader=classLoader.getParent();
		}
	}
	
	
	public static void test1(){
		System.out.println("hello class");
	}

}
