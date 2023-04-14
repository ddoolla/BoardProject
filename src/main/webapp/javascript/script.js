/**
 * 
 */
//게시글 상세보기에서 목록으로 
 function goList() {
	
	if (document.referrer == 'http://localhost:8090/view/home.do') { //이전 페이지 URL이 홈에서온거면 게시글 목록으로 이동 
		location.href ="./list.do"
	} else {
		location.href = document.referrer; //뒤로가기 후 새로고침 : 상세보기에서 목록 누르면 원래 머물고 있던 페이지로 (1페이지가 아니라)
	}
	
}//goList()

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
		
		alert("회원가입이 완료되었습니다.");
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
		
		alert("회원정보 변경이 완료되었습니다. 다시 로그인 해주세요.");
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

















