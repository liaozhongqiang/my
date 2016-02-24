package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class Test2 {
	
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db=dbf.newDocumentBuilder();
		//InputStream is=new FileInputStream("C:\\Users\\myzhong2012\\Desktop\\spring-core.xml");
		//InputSource iss=new InputSource(is);
		InputStream iss=Test2.class.getResourceAsStream("spring-core.xml");
		Document doc=db.parse(iss);
		//NodeList nodes=doc.getElementsByTagName("book");
		/*for(int i=0;i<nodes.getLength();i++){
			Node node=nodes.item(0);
			//System.out.println(node.getTextContent());
			System.out.println(node.getNamespaceURI());
		}*/
		
		Element root=doc.getDocumentElement();
		
		System.out.println(root.getAttribute("default-autowire-candidates"));
		
	}

}
