<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/commonStyle.css">
    <link rel="stylesheet" href="../css/joinFormStyle.css">
    <script src="../javascript/script.js" type="text/javascript"></script>
</head>
<body>
    <div id="page-wrapper">
        
        <jsp:include page="../common/header.jsp"/>
        
        <section id="join-section">
            <h1>회원가입</h1>
            
            <form method="post" name="joinForm" action="./join.do">
                <div id="join-container">
                    <div>
                        <span class="cls1">아이디</span> 
                        <input type="text" name="userId" autofocus>
                    </div>
                    <div>
                        <span class="cls1">비밀번호</span>
                        <input type="password" name="userPass">
                    </div>
                    <div>
                        <span class="cls1">비밀번호 확인</span> 
                        <input type="password" name="userPass2">
                    </div>
                    <div>
                        <span class="cls1">이름</span>
                        <input type="text" name="name">
                    </div>
                    <div>
                        <span class="cls1">전화번호</span>
                        <input type="text" name="phone">
                    </div>
                    <div>
                        <span class="cls1">이메일</span>
                        <input type="text" name="email">
                    </div>
                </div>
                <div class="btn">
                    <input type="submit" value="가입하기" onClick="return joinCheck();">
                    &nbsp;
                    <input type="button" value="취소">
                </div>
            </form>
            

        </section>
		
		<jsp:include page="../common/footer.jsp"/>
        
    </div>
</body>
</html>