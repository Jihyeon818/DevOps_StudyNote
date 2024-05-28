<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인메뉴</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">

			<!-- 내비게이션 바 (헤더) -->
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#Navbar">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${root }/">스프링 레거시</a>
			</div>

			<!-- 내비게이션 바 -->
			<div class="collapse navbar-collapse" id="Navbar">
				<!-- 게시판 -->
				<ul class="nav navbar-nav">
						<li><a href="MainBoard">게시판</a></li>
				</ul>
				

				<!-- 로그인이 안되어 있는 경우 (=회원정보가 empty 인 경우) if문 안의 항목이 보이게 만듬 -->
				<c:if test="${empty memberVo }">
				
					<!-- 로그인/회원가입 -->
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a class="dropdown-item" href="${root }/memberLoginForm">
								<span class="glyphicon glyphicon-log-in"> 로그인</span>
							</a>
						</li>
						<li>
							<a class="dropdown-item" href="${root }/memberJoin">
								<span class="glyphicon glyphicon-user"> 회원가입</span>
							</a>
						</li>
					</ul>
				</c:if>

				<!-- 로그인 되어있는 경우 (=회원정보가 empty 가 아닌 경우) if문 안의 항목이 보이게 만든다. -->
				<c:if test="${!empty memberVo }">

					<!-- 마이페이지 -->
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown"> 마이페이지 </a>
							<ul class="dropdown-menu dropdown-menu-dark">
								<li><a class="dropdown-item" href="${root }/memberUpdateForm">
									<span class="glyphicon glyphicon-user"> 회원정보수정</span>
								</a></li>
								<li><a class="dropdown-item" href="${root }/memberImageForm">
									<span class="glyphicon glyphicon-picture"> 사진등록</span>
								</a></li>
								<li><a class="dropdown-item" href="${root }/memberLogout">
									<span class="glyphicon glyphicon-log-out"> 로그아웃</span>
								</a></li>
							</ul>
						</li>
						<li>
							<c:if test="${!empty memberVo}">
								<!-- 프로필 사진이 없으면 기본 사진으로 -->
								<c:if test="${memberVo.memberProfile eq ''}">
									<img src="${root }/resources/images/kirby-free.png" style="width: 50px; height: 50px;">
									${memberVo.memberName}님 안녕하세요
								</c:if>
								<!-- 프로필 사진이 있으면 띄우기 -->
								<c:if test="${memberVo.memberProfile ne '' }">
									<img src="${root }/resources/upload/${memberVo.memberProfile }" style="width: 50px; height: 50px;">
									${memberVo.memberName}님 안녕하세요
								</c:if>
							</c:if>
						</li>
					</ul>
				</c:if>
			</div>
		</div>
	</nav>
</body>
</html>