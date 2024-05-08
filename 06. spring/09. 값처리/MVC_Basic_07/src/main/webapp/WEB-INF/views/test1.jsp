<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿼리스트링 값 출력</title>
</head>
<body>
	<%
		String d1 = request.getParameter("data1");
		String d2 = request.getParameter("data2");
	%>
	<%=d1 %>
	<%=d2 %><br>
	
	<!-- EL언어 -->
	${param.data1 }
	${param.data2 }
</body>
</html>