<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<form action="LoginServlet" method="post">
	username:<input type="text" name="name" value="${username }"/><br/>
	password:<input type="password" name="password" value="${password }"/><br/>
	<input type="checkbox" value="yes" name="isSave" ${(empty username)?'':'checked'}/>是否保存用户信息<br/>
	<input type="submit" value="login"/> 
</form>
</body>
</html>