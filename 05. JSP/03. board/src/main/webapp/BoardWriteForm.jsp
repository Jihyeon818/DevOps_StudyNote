<%@page import="bean.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시물 작성 폼</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="boardbean" class="bean.BoardBean">
		<jsp:setProperty property="*" name="boardbean"/>
	</jsp:useBean>
	<!--  set으로 Bean에 값 저장 -->
	<%
		BoardDAO bdao = new BoardDAO();
		bdao.insertBoard(boardbean);
	
		response.sendRedirect("BoardList.jsp");//글쓰기 한 후 바로 글쓴 목록으로 이동
	%>
</body>
</html>