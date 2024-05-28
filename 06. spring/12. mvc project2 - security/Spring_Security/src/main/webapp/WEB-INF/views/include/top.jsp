<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="root" value="${pageContext.request.contextPath }" />
<c:set var="memberVo" value="${SPRING_SECURITY_CONTEXT.authentication.principal}"/>
<c:set var="auth" value="${SPRING_SECURITY_CONTEXT.authentication.authorities}"/>

<script>
var csrfHeaderName = "${_csrf.headerName}";
var csrfTokenValue = "${_csrf.token}";

function logout() {
	$.ajax({
		url:"${root}/logout",
		type:"post",
		beforeSend: function(xhr){ 
			xhr.setRequestHeader(csrfHeaderName,csrfTokenValue)
		},
		success: function() {
			location.href="${root}/";
		},
		error : function() {
			alert("error");
		}	
	});
}
</script>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<div class="navbar-header">
			<button class="navbar-toggle" type="button" data-toggle="collapse"
				data-target="#Navbar">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${root}/">Spring Legacy</a>
		</div>

		<div class="collapse navbar-collapse" id="Navbar">
			<ul class="nav navbar-nav">
				<li><a href="MainBoard">게시판</a></li>
			</ul>


			<%-- <c:if test="${empty memberVo }"> --%>
			<security:authorize access="isAnonymous()"> <!-- 권한이 없는 익명 사용자일 경우 -->
				<!-- 회원정보 비어있을 경우 -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${root }/memberLoginForm"> 
						<span class="glyphicon glyphicon-log-in"> 로그인</span>
					</a></li>

					<li><a href="${root }/memberJoin"> <span
							class="glyphicon glyphicon-user"> 회원가입</span>
					</a></li>
				</ul>
			</security:authorize>
			<%-- </c:if> --%>

			<%-- <c:if test="${!empty memberVo }"> --%>
			<!-- 로그인 인증을 받은 경우 -->
			<security:authorize access="isAuthenticated()">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${root }/memberUpdateForm"> 
						<span class="glyphicon glyphicon-check"> 회원수정</span>
					</a></li>
					<li><a href="${root }/memberImageForm">
							<span class="glyphicon glyphicon-picture"> 사진</span>
					</a></li>
					<li><a href="javascript:logout()">
							<span class="glyphicon glyphicon-log-out"> 로그아웃</span>
					</a></li>
					<!-- 시큐리티에서 로그아웃은 get방식으로 가지 않음 -->

					<%-- <c:if test="${!empty memberVo}"> --%>
						<c:if test="${empty memberVo.member.memberProfile}"> <!-- MemberUser에서 memberVo를 memeber객체에 담아서 불러올 때 member 객체도 참고해야 함 -->
							<li>
								<img src="${root }/resources/images/짱구.png" style="width: 50px; height: 50px;" />
							${memberVo.member.memberName}님 (
							<!-- hasRole: 해당 권한이 있을 경우 -->
							<security:authorize access="hasRole('ROLE_USER')">일반회원</security:authorize>
							<security:authorize access="hasRole('ROLE_MANAGER')">매니저</security:authorize>
							<security:authorize access="hasRole('ROLE_ADMIN')">관리자</security:authorize>
							)안녕하세요~
							
							<%-- 시큐리티 이전에 권한을 받아올 때
							<c:forEach var="authVo" items="${memberVo.authLi}">
								<c:if test="${authVo.auth eq 'ROLE_USER'}">일반회원</c:if> <!-- join에 권한설정한 value 값 -->
								<c:if test="${`authVo.auth eq 'ROLE_MANAGER'}">매니저</c:if>
								<c:if test="${authVo.auth eq 'ROLE_ADMIN'}">관리자</c:if>
							</c:forEach>)안녕하세요~ --%>
							
							</li>
							
						</c:if> 

						<c:if test="${!empty memberVo.member.memberProfile}">
							<li><img src="${root }/resources/upload/${memberVo.member.memberProfile}" style="width: 50px; height: 50px;"/> 
							${memberVo.member.memberName}님(
								<security:authorize access="hasRole('ROLE_USER')">일반회원</security:authorize>
								<security:authorize access="hasRole('ROLE_MANAGER')">매니저</security:authorize>
								<security:authorize access="hasRole('ROLE_ADMIN')">관리자</security:authorize>
							) 안녕하세요~</li>
							
						</c:if>
					<%-- </c:if> --%>
				</ul>
			</security:authorize>
			<%-- </c:if> --%>
		</div>
	</div>
</nav>