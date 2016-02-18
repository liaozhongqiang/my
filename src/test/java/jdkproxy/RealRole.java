package jdkproxy;

public class RealRole implements InterFaceRole,IRole2{

	@Override
	public void doSomeThing() {
		System.out.println("真实角色处理！！！！");
	}

	@Override
	public void doSomething2() {
		System.out.println("RealRole doSomething2");
	}

}
