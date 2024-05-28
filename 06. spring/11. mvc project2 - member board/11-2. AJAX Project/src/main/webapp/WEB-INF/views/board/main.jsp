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
	$(document).ready(function() {
		loadBoard();
	});
	function loadBoard() {

		$.ajax({
			url : "board/list",
			type : "get",
			dataType : "json",
			success : make,
			error : function() {
				alert("error");
			}
		});
	}
	function make(data) {
		var li = "<table class='table table-bordered'>";
		li += "<tr>";
		li += "<td>번호</td>";
		li += "<td>제목</td>";
		li += "<td>작성자</td>";
		li += "<td>작성일</td>";
		li += "<td>조회수</td>";
		li += "</tr>";
		$.each(data,function(index, obj) {
			li += "<tr>";
			li += "<td><a href='javascript:goContent(" + obj.idx + ")'>" + obj.idx + "</td>";
			li += "<td id='tit"+obj.idx+"'><a href='javascript:goContent("
					+ obj.idx + ")'>" + obj.title + "</a></td>";
			li += "<td>" + obj.writer + "</td>";
			li += "<td>" + obj.indate.split(' ')[0] + "</td>";
			li += "<td id='cnt"+obj.idx+"'>" + obj.count + "</td>";
			li += "</tr>";
			
			//id = con
			li += "<tr id='con"+obj.idx+"' style='display:none'>";
			li += "<td>내용</td>";
			li += "<td colspan='4'>";
			li += "<textarea id='ta"+obj.idx+"' readonly rows='7' class='form-control'></textarea>";
			li += "<br/>";
			
			if("${memberVo.memberID}"==obj.memberID){
				li += "<span id='up"+obj.idx+"'><button class='btn btn-success btn-sm' onclick='goUpdateForm(" + obj.idx + ")'>수정화면</button></span>&nbsp;";
				li += "<button class='btn btn-danger btn-sm' onclick='goDelete(" + obj.idx + ")'>삭제</button>";
			}else{
				li += "<span id='up"+obj.idx+"'><button disabled class='btn btn-success btn-sm' onclick='goUpdateForm(" + obj.idx + ")'>수정화면</button></span>&nbsp;";
				li += "<button disabled class='btn btn-danger btn-sm' onclick='goDelete(" + obj.idx + ")'>삭제</button>";
			}
			li += "</td>";
			li += "</tr>";

		});
		
		//로그인이 안되어있으면 글작성 버튼이 안보임
		if(${!empty memberVo}){
			li += "<tr>";
			li += "<td colspan='5'>";
			li += "<button class='btn btn-primary btn-sm' onclick='getForm()'>글작성</button>";
			li += "</td>";
			li += "</tr>";
		}
		
		li += "</table>";
		$("#view").html(li);

		$("#view").css("display", "block");
		$("#wfrom").css("display", "none");
	}
	
	function goUpdate(idx) {
		let title=$("#nt"+idx).val();
		let updateData = $("#ta"+idx).val();
		
		$.ajax({
			url : "board/update",
			type : "put",
			//여러개의 값을 json 형식으로 컨트롤러에 보낼 때 json.stringify 로 변환해서 전달해야함.
			//컨트롤러에서 받을 때 @RequestBody 를 붙여야 json 형식으로 받을 수 있음.
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify({
				"idx" : idx, 
				"title" : title,
				"content" : updateData
			}),
			success : loadBoard,
			error : function() {
				alert("error");
			}
		});
	}	
	
    function goUpdateForm(idx) {
        $("#ta"+idx).attr("readonly", false); //수정가능하도록
        
        //게시글 제목을 title이라는 변수에 저장
        let title=$("#tit"+idx).text();
        let newInput="<input type='text' id='nt"+idx+"' class='form-control' value='"+title+"'/>";
        //수정 전 적었던 제목을 text창에 띄운다
        $("#tit"+idx).html(newInput);
        
        let newButton="<button class='btn btn-primary btn-sm' onclick='goUpdate("+idx+")'>수정</button>";
        $("#up"+idx).html(newButton);
     }
	
	function goDelete(idx) {
		$.ajax({
			url : "board/" + idx,
			type : "delete",
			data : {"idx":idx}, //삭제할 글 번호를 서버에 전달
			success : loadBoard, 
			error : function() {
				alert("error");
			}
		});
	}
	
	function goContent(idx) {
		if($("#con" + idx).css("display") == "none") { //id=con 이 안 보이면 보이게끔,
			
			//글을 클릭했을 때 내용이 보이게끔 하고 싶음,
			
			$.ajax({
				url : "board/" + idx,
				type : "get",
				data : {"idx":idx},
				dataType : "json",
				success : function(data) {
					$("#ta"+idx).val(data.content);
				},
				error : function() {
					alert("error");
				}
			});
		
			//글을 클릭하면 조회수를 증가시키고 싶음.
			$.ajax({
				url : "board/count/" + idx,
				type : "put",
				data : {"idx" : idx},
				dataType : "json",
				success : function(data) {
					$("#cnt" + idx).text(data.count);
				}, 
				error : function() {
					alert("error");
				}
			});
		
			$("#con" + idx).css("display","table-row");
			
		} else {
			
			$("#con" + idx).css("display", "none"); //id=con 이 보이면 안 보이게끔...
			
		}
	}

	function goInsert() {

		var formData = $("#frm").serialize();

		$.ajax({
			url : "board/create",
			type : "post",  //post방식으로 /boardInsert로 매핑
			data : formData, //내가 폼에 입력한 데이터를 서버로 전달
			success : loadBoard,
			//서버와의 통신이 성공되면 loadBoard메서들 호출 -> 내가 쓴거 테이블형식으로 출력
			error : function() {
				alert("error");
			}
		});
	}
	
	function getForm() {
		$("#wfrom").css("display", "block"); //글작성 폼은 보임
		$("#view").css("display", "none"); //게시글 목록은 안보임
	}

	function goList() {
		$("#view").css("display", "block");
		$("#wfrom").css("display", "none");
	}
	
</script>
</head>
<body>

	<div class="container">
		<jsp:include page="../include/top.jsp" />
		<h2>Spring Legacy</h2>
		<div class="panel panel-default">
			<div class="panel-heading">게시판</div>
			<div class="panel-body" id="view">본문</div>
			<div class="panel-body" id="wfrom">
				<form id="frm">
					<input type="hidden" name="memberID" value="${memberVo.memberID}"/>
					<table class="table">
						<tr>
							<td>제목</td>
							<td><input type="text" id="title" name="title" class="form-control" /></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea rows="7" class="form-control" id="content" name="content"></textarea></td>
						</tr>
						<tr>
							<td>글쓴이</td>
							<td><input type="text" id="writer" name="writer" class="form-control"  value="${memberVo.memberID }" readonly="readonly"/></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button type="button" class="btn btn-success btn-sm" onclick="goInsert()">등록</button>
								<button type="reset" class="btn btn-warning btn-sm" id="formclear">취소</button>
								<button type="button" class="btn btn-info btn-sm" onclick="goList()">리스트</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="panel-footer">비트캠프</div>
		</div>
	</div>

</body>
</html>