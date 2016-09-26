package core.serial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerialTest {
	
	public static void main(String[] args) throws IOException {
		
		SerialEntity serial = new SerialEntity();
		serial.setId("1001");
		serial.setAge("18");
		serial.setName("zhangsan");
		
		OutputStream os = new FileOutputStream("C:\\Users\\myzhong2012\\Desktop\\test\\1.txt");
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(serial);
		oos.close();
	}

}
