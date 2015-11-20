package com.my.core.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationContext;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author liaozq
 * @DATE 2015年11月19日
 */
public class FileUtil {

	private static Map<String, String> uploadConfig = new HashMap<String, String>();
	
	// ��ʼ��config
	static{
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(BaseUtil.getResource("uploadconfig.xml").getInputStream());
			uploadConfig = XmlUtil.xmlToMap(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public static void uploadFile(MultipartFile multipartFile) throws Exception {
		String filePath=uploadConfig.get("basepath")+"/"+DateUtil.getNow("yyyy-MM-dd")+"/"+multipartFile.getOriginalFilename();
		File file=null;
		if ("local".equals(uploadConfig.get("type"))) {
			file=new File(filePath);
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
		}
	}
	
}
