<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="test1_proc" modelAttribute="data" method="post">
	num1 : <form:input path="num1" type="text"/><br>
	<!-- 이번에는 form 태그의 errors 로 에러를 가져와 본다... -->
	<form:errors path="num1" /><br>
	num2 : <form:input path="num2" type="text"/><br>
	<form:errors path="num2" /><br>
	<button type="submit">확인</button>
</form:form>
</body>
</html>