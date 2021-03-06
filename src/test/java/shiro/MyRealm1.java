package shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm1 implements Realm{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "myRealm1";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("使用myrealm1");
		String username=(String) token.getPrincipal();
		String passwd=(String) token.getCredentials();
		if(!"root".equals(username)){
			throw new UnknownAccountException();
		}
		if(!"root".equals(passwd)){
			throw new IncorrectCredentialsException();
		}
		return new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), getName());
	}

}
