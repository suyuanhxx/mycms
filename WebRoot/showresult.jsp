<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <title>My JSP 'showresult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />
  </head>
  
  <body>
    <ul>
    <c:forEach items="${resultlist }" var="item" >
    <li>${item.id }</li>
    <li>${item.context }</li>
    </c:forEach>
    </ul>
    <c:if test="${pagination.totalPage > 0 }">
    <div class="pagination pagination-small">
    	<ul>
    		<c:if test="${pagination.currentPage > 1 }">
    			<li><a href="allsearch.do?page=1">首页</a></li>
    		</c:if>
    		<c:choose>
    			<c:when test="${pagination.totalPage%10 > 0 }">
    				<c:set var="count" value="${pagination.totalPage/pagination.pageSize + 1 }" />
    			</c:when>
    			<c:otherwise>
    				<c:set var="count" value="${pagination.totalPage/pagination.pageSize }" />
    			</c:otherwise>
    		</c:choose>
    		<li>
    			<a <c:if test="${pagination.currentPage > 1 }">href='allsearch.do?page=${pagination.currentPage - 1 }'</c:if> >&laquo;</a>
    		</li>
    		<c:choose>
    			<c:when test="${count - 1 > 1}">
	                <c:forEach var="p" begin="1" end="10">
	                    <li<c:if test="${p==pagination.currentPage}"> class='active'</c:if>>
	                    	<a href="allsearch.do?page=${p }">${p}</a>
	                    </li>  
	                </c:forEach>
	                <c:forEach var="index" begin="2" end="${count}">
	                    <c:forEach items="${pagination.pages}" var="page" begin="${(index-1)*pagination.pageSize}" end="${index*pagination.pageSize-1}">  
	                        <c:if test="${page>10}">
	                            <li <c:if test="${page==pagination.currentPage}">class='active'</c:if>>
	                            	<a href="allsearch.do?page=${page }">${page}</a>
	                            </li>  
	                        </c:if>
	                    </c:forEach>
	                    <c:if test="${count - index >= 1}">
	                        
	                    </c:if>
	                </c:forEach>
    			</c:when>
    			<c:otherwise>
    			 	<c:forEach items="${pagination.pages}" var="page">
	                    <li <c:if test="${page==pagination.currentPage}">class='active'</c:if>>
	                    	<a href="allsearch.do?page=${page }">${page}</a>
	                    </li>  
	                </c:forEach>
    			</c:otherwise>
    		</c:choose>
    		<li>
    			<a <c:if test="${pagination.currentPage < pagination.totalPage }">href='allsearch.do?page=${pagination.currentPage + 1 }'</c:if> >&raquo;</a>
    		</li>
    		<c:if test="${pagination.currentPage!=pagination.totalPage}">
	        	<li><a href="allsearch.do?page=${pagination.totalPage }">末页</a></li>
	        </c:if>
    	</ul>
    </div>
    </c:if>
    <div>
    </div>
  </body>
  
  <script src="./js/jquery-1.7.2.min.js"></script>
  <script src="./js/bootstrap.js"></script>
</html>
