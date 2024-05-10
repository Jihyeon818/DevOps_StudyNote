<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1. request 영역에서 값이 유지되는지 확인<br>
<!-- sbean을 session 영역에 넣었음에도 requestScope 로 해도 출력되는 이유?
	그야 request 영역이 더 작으니까... sbean은 session 영역에 있긴 하지만 requestScope로 출력해도 나온다. -->
${requestScope.sbean.str1 }<br>
${requestScope.sbean.str2 }<br>
<br>
2. session 영역에서 값이 유지되는지 확인<br>
${sessionScope.sbean2.str1 }<br>
${sessionScope.sbean2.str2 }<br>
</body>
</html>