<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<!-- session : 브라우저가 서버에 요청하면 서버는 브라우저당 하나씩 메모리 공간을 할당해준다. 새로운 요청이 들어와도 같은 메모리 공간을 사용하게 된다.-->
<!-- @sessionScope : 최초의 요청이 있을 때부터 브라우저를 닫을 때까지 값이 유지된다.-->
<a href="t1">test1</a><br>
<a href="t2">test2</a><br>
<a href="t3">test3</a><br>
<a href="s1">spring1</a><br>

<a href="t4">test4</a><br>
<a href="s4">spring4</a><br>

<a href="t5">test5</a><br>
<a href="s5">spring5</a><br>

</body>
</html>