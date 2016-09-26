package core.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DserialTest {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		InputStream is = new FileInputStream("C:\\Users\\myzhong2012\\Desktop\\test\\1.txt");
		
		ObjectInputStream ois = new ObjectInputStream(is);
		
		SerialEntity se=(SerialEntity) ois.readObject();
		System.out.println(se);
		
	}

}
