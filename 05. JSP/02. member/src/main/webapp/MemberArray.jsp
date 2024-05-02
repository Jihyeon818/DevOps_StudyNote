<%@page import="kr.co.bit.MemberDAO"%>
<%@page import="kr.co.bit.MemberBean"%>
<%@page import="java.util.Vector"%>
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
	//모든 회원정보 가져오기
	MemberDAO mdao = new MemberDAO();
	//가변길이인 vector를 이용해 데이터를 저장한 후 화면에 회원들 정보 출력
	Vector<MemberBean> vec = mdao.allSelectMember();
%>
	<table width="800" border="1">
		<tr height="50">
			<td width="150" align="center">아이디</td>
			<td width="250" align="center">이메일</td>
			<td width="200" align="center">전화번호</td>
			<td width="200" align="center">취미</td>
		</tr>
		<%
			for(int i=0;i<vec.size();i++){
				MemberBean bean = vec.get(i);
		%>
		<tr height="50">
			<td width="150" align="center"><a href="MemberIn.jsp?id=<%=bean.getId()%>"><%=bean.getId()%></a></td>
			<td width="250" align="center"><%=bean.getEmail()%></td>
			<td width="200" align="center"><%=bean.getTel()%></td>
			<td width="200" align="center"><%=bean.getHobby()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>