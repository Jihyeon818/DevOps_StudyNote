<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="obj" items="${li }">
		<hr>
		${obj.num1 }<br>
		${obj.num2 }<br>
		${obj.num3 }<br>
	</c:forEach>
</body>
</html>