<%@page import="kr.co.bit.MemberBean"%>
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
	MemberDAO mdao = new MemberDAO();
	String pass = mdao.getPass(mbean.getId());
	if(mbean.getPass1().equals(pass)){
		mdao.deleteMember(mbean.getId());
		response.sendRedirect("MemberArray.jsp");
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