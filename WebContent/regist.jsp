<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
		<script src="js/jquery-3.3.1.min.js"></script>
		<script>
			function fun(){
				if($("#name").val()==""){
					alert("用户名不能为空！");
					return false;
				}
				if($("#password").val()==""){
					alert("密码不能为空！");
					return false;
				}
				return true;
			}
			function check(){
				$.get("CheckUserServlet",
					{username:$("#name").val()},
					function(data){
						$("#note").html(data);
					}
				)
			}
		</script>
</head>
<body>
	<form action="RegistServlet" method="post" onsubmit="return fun()">
		username:<input type="text" name="name" id="name" onchange="check()"/>
		<span id="note"></span><br/>
		password:<input type="password" name="password" id="password"/><br/>
		<input type="submit" value="regist"/> 
	</form>
</body>
</html>