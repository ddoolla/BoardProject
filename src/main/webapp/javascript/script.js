/**
 * 
 */

//회원가입 유효성 검사
function joinCheck() {
		
		if (document.joinForm.userId.value == "") {
			alert("아이디를 입력하세요.");
			document.joinForm.userId.focus();	
			return false;
		}
		
		if (document.joinForm.userPass.value == "") {
			alert("비밀번호를 입력하세요.");
			document.joinForm.userPass.focus();	
			return false;
		}
		
		if (document.joinForm.userPass2.value == "") {
			alert("비밀번호 확인을 입력하세요.");
			document.joinForm.userPass2.focus();	
			return false;
		}
		
		if (document.joinForm.userPass.value != document.joinForm.userPass2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			document.joinForm.userPass2.value = "";
			document.joinForm.userPass2.focus();	
			return false;	
		}
		
		if (document.joinForm.name.value == "") {
			alert("이름을 입력하세요.");
			document.joinForm.name.focus();	
			return false;
		}
		
		if (document.joinForm.phone.value == "") {
			alert("전화번호를 입력하세요.");
			document.joinForm.phone.focus();	
			return false;
		}
		
		if (document.joinForm.email.value == "") {
			alert("이메일을 입력하세요.");
			document.joinForm.email.focus();	
			return false;
		}
		
		if (document.joinForm.email.value.indexOf("@") == -1) {
			alert("이메일 형식에 맞지 않습니다.");
			document.joinForm.email.focus();	
			return false;
		}
		
		return true;
}//joinCheck()

//회원수정 유효성 검사
function updatejoinCheck() {
		
		if (document.joinForm.userPass.value == "") {
			alert("비밀번호를 입력하세요.");
			document.joinForm.userPass.focus();	
			return false;
		}
		
		if (document.joinForm.userPass2.value == "") {
			alert("비밀번호 확인을 입력하세요.");
			document.joinForm.userPass2.focus();	
			return false;
		}
		
		if (document.joinForm.userPass.value != document.joinForm.userPass2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			document.joinForm.userPass2.value = "";
			document.joinForm.userPass2.focus();	
			return false;	
		}
		
		if (document.joinForm.name.value == "") {
			alert("이름을 입력하세요.");
			document.joinForm.name.focus();	
			return false;
		}
		
		if (document.joinForm.phone.value == "") {
			alert("전화번호를 입력하세요.");
			document.joinForm.phone.focus();	
			return false;
		}
		
		if (document.joinForm.email.value == "") {
			alert("이메일을 입력하세요.");
			document.joinForm.email.focus();	
			return false;
		}
		
		if (document.joinForm.email.value.indexOf("@") == -1) {
			alert("이메일 형식에 맞지 않습니다.");
			document.joinForm.email.focus();	
			return false;
		}
		
		return true;
}//joinCheck()


//로그인 유효성 검사
function loginCheck() {
	var userId = document.loginForm.userId;
	var userPass = document.loginForm.userPass;
	
	if (userId.value == "") {
		alert("아이디를 입력하세요.");
		userId.focus();
		return false;
	}
	if (userPass.value == "") {
		alert("비밀번호를 입력하세요.");
		userPass.focus();
		return false;
	}
	
	return true;
}
















