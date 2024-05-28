<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>로그인</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery-3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="/WEB-INF/views/include/nav.jsp"/>
	<div class="container" style="margin-top: 100px">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="card shadow">
					<div class="card-body">
						<c:if test="${fail==false }">
							<div class="alert alert-primary">
								<h2>환영합니다!</h2>
								<p>어서오세요. 로그인을 진행해주세요</p>
							</div>
						</c:if> 
						<c:if test="${fail==true }">
							<div class="alert alert-danger">
								<h2>로그인 실패</h2>
								<p>아이디와 비밀번호를 확인하세요</p>
							</div>
						</c:if> <!-- 로그인에 실패하면 true가 boolean fail에 저장 -->
						<form:form action="${root}user/login_pro" method="post" modelAttribute="loginProBean">
							<div class="form-group">
								<form:label path="user_id">아이디</form:label> 
								<form:input type="text" class="form-control" path="user_id" />
								<form:errors path="user_id" style='color:red'/>
							</div>
							<div class="form-group">
								<form:label path="user_pw">비밀번호</form:label> 
								<form:input type="password" class="form-control" path="user_pw" />
								<form:errors path="user_pw" style='color:red'/>
							</div>
							<div class="text-right">
									<form:button class="btn btn-primary">로그인</form:button>
									<a href="${root }user/join" class="btn btn-danger">회원가입</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/include/footer.jsp"/>
</body>