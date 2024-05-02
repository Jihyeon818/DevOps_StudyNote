<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 확인</title>
	<script type="text/javascript" src="member.js"></script>
	<link rel="stylesheet" href="login_style.css">
</head>
<body>
	<h2>아이디 확인</h2>
	<form action="idCheck.do" method="get" name="frm">
		<label for="name">이름</label>
		<input type="text" name="name" id="name">
		<input type="submit" value="중복체크"><br>
		
		<c:if test="${result==1 }">
			<script type="text/javascript">
				opener.document.frm.userid.value="";
			</script>
			${userid }는 이미 사용중인 아이디입니다.
		</c:if>
		<c:if test="${result==-1 }">
			${userid }는 사용가능한 아이디입니다.
		</c:if>
	</form>
</body>
</html>