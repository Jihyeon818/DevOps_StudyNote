<%@page import="bean.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제 기능</title>
</head>
<body>
<%
	String pass = request.getParameter("password");
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDAO  bdao = new BoardDAO();
	String password = bdao.getPass(num);	
	// ↓DB에 있는 값   ↓폼에 입력한 값(수정할때 적은 비밀번호 값)
	if(pass.equals(password)){
		bdao.deleteBoard(num);
		response.sendRedirect("BoardList.jsp");
	}else{
%>
		<script type="text/javascript">
			alert("비밀번호를 다시 확인해주세요");
			history.go(-1);
		</script>		
<%		
	}
%>

</body>
</html>