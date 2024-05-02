function check(){
		if(document.frm.userid.value==""){
		alert("아이디를 입력해주세요");
		return false;
	}
	else if(document.frm.pwd.value==""){
		alert("비밀번호를 입력해주세요");
		return false;
	}
	else{
		return true;
	}
}

function idCheck(){
	if(document.frm.userid.value==""){
		alert("아이디를 입력해주세요");
		return;
	}
	let url="idCheck.do?userid="+document.frm.userid.value; //userid를 가져감
	window.open(url,'팝업',"width=400, height=200, scrollbars=yes, resizable=no"); //새창으로 띄우기
}

function joinCheck(){
	
}
