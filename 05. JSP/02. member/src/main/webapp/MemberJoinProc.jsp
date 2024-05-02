<%@page import="kr.co.bit.MemberDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	request.setCharacterEncoding("UTF-8");
	String[] hobby = request.getParameterValues("hobby");
	String str="";
	
	//배열에 있는 내용을 하나의 문자열로 저장
	for(int i=0;i<hobby.length;i++){
		str+=hobby[i]+""; //여러개의 값 클릭시 연결해서 하나의 값으로 받음(캠핑등산)
	}
%>
<!-- useBean을 이용하여 한꺼번에 데이터 받기 -->
<jsp:useBean id="mbean" class="kr.co.bit.MemberBean">
	<jsp:setProperty property="*" name="mbean"/>
</jsp:useBean>

<%
	mbean.setHobby(str);
	MemberDAO mdao = new MemberDAO(); //Data Access Object
	mdao.insertMember(mbean);
	
	//회원가입이 되었다면 회원정보를 보여주는 페이지로 이동
	 response.sendRedirect("MemberArray.jsp");

%>
디비완료

</body>
</html>