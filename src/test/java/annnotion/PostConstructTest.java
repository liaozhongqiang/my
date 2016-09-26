package annnotion;

import javax.annotation.PostConstruct;

public class PostConstructTest {
	
	public PostConstructTest() {
		System.out.println("1");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	
	public static void main(String[] args) {
		PostConstructTest test=new PostConstructTest();
	}

}
