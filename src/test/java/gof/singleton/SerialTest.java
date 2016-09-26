package gof.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.Test;

public class SerialTest {
	
	@Test
	public void enumTest() throws IOException, ClassNotFoundException{
		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		OutputStream os = new FileOutputStream("C:\\Users\\myzhong2012\\Desktop\\test\\enumsingleton.txt");
		ObjectOutputStream oss = new ObjectOutputStream(os);
		oss.writeObject(enumSingleton);
		oss.flush();
		oss.close();
		
		InputStream is = new FileInputStream("C:\\Users\\myzhong2012\\Desktop\\test\\enumsingleton.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		EnumSingleton enumSingleton2=(EnumSingleton) ois.readObject();
		ois.close();
		Assert.assertEquals(enumSingleton, enumSingleton2);
	}
	
	@Test
	public void staticClassTest() throws IOException, ClassNotFoundException{
		StaticClassSingleton staticClassSingleton = StaticClassSingleton.getInstance();
		OutputStream os = new FileOutputStream("C:\\Users\\myzhong2012\\Desktop\\test\\staticClassSingleton.txt");
		ObjectOutputStream oss = new ObjectOutputStream(os);
		oss.writeObject(staticClassSingleton);
		oss.flush();
		oss.close();
		
		InputStream is = new FileInputStream("C:\\Users\\myzhong2012\\Desktop\\test\\staticClassSingleton.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		StaticClassSingleton staticClassSingleton2=(StaticClassSingleton) ois.readObject();
		ois.close();
		Assert.assertEquals(staticClassSingleton, staticClassSingleton2);
	}

}
