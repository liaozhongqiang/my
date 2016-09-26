package gof.proxy;

public class UserServiceImpl implements IUserService{

	@Override
	public void save(String user) {
		System.out.println("save user");
	}

}
