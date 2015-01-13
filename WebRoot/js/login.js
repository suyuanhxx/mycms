$(function(){
	
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
			$("loginmsg").html("");
		}
		else
		{
			$("#logintip").html("");
			document.forms["loginform"].submit();
//			$.ajax({
//		         type:"POST",
//		         url:"login.do",
//		         data:{username:username,password:password},
//		         success:function(msg){
//		             alert(msg.login);
//		         },
//		         error:function(msg){
//		         }
//		     });
		}
	});
	
});