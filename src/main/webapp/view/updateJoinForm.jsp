<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보 변경</title>
    <link rel="stylesheet" href="../css/commonStyle.css">
    <link rel="stylesheet" href="../css/joinFormStyle.css">
    <script src="../javascript/script.js" type="text/javascript"></script>
</head>
<body>
    <div id="page-wrapper">
        
        <jsp:include page="../common/header.jsp"/>
        
        <section id="join-section">
            <h1>회원정보</h1>
            
            <form method="post" name="joinForm" action="./updateJoin.do">
                <div id="join-container">
                    <div>
                        <span class="cls1">아이디</span> 
                        <input type="text" name="userId" value="${ sessionScope.loginOK.userId }" readonly="readonly">
                    </div>
                    <div>
                        <span class="cls1">비밀번호</span>
                        <input type="password" name="userPass" value="${ sessionScope.loginOK.userPass }" autofocus>
                    </div>
                    <div>
                        <span class="cls1">비밀번호 확인</span> 
                        <input type="password" name="userPass2" value="${ sessionScope.loginOK.userPass }">
                    </div>
                    <div>
                        <span class="cls1">이름</span>
                        <input type="text" name="name" value="${ sessionScope.loginOK.name }">
                    </div>
                    <div>
                        <span class="cls1">전화번호</span>
                        <input type="text" name="phone" value="${ sessionScope.loginOK.phone }">
                    </div>
                    <div>
                        <span class="cls1">이메일</span>
                        <input type="text" name="email" value="${ sessionScope.loginOK.email }">
                    </div>
                </div>
                <div class="btn">
                    <input type="submit" value="변경하기" onClick="return updatejoinCheck();">
                    &nbsp;
                    <input type="button" value="취소" onClick="location.href='./home.do'">
                </div>
            </form>
            

        </section>
		
		<jsp:include page="../common/footer.jsp"/>
        
    </div>
</body>
</html>