<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<script type="text/javascript" src="member.js"></script>
	<link rel="stylesheet" href="login_style.css">
</head>
<body>
	<form action="join.do" method="post" name="frm">
		<ul>
			<li>
				<label for="name" class="intitle">이름</label>
				<input type="text" name="name" id="name">
			</li>
			<li>
				<label for="id" class="intitle">아이디</label>
				<input type="text" name="userid" id="id">
				<input type="hidden" name="reid">
				<input type="button" value="중복체크" onclick="idCheck()">
			</li>
			<li>
				<label for="pw" class="intitle">비밀번호</label>
				<input type="password" name="pwd" id="pw">
			</li>
			<li>
				<label for="pw2" class="intitle">비밀번호 확인</label>
				<input type="password" name="pwd_check" id="pw2">
			</li>
			<li>
				<label for="email" class="intitle">이메일</label>
				<input type="email" name="email" id="email">
			</li>
			<li>
				<label for="phone" class="intitle">전화번호</label>
				<input type="tel" name="phone" id="phone">
			</li>
			<li>
				<span class="intitle">회원구분</span>
				<input type="radio" name="admin" value="0" checked="checked" id="admin1">
				<label for="admin1">일반회원</label>
				<input type="radio" name="admin" value="1" id="admin2">
				<label for="admin2">관리자</label>
			</li>
		</ul>
		<div class="join">
			<input type="submit" value="회원가입" onclick="return joinCheck()">
			${msg }
		</div>
	</form>
</body>
</html>