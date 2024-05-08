<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1번 페이지</title>
</head>
<body>
	<form:form modelAttribute="data">
		<form:hidden path="str1"/><br>
		<form:input path="str2"/><br>
		<form:password path="str3" showPassword="true"/><br>
		<form:textarea path="str4"/><br>
		<form:button disabled="true">체크</form:button>
	</form:form>
</body>
</html>