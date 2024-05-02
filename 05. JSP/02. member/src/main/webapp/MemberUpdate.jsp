<%@page import="kr.co.bit.MemberBean"%>
<%@page import="kr.co.bit.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	MemberDAO mdao = new MemberDAO();
	MemberBean mbean = mdao.oneMember(id);
%>
<center>
<h1><%=id %>님의 회원정보 수정</h1>
<table width="400" border="1">
	<form action="UpdateProc.jsp" method="post">
		<tr height="50">
			<td width="150" align="center">아이디</td>
			<td width="250" align="center"><%=mbean.getId() %></td>
		</tr>
		<tr height="50">
			<td width="150" align="center">이메일</td>
			<td width="250" align="center">
				<input type="email" name="email" value="<%=mbean.getEmail()%>">
			</td>
		</tr>
		<tr height="50">
			<td width="150" align="center">전화번호</td>
			<td width="250" align="center">
				<input type="tel" name="tel" value="<%=mbean.getTel() %>">
			</td>
		</tr>
		<tr height="50">
			<td width="150" align="center">비밀번호</td>
			<td width="250" align="center">
				<input type="password" name="pass1">
			</td>
		</tr>
		<tr height="50">
			<td colspan="2" align="center">
				<input type="hidden" name="id" value="<%=mbean.getId() %>"> <!-- 서버에 값을 숨겨서 넘김 -->
				<input type="submit" value="회원수정">
		</form>
				<button onclick="location.href='MemberArray.jsp'">전체목록</button>
			</td>
		</tr>
	
</table>

</body>
</html>