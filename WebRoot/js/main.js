$(function(){
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

})