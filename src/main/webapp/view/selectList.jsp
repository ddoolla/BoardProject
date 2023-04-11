<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>selectList</title>
    <link rel="stylesheet" href="../css/commonStyle.css">
    <link rel="stylesheet" href="../css/selectListStyle.css">
    <script src="../javascript/script.js" type="text/javascript"></script>
</head>
<body>
    <div id="page-wrapper">
        
        <jsp:include page="../common/header.jsp"/>

        <section id="selectList-section">
            <div>
                <span>제목:</span>
                ${ BoardDTO.title }
            </div>
            <div>
                <div>
                    <span>작성자:</span> ${ BoardDTO.userId }
                </div>
                <div></div>
                <div>
                	<span>조회수:</span> ${ BoardDTO.visitNum } <br>
                    <span>작성일:</span> ${ BoardDTO.writeDate }
                </div>
            </div>
            <div>
                ${ BoardDTO.content }
            </div>
            <div>
            	<c:if test="${ !empty sessionScope.loginOK.userId &&                  
            		(sessionScope.loginOK.userId == requestScope.BoardDTO.userId) }"> <!-- 로그인 하고, 작성자와 아이디 같은경우에만 버튼 보이게 -->
            		<input type="button" value="수정">
                	<input type="button" value="삭제">
            	</c:if>
                <input type="button" value="목록" onclick="goList();">
            </div>
        </section>


        <jsp:include page="../common/footer.jsp"/>
    </div>
</body>
</html>