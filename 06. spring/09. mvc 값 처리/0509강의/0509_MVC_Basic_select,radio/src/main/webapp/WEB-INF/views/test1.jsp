<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="data">
	<!-- select 태그의 path 가 s1 으로 되어있어서 s1의 값인 d2가 선택되어진채로 브라우저에 뜨게 된다. -->
	<form:select path="s1">
		<form:option value="d1">one</form:option>
		<form:option value="d2">two</form:option>
		<form:option value="d3">three</form:option>
	</form:select>
	
	<form:select path="s2">
		<form:options items="${requestScope.li1 }"></form:options>
	</form:select>
	
	<form:select path="s3">
		<form:options items="${requestScope.li2 }"></form:options>
	</form:select>
	
	<form:select path="s4">
		<form:options items="${requestScope.li3 }" itemLabel="s1" itemValue="s2"/>
	</form:select>
	
	<!-- form태그를 활용한 checkbox 예제 -->
	<!-- 하나하나 설정해도 되고 -->
	<form:checkbox path="s5" value="d1" />one
	<form:checkbox path="s5" value="d2" />two
	<form:checkbox path="s5" value="d3" />three<br>
	<!-- 배열에 넣어서 아래처럼 적어줘도 됨 -->
	<form:checkboxes path="s6" items="${requestScope.li1 }" />
	<form:checkboxes path="s7" items="${requestScope.li2 }" />
	<form:checkboxes path="s8" items="${requestScope.li3 }" />
	
	<!-- form태그를 활용한 radiobutton 예제 -->
	<form:radiobutton path="s9" value="d1" />one
	<form:radiobutton path="s9" value="d2" />two
	<form:radiobutton path="s9" value="d3" />three
	
	<form:radiobuttons path="s10" items="${requestScope.li1 }" />
	<form:radiobuttons path="s10" items="${requestScope.li2 }" />
	<form:radiobuttons path="s10" items="${requestScope.li3 }" itemLabel="s1" itemValue="s2"/>
	
</form:form>
</body>
</html>