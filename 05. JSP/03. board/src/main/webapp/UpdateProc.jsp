<%@page import="bean.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>글 수정</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="boardbean" class="bean.BoardBean">
	<jsp:setProperty property="*" name="boardbean"/>
</jsp:useBean>
<%
	BoardDAO bdao = new BoardDAO();
	String pass = bdao.getPass(boardbean.getNum()); //hidden으로 넘긴 값 받기
	// ↓DB에 있는 값   ↓폼에 입력한 값(수정할때 적은 비밀번호 값)
	if(pass.equals(boardbean.getPassword())){
		bdao.updateBoard(boardbean);
		response.sendRedirect("BoardList.jsp");
	}else{
%>
	<script type="text/javascript">
		alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
		history.go(-1);
	</script>
<%
	}
%>
</body>
</html>