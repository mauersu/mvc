package com.howto.parseXML.model;

import java.util.HashMap;
import java.util.Map;

public class Action {
	
	public String name;
	public String className;
	public String method;
	public Map<String ,String> result = new HashMap<String ,String>();

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Map<String, String> getResult() {
		return result;
	}

	public void setResult(Map<String, String> result) {
		this.result = result;
	}

	
	
}
