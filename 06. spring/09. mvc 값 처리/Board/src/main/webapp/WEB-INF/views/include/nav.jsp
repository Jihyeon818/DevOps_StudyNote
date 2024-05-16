<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/"/>

<!-- 상단 -->

<nav class="navbar navbar-expand-md bg-dark text-white fixed-up shadow-lg">
    <a class="navbar-brand" href="${root }main">데브옵스</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
      	<c:forEach var='obj' items="${team }">
      		<li class="nav-item">
      			<a href="${root }board/main?board_info_idx=${obj.board_info_idx}" class="nav-link">${obj.board_info_name }</a>
      		</li>
      	</c:forEach>
      </ul>
      <ul class="navbar-nav ml-auto">
	      <c:choose>
	      	<c:when test="${loginBean.userLogin == true }"> <!-- 로그인 상태일 경우 2개 메뉴만 뜨도록 -->
		        <li class="nav-item">
		          <a class="nav-link" href="${root }user/modify">정보수정</a>
		        </li>
		        
		        <li class="nav-item">
		          <a class="nav-link" href="${root }user/logout">로그아웃</a>
		        </li>
	      	</c:when>
	      	
	      	<c:otherwise> <!-- when절과 반대의 경우. 비로그인일 경우 해당 메뉴 2개만 뜸 -->
		        <li class="nav-item">
		          <a class="nav-link" href="${root }user/login">로그인</a>
		        </li>
		        
		        <li class="nav-item">
		          <a class="nav-link" href="${root }user/join">회원가입</a>
		        </li>
	      	</c:otherwise>
	      </c:choose>
      </ul>
    </div>
</nav>