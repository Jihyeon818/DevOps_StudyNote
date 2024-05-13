<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>

<form:form modelAttribute="data" method="post" action="test_proc"> <!-- modelAttribute="클래스(앞글자소문자)"로 연결하여 데이터 주입 -->
	num1: <form:radiobutton path="num1" value="true"/>true <!-- Data에서 기본값으로 true를 초기화해서 선택됨 -->
		  <form:radiobutton path="num1" value="false"/>false <!-- @AssertTrue에 위배되서 false선택 시 에러, 메세지를 띄우기 위해 bindingResurlt 연결해야 함 -->
		  <form:errors path="num1"/><br>
		  
	num2: <form:radiobutton path="num2" value="true"/>true 
		  <form:radiobutton path="num2" value="false"/>false
		  <form:errors path="num2"/><br>
	
	num3: <form:input path="num3" type="text"/><br>
		  <form:errors path="num3"/><br>

	num4: <form:checkbox path="num4" value="check1"/>Null<br>
		  <form:errors path="num4"/><br>
	
	num5: <form:checkbox path="num5" value="check2"/>NotNull<br>
		  <form:errors path="num5"/><br>
		  
	num6: <form:input path="num6" type="text"/><br>
		  <form:errors path="num6"/><br>
		 
	num7: <form:input path="num7" type="text"/><br>
		  <form:errors path="num7"/><br>
		  
	num8: <form:input path="num8" type="text"/><br>
		  <form:errors path="num8"/><br>
	
	<form:button type="submit">체크</form:button>
</form:form>


</body>
</html>