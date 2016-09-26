package spring.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

public class InitTest implements InitializingBean{
	
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("---------set---------");
		this.name = name;
	}
	
	public void initMethod(){
		System.out.println("---------initMethod---------");
	}

	@PostConstruct
	public void postConst(){
		System.out.println("---------postConst---------");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("---------afterPropertiesSet---------");
	}

}
