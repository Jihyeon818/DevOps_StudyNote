<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>학생정보 검색</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script>
		function more(num) {
			$.ajax({
				url : "${root}/"+num,
				type : "get",
				data : {"num":num},
				dataType : "json",
				success : function(data) {
					$("#studentNum").val(data.num);
					$("#studentName").val(data.name);
					$("#studentAdr").val(data.adr);
					$("#univer").val(data.university);
					$("#major").val(data.major);
				},
				error : function() {
					alert("error");
				}
			});
			
			$("#studentDetail").css("display", "block");
			$("#buttonGroup").html("<button class='btn btn-primary btn-sm' style='margin:2px;'onclick='update("
                    		+num
                    		+")'>수정</button><button class='btn btn-danger btn-sm' style='margin:2px;' onclick='goDelete("
		                    +num
		                    +")'>삭제</button>");
			
			$("#studentNum").focus();
		}
		
		function update(num) {
			$("#studentAdr").css("border", "1px solid #b5b5b5");
			$("#studentAdr").attr("readonly",false);
			$("#univer").css("border", "1px solid #b5b5b5");
			$("#univer").attr("readonly",false);
			$("#major").css("border", "1px solid #b5b5b5");
			$("#major").attr("readonly",false);
			
			$("#studentAdr").focus();
			
			$("#buttonGroup").empty();
			$("#buttonGroup").html("<button class='btn btn-primary btn-sm' style='margin:2px;'onclick='goUpdate("
            		+num
            		+")'>완료</button><button class='btn btn-danger btn-sm' style='margin:2px;' onclick='more("
                    +num
                    +")'>취소</button>");
			
		}
		function goUpdate(num) {
		
			let name = $("#studentName").val();
			let adr = $("#studentAdr").val();
			let university = $("#univer").val();
			let major = $("#major").val();
			
			$.ajax({
				url : "${root}/update",
				type : "put",
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify({
					"num" : num, 
					"name" : name,
					"adr" : adr,
					"university" : university,
					"major" : major
				}),
				success : function() {
					alert("수정되었습니다");
					location.reload();
				},
				error : function() {
					alert("error");
				}
			});
		}
		
		function goDelete(num) {
			$.ajax({
				url : "${root}/"+num,
				type : "delete",
				data : {"num":num}, 
				success : function() {
					alert("삭제되었습니다");
					location.reload();
				}, 
				error : function() {
					alert("error");
				}
			});
		}
		
		function goSearch() {
			let name =  $("#search").val();
			
			if(name.length == 0){
				alert("검색어를 입력해주세요");
			}else{
				$.ajax({
					url : "${root}/serch/"+name,
					type : "get",
					data : {"name":name}, 
					dataType:"json",
					success : studentSearch,
					error : function() {
						alert("error");
					}
				});
			}		
		}

		function studentSearch(data) {
			$("#view").empty();
			let li = "";
		    if (data != null && data != "") {
		    	$.each(data, function (index, obj) {
		    		li += "<tr class='align-middle white-space-nowrap hover-actions-trigger btn-reveal-trigger hover-bg-100'>";
		    		li += "<td class='align-middle text-center'>" + obj.num + "</td>";
		        	li += "<td class='align-middle text-center'>";
		        	li += "<span id='name'>" + obj.name + "</span>";
		        	li += "</td>";
		            li += "<td class='align-middle text-center'>";
		            li += "<button type='button' class='btn btn-info' onclick='more(" + obj.num + ")'>";
		            li += "<svg style='position: relative; top: 3px;'  xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-plus-lg' viewBox='0 0 16 16'>";
		            li += "<path fill-rule='evenodd' d='M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2'></path>";
		            li += "</svg>MORE</button></td>";
		            li += "</tr>";
				})
		    } else {
	    		li += "<tr class='align-middle white-space-nowrap hover-actions-trigger btn-reveal-trigger hover-bg-100'>";
		    	li += "<td class='align-middle text-center' colspan='3'>";
		    	li += "<br><p>존재하지 않는 학생입니다.</p><p>학생을 등록하시겠습니까?</p>";
		        li += "<button class='btn btn-primary btn-sm' style='margin:2px;' onclick='insert()'>등록하기</button>";
		        li += "</td>";
		        li += "</tr>";
		    }

		    $("#view").html(li);
		}
		
		function insert() {
			$('#studentNum').val("");
			$("#studentName").css("border", "1px solid #b5b5b5");
			$("#studentName").attr("readonly",false);
			$('#studentName').val("");
			$("#studentAdr").css("border", "1px solid #b5b5b5");
			$("#studentAdr").attr("readonly",false);
			$('#studentAdr').val("");
			$("#univer").css("border", "1px solid #b5b5b5");
			$("#univer").attr("readonly",false);
			$('#univer').val("");
			$("#major").css("border", "1px solid #b5b5b5");
			$("#major").attr("readonly",false);
			$('#major').val("");
			
			$("#studentDetail").css("display", "block");
			$("#studentName").focus();
			
			$("#buttonGroup").empty();
			$("#buttonGroup").html("<button class='btn btn-primary btn-sm' style='margin:2px;' onclick='goInsert()'>등록</button>"
          						+"<button type='reset' class='btn btn-danger btn-sm' style='margin:2px;'>취소</button>");
		}
		
		function goInsert() {
			
			let name = $("#studentName").val();
			let adr = $("#studentAdr").val();
			let university = $("#univer").val();
			let major = $("#major").val();
			
			$.ajax({
				url : "${root}/insert",
				type : "post", 
				data: {
					"name" : name,
					"adr" : adr,
					"university" : university,
					"major" : major
				}, 
				success : function() {
					alert("등록되었습니다");
					location.reload();
				},
				error : function() {
					alert("error");
				}
			});
		}
		
	</script>
