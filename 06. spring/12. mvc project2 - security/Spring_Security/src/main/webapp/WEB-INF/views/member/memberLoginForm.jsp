<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	if(${param.error!=null}){ //시큐리티 내부에서 error를 전달받아 처리
		$("#msgType").attr("class","modal-content panel-warning");
		$(".modal-body").text('아이디 또는 비밀번호를 확인해주세요');
		$(".modal-header").text('실패');
		$("#failModal").modal("show");
	}
	
	if(${!empty msg1}){
		$("#msgType").attr("class","modal-content panel-warning");
		$("#failModal").modal("show");
	}	
});
</script>
</head>

<body>
	<div class="container">
		<jsp:include page="../include/top.jsp" />
		<div class="panel panel-default">
			<div class="panel-heading">로그인</div>
			<div class="panel-body">
				<form action="${root }/memberLogin" method="post">
					<table class='table table-bordered' style="text-align: center;">
						<tr>
							<th style="width: 100px; vertical-align: middle;">아이디</th>
							<td>
								<input type="text" class="form-control" id="memberID" name="username" placeholder="아이디 입력" />
							</td>
						</tr>
						<tr>
							<th style="width: 100px; vertical-align: middle;" />비밀번호</th>
							<td colspan="2">
								<input class="form-control" type="password" id="memberPw" name="password" placeholder="비밀번호를 입력">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" class="btn btn-primary btn-sm pull-right" value="로그인">
							</td>
						</tr>
					</table>
					
					<!-- security 환경설정 후 값을 암호화해서 넘김 -->
					<input type="hidden" name="${_csrf.parameterName }"
						value="${_csrf.token }" />
				</form>
			</div>

			<!--모달-->
			<div class="modal fade" id="failModal" role="dialog">
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

		</div>
	</div>
</body>
</html>
