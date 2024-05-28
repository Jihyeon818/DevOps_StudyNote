<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
 <style>
        .slide-out-left {
            animation: slide-out-left 1s;
        }
</style>

<script type="text/javascript">

$(document).ready(function(){
	//만약에 msg1 이 비어있지 않다면, 다시말해 컨트롤러에서 실시한 유효성 검사에서 에러가 발생하면, 모달창을 띄운다.
	if(${!empty msg1}) {
		$("#msgType").attr("class","modal-content panel-warning");
		$("#registerFailModal").modal("show");
	}
})

</script>
</head>
<body>

	<div class="container">
		<jsp:include page="include/top.jsp" />
		
			<c:if test="${empty memberVo }">
				<h3>Spring Legacy</h3>
			</c:if>
			
			<%-- <c:if test="${!empty memberVo }">
				<!-- 기본 사진 (사용자가 사진을 넣지 않은 경우) -->
				<c:if test="${memberVo.memberProfile eq '' }">
					<img src="${root }/resources/images/kirby-free.png" style="width: 50px; height: 50px;">
				</c:if>
				<!-- 사용자가 사진을 넣으면 뜨도록 만들기 -->
				<c:if test="${memberVo.memberProfile ne '' }">
					<img src="${root }/resources/upload/${memberVo.memberProfile }" style="width: 50px; height: 50px;">
				</c:if>
				<h3>${memberVo.memberName } 님 환영합니다 :D</h3>
			</c:if> --%>
		
		<div class="panel panel-default">
			<div>
				<img src="${root }/resources/images/kimsu.jpeg" style="width:100%; height:100%;" class="slide-out-left" >
			</div>
		
			<div class="panel-body">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#home"> Home
					</a></li>
					<li><a href="MainBoard">게시판</a></li>
					<li><a href="#" data-toggle="tab">공지</a></li>
				</ul>

				<div class="tab-content">
					<div class="tab-pane fade show active" id="home">
						<h4>Home</h4>
						<p>content</p>
					</div>

					<div class="tab-pane fade show" id="home1">
						<h4>게시판</h4>
						<p>content</p>
					</div>

					<div class="tab-pane fade show" id="home2">
						<h4>공지</h4>
						<p>content</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 회원가입 실패 에러 메시지 모달 -->
	<div class="modal fade" id="registerFailModal" tabindex="-1"
		role="dialog">
		<div class="modal-dialog">
			<div class="modal-content" id="msgType">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3>${msg1 }</h3>
				</div>
				<div class="modal-body">
					<p>${msg2 }</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>