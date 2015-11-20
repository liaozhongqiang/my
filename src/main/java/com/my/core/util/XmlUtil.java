package com.my.core.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;

public class XmlUtil {
	/**
	 * 
	 * @param document
	 * @return
	 */
	public static Map<String,String> xmlToMap(Document document){
		Map<String,String> resultMap=new HashMap<String,String>();
		Element root=document.getRootElement();
		for(Iterator it=root.elementIterator();it.hasNext();){
			Element element=(Element) it.next();
			resultMap.put(element.getName(), element.getTextTrim());
		}
		return resultMap;
	}

}
