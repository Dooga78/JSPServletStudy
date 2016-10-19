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
		<td>ID</td>
	</tr>
	<c:forEach items="${ list }" var="eVo">
	<tr>
		<td>${ eVo.empId }</td>
	</tr>
	</c:forEach>
</table>
<%@ include file="/jsp/common/copyright.jsp" %>
</body>
</html>