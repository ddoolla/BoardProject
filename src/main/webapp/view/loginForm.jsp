<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로그인</title>
<link rel="stylesheet" href="../css/commonStyle.css">
<link rel="stylesheet" href="../css/loginStyle.css">
<script src="../javascript/script.js" type="text/javascript"></script>
</head>
<body>
	<div id="page-wrapper">

		<jsp:include page="../common/header.jsp" />

		<section id="loginSection">
			<form action="./login.do" method="post" name="loginForm">
				<div id="loginContainer">
					<h1>Log In</h1>
					<div class="loginX">
						<c:if test="${ !empty requestScope.message }">
							${ requestScope.message }
						</c:if>
					</div>
					<div id="loginBox">
						<div>
							<!-- 체크박스 체크시 쿠키 값으로 유저아이디 가져와서 하루 유지 -->
							<span>ID</span> <input type="text" name="userId" value="${ cookie.userId.value }" placeholder=" 아이디" autofocus />
						</div>
						<div>
							<span>PW</span> <input type="password" name="userPass"
								placeholder=" 비밀번호">
						</div>
						<div>
							<input type="checkbox" name="chkId" id="chk1" value="ck" ${ cookie.checked.value }> <!-- 체크박스 체크시 쿠키 값="checked" 하루 유지 -->
							<label for="chk1">아이디 기억하기</label>
							&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 
							<a href="./joinForm.jsp">회원가입</a>
						</div>
						<div>
							<input type="submit" value="로그인" onClick="return loginCheck();">
						</div>
					</div>
				</div>
			</form>
		</section>

		<jsp:include page="../common/footer.jsp" />

	</div>
</body>
</html>