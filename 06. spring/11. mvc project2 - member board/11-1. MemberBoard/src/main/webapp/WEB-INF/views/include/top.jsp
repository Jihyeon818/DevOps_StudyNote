<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
  
    <div class="navbar-header">
	    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#Navbar">
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="${root}/">개발자의 봄</a>
    </div>
    
    <div class="collapse navbar-collapse" id="Navbar">
      <ul class="nav navbar-nav">
        <li><a href="MainBoard">게시판</a></li>
      </ul>
        
        <!-- 0522 추가사항 확인 -->
        <c:if test="${empty memberVo }">
        	<ul class="nav navbar-nav">
		        <li class="dropdown">
		          <a class="dropdown-toggle" href="#" data-toggle="dropdown">
		            로그인/회원가입
		          </a>
		          <ul class="dropdown-menu dropdown-menu-dark">
		            <li><a class="dropdown-item" href="${root }/memberLoginForm">로그인</a></li>
		            <li><a class="dropdown-item" href="${root}/memberJoin">회원가입</a></li>
		          </ul>
		        </li>
	      	</ul>
        </c:if>
        
        
        <c:if test="${!empty memberVo }">
	        <ul class="nav navbar-nav">
		        <li class="dropdown">
		          <a class="dropdown-toggle" href="#" data-toggle="dropdown">
		            마이페이지
		          </a>
		          <ul class="dropdown-menu dropdown-menu-dark">
		            <li><a class="dropdown-item" href="${root }/memberUpdateForm">회원수정</a></li>
		            <li><a class="dropdown-item" href="#">사진</a></li>
		            <li><a class="dropdown-item" href="${root }/memberLogout">로그아웃</a></li>
		          </ul>
		        </li>
	      	</ul>
        </c:if>

    </div>
  </div>
</nav>