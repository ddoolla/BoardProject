<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>loginForm</title>
<link rel="stylesheet" href="/css/commonStyle.css">
<link rel="stylesheet" href="/css/loginStyle.css">
</head>
<body>
	<div id="page-wrapper">

		<jsp:include page="/common/header.jsp" />

		<section id="loginSection">
			<form action="" method="post">
				<div id="loginContainer">
					<h1>Log In</h1>

					<div id="loginBox">
						<div>
							<span>ID</span> <input type="text" name="userId"
								placeholder=" 아이디" autofocus />
						</div>
						<div>
							<span>PW</span> <input type="password" name="userPass"
								placeholder=" 비밀번호">
						</div>
						<div>
							<input type="checkbox" name="chkId" id="chk1"> <label
								for="chk1">아이디 기억하기</label>
							&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; 
							<a href="/view/joinForm.jsp">회원가입</a>
						</div>
						<div>
							<input type="submit" value="로그인">
						</div>
					</div>
				</div>
			</form>
		</section>

		<jsp:include page="/common/footer.jsp" />

	</div>
</body>
</html>