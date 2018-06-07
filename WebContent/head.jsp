<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
欢迎访问本网站!
<c:if test="${empty login }">
	<a href="login.jsp">登录</a>
	
	<a href="regist.jsp">注册</a>
</c:if>
<c:if test="${not empty login }">
	欢迎 ${username}. 
	<a href="LogoutServlet">注销</a> <br/>		
</c:if>