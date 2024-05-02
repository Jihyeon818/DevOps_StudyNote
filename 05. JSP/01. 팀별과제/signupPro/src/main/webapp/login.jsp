<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>로그인</title>
	<script type="text/javascript" src="script/script.js"></script>
	<link rel="stylesheet" href="css/script.css">
</head>
<body>
	<div id="loginbox">
		<h2>로그인</h2>
		<form action="loginProc.jsp" name="frm">
			<label for="id">로그인</label>
			<input type="text" name="id" id="id"><br>
			<label for="pwd">비밀번호</label>
			<input type="text" name="pwd" id="pwd"><br>
			<input type="submit" value="로그인" onclick="return loginCheck()">
		</form>
		<button onclick="location.href='member.jsp'">회원가입</button>
	</div>
</body>
</html>