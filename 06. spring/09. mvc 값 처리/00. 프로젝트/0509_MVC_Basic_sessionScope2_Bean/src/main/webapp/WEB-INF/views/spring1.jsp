<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Session 영역<br>
${sessionScope.data1.str1}<br>
${sessionScope.data1.str2}<br>
아무것도 출력되지 않는다. model객체에 담아서 전송했기 때문이지...ㅎ
<hr>
Request 영역<br>
${requestScope.data1.str1 }<br>
${requestScope.data1.str2 }<br>
<br>
${requestScope.data2.str3 }<br>
${requestScope.data2.str4 }<br>
<br>
${requestScope.data3.str5 }<br>
${requestScope.data3.str6 }<br>
</body>
</html>