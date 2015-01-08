package com.mycms.util.web;


import org.apache.log4j.Logger;

import com.mycms.page.Page;



@SuppressWarnings("serial")
public class HandlerResult implements java.io.Serializable
{
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(HandlerResult.class);
	
	protected Object resultObj;
	
	protected Page page;
	
	public HandlerResult(){}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Object getResultObj() {
		return resultObj;
	}

	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}

}
