function open_win(url) {
	window.open(url, "", "width=500, height=230");
}

function loginCheck(){
	if(document.frm.id.value==""){
		alret("아이디를 입력해주세요");
		return false;
	}else if(document.frm.pwd.value==""){
		alret("비밀번호를 입력해주세요");
		return false;
	}else{
		return true;
	}
}