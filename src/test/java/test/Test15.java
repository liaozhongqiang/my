package test;

import java.security.CodeSource;
import java.text.MessageFormat;
import java.util.ServiceLoader;

import javax.xml.parsers.DocumentBuilderFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Test15 {
	
	public static void main(String[] args) {
		//ObjectMapper objectMapper=new ObjectMapper();
		
		//ServiceLoader<DocumentBuilderFactory> loader=ServiceLoader.load(DocumentBuilderFactory.class);
		//loader.forEach(System.out::println);
		
		System.out.println(System.getProperty("javax.xml.parsers.DocumentBuilderFactory"));
		
		 DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		    Class<? extends DocumentBuilderFactory> c = documentBuilderFactory.getClass();
		    Package p = c.getPackage();
		    CodeSource source = c.getProtectionDomain().getCodeSource();
		    String res=	MessageFormat.format(
		            "Using JAXP implementation ''{0}'' ({1}) version {2} ({3}){4}",
		            p.getName(),
		            p.getImplementationVendor(),
		            p.getSpecificationVersion(),
		            p.getImplementationVersion(),
		            source == null ? "." : " loaded from: " + source.getLocation());
		    System.out.println(res);
		    
	}

}
