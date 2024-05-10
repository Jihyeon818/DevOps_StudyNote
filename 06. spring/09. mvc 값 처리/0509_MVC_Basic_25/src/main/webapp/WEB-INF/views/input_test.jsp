<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력 폼</title>
</head>
<body>
	<form action="input_proc" method="post">
		num1 : <input type="text" name="num1"><br> <!-- num1,2,3에 입력한 값을 Data 클래스 필드에 넣기 -->
		num2 : <input type="text" name="num2"><br>
		num3 : <input type="text" name="num3"><br>
		
		<button type="submit">확인</button>
	</form>
</body>
</html>