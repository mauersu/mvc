package com.howto.parseXML.util;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXML {
	
	static Logger logger = Logger.getLogger(ParseXML.class.getName());
	
/*	public Map<String, Action> parseMVC(String filename) {
		List parseList = new ArrayList();
		
		SAXReader saxReader = new SAXReader();
		Document document;
		
		Map<String, Action> mvcMap = new HashMap<String, Action>();
		try{
			
			document = saxReader.read(new File(filename));
			
			Element root_EL = document.getRootElement();
			
			for(Iterator iter=root_EL.elementIterator();iter.hasNext();) {
				Element action_EL = (Element)iter.next();
				
				Action action = new Action();//xml解析 对应 对象
				
				action.setName(action_EL.attribute("name").getValue());
				action.setClassName(action_EL.attribute("class").getValue());
				action.setMethod(action_EL.attribute("method").getValue());
				
				for(Iterator iter0=action_EL.elementIterator();iter0.hasNext();){
					Element result_EL = (Element)iter0.next();
					
					Result result = new Result();
					result.setJsp(result_EL.getText());
					result.setName(result_EL.attribute("name").getValue());
					
					action.result.put(result.name, result.jsp);
				}
				
				mvcMap.put(action.name, action);
			}
		} catch(DocumentException e) {
			e.printStackTrace();
		}
		return mvcMap;
	}*/
	
	public Map<String, Map<String, String>> parseMVC(String filename) {
		List parseList = new ArrayList();
		
		SAXReader saxReader = new SAXReader();
		Document document;
		
		Map<String, Map<String, String>> mvcMap = new HashMap<String, Map<String, String>>();
		try{
			
			InputStream input = this.getClass().getClassLoader().getResourceAsStream(filename); 
			document = saxReader.read(input);
			//document = saxReader.read(new File(filename));
			
			Element root_EL = document.getRootElement();
			
			for(Iterator iter=root_EL.elementIterator();iter.hasNext();) {
				Element action_EL = (Element)iter.next();
				
				Map<String, String> tempMap = new HashMap<String, String>();
				
				tempMap.put("name", action_EL.attribute("name").getValue());
				tempMap.put("class", action_EL.attribute("class").getValue());
				tempMap.put("method", action_EL.attribute("method").getValue());
				
				for(Iterator iter0=action_EL.elementIterator();iter0.hasNext();){
					Element result_EL = (Element)iter0.next();
					
					tempMap.put(result_EL.attribute("name").getValue(), result_EL.getText());
				}
				
				mvcMap.put(action_EL.attribute("name").getValue(), tempMap);
			}
		} catch(DocumentException e) {
			e.printStackTrace();
		}
		return mvcMap;
	}
	
}
