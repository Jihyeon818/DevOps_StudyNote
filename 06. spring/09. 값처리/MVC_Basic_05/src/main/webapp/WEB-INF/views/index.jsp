<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>

<a href="t1?data1=10&data2=20&data3=30&data3=40">test1</a><br>
<form action="t2" method="post">
	d1: <input type="text" name="d1"><br>
	d2: <input type="text" name="d2"><br>
	d3: <input type="checkbox" name="d3" value="10">data3 10
		<input type="checkbox" name="d3" value="20">data3 20<br>
		<button type="submit">test2</button>
</form>

<br><br>

<a href="t3?data1=10&data2=20&data3=30&data3=40">test3</a><br>

<a href="t4/10/20/30">test4</a><br>

<a href="t5?data1=10&data2=20&data3=30&data3=40">test5</a><br>
<a href="t6?data1=10&data2=20&data3=30&data3=40">test6</a><br>

<a href="t7?data1=10">test7</a><br>

</body>
</html>