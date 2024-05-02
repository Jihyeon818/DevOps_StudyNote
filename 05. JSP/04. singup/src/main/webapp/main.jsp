<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:if test="${empty loguser }">
	<jsp:forward page="Login2.do"></jsp:forward>
</c:if>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>메인</title>
	<script type="text/javascript" src="member.js"></script>
	<link rel="stylesheet" href="login_style.css">
</head>
<body>
<h2>메인</h2>
<form action="Logout.do">
	${loguser.userid }
	<input type="submit" value="로그아웃">&nbsp;&nbsp;
	<input type="button" value="수정" onclick="location.href='memberUpdate.do?userid=${loguser.userid}'">
</form>
</body>
</html>