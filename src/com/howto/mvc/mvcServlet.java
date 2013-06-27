package com.howto.mvc;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.howto.parseXML.util.XMLResource;

public class mvcServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		XMLResource xmlResource = new XMLResource();
		
		Map<String, Map<String, String>> urlMapping = xmlResource.getXMLDom("mvc.xml");
		
		getServletContext().setAttribute("urlMapping", urlMapping);
	}
	
	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//example path /mvc_demo/hello?method=hello
		String url = request.getServletPath().substring(1);
		System.out.println(url);
		//拿到 urlMapping 解析的Map
		Map<String, Map<String, String>> urlMapping = (Map<String, Map<String, String>>)getServletContext().getAttribute("urlMapping");
		
		Map<String, String> actionMap = urlMapping.get(url);
		
		processRequset(actionMap, request, response);
		
		dispatcherRequest(actionMap, request, response);
	}

	private void processRequset(Map<String, String> actionMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String className = actionMap.get("class");
		
		Class serviceClass;
		Object serviceObject;
		Method method1;
		Method method2;

		try {
			serviceObject = Class.forName(className).newInstance();
			serviceClass = Class.forName(className);
			
			method1 = serviceClass.getMethod("setRequest",HttpServletRequest.class);
			method2 = serviceClass.getMethod("setResponse",HttpServletResponse.class);
			
			method1.invoke(serviceObject, request);
			method2.invoke(serviceObject, response);
			

			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	private void dispatcherRequest(Map<String, String> actionMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String method = actionMap.get("method");
		String className = actionMap.get("class");
		
		Class serviceClass;
		Object serviceObject;
		Method method1;
		try {
			serviceObject = Class.forName(className).newInstance();
			serviceClass = Class.forName(className);
			
			method1 = serviceClass.getMethod(method);
			String jsp = (String)method1.invoke(serviceObject);
			
			RequestDispatcher rd = request.getRequestDispatcher(jsp);
			
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
