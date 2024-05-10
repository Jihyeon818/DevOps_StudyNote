<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- taglib 추가 ! -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 유효성 검사 : num1, num2 에 적는 값은 Data 클래스의 어노테이션 조건에 맞아야 한다. (@Max, @Size) -->
<form action="test1_proc" method="post">
	num1 : <input type="text" name="num1"><br>
	<!-- 유효성 검사를 통과 못하는 경우, 요 밑에다가 에러메시지를 띄울것임. -->
	<!-- Data 클래스에서 에러가 있는 경우, -->
	<spring:hasBindErrors name="data">
		<!-- num1에서 에러가 있다? --> 
		<c:if test="${errors.hasFieldErrors('num1') }">
			<!-- 해당 에러에 대한 defalutMessafe를 브라우저에 띄운다. -->
			${errors.getFieldError('num1').defaultMessage }<br>
		</c:if>
	</spring:hasBindErrors>
	
	<!-- num2에도 똑같이 설정.. -->
	num2 : <input type="text" name="num2"><br>
	<spring:hasBindErrors name="data">
		<c:if test="${errors.hasFieldErrors('num2') }">
			${errors.getFieldError('num2').defaultMessage }<br>
		</c:if>
	</spring:hasBindErrors>
	<button type="submit">확인</button>
</form>
</body>
</html>