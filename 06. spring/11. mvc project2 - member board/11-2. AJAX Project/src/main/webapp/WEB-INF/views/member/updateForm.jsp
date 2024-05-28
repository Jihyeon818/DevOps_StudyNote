<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	//만약에 msg1 이 비어있지 않다면, 다시말해 컨트롤러에서 실시한 유효성 검사에서 에러가 발생하면, 모달창을 띄운다.
	if(${!empty msg1}) {
		$("#msgType").attr("class","modal-content panel-warning");
		$("#failModal").modal("show");
	}
})

function passwordCheck() {
	//비밀번호, 비밀번호확인에 입력한 값이 일치하는지 확인하는 작업
	//불일치하면 passMessage 영역([등록]버튼 앞에 span태그로 주어짐)에 메시지를 띄울 것이다.
	let memberPw1 = $("#memberPw1").val();
	let memberPw2 = $("#memberPw2").val();
	
	if(memberPw1 != memberPw2) {
		//불일치하면 아래 메시지가 들어감
		$("#passMessage").html("비밀번호가 일치하지 않습니다.");
	} else {
		//일치하면 아무 메시지도 띄우지 않고,
		$("#passMessage").html("");
		//비밀번호칸에 적은 입력값을 hidden 영역에 value값으로 넣어서 서버에 전송하겠다.
		$("#memberPw").val(memberPw1);
	}
	
}

function goUpdate() {
	let memberAge = $("#memberAge").val();
	
	if(memberAge == 0 || memberAge == "") {
		alert("나이를 입력해주세요.");
		return false;
	}
	
	//나이 입력에 문제가 없으면 서버로 전송
	document.frm.submit();
}

</script>
</head>
<body>
	<div class="container">
		<jsp:include page="../include/top.jsp" />
		<div class="panel panel-default">
			<div class="panel-heading">회원정보 수정</div>
			<div class="panel-body">
				<form name="frm" action="${root }/memberUpdate" method="post">
					<input type="hidden" id="memberID" name="memberID" value="${memberVo.memberID }" />
					<input type="hidden" id="memberPw" name="memberPw" value="${memberVo.memberPw }" />
					<table class='table table-bordered' style="text-align: center;">
						<tr>
							<td style="width: 100px; vertical-align: middle;" />아이디
							</td>
							<td>${memberVo.memberID }</td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;" />비밀번호
							</td>
							<td><input class="form-control" type="password"
								id="memberPw1" name="memberPw1" onkeyup="passwordCheck()"
								placeholder="비밀번호를 입력해주세요." /></td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;" />비밀번호확인
							</td>
							<td><input class="form-control" type="password"
								id="memberPw2" name="memberPw2" onkeyup="passwordCheck()"
								placeholder="비밀번호 확인" /></td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;" />이름
							</td>
							<td><input class="form-control" type="text"
								id="memberName" name="memberName" value=${memberVo.memberName } /></td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;">나이</td>
							<td><input id="memberAge" name="memberAge"
								class="form-control" type="number" maxlength="10"
								value=${memberVo.memberAge }/></td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;">성별</td>
							<td>
								<div class="form-group"
									style="text-align: center; margin: 0 auto;">
									<input type="radio" name="memberGender" autocomplete="off"
										value="남자" checked />남자 <input type="radio"
										name="memberGender" autocomplete="off" value="여자" />여자
								</div>
							</td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;">이메일</td>
							<td colspan="2"><input id="memberEmail" name="memberEmail"
								class="form-control" type="text" maxlength="20"
								value=${memberVo.memberEmail }/></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: left;"><span
								id="passMessage" style="color: red"></span><input type="button"
								class="btn btn-primary btn-sm pull-right" value="수정"
								onclick="goUpdate()" /></td>
						</tr>
					</table>
				</form>
			</div>
			
			<!-- 에러 메시지 모달 -->
			<div class="modal fade" id="failModal" tabindex="-1" role="dialog">
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
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>