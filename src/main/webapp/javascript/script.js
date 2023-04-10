/**
 * 
 */
//게시글 상세보기에서 목록으로 
 function goList() {
	
	if (document.referrer == 'http://localhost:8090/view/home.do') { //이전 페이지 URL이 홈에서온거면 게시글 목록으로 이동 
		location.href ="./list.do"
	} else {
		history.back(); //게시글에서 상세보기페이지를 클릭했다면 뒤로가기	
	}
	
}//goList()

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
		
}//joinCheck()