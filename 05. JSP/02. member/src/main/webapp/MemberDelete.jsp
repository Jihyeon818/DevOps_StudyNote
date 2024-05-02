<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>회원정보 삭제</h1>
<table width="400" border="1">
	<form action="DeleteProc.jsp" method="post">
		<tr height="50">
			<td width="150" align="center">아이디</td>
			<td width="250" align="center"><%=request.getParameter("id") %></td>
		</tr>
		<tr height="50">
			<td width="150" align="center">비밀번호</td>
			<td width="250" align="center">
				<input type="password" name="pass1">
			</td>
		</tr>
		<tr height="50">
			<td colspan="2" align="center">
				<input type="hidden" name="id" value="<%=request.getParameter("id") %>"> <!-- 서버에 값을 숨겨서 넘김 -->
				<input type="submit" value="회원삭제">
		</form>
				<button onclick="location.href='MemberArray.jsp'">전체목록</button>
			</td>
		</tr>
	
</table>

</body>
</html>