<%@page import="bean.BoardBean"%>
<%@page import="bean.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시물 삭제</title>
	<link rel="stylesheet" href="BoardStyle.css">
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDAO bdao = new BoardDAO();
	BoardBean bean = bdao.oneUpdateBoard(num);
	//삭제하기 전에 삭제하고 싶은 게시글의 입력 정보를 띄움
%>
<h2>게시글 삭제</h2>
<form action="DeleteProc.jsp" method="post">
	<table width="600">
		<tr height="40">
			<th width="150">작성자</th>
			<td width="150"><%=bean.getWriter()%></td>
			<th width="150">작성일</th>
			<td width="150"><%=bean.getReg_date()%></td>
		</tr>
		<tr height="40">
			<th width="150">제목</th>
			<td width="450" colspan="3">&nbsp;<input type="text" name="subject" value="<%=bean.getSubject()%>"></td>
		</tr>
		<tr height="40">
			<th width="150">비밀번호</th>
			<td width="450" colspan="3">&nbsp;<input type="password" name="password" value="<%=bean.getPassword()%>"></td>
		</tr>
		<tr height="40" class="lasttr">
			<td width="450" colspan="4">
				<input class="btn" type="hidden" name="num" value="<%=bean.getNum() %>">
				<input class="btn" type="submit" value="삭제">&nbsp;
				<input class="btn" type="button" value="목록" onclick="location.href='BoardList.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>