<%@page import="kr.co.bit.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mbean" class="kr.co.bit.MemberBean">
	<jsp:setProperty property="*" name="mbean"/>
</jsp:useBean>

<%
	String id = request.getParameter("id");
	MemberDAO mdao = new MemberDAO();
	
	//데이터베이스에서 비밀번호 가져오기
	String pass = mdao.getPass(id);
	
	if(mbean.getPass1().equals(pass)){
		mdao.updateMember(mbean);
		response.sendRedirect("MemberArray.jsp");
		//DB패스워드와 입력 패스워드 같다면 member테이블 수정할 수 있음
	}else{
%>
	<script type="text/javascript">
		alert("패스워드가 틀렸습니다. 다시 입력해주세요.");
		history.go(-1);
	</script>
<%
	}
%> 
</body>
</html>