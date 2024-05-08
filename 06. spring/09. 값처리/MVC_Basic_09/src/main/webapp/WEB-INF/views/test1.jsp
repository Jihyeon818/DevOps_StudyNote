<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1번 페이지</title>
</head>
<body>
	<form action="final" method="post">
		이름: <input type="text" name="name" value="${requestScope.data.name}" }><br>
		아이디: <input type="text" name="id" value="${data.id}" }><br>
		비밀번호: <input type="text" name="pw" value="${data.pw}" }><br>
		주소1: <input type="text" name="adr1" value="${data.adr1}" }><br>
		주소2: <input type="text" name="adr2" value="${data.adr2}" }>
		
		<button type="submit">로그인</button>
	</form>
</body>
</html>