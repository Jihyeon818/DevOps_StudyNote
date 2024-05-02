<%@page import="bean.BoardBean"%>
<%@page import="bean.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 상세</title>
	<link rel="stylesheet" href="BoardStyle.css">
</head>
<body>
	<%
	//게시글 상세보기을 하기 위해 BoardList에서 전달받은 num값을 가지고 옴
		int num = Integer.parseInt(request.getParameter("num").trim());
		BoardDAO bdao = new BoardDAO();
		BoardBean bean = bdao.oneBoard(num); //한 게시물 상세보기 할거임
	%>
	<h2>게시글 상세</h2>
	<table width="600">
		<tr height="40">
			<th width="120">번호</th>
			<td width="120"><%=bean.getNum() %></td>
			<th width="120">조회수</th>
			<td width="120"><%=bean.getReadcount() %></td>
		</tr>
		<tr height="40">
			<th width="120">작성자</th>
			<td width="120"><%=bean.getWriter() %></td>
			<th width="120">작성날짜</th>
			<td width="120"><%=bean.getReg_date() %></td>
		</tr> 
		<tr height="40">
			<th width="120">이메일</th>
			<td width="=360" colspan="3"><%=bean.getEmail()%></td>
		</tr>
		<tr height="40">
			<th width="120">제목</th>
			<td width="=360" colspan="3" ><%=bean.getSubject()%></td>
		</tr>
		<tr height="40">
			<th width="120">내용</th>
			<td width="=360" colspan="3"><%=bean.getContent()%></td>
		</tr>
		<tr height="40" class="lasttr">
			<td width="480" colspan="4">
				<input type="button" value="댓글쓰기" onclick="location.href='ReWriteForm.jsp?num=<%=bean.getNum() %>&ref=<%=bean.getRef() %>&re_step=<%=bean.getRe_step() %>&re_level=<%=bean.getRe_level() %>'">
         		<input type="button" value="수정" onclick="location.href='UpdateForm.jsp?num=<%=bean.getNum() %>'"> <!-- 글번호 가지고 UpdateForm -->
         		<input type="button" value="삭제" onclick="location.href='DeleteForm.jsp?num=<%=bean.getNum() %>'"> <!-- 글번호 가지고 DeleteForm -->
         		<input type="button" value="목록" onclick="location.href='BoardList.jsp'"> <!-- BoardList -->
         	</td>
		</tr>
	</table>
</body>
</html>