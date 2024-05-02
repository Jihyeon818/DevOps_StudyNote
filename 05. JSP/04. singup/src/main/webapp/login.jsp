<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>로그인</title>
	<script type="text/javascript" src="member.js"></script>
	<link rel="stylesheet" href="login_style.css">
</head>
<body>
<h2>로그인</h2>
<!-- 서블릿으로 넘길 때 do라는 확장자를 씀 -->
<form action="Login2.do" method="post" name="frm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userid" value="${userid}" ></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인" onclick="return check()">&nbsp;&nbsp;
				<input type="reset"  value="취소"> &nbsp;&nbsp;
				<input type="button" value="회원가입" onclick="location.href='join.do'">
			</td>
		</tr>
		<tr>
			<td colspan="2" class="msg">${requestScope.msg}</td> <!-- setAtrribute한거라 el언어에 변수만 적어도됨 -->
		</tr>
	</table>
</form>
</body>
</html>