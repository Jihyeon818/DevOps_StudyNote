<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>댓글기능</title>
	<link rel="stylesheet" href="BoardStyle.css">
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int ref = Integer.parseInt(request.getParameter("ref"));
	int re_step = Integer.parseInt(request.getParameter("re_step"));
	int re_level = Integer.parseInt(request.getParameter("re_level"));
%>
	<h2>댓글쓰기</h2>
	<form action="ReWriteProc.jsp" method="post">
		<table width="600">
			<tr height="40">
				<th width="150">작성자</th>
				<td width="450"><input type="text" name="writer" size="58"></td>
			</tr>
			<tr height="40">
				<th width="150">제목</th>
				<td width="450"><input type="text" name="subject" size="58"></td>
			</tr>
			<tr height="40">
				<th width="150">이메일</th>
				<td width="450"><input type="email" name="email" size="58"></td>
			</tr>
			<tr height="40">
				<th width="150">비밀번호</th>
				<td width="450"><input type="password" name="password" size="58"></td>
			</tr>
			<tr height="40">
				<th  width="150">글내용</th>
				<td width="450"><textarea rows="10" cols="60" name="content" size="50"></textarea></td>
			</tr>
			<tr height="40" class="lasttr">
				<td colspan="2">
					<input type="hidden" name="ref" value="<%=ref %>">
					<input type="hidden" name="re_step" value="<%=re_step %>">
					<input type="hidden" name="re_level" value="<%=re_level %>">
					
					<input type="submit" value="답글쓰기">
					<input type="reset" value="재작성">
					<input type="button" onclick="location.href='BoardList.jsp'" value="전체글 보기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>