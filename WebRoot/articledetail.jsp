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
    
    <title>detail</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />
    
    <!--<link href="./font-awesome/css/font-awesome.min.css" rel="stylesheet" />-->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    
    <link href="./css/adminia.css" rel="stylesheet" /> 
    <link href="./css/adminia-responsive.css" rel="stylesheet" /> 

    <link rel="stylesheet" type="text/css" href="./css/main.css">
    
    
	<style type="text/css">
		a:link{text-decoration: none};
	</style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>

<body>
	
<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 				
			</a>
			
			<a class="brand" href="./"></a>
			
			<div class="nav-collapse">
				<div class="pull-right">		
					<a href="login.html" ><i class="fa fa-sign-in"></i> Login In </a>
					<a href="register.html" ><i class="fa fa-user"></i> Sign Up </a>
				</div>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->




<div id="content">
	
	<div class="container">
		
		<div class="row">
			<div class="span10 offset1">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container">
							<ul class="nav" style="width:100%">
			                  <li class="active"><a href="#">首页</a></li>
			                  <li><a href="#">法制</a></li>
			                  <li><a href="#">文学</a></li>
			                  <li><a href="#">社区</a></li>
			                  <li><a href="#">活动</a></li>
		                	</ul>
	                	</div>
                	</div>
				</div>
				<div class="span10 body-center">
					<div class="container-fluid" style="padding: 0 0;">
						<div class="row-fluid">
							<span>${article.title}</span>
							<span>${articledetail.context}</span>
						</div>
					</div>
				</div>

				<div class="span10 offset1">
					<span>法制专区</span>
				</div>
			</div>
			
		</div> <!-- /row -->
		
	</div> <!-- /container -->
	
</div> <!-- /content -->
					
	 
<div id="footer">
	
	<div class="container">				
		<hr />
		<p style="margin-left:100px">&copy; 2014 suyuanhxx</p>
	</div> <!-- /container -->
	
</div> <!-- /footer -->


    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./js/jquery-1.7.2.min.js"></script>

<script src="./js/bootstrap.js"></script>
<script type="text/javascript">
	$(document).ready(function(){

	})
</script>


</body>
</html>

