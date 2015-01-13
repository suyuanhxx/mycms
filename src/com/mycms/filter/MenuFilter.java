package com.mycms.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycms.model.Admin;

public class MenuFilter implements Filter{

	private static HashSet superMenuSet=null;
	
	private static HashSet commonMenuSet=null;
	
	private static HashSet userMenuSet=null;
	
	private static HashSet protectedSet=null;
	
	static{
		superMenuSet = new HashSet();
		superMenuSet.add("/mycms/admin/addarticle.jsp");
		

	}
	
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
