<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addarticle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action="addarticle.do">
  		<fieldset>
			<div class="control-group">
				<label class="control-label" for="title">title</label>
				<div class="controls">
					<input type="text" class="" id="title" name="title"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="typename">typename</label>
				<div class="controls">
					<input type="text" class="" id="typename" name="typename"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="context">context</label>
				<div class="controls">
					<input type="text" class="" id="context" name="context"/>
				</div>
			</div>
		</fieldset>
		
		<div class="pull-right">
			<button id="add" type="submit" class="btn btn-warning btn-large">
				Add
			</button>
		</div>
  	</form>
  </body>
</html>
