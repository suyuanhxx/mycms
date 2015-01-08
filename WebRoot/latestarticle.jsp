<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'latestarticle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  	<link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />
    
    <!--<link href="./font-awesome/css/font-awesome.min.css" rel="stylesheet" />-->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	
	<style type="text/css">
		a:link{text-decoration: none};
	</style>
	
  </head>
  <body style="background: url(./img/body-bg.png) repeat 0 0;">
   <h2 style="text-align:center;">最新文章列表</h2>
   <ul>
	   	<c:forEach items="${latest}" var="item" varStatus="status">
	   		<li><a target="_blank" href="articledetail.do?articleid=${item.id}">${item.title}--------------${item.username}<span style="font-size:24px;;">&nbsp;&nbsp;</span><fmt:formatDate value="${item.pubtime}" pattern="yyyy-MM-dd"/></a></li>
	   	</c:forEach>
   	</ul>
  </body>
  
  <script src="./js/jquery-1.7.2.min.js"></script>
  <script src="./js/bootstrap.js"></script>
</html>
