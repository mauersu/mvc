package com.howto.mvc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.howto.parseXML.model.Action;
import com.howto.parseXML.model.Result;
import com.howto.parseXML.util.ParseXML;

public class ParseXMLTest {

	@Test
	public void testParseMVC() {
		
		ParseXML parseXml = new ParseXML();
		
/*		Map<String , Action> mvcMap = parseXml.parseMVC("D:/mvc.xml");
		
		assertEquals("hello", mvcMap.get("hello").name);
		assertEquals("com.howto.mvc.Hello", mvcMap.get("hello").className);
		assertEquals("hello", mvcMap.get("hello").method);
		
		assertEquals("/index.jsp", mvcMap.get("hello").result.get("success"));*/
		
		//Map<String , Map<String, String>> mvcMap = parseXml.parseMVC("D:/mvc.xml");
		Map<String , Map<String, String>> mvcMap = parseXml.parseMVC("mvc.xml");
		assertEquals("hello", mvcMap.get("hello").get("name"));
		assertEquals("com.howto.mvc.Hello", mvcMap.get("hello").get("class"));
		assertEquals("hello", mvcMap.get("hello").get("method"));
		
		assertEquals("/index.jsp", mvcMap.get("hello").get("success"));
		
	}

}
