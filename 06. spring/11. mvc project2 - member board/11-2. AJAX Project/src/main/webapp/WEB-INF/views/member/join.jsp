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
		$("#registerFailModal").modal("show");
	}
})

function idCheck() {
	let memberID = $('#memberID').val();
	
	$.ajax({
		url : "${root}/memberRegisterCheck",
		type : "get",
		data : {"memberID" : memberID},
		success : function(result) {
			if(result == 1) {
				$("#checkMessage").html("사용할 수 있는 아이디입니다");
			} else {
				$("#checkMessage").html("사용할 수 없는 아이디입니다");
			}
			$("#idCheckModal").modal("show");
		},
		error : function() {
			alert("error");
		}
	});

}

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

function goInsert() {
	/* 
	나이 필드가 text가 아닌 number 로 되어있어서 나이 항목을 입력하지 않으면 int memberAge 에 null 값이 들어가게 된다.
	그런데 자바는 기본타입 int 에는 null 값이 들어갈 수 없도록 설계되어있어서 컴파일 오류가 난다.
	 --> 왜 그런거냐면 null 은 참조할 값이 없다는 뜻이라서. 기본타입의 경우는 참조할 주소값을 넣는게 아니고 값 그 자체를 넣게 되어있으니까 0은 넣을 수 있는데 null 은 못 넣는 것이다.	
	그래서 submit 하기 전에 나이 필드의 유효성검사를 한 이후 문제가 없을 때 전송하도록 했따.
	*/
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
			<div class="panel-heading">회원가입</div>
			<div class="panel-body">
				<form name="frm" action="${root }/memberRegister" method="post">
					<input type="hidden" id="memberPw" name="memberPw" value="" />
					<table class='table table-bordered' style="text-align: center;">
						<tr>
							<td style="width: 100px; vertical-align: middle;" />아이디
							</td>
							<td><input type="text" class="form-control" id="memberID"
								name="memberID" placeholder="아이디를 입력해주세요." /></td>
							<td><button type="button" class="btn btn-success btn-sm"
									onclick="idCheck()">중복확인</button></td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;" />비밀번호
							</td>
							<td colspan="2"><input class="form-control" type="password"
								id="memberPw1" name="memberPw1" onkeyup="passwordCheck()"
								placeholder="비밀번호를 입력해주세요." /></td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;" />비밀번호확인
							</td>
							<td colspan="2"><input class="form-control" type="password"
								id="memberPw2" name="memberPw2" onkeyup="passwordCheck()"
								placeholder="비밀번호 확인" /></td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;" />이름
							</td>
							<td colspan="2"><input class="form-control" type="text"
								id="memberName" name="memberName" placeholder="이름을 입력해주세요." /></td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;">나이</td>
							<td colspan="2"><input id="memberAge" name="memberAge"
								class="form-control" type="number" maxlength="10"
								placeholder="나이를 입력해주세요." /></td>
						</tr>
						<tr>
							<td style="width: 100px; vertical-align: middle;">성별</td>
							<td colspan="2">
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
								placeholder="이메일을 입력해주세요." /></td>
						</tr>
						<tr>
							<td colspan="3" style="text-align: left;"><span
								id="passMessage" style="color: red"></span><input type="button"
								class="btn btn-primary btn-sm pull-right" value="등록"
								onclick="goInsert()" /></td>
						</tr>
					</table>
				</form>
			</div>

			<!-- idCheck 모달 -->
			<div class="modal fade" id="idCheckModal" tabindex="-1" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h3>메시지 확인</h3>
						</div>
						<div class="modal-body">
							<p id="checkMessage"></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
			
			<!-- 회원가입 실패 에러 메시지 모달 -->
			<div class="modal fade" id="registerFailModal" tabindex="-1" role="dialog">
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