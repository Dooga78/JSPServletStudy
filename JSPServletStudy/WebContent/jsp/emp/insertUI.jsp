<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<title>Emp insert UI</title>
</head>
<body>
<h1>Emp</h1>
<form action="insert.do" method="post">
<table>
	<tr>
		<td>ID</td>
		<td><input type="text" name="empId"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="ename"></td>
	</tr>
	<tr>
		<td>연봉</td>
		<td><input type="text" name="salary"></td>
	</tr>
</table>
<input type="submit" value="저장">
<input type="reset" value="Reset">
</form>
<%@ include file="/jsp/common/copyright.jsp" %>
</body>
</html>