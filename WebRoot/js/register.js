$(function(){
	
	$("#username").blur(function(){
	    var username = $("#username").val();
	    $.ajax({
	    	type : "post",
	    	url : "checkusername.do",
	    	data : {username:username},
	    	contentType : "application/x-www-form-urlencoded",
	    	success : function(data)
	    	{
				if(data.result == "exist")
				{
					$("#checkusernameinfo").html("用户名已存在");
					userillegal = 1;
				} else {
					$("#checkusernameinfo").html("可以使用此用户名");
					userillegal = 0;
				}
			}
	    });	
	});
	
	$("#repassword").blur(function(){
		var pwd = document.getElementById("password").value;
		var repwd = document.getElementById("repassword").value;
		if(pwd!=repwd)
		{
			document.getElementById("passwordtag").innerText="Password does not match";
			$("#register").attr('disabled',true);
		}
		else
		{
			document.getElementById("passwordtag").innerText="";
			$("#register").attr('disabled',false);
		}
	});
	
	$("#password").blur(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		if(username==null || username=="" || password==null || password==""){
			$("#logintip").html("请输入用户名和密码");
			$("#login").attr('disabled',true);
		}
		else
		{
			$("#logintip").html("");
			$("#login").attr('disabled',false);
		}
	});

	$("#login").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		if(username==null || username=="" || password==null || password==""){
			$("#logintip").html("请输入用户名和密码");
		}
		else
		{
			$("#logintip").html("");
			document.forms["loginform"].submit();
		}
	});
	
});