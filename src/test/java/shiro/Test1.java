package shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class Test1 {

	private static final Logger logger = LoggerFactory.getLogger(Test1.class);

	public static void main(String[] args) {
		logger.info("my first Apache Shiro Application");
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/shiro1.ini");
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject currentUser=SecurityUtils.getSubject();
		Session session=currentUser.getSession();
		session.setAttribute("someKey", "aValue");
		String aValue=(String) session.getAttribute("someKey");
		if(aValue.equals("aValue")){
			logger.info("Retrieved the correct value!{}",aValue);
		}
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken token=new UsernamePasswordToken("lonestarr","vespa");
			token.setRememberMe(true);
			currentUser.login(token);
		}
		logger.info("User {} login in successfully",currentUser.getPrincipal());
		
		//test a role
		if(currentUser.hasRole("goodguy")){
			logger.info("the user has role goodguy");
		}else{
			logger.info("Hello, mere mortal.");
		}
		//test permission
		if(currentUser.isPermitted("lightsaber:test")){
			logger.info("you can use lightsaber:test");
		}else{
			logger.info("no permittion");
		}
		
		currentUser.logout();
		
	}

}
