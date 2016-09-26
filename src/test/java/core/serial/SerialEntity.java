package core.serial;

import java.io.Serializable;

public class SerialEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5550061359435423211L;
	
	private String id;
	
	private String age;
	
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id:"+id+","+"age:"+age+","+"name:"+name;
	}

}
