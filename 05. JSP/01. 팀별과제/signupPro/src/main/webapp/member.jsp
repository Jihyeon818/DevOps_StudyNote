<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/script.js"></script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="memberProc.jsp">
		<ul>
			<li>
				<label for="id">아이디</label><span>*</span>
				<input type="text" id="id" name="id" value=${id }>
				<input type="button" value="ID중복확인" onclick="open_win('idCheck.jsp?id=${id}','idCheck')">
			</li>
			<li>
				<label for="pw">비밀번호</label><span>*</span>
				<input type="password" id="pw" name="pwd">
			</li>
			<li>
				<label for="pwCheck">비밀번호 확인</label><span>*</span>
				<input type="password" id="pwCheck" name="pwCheck">
			</li>
			<li>
				<label for="name">이름</label><span>*</span>
				<input type="text" id="name" name="name">
			</li>
			<li>
				<label>성별</label><span>*</span>
				<input type="radio" id="gender" name="gender" value="남자" checked> 남
				<input type="radio" id="gender" name="gender" value="여자"> 여
			</li>
			<li>
				<label for="birth">생년월일</label><span>*</span>
				<input type="text" id="birth" name="birth">
				ex)900323
			</li>
			<li>
				<label for="email">Email</label><span>*</span>
				<input type="email" id="email" name="email">
			</li>
			<li>
				<label for="zip">우편번호</label>
				<input type="text" id="zip" name="zipcode">
				<input type="button" value="우편번호 찾기" onclick="open_win('zip.jsp','zipCheck')">
			</li>
			<li>
				<label for="addr">주소</label>
				<input type="text" id="addr" name="address">
			</li>
			<li>
				<label>취미</label>
				<input type="checkbox" value="인터넷"> 인터넷
				<input type="checkbox" value="여행"> 여행
				<input type="checkbox" value="게임"> 게임
				<input type="checkbox" value="영화"> 영화
				<input type="checkbox" value="운동"> 운동
			</li>
			<li>
				<label>직업</label>
				<select name="job">
					<option value=""> 선택하세요
					<option value="학생"> 학생
					<option value="회사원"> 회사원
					<option value="자영업"> 자영업
				</select>
			</li>
		</ul>
		<input type="submit" value="회원가입">
		<input type="reset" value="다시쓰기">
	</form>   
</body>
</html>