package com.howto.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello {
	public HttpServletRequest request;
	public HttpServletResponse response;
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String hello() {
		
		System.out.println("hello");
		
		return "/index.jsp";
		
	}
	
	
}
