package spring.depends;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ResourcesBean {
	
	private OutputStream os;
	
	private File file;
	
	public OutputStream getOs() {
		return os;
	}
	public void setOs(OutputStream os) {
		this.os = os;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	public void init(){
		System.out.println("ResourcesBean:------初始化");
		System.out.println("ResourcesBean:------加载资源,执行一些预操作");
		try {
			os=new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy(){
		System.out.println("ResourcesBean:------销毁");
		System.out.println("ResourcesBean:------释放资源,执行一些清理操作");
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
