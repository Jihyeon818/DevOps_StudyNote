<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시물 작성</title>
	<link rel="stylesheet" href="BoardStyle.css">
</head>
<body>
	<h1>게시물 작성</h1>
	<form action="BoardWriteForm.jsp" method="post">
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
					<input type="submit" value="글쓰기">
					<input type="reset" value="재작성">
					<button onclick="location.href='BoardList.jsp'">전체글 보기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>