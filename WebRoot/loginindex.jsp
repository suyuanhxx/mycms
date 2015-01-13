<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
  <head>
    <title></title>
    
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
			
			<a class="brand" href="./">Adminia Admin</a>
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					<li>
						<a href="#"><span class="badge badge-warning">7</span></a>
					</li>
					
					<li class="divider-vertical"></li>
					
					<li class="dropdown">
						
						<a data-toggle="dropdown" class="dropdown-toggle " href="#">
							${user.username } <b class="caret"></b>							
						</a>
						
						<ul class="dropdown-menu">
							<li>
								<a href="./account.html"><i class="icon-user"></i> Account Setting  </a>
							</li>
							
							<li>
								<a href="./change_password.html"><i class="icon-lock"></i> Change Password</a>
							</li>
							
							<li class="divider"></li>
							
							<li>
								<a href="./"><i class="icon-off"></i> Logout</a>
							</li>
						</ul>
					</li>
				</ul>
				
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
							<div class="span4">
								<div class="carousel slide" id="carousel">
									<div class="carousel-inner">
										<div class="item active">
											<img alt="" src="./img/pic1.jpg" />
										</div>
										<div class="item">
											<img alt="" src="./img/pic2.jpg" />
										</div>
										<div class="item">
											<img alt="" src="./img/pic3.jpg" />
										</div>
									</div>
									<a data-slide="prev" href="#carousel" class="left carousel-control">‹</a> 
									<a data-slide="next" href="#carousel" class="right carousel-control">›</a>
									<div id="slide-list">
					            		<ul id="slide-list-items">
							              <li class="current"><a href="#"></a></li>
							              <li><a href="#"></a></li>
							              <li><a href="#"></a></li>
					            		</ul>
					        		</div>
								</div>
							</div>
							<div class="span8" style="height:500px;">
								<div class="searcharea">
									<form class="form-search pull-right" action="allsearch.do" method="get">
										<span>知识就是力量</span>
									  	<input type="text" class="input search-query" name="key">
									  	<button type="submit" class="btn">Search</button>
									</form>
								</div>
								<div class="container-fuild" style="height: 560px;">
										<iframe width="100%" height="100%" scrolling="no" frameborder="0" src="latest.do">
										</iframe>
									</div>
								</div>
							</div>
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



</body>
</html>
