package com.howto.parseXML.util;

import java.util.Map;

import com.howto.parseXML.model.Action;

public class XMLResource {

	public Map<String , Map<String, String>> getXMLDom(String filename) {
		ParseXML parseXml = new ParseXML();
		
		Map<String , Map<String, String>> mvcMap = parseXml.parseMVC(filename);
		
		return mvcMap;
	}
}
