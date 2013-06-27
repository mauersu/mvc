package com.howto.parseXML.util;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import com.howto.parseXML.model.Action;

import junit.framework.TestCase;

public class ParseXMLTest extends TestCase {

	public void testParseMVC() {
		ParseXML parseXml = new ParseXML();
		
/*		Map<String , Action> mvcMap = parseXml.parseMVC("D:/mvc.xml");
		
		assertEquals("hello", mvcMap.get("hello").name);
		assertEquals("com.howto.mvc.Hello", mvcMap.get("hello").className);
		assertEquals("hello", mvcMap.get("hello").method);
		
		assertEquals("/index.jsp", mvcMap.get("hello").result.get("success"));*/
	}

}
