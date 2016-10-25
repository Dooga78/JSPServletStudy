<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<title>Emp List</title>
</head>
<body>
<h1>Emp</h1>
<table>
	<tr>
		<td>ID</td><td>이 름</td>
	</tr>
	<c:forEach items="${ list }" var="eVo">
	<tr>
		<td>${ eVo.empId }</td>
		<td>${ eVo.ename }</td>
	</tr>
	</c:forEach>
</table>oops!!
<a href="insertUI.do">직원 생성</a><br>
<c:if test="${ message ne null }">${ message }</c:if>
<%@ include file="/jsp/common/copyright.jsp" %>
</body>
</html>