</head>
<body style="background-color: #edf2f9; padding: 10px;">
    <div class="container">
        <div class="container-fluid">
            <div class="col-lg-6" style="background-color: #fff; border-radius: 5%; box-shadow: 5px 5px 5px rgb(0, 0, 0, 0.2); margin: 5px;">
                <div class="card" style="padding: 30px;">
                    <div class="bg-body-tertiary card-header">
                        <div class="row align-items-center g-2"> 
                            <div class="col">
                                <h3 class="mb-0" style="display: inline-block; margin: 0;">학생 정보 시스템</h3>
                                <div class="position-relative" style="display: flex; float: right;">
                                    <input id="search" placeholder="Search" type="search" class="rounded-pill search-input form-control" value="" style="width: 85%;">
                                    <button class="btn btn-outline-secondary" type="button" onclick="goSearch()" style="padding: 6px; margin: 0 2px;" aria-label="검색">
                                        <svg style="width: 12px; color: gray;" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="search" class="svg-inline--fa fa-search fa-w-16 position-absolute text-400 search-box-icon" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
                                            <path fill="currentColor" d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z">
                                            </path>
                                        </svg>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="py-0 card-body">
                        <div class="position-relative align-items-center py-2 border-bottom border-200  row">
                            <table class="fs-10 mb-0 overflow-hidden table">
                                <thead class="bg-200 text-nowrap align-middle">
                                    <tr>
                                        <th class="text-200 text-nowrap text-center">No</th>
                                        <th class="text-200 text-nowrap text-center">Name</th>
                                        <th class="text-200 text-nowrap text-center">Detail</th>
                                    </tr>
                                </thead>
                                <tbody id="view">
                                	<c:forEach var='obj' items="${studentList}">
	                               		<tr class="align-middle white-space-nowrap hover-actions-trigger btn-reveal-trigger hover-bg-100">
	                                        <td class="align-middle text-center">${obj.num}</td>
	                                        <td class="align-middle text-center">
	                                            <span id="name">${obj.name}</span>
	                                        </td>
	                                        <td class="align-middle text-center">
	                                            <button type="button" class="btn btn-info" onclick="more(${obj.num})">
	                                                <svg style="position: relative; top: 3px;"  xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
	                                                    <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2"></path>
	                                                </svg>
	                                                MORE
	                                            </button>
	                                        </td>
	                                    </tr>
                                	</c:forEach>
                                </tbody>
                             </table>
                        </div>         
                    </div>
                </div>
            </div>

            <div id="studentDetail" class="col-lg-5" style="display:none; background-color: #fff; border-radius: 5%; box-shadow: 5px 5px 5px rgb(0, 0, 0, 0.2); margin: 5px;">
                <div class="card" style="padding: 30px;">
                    <div class="bg-body-tertiary card-header">
                        <div class="row align-items-center g-2"> 
                            <div class="col">
                                <h3 class="mb-0" style="display: inline-block; margin: 0;">학생 정보</h3>
                            </div>
                        </div>
                    </div>
                    <div class="py-0 card-body">
                        <div class="position-relative align-items-center py-2 border-bottom border-200  row">
                             <table class="fs-10 mb-0 overflow-hidden table">
                                <thead class="bg-200 text-nowrap align-middle">
                                    <tr>
                                        <th class="text-200 text-nowrap text-center">구분</th>
                                        <th class="text-200 text-nowrap text-center">내용</th>
                                    </tr>
                                </thead>
                                <tbody id="details">
                                	<tr class="align-middle white-space-nowrap hover-actions-trigger btn-reveal-trigger hover-bg-100">
                                        <th class="text-100 text-nowrap text-center">학생번호</th>
                                        <td class="align-middle text-center">
                                        	<input type="text" id="studentNum" readonly="readonly" style="text-align: center; border: none; border-radius: 10px;">
                                        </td>
                                    </tr>
                                    <tr class="align-middle white-space-nowrap hover-actions-trigger btn-reveal-trigger hover-bg-100">
                                        <th class="text-100 text-nowrap text-center">학생이름</th>
                                        <td class="align-middle text-center">
                                        	<input type="text" id="studentName" readonly="readonly" style="text-align: center; border: none; border-radius: 10px;">
                                        </td>
                                    </tr>
                                    <tr class="align-middle white-space-nowrap hover-actions-trigger btn-reveal-trigger hover-bg-100">
                                        <th class="text-100 text-nowrap text-center">거주지(동)</th>
                                        <td class="align-middle text-center">
                                        	<input type="text" id="studentAdr" readonly="readonly" style="text-align: center; border: none; border-radius: 10px;">
                                        </td>
                                    </tr>
                                    <tr class="align-middle white-space-nowrap hover-actions-trigger btn-reveal-trigger hover-bg-100">
                                        <th class="text-100 text-nowrap text-center">학교</th>
                                        <td class="align-middle text-center">
                                        	<input type="text" id="univer" readonly="readonly" style="text-align: center; border: none; border-radius: 10px;">
                                        </td>
                                    </tr>
                                    <tr class="align-middle white-space-nowrap hover-actions-trigger btn-reveal-trigger hover-bg-100">
                                        <th class="text-100 text-nowrap text-center">전공</th>
                                        <td class="align-middle text-center">
                                        	<input type="text" id="major" readonly="readonly" style="text-align: center; border: none; border-radius: 10px;">
                                        </td>
                                    </tr>
                                </tbody>
                              </table>
                              <div style="text-align: center;" id="buttonGroup">
	                          </div>
                        </div>         
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>