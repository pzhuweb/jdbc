<%@page import="cn.pzhu.pojo.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车信息</title>
</head>
<body>
<table>
	<tr>
	<th>状态</th>
	<th>id</th>
	<th>name</th>
	<th>type</th>
	<th>price</th>
	</tr>
	<c:forEach items="${list }" var="car" varStatus="X">
		<tr>
			<td>${X.count}</td>
			<td>${car.id}</td>
			<td>${car.name}</td>
			<td>${car.type}</td>
			<td><fmt:formatNumber value="${car.price}" pattern=".00"></fmt:formatNumber></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5"> ${bar}</td>
	</tr>
</table>
</body>
</html